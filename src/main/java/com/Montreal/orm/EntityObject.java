package com.Montreal.orm;

import org.w3c.dom.Element;

public class EntityObject implements IEntityCrud {
	
	
	@Override
	public Object[] findAll() {
		System.out.println(this.getClass().getSimpleName());
		QueryResolver q = QueryResolver.getInstance();
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Element query = q.findQuery(this.getClass().getSimpleName(), name);
		q.queryMaker(query, this);
		return null;
	}

	@Override
	public Object findById(String id) {
		System.out.println(this.getClass().getSimpleName());
		QueryResolver q = QueryResolver.getInstance();
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Element query = q.findQuery(this.getClass().getSimpleName(), name);
		q.queryMaker(query, this);
		return null;
	}

	@Override
	public Object add(Object o) {
		System.out.println(this.getClass());
		return null;
	}

	@Override
	public boolean remove(String id) {
		System.out.println(this.getClass());
		return false;
	}
	
	
	
}
