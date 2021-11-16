package models;

import java.util.*;

/**
 * The below class variables(related to repo details) will be assigned from HomeController.java to use them in Userinfo.scala.html
 * @author Bhavitha
 */

public class Repository{

	
	public String name;
	public String url;
	
	public Repository(String name,String url){
	
		this.name=name;
		this.url=url;

	}

	@Override
	public String toString(){
		return name+" - "+url;
	}
}