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
}
