package models;

import java.util.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The below class variables(related to repository details) will be assigned from HomeController.java to use them in Userinfo.scala.html
 * @author Bhavitha
 */

public class Repository implements Serializable{
	private static final long serialVersionUID = 1L;	
		
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("url")
	public String url;
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}
	
	public Repository() { }
	
	public Repository(String name,String url){
	    super();
		this.name=name;
		this.url=url;

	}

	@Override
	public String toString(){
		return name+" - "+url;
	}
}