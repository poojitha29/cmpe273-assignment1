package edu.sjsu.cmpe.library.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Author {
	int id;
	String name;
	
	/**private static int authorid;*/
	
/**	public Author() {
*		this.id = ++authorid;
	}*/
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id  = id;
	} 
	/**
	 * @return the name
	 */
	@NotEmpty(message="Required field")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	
	
}
