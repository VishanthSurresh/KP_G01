package actors;

import akka.actor.AbstractActor;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

import play.Logger;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.Http;
import models.CacheManager;
import models.QuerySearchResult;
import models.SearchResult;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import scala.concurrent.duration.Duration;
import actors.Searchsupervisor;


/**
 * This class Acts as Actor for Search Results (Github API)
 * @author vishanth
 * @author varshini
 * @author heet patel
 * @author shail patel
 * @author bhavitha
 *
 */


public class SearchResultActor extends AbstractActorWithTimers {
	private Set<ActorRef> replyActors;
	private SearchResultInfo srf;
	List<QuerySearchResult> currentResultList;
	HashMap<String, ArrayList<String>> currentRepoList = new HashMap<String, ArrayList<String>>();

	static public class SearchResultInfo {
		Http.Request request;
		CacheManager cm;

		public SearchResultInfo(Http.Request request, CacheManager cm) {
			this.request = request;
			this.cm = cm;
		}
	}
	
	static public class RegisterMsg{

    }

	private SearchResultActor() {
		this.replyActors = new HashSet<>();
	}

	private static final class Tick {
		SearchResultInfo savedSRF;

		public Tick(SearchResultInfo savedSRF) {
			this.savedSRF = savedSRF;
		}
	}

	static public class registration_message {

	}

	public void preStart() {
		// getTimers().startPeriodicTimer("Timer", new Tick(), Duration.create(25,
		// TimeUnit.SECONDS));
	}

	public static Props getProps() {
		return Props.create(SearchResultActor.class);
	}

	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder().match(SearchResultInfo.class, this::sendSearchResults)
				.match(RegisterMsg.class, msg -> replyActors.add(sender()))
				.match(Tick.class, msg -> UpdateSearchResults(msg.savedSRF)).build();
	}

	private void sendSearchResults(SearchResultInfo sri) {
		var sessionData = sri.request.session().get("searchedTerms");
		System.out.println("OUTPUT FROM SearchResult Actor*******************************" + sessionData);

		if (!sessionData.isPresent()) {
			System.out.println("23" + sri.request);
			// System.out.println(ws);
			List<QuerySearchResult> searchList = new ArrayList<QuerySearchResult>();
			sender().tell(searchList, self());
			// return ok(views.html.index.render();
		} else {
			List<QuerySearchResult> searchList = new ArrayList<QuerySearchResult>();
			searchList = Arrays.stream(sessionData.get().split(",")).filter(e -> !e.isEmpty()).parallel()
					.map(CacheManager.GetCache()::GetTrimmedSearchResult).collect(Collectors.toList());
			currentResultList = searchList;
		    updateRepoIDs();
			getTimers().startPeriodicTimer("Timer", new Tick(sri), Duration.create(5, TimeUnit.SECONDS));
			sender().tell(searchList, self());
		}
	}

	private void UpdateSearchResults(SearchResultInfo sri) {
			Boolean Has_Changed = false;
			Integer changeCount=0;
			var sessionData = sri.request.session().get("searchedTerms");
	        System.out.println("Here in Update Search ******************************");
	
	        	 List<QuerySearchResult> searchList = new ArrayList<QuerySearchResult>();
	        	 searchList =  Arrays.stream(sessionData.get().split(","))
		                    .filter(e->!e.isEmpty())
		                    .parallel()
		                    .map(CacheManager.GetCache()::GetTrimmedSearchResult)
		                    .collect(Collectors.toList());
	        	
	 	        System.out.println("****************************** Reply Actors"+replyActors.size());
	 	       final ObjectNode response = Json.newObject();
			    
			    ArrayList<ObjectNode> arrayOfChanges = new ArrayList<>();
		    	
		    		for(int i =0; i< searchList.size();i++) {
		    			List<SearchResult> posts = searchList.get(i).posts;
		    			
		    			
			    		for(int j =0; j< posts.size();j++) {
			    			SearchResult searchResult  = posts.get(j);
		    			if(!currentRepoList.get(searchList.get(i).searchTerm).contains(searchResult.full_name)){
		    				Has_Changed = true;
		    				 ObjectNode ChangeObject = Json.newObject(); 
		    				 ChangeObject.put("queryString", searchList.get(i).searchTerm);
		    				 ChangeObject.put("full_name", searchResult.full_name);
		    				 ChangeObject.put("name", searchResult.name);
		    				 ChangeObject.put("topics", searchResult.topics.toString());	 
		    				 ChangeObject.put("repoToChange",currentRepoList.get(searchList.get(i).searchTerm).get(changeCount));		    				 
		    				 arrayOfChanges.add(ChangeObject);
		    				 changeCount++;
		    		}
		    	}
		    		}
		    	
			    
			    if(Has_Changed) {
			    	System.out.println(changeCount + " - Changes");
			    	response.put("status", changeCount.toString());
					 response.put("value", arrayOfChanges.toString());
					 currentResultList = searchList;
					 updateRepoIDs();
			    }else {
			    	System.out.println("No Change in List");
			    	response.put("status", "No-Change");
			    }
			    
			    Searchsupervisor.GithubSearchMessage tMsg = new Searchsupervisor.GithubSearchMessage(response);
			    replyActors.forEach(ar -> ar.tell(tMsg, self()));
					    
			}
	
	private void updateRepoIDs() {
	
		for(int i =0; i< currentResultList.size();i++) {
			List<SearchResult> posts = currentResultList.get(i).posts;
			
			ArrayList<String> repoIDListforString = new ArrayList<>();
    		for(int j =0; j< posts.size();j++) {
    			SearchResult searchResult  = posts.get(j);
    			repoIDListforString.add(searchResult.full_name);
    		}
    	
	    	System.out.println( "************************************************************************ REPO NAMES :: "+ repoIDListforString.toString());

		    currentRepoList.put(currentResultList.get(i).searchTerm, repoIDListforString);

    	
    	}
	
		}

}