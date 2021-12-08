package models;

import java.util.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The below class variables(related to user details) will be assigned from HomeController.java to use them in Userinfo.scala.html
 * @author Bhavitha
 */


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	public int id;

	@JsonProperty("login")
	public String login;
	
	@JsonProperty("url")
	public String url;
	
	@JsonProperty("email")
	public String email;
	
	@JsonProperty("bio")
	public String bio;
	
	@JsonProperty("location")
	public String location;
	
	@JsonProperty("followers")
	public String followers;
	
	@JsonProperty("following")
	public String following;
	
	@JsonProperty("html_url")
	public String html_url;
	
	@JsonProperty("avatar_url")
	public String avatar_url;
	
	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String gethtml_url() {
		return html_url;
	}
	
	public void sethtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getfollowing() {
		return following;
	}

	public void setfollowing(String following) {
		this.following = following;
	}

	
	public String getfollowers() {
		return followers;
	}

	public void setfollowers(String followers) {
		this.followers = followers;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public String getbio() {
		return bio;
	}

	public void setbio(String bio) {
		this.bio = bio;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}

	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public User() {}
	
	public User(int id,String login,String url,String email,String bio,String location,String followers,String following,String html_url,String avatar_url){
		super();
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
