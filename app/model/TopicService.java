package models;

import github.GithubHelper;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;
import com.google.inject.Inject;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import github.GithubHelper;
import play.libs.Json;
public class TopicService {
	
	private final GithubHelper github;
	private String repoName;
	
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	@Inject
	public TopicService(GithubHelper github) {
		this.github = github;
	}
	
	CompletionStage<List<String>> titles = null;
	public CompletionStage<List<String>> getTopics(String repo) {
		this.setRepoName(repo);
		CompletionStage<List<Topics>> issues = this.getTopic(repo);
		titles = issues.thenApplyAsync(issue -> issue.stream()
				.map(s -> s.getFull_name()).collect(Collectors.toList()));
//		CompletionStage<Map<String, Integer>> issueStatistics = titles
//				.thenApply(title -> title.parallelStream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum)));
//		issueStatistics = issueStatistics.thenApply(statistics -> statistics.entrySet().stream()
//				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)));
		return titles;
	}
	public CompletionStage<List<Topics>> getTopic(String repo) {
		return github.getTopic(repo);

	}
	
}
