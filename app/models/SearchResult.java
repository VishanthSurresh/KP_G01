package models;

/**
 * This class initializes all the attributes pertaining to Github
 * @author Vishanth
 * @author Varshini
 * @author Bhavitha
 * @author Shail
 * @author Heet
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class SearchResult {
  public String name;
  public String full_name;
  public ArrayList<String> topics;
  public Hashtable<String, String> owner = new Hashtable<String, String>();

  /*public String body;
  public String subreddit;*/

  public SearchResult() {}
  public SearchResult(String name,String full_name, ArrayList<String> topics, Hashtable<String, String> owner) {
    this.name = name;
    this.full_name = full_name;
    this.topics = topics;
	this.owner = owner;
  }
}
