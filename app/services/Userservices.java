package services;

import models.*;
import actors.TopicDataActor;
import actors.RepoProfileActor;
import actors.RepoProfileActor.RepoInfo;
import actors.TopicDataActor.TopicDetails;
import actors.UserActor;
import actors.UserActor.UserInfo;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import services.Commitservices;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import github.GithubHelper;
import java.io.IOException;
import play.api.libs.json.Json;
import play.libs.ws.*;
import akka.actor.*;
import akka.stream.Materializer;
import actors.CommitsActor;
import actors.CommitsActor.CommitInfo;
import static akka.pattern.Patterns.ask;

public class Userservices implements WSBodyReadables, WSBodyWritables{

	//private WSClient ws;
	public Map<String, Integer> result = new LinkedHashMap<>();
	
	
	User ur;
	private final GithubHelper github;
	private List<Repository> postss;
	
	@Inject
	public Userservices(GithubHelper github) {
		this.github = github;
		
	}
	
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public List<Repository> getDet(){
		    return this.postss;
	 }
	 
	 /**
	 * This method returns the data related to user profile.
	 * @author Bhavitha
	 * @param owner
	 */
	
	public CompletionStage<User> getUserData(String owner) {
			 this.setOwner(owner);
             this.repos();
             var response = github.getUser(owner);
                return response
            .get()
            .thenApplyAsync(r -> {
                JsonNode item = r.asJson();
                return new User(item.get("id").asInt(), item.get("login").asText(), item.get("url").asText(), item.get("email").asText(),item.get("bio").asText(),item.get("location").asText(),item.get("followers").asText(),item.get("following").asText(),item.get("html_url").asText(),item.get("avatar_url").asText());
            });
            
    } 
	
	/**
	 * This method returns the repositories of a user.
	 * @author Bhavitha
	 */
	
	public void repos() {
		 var response = github.getRepoDet(this.getOwner());
		 CompletionStage<List<Repository>> f = response.get().thenApplyAsync((WSResponse res) -> {
		      try {
		           JsonNode items = res.asJson();
                            List<Repository> repoList = new ArrayList<Repository>();
                            for (int i = 0; items.get(i) != null; i++) {
                                JsonNode item = items.get(i);
                                Repository postsList = new Repository();
                                //System.out.println("::::::" + item.get("name").asText());
                                //System.out.println("::::::" + item.get("url").asText());
                                postsList.setname(item.get("name").asText());
                                postsList.seturl(item.get("url").asText());
                                repoList.add(postsList);
								
                            }
                            this.postss = repoList;
		        	        return repoList;

		      } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		      }
		    });
	}
        	
}