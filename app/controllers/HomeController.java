package controllers;
import models.*;
import actors.TopicDataActor;
import actors.RepoProfileActor;
import actors.RepoProfileActor.RepoInfo;
import actors.TopicDataActor.TopicDetails;
import actors.IssueStatActor;
import actors.IssueStatActor.IssueStatInfo;
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
import actors.SearchResultActor;
import actors.UserActor;
import actors.UserActor.UserInfo;
import services.Userservices;
import actors.SearchResultActor.SearchResultInfo;
import actors.Searchsupervisor;
import play.libs.streams.ActorFlow;
import static akka.pattern.Patterns.ask;

// TODO: Auto-generated Javadoc
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {
    
    /** The ws. */
	@Inject
    private WSClient ws;
	@Inject
	private ActorSystem actorSystem;
	@Inject
	private Materializer materializer;
	

	
	ActorRef commitsActor;
	ActorRef topicDataActor;
    ActorRef repoActor;
    ActorRef issueStatActor;
    ActorRef searchResultActor;
    ActorRef userActor;
    
    /** The github. */
    private final GithubHelper github;
    
    /** The issue search result. */
    private final IssueSearchResult issueSearchResult;
    
    private final Userservices userservices;
    /** The topic service. */
    //private final TopicService topicService;
    
    /** The user. */
    User user;
    
    /** The full commits result. */
    JsonNode fullCommitsResult;
    
    /** The max add list. */
    List<Integer> maxAddList = new ArrayList<>();
    
    /** The max del list. */
    List<Integer> maxDelList = new ArrayList<>();
    
    /** The cr. */
    CommitsResult cr;
    Userservices usvc;
    //Cache
    CacheManager cm;
    
    List<QuerySearchResult> ex = new ArrayList<>();
    
    public Map<String,Integer> result = new LinkedHashMap<>();
    
    @Inject Commitservices commit = new Commitservices(ws);
    private final TopicService topic;
    
    /**
     * Instantiates a new home controller.
     * @param ws the ws
     * @param github the github
     */
    @Inject
    public HomeController(WSClient ws,GithubHelper github, ActorSystem system) {
        this.ws = ws;
        this.github = github;
        this.issueSearchResult =  new IssueSearchResult(github);
        this.userservices  = new Userservices(github); 
        this.topic = new TopicService(github);
        commitsActor = system.actorOf(CommitsActor.getProps(commit));
        topicDataActor=system.actorOf(TopicDataActor.getProps(topic));
        repoActor=system.actorOf(RepoProfileActor.getProps(issueSearchResult));
        userActor=system.actorOf(UserActor.getProps(userservices));
        issueStatActor = system.actorOf(IssueStatActor.getProps(issueSearchResult));
        cm = new CacheManager(ws);
        searchResultActor = system.actorOf(SearchResultActor.getProps(), "searchResultActor");
    }
    
    public WebSocket ws(){
		 System.out.println("Inside Websocket!!-----> ");
	        return WebSocket.Json.accept(request -> ActorFlow.actorRef(Searchsupervisor::props, actorSystem, materializer));
	    }
    /**
     * An action that renders an HTML page. The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     * @param request the request
     * @return the result
     */
     
    @SuppressWarnings("unchecked")
	public CompletionStage<Result> index(Http.Request request) {

    	return FutureConverters
				.toJava(ask(searchResultActor, new SearchResultInfo(request,cm), 10000))
				.thenApply(res ->{
					ex = (List<QuerySearchResult>)res;
					return ok(views.html.index.render(ex,request));
				});
				
    }
    
    /**
     * This function returns the values for search result from Github API.
     * @param query the query
     * @param request the request
     * @return the result
     */
    
    public Result search(String query, Http.Request request) {
        var currentSession = request.session().get("searchedTerms").orElse("");
        currentSession += "," + query;
        return redirect("/")
            .addingToSession(request, "searchedTerms", currentSession);
    }

    /**
     * This method fetches the repository issues from IssueSearchResult.java and RepoIssues.java
     * @author Shail
     * @param user the user
     * @param repo the repo
     * @return the completion stage
     */

    public CompletionStage<Result> issues(String user, String repo){
    	return FutureConverters.toJava(ask(repoActor, new RepoInfo(user+"/"+repo, issueSearchResult), 1000000))
				.thenApplyAsync(response -> {
					List<String> issues = (List<String>)response;
					return ok(views.html.repositoryprofile.render(issues,user.toString(),issueSearchResult.getData(), issueSearchResult.getRepoName()));
				});
    }
    
	/**
     * This method fetches the user details from User.java and Userservices.java
     * @author Bhavitha
     * @param owner
     * @return the completion stage
     */
	 
    public CompletionStage<Result> userDetails(String owner){
    	return FutureConverters.toJava(ask(userActor, new UserInfo(owner,userservices), 10000)).thenApplyAsync(response -> {
					User userDet = (User)response;
					return ok(views.html.Userinfo.render(userDet,userservices.getDet()));
		}); 
    }
    
    /**
     * This method fetches the Issue Statics results from IssueSearchResult.java
     *
     * @author Varshini
     * @return the completion stage
     */
    
    
    public CompletionStage<Result> issuesstat(){
    	return FutureConverters.toJava(ask(issueStatActor, new IssueStatInfo(issueSearchResult), 1000000))
				.thenApplyAsync(response -> {
					Map<String, Integer> issues = (Map<String, Integer>)response;
					return ok(views.html.issuestatistics.render(issues));
				});
    }
    
    /**
     * This method fetches the top 10 topics from Topics and TopicService.java
     *
     * @author Heet Patel
     * @param repo the repo
     * @return the completion stage
     */
    
    public CompletionStage<Result> topics(String repo){
    	return FutureConverters.toJava(ask(topicDataActor, new TopicDetails(repo,topic), 10000)).thenApplyAsync(response -> {
			List<String> topicsList = (List<String>)response;
            return ok(views.html.topic.render(topicsList));
});
    }
    
        /**
		 * This part of code returns the Top 10 Commiters data for Repository Commits
		 * @author Vishanth
		 */
        
        public CompletionStage<Result> commits(String user, String repo) throws Exception{
        	List<String> commitKeysList = new ArrayList<>();
        	return FutureConverters.toJava(ask(commitsActor, new CommitInfo(user, repo, commit), 1000000))
    				.thenApplyAsync(response -> {
    					List<CommitsResult> topCommiters = (List<CommitsResult>)response;
    					List<CommitsResult> topTen = topCommiters.parallelStream()
    							.map(c -> new CommitsResult(c.get_user_name(), c.get_additions(), c.get_deletions()))
    							.collect(Collectors.toList());
    					result = topTen.parallelStream()
    							.collect(Collectors.toMap(w -> w.get_user_name(), w -> 1, Integer::sum));
    					result = result.entrySet().stream()
    							.sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).limit(10)
    							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
    									LinkedHashMap::new));
    					Iterator<String> iterator = result.keySet().iterator();
    					while (iterator.hasNext()) {
    						Object commitKey = iterator.next();
    						commitKeysList.add((String) commitKey);
    					}
    					int size = topCommiters.size();
    					System.out.println("LAST VALUE: " + topCommiters.get(size - 1));
    					return ok(views.html.commits.render(topCommiters.get(size - 1), commitKeysList, result));
    				});
     
    }
        

}