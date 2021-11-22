package models;

import java.util.*;

/**
 * The below class variables(related to user details) will be assigned from HomeController.java to use them in Userinfo.scala.html
 * @author Bhavitha
 */


public class User {
	
	public int id;
	public String login;
	public String url;
	public String email;
	public String bio;
	public String location;
	public String followers;
	public String following;
	public String html_url;
	public String avatar_url;

	public User() {}
	
	public User(int id,String login,String url,String email,String bio,String location,String followers,String following,String html_url,String avatar_url){

		this.id=id;
		this.login=login;
		this.url=url;
		this.email=email;
		this.bio=bio;
		this.location=location;
		this.followers=followers;
		this.following=following;
		this.html_url=html_url;
		this.avatar_url=avatar_url;
	}

	
    @Override
	public String toString(){
    	return login;
	}
}
