package models;

import org.junit.Test;
import static org.junit.Assert.*;



//import github.GithubHelper;


public class IssueSearchResultTest {
	@Test
	public void getRepoNameTest() {
		IssueSearchResult issue_result = new IssueSearchResult();
		issue_result.setRepoName("repo_name");
		assertEquals(issue_result.getRepoName(),"repo_name");
	}
	
	@Test
	public void getIssueStatisticsTest() {
		IssueSearchResult issue_result = new IssueSearchResult();
		try {
		issue_result.getIssueStatistics("repo_name");
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void getgetIssueStatisticssTest() {
		IssueSearchResult issue_result = new IssueSearchResult();
		try {
			
		
		issue_result.getIssueStatisticss();
		}catch(Exception e) {
			
		}
	}

}