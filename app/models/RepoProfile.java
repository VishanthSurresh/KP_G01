package models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The below class variables will be assigned values from IssueSearchResult.java to use them in repositoryprofile.scala.html
 * @author Shail
 */

public class RepoProfile implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("size")
	public String size;

	@JsonProperty("name")
	public String name;
	@JsonProperty("visibility")
	public String visibility;
	
	@JsonProperty("stargazers_count")
	public String stargazers_count;
	
	@JsonProperty("watchers_count")
	public String watchers_count;
	
	@JsonProperty("language")
	public String language;
	
	@JsonProperty("forks")
	public String forks;
	
	@JsonProperty("open_issues")
	public String open_issues;
	
	@JsonProperty("network_count")
	public String network_count;
	
	@JsonProperty("subscribers_count")
	public String subscribers_count;
	@JsonProperty("avatar_url")
	public String avatar_url;

	
	
	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getName() {
		return name;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForks() {
		return forks;
	}

	public void setForks(String forks) {
		this.forks = forks;
	}

	public String getOpen_issues() {
		return open_issues;
	}

	public void setOpen_issues(String open_issues) {
		this.open_issues = open_issues;
	}

	public String getNetwork_count() {
		return network_count;
	}

	public void setNetwork_count(String network_count) {
		this.network_count = network_count;
	}

	public String getSubscribers_count() {
		return subscribers_count;
	}

	public void setSubscribers_count(String subscribers_count) {
		this.subscribers_count = subscribers_count;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStargazers_count() {
		return stargazers_count;
	}

	public void setStargazers_count(String stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public String getWatchers_count() {
		return watchers_count;
	}

	public void setWatchers_count(String watchers_count) {
		this.watchers_count = watchers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public RepoProfile() {
	}

	

	public RepoProfile(String size, String name, String stargazers_count, String watchers_count, String language,
			String forks, String open_issues, String network_count, String subscribers_count) {
		super();
		this.size = size;
		this.name = name;
		this.stargazers_count = stargazers_count;
		this.watchers_count = watchers_count;
		this.language = language;
		this.forks = forks;
		this.open_issues = open_issues;
		this.network_count = network_count;
		this.subscribers_count = subscribers_count;
	}

	
	
	
}
