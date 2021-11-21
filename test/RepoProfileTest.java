package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;



public class RepoProfileTest {

	@Test
	public void RepoProfileConstructorTest() {
		RepoProfile repo = new RepoProfile("size", "String","stargazers_count", "watchers_count", "language",
				"forks", "open_issues", "network_count", "subscribers_count");
	repo.setAvatar_url("avatar");
	assertNotNull(repo.getAvatar_url());
	
	repo.setVisibility("avatar");
	assertNotNull(repo.getVisibility());
	
	repo.setAvatar_url("avatar");
	assertNotNull(repo.getAvatar_url());
	
	repo.setName("avatar");
	assertNotNull(repo.getName());
	
	repo.setForks("avatar");
	assertNotNull(repo.getForks());
	
	repo.setOpen_issues("avatar");
	assertNotNull(repo.getOpen_issues());
	
	repo.setNetwork_count("avatar");
	assertNotNull(repo.getNetwork_count());
	
	repo.setSubscribers_count("avatar");
	assertNotNull(repo.getSubscribers_count());
	
	repo.setSize("avatar");
	assertNotNull(repo.getSize());
	
	repo.setStargazers_count("avatar");
	assertNotNull(repo.getStargazers_count());
	
	repo.setWatchers_count("avatar");
	assertNotNull(repo.getWatchers_count());
	
	repo.setLanguage("avatar");
	assertNotNull(repo.getLanguage());
	
	repo.setWatchers_count("avatar");
	assertNotNull(repo.getWatchers_count());
	
	}

}
