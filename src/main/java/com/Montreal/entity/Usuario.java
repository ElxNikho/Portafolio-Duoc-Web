
package com.Montreal.entity;

import java.util.Date;

import com.Montreal.orm.EntityObject;

public class Usuario extends EntityObject{

	private int id;
	private String nombre, apellido, correo;
	private Date fNac;
	
	public Usuario() { 
		this.id = 1;
		this.nombre = "Marcelo";
		this.apellido = "Espina";
		this.correo = "m.espina@gmail.com";
		this.fNac = new Date();
	}
	public Usuario(int id, String nombre, String apellido, String correo, Date fnac) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fNac = fnac;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getfNac() {
		return fNac;
	}
	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
	
}
