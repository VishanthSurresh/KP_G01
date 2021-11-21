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

/**
 * The below class variables will be assigned from GithubHelper.java to use them in topic.scala.html
 * @author Heet Patel
 */

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
				.map(s -> s.getFull_name()).limit(10).collect(Collectors.toList()));
		return titles;
	}
	public CompletionStage<List<Topics>> getTopic(String repo) {
		return github.getTopic(repo);

	}
	
}
