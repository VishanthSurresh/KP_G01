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
	
	public List<JsonNode> commitsList;
	public JsonNode allCommitsData;
	public String userAvatar;
	public String userName;
	public String commitMsg;
	public String nAdd, nDel, total;
	public Optional<Integer> maxAdd, maxDel, minAdd, minDel, avgAdd, avgDel;
	
	public CommitsResult()
	{
		
	}
	public CommitsResult(String userName, String nAdd, String nDel) {
		this.userName = userName;
		this.nAdd = nAdd;
		this.nDel = nDel;
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
	
	public CommitsResult(String userAvatar, String userName, String commitMsg, String nAdd, String nDel, String total, 
			Optional<Integer> maxAdd, Optional<Integer> minAdd, Optional<Integer> maxDel, Optional<Integer> minDel, Optional<Integer> avgAdd, Optional<Integer> avgDel){
		this.userAvatar = userAvatar;
		this.userName = userName;
		this.commitMsg = commitMsg;
		this.nAdd = nAdd;
		this.nDel = nDel;
		this.total = total;
		this.maxAdd = maxAdd;
		this.minAdd = minAdd;
		this.maxDel = maxDel;
		this.minDel = minDel;
		this.avgAdd = avgAdd;
		this.avgDel = avgDel;
	}

}
