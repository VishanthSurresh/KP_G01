package models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The below class variables will be assigned from GithubHelper.java to use them in topic.scala.html
 * @author Heet Patel
 */


public class Topics implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("full_name")
	public String full_name;

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Topics() {
	}
	
	public Topics(String full_name) {
		super();
		this.full_name = full_name;
	}

}
