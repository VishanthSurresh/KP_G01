package models;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;
import com.google.inject.Inject;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import github.GithubHelper;
import play.libs.Json;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.util.stream.Collectors.*;

public class IssueSearchResult {

	private final GithubHelper github;
	private RepoProfile posts;
	private String repoName;
	
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	 public RepoProfile getData(){
		    return this.posts;
	 }
	 public IssueSearchResult() {
		this.github = null;
	}
	@Inject
	public IssueSearchResult(GithubHelper github) {
		this.github = github;
	}
	
	CompletionStage<List<String>> titles = null;
	
	/**
	 * This method list the top 20 Issues in github repository.
	 * @author Shail
	 * @param repo RepoString
	 * @return Return
	 */
	
	public CompletionStage<List<String>> getIssueStatistics(String repo) {
		this.setRepoName(repo);
		CompletionStage<List<RepoIssues>> issues = this.getIssues(repo);
		titles = issues.thenApplyAsync(issue -> issue.stream()
				.map(s -> s.getTitle()).limit(20).collect(Collectors.toList()));
		this.repoDetail(repo);
		return titles;
	}
	/**
	 * This method  fetch the available issues and compute a word-level statistics of
	 * the issue titles, counting all unique words in descending order
	 * @author Varshini
	 * @return Return
	 */
	
	public CompletionStage<Map<String, Integer>> getIssueStatisticss() {
		CompletionStage<List<RepoIssues>> issues = this.getIssues(this.getRepoName());
		CompletionStage<List<String>> titles = issues.thenApplyAsync(issue -> issue.stream()
				.map(s -> s.getTitle().split(" ")).flatMap(Arrays::stream).collect(Collectors.toList()));
		CompletionStage<Map<String, Integer>> issueStatistics = titles
				.thenApply(title -> title.parallelStream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum)));
		issueStatistics = issueStatistics.thenApply(statistics -> statistics.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)));
		return issueStatistics;
	}

	public CompletionStage<List<RepoIssues>> getIssues(String repo) {
		return github.getIssues(repo);

	}
	
	/**
	 * This method get the Repository Results from Github API.
	 * @author Shail
	 * @param repo RepoString
	 */
	
	public void repoDetail(String repo) {
		 var response = github.getRepoResult(repo);
		 CompletionStage<RepoProfile> f = response.get().thenApplyAsync((WSResponse r) -> {
		      try {
		        //ObjectMapper mapper = new ObjectMapper();
		        RepoProfile postList = new RepoProfile();
		        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		        System.out.println("Response: *******"+r.asJson());
		        postList.setSize(r.asJson().get("size").toString());
		        postList.setStargazers_count(r.asJson().get("stargazers_count").toString());
		        postList.setName(r.asJson().get("name").asText());
		        postList.setVisibility(r.asJson().get("visibility").asText());
		        postList.setWatchers_count(r.asJson().get("watchers_count").toString());
		        postList.setLanguage(r.asJson().get("language").asText());
		        postList.setForks(r.asJson().get("forks").toString());
		        postList.setOpen_issues(r.asJson().get("open_issues").toString());
		        postList.setNetwork_count(r.asJson().get("network_count").toString());
		        postList.setSubscribers_count(r.asJson().get("subscribers_count").toString());
		        postList.setAvatar_url(r.asJson().get("owner").get("avatar_url").asText());
		        this.posts = postList;
		        //this.forks = sizes;
		       // System.out.println(postList);
		        return postList;

		      } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		      }
		    });
	}
}
