package com.Montreal.orm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class QueryResolver {

	private final static String xmlPath = "WsQuery.xml";
	private static String basePathURL = "";
	private static Document WsQuerys = null;	
	
	// Singleton
	private static QueryResolver instance = null;
	public static QueryResolver getInstance() {
		if(instance == null) {			
			instance = new QueryResolver();
		}
		return instance;
	}
	private QueryResolver() {		
		String xml = this.getClass().getClassLoader().getResource(xmlPath).toString();
		xml = xml.replaceAll("file:/", "");
		File inputFile = new File(xml);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			WsQuerys = dBuilder.parse(inputFile);
			WsQuerys.getDocumentElement().normalize();	
			findWsURL();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}       
		
		
	}
	
	
	
	private Object getMethodValueByString(EntityObject entity, String methodName) {
		Method method;
		Object value = null;
		try{
			//Definicion del metodo a buscar, con clase, nombre de metodos y parametros necesarios.
			method = entity.getClass().getMethod("getId");
			try {
				// Invocacion del metodo entregando los objetos y parametros ya definidos.
				value = method.invoke(entity);
			} 
			catch (IllegalArgumentException e) { e.printStackTrace(); }
			catch (IllegalAccessException e) { e.printStackTrace(); }
			catch (InvocationTargetException e) { e.printStackTrace(); }
			
		}
		catch (SecurityException e) { e.printStackTrace(); }
		catch (NoSuchMethodException e) { e.printStackTrace(); }
		return value;
	}
	
	public String findWsURL() {
		Element firstElement = WsQuerys.getDocumentElement();
		basePathURL = firstElement.getElementsByTagName("url").item(0).getTextContent();
		return basePathURL;
	}
	
	
	
	public String queryMaker(Element e, EntityObject entity) {
		
		e.getAttribute("entity");	
		String path = e.getAttribute("path");		
		String method = e.getAttribute("method");		
		String currentValue = "";
		NodeList params;
		Node nNode = null;
		Element eElement;
		params = e.getElementsByTagName("param");
		
		StringBuilder sb = new StringBuilder(basePathURL + "?");
		
		
		for(int i = 0; i < params.getLength(); i++) {
			nNode = params.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {			
				eElement = (Element) nNode;
				if(eElement.getAttribute("entityParam") != null && !eElement.getAttribute("entityParam").trim().equalsIgnoreCase("") && eElement.getAttribute("paramType") != null && !eElement.getAttribute("paramType").trim().equalsIgnoreCase("")) {
					sb.append( eElement.getTextContent() );
					sb.append( "=" );
					currentValue = (String) getMethodValueByString(entity,  eElement.getAttribute("entityParam")).toString();
					sb.append( currentValue );
				}
				if(eElement.getAttribute("customParam") != null && !eElement.getAttribute("customParam").trim().equalsIgnoreCase("") && eElement.getAttribute("paramType") != null && !eElement.getAttribute("paramType").trim().equalsIgnoreCase("")) {
					
					sb.append( eElement.getTextContent() );
					sb.append( "=" );
					
					// agregar valor del parametro de lista de parametros (hashmap)
					//sb.append( eElement.getTextContent() );
					
				}
								
				sb.append("&");
			}
		}					
		
		return sb.toString();
	}
	
	public Element findQuery(String entity, String query) {
					
		System.out.println("Iniciando busqueda: " + WsQuerys.getDocumentElement().getNodeName());
		Element firstElement = WsQuerys.getDocumentElement();
		NodeList nList = firstElement.getElementsByTagName("query");
		// finding by entity and queryname
		Node nNode = null;
		Element eElement = null;
		boolean found = false;
		for (int it = 0; it< nList.getLength() && !found; it++) {
			nNode = nList.item(it);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {			
				eElement = (Element) nNode;
				// buscando querys segun entidad y nombre de query
				if(eElement.getAttribute("entity").equalsIgnoreCase(entity) && eElement.getAttribute("wsquery").equalsIgnoreCase(query)) {
					found = true;
				}								
			}
		}
		return found ? eElement : null;	
	}	
	
}
