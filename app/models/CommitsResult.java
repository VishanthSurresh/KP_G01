package models;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;

/**
 * The below class variables will be assigned values from HomeController.java to use them in commits.scala.html
 * @author Vishanth
  */

public class CommitsResult {
	
	public List<JsonNode> commits_list;
	public JsonNode commits_data;
	public String userAvatar;
	public String userName;
	public String commitMsg;
	public String nAdd, nDel, total;
	public Optional<Integer> max_addition, max_deletion, min_addition, min_deletion, avg_addition, avg_deletion;
	
	public CommitsResult()
	{
		
	}
	public CommitsResult(String userName, String n_Addition, String n_Deletion) {
		this.userName = userName;
		this.nAdd = n_Addition;
		this.nDel = n_Deletion;
	}
	
	public String get_user_name() {
		return this.userName;
	}
	
	public String get_additions() {
		return this.nAdd;
	}
	
	public String get_deletions() {
		return this.nDel;
	}
	
	public CommitsResult(String userAvatar, String userName, String commits_message, String n_addition, String n_deletion, String total, 
			Optional<Integer> max_addition, Optional<Integer> min_addition, Optional<Integer> max_deletion, Optional<Integer> min_deletion, Optional<Integer> avg_addition, Optional<Integer> avg_deletion){
		this.userAvatar = userAvatar;
		this.userName = userName;
		this.commitMsg = commits_message;
		this.nAdd = n_addition;
		this.nDel = n_deletion;
		this.total = total;
		this.max_addition = max_addition;
		this.min_addition = min_addition;
		this.max_deletion = max_deletion;
		this.min_deletion = min_deletion;
		this.avg_addition = avg_addition;
		this.avg_deletion = avg_deletion;
	}

}
