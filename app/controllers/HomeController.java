package controllers;

import models.*;

import play.mvc.*;
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
// TODO: Auto-generated Javadoc
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {
    
    /** The ws. */
    private final WSClient ws;
    
    /** The github. */
    private final GithubHelper github;
    
    /** The issue search result. */
    private final IssueSearchResult issueSearchResult;
    
    /** The topic service. */
    private final TopicService topicService;
    
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
    
    
    /**
     * Instantiates a new home controller.
     *
     * @param ws the ws
     * @param github the github
     */
    @Inject
    public HomeController(WSClient ws,GithubHelper github) {
        this.ws = ws;
        this.github = github;
        this.issueSearchResult =  new IssueSearchResult(github);
        this.topicService = new TopicService(github);
    }
    
    /**
     * An action that renders an HTML page. The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     *
     * @param request the request
     * @return the result
     */
     
    public Result index(Http.Request request) {
        var sessionData = request.session().get("searchedTerms");
        System.out.println(sessionData);

        if(!sessionData.isPresent()) {
            System.out.println("23"+request);
            System.out.println(ws);
            return ok(views.html.index.render(new ArrayList<QuerySearchResult>()));
            //  return ok(views.html.index.render();
         } else {
             return ok(views.html.index.render(
                 Arrays.stream(sessionData.get().split(","))
                    .filter(e->!e.isEmpty())
                    .parallel()
                    .map(CacheManager.GetCache(ws)::GetTrimmedSearchResult)
                    .collect(Collectors.toList()))
             );
         }
    }
    
    /**
     * This function returns the values for search result from Github API.
     *
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
     *
     * @author Varshini
     * @param user the user
     * @param repo the repo
     * @return the completion stage
     */

    public CompletionStage<Result> issues(String user, String repo){
        CompletionStage<Result> result = issueSearchResult.getIssueStatistics(user+"/"+repo).thenApplyAsync(
                op -> ok(views.html.repositoryprofile.render(op, user.toString(),issueSearchResult.getData(), issueSearchResult.getRepoName())));
                
        return result;
    }
    
    /**
     * This method fetches the Issue Statics results from IssueSearchResult.java
     *
     * @author Varshini
     * @return the completion stage
     */
    
    
    public CompletionStage<Result> issuesstat(){
        CompletionStage<Result> result = issueSearchResult.getIssueStatisticss().thenApplyAsync(
                op -> ok(views.html.issuestatistics.render(op)));
        
        return result;
    }
    
    /**
     * This method fetches the top 10 topics from Topics and TopicService.java
     *
     * @author Heet Patel
     * @param repo the repo
     * @return the completion stage
     */
    
    public CompletionStage<Result> topics(String repo){
        CompletionStage<Result> result = topicService.getTopics(repo).thenApplyAsync(
                op -> ok(views.html.topic.render(op)));
        
        return result;
    }
    
    /**
     * This method fetches all the user details. 
     *
     * @author Bhavitha
     * @param owner the owner
     * @return the completion stage
     */
    
    
    
    public CompletionStage<Result> fetchUser(final String owner) {
                return ws.url("https://api.github.com/users/"+owner)
            //.addHeader("Authorization", "token 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")
            .get()
            .thenApply(r -> {
                JsonNode item = r.asJson();
                return new User(item.get("id").asInt(), item.get("login").asText(), item.get("url").asText(), item.get("email").asText(),item.get("bio").asText(),item.get("location").asText(),item.get("followers").asText(),item.get("following").asText(),item.get("html_url").asText(),item.get("avatar_url").asText());
            })
            .thenApplyAsync(r -> {
                try {
                    CompletionStage<List<Repository>> c = ws.url("https://api.github.com/users/"+owner+"/repos")
                        .addHeader("Authorization", "token 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")
                        .get()
                        .thenApply(res -> {
                            JsonNode items = res.asJson();
                            Repository repo;
                            List<Repository> repos = new ArrayList<Repository>();
                            for (int i = 0; items.get(i) != null; i++) {
                                JsonNode item = items.get(i);
                                List<String> topics = new ArrayList<String>();
                                JsonNode topicNode = item.get("topics");
                                for (int j = 0; topicNode.get(j) != null; j++) {
                                    topics.add(topicNode.get(j).asText());
                                }
                                repo = new Repository(item.get("name").asText(),item.get("url").asText());
                                repos.add(repo);
                            }
                            return repos;
                        });
                    return ok(views.html.Userinfo.render(r, c.toCompletableFuture().get()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            });
    
        
}
    
    /**
     * This method returns the entire data for repository commits. And also it is used for authorization purpose to Github API to get more than 100 commits data.
     *
     * @author Vishanth
     * @param url the url
     * @return the full commits data
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException the execution exception
     */
    
    public void get_full_commits_data(String url) throws InterruptedException, ExecutionException {
        System.out.println("Inside get_full_commits_data");
        WSRequest req = ws.url(url).addHeader("Authorization", "token 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");
        req.addQueryParameter("per_page", "100");
        req.addQueryParameter("page", "1");
        req.setMethod("GET");
        CompletionStage<JsonNode> resFromRequest = req.get().thenApply(result -> result.asJson());
        fullCommitsResult = resFromRequest.toCompletableFuture().get();
    }
    
    /**
     * This method returns the addition, deletion and average number of additons and deletions value for Repository Commits.
     *
     * @author Vishanth
     * @param user the user
     * @param repo the repo
     * @return the result
     * @throws InterruptedException the interrupted exception
     * @throws ExecutionException the execution exception
     */
    
    public Result commits(String user, String repo) throws InterruptedException, ExecutionException{
        System.out.println("Inside get_commits_data");
        Optional<Integer> maxAdd, maxDel, minAdd, minDel, avgAdd, avgDel;
        List<CommitsResult> topCommiters = new ArrayList<>();
        List<String> commitKeysList = new ArrayList<>();
        String commitUrl = "https://api.github.com/repos" + "/" + user + "/" + repo + "/commits";
        get_full_commits_data(commitUrl);
        List<String> shaList = new ArrayList<>();
        for (JsonNode sha : fullCommitsResult) {
            shaList.add(sha.get("sha").toString().replaceAll("^\"|\"$", ""));
        }
        System.out.println("Sha size: " + shaList.size());
        for (int i = 0; i < shaList.size(); i++) {
            WSRequest req = ws.url(commitUrl + "/" + shaList.get(i)).addHeader("Authorization", "token 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");
            req.setMethod("GET");
            CompletionStage<JsonNode> resFromRequest = req.get().thenApply(result -> result.asJson());
            JsonNode temp = resFromRequest.toCompletableFuture().get();
            // System.out.println(Json.prettyPrint(temp.get("stats")));
            maxAddList.add(temp.get("stats").findPath("additions").asInt());
            maxDelList.add(temp.get("stats").findPath("deletions").asInt());
            maxAdd = maxAddList.stream().max(Integer::compare);
            minAdd = maxAddList.stream().min(Integer::compare);
            avgAdd = Optional.of(maxAddList.stream().reduce(0, Integer::sum) / shaList.size());
            maxDel = maxDelList.stream().max(Integer::compare);
            minDel = maxDelList.stream().min(Integer::compare);
            avgDel = Optional.of(maxDelList.stream().reduce(0, Integer::sum) / shaList.size());
            cr = new CommitsResult(
                    temp.get("author").findPath("avatar_url").asText(),
                    temp.get("author").findPath("login").asText(),
                    temp.get("commit").findPath("message").asText(),
                    temp.get("stats").findPath("additions").asText(),
                    temp.get("stats").findPath("deletions").asText(),
                    temp.get("stats").findPath("total").asText(),
                    maxAdd,
                    minAdd,
                    maxDel, 
                    minDel,
                    avgAdd,
                    avgDel
                    );
            topCommiters.add(cr);
        }
        
        /**
		 * This part of code returns the Top 10 Commiters data for Repository Commits
		 * @author Vishanth
		 */
        
        List<CommitsResult> topTen = topCommiters.parallelStream()
                .map(c -> new CommitsResult(c.get_user_name(), c.get_additions(), c.get_deletions()))
                .collect(Collectors.toList());
        Map<String, Integer> result = new LinkedHashMap<>();
        result = topTen.parallelStream().collect(Collectors.toMap(w -> w.get_user_name(), w -> 1, Integer :: sum));
        result = result.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(result);
        Iterator<String> iterator = result.keySet().iterator();
        while(iterator.hasNext()){
          Object commitKey = iterator.next();
          commitKeysList.add((String)commitKey); 
        }
    
        return ok(views.html.commits.render(cr, commitKeysList, result));
     
    }

}