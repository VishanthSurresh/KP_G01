package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



//import github.GithubHelper;


public class QuerySearchResultTest {
	@Test
	public void getRepoNameTest() {
		QuerySearchResult q = new QuerySearchResult("Bhavitha");
		String st = q.getSearchTerm();
		q.setKeyTermData(null);
		List<SearchResult> list = q.getData();
	}

}