package com.Montreal.orm;

public interface IEntityCrud {
	
	//Select * from []
	public Object[] findAll();
	//Select * from [] where id = ? 
	public Object findById(String id);
	//Insert into [] values ()
	//Update [] set col1, col2, ... coln where id = ?
	public Object add(Object o);
	//Delete from [] where id = ?
	public boolean remove(String id);
	
	
}
