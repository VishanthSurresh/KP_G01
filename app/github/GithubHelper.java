package github;

import models.*;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import play.mvc.*;
import play.api.libs.json.Json;
import play.libs.ws.*;
import play.api.Application;
import java.util.concurrent.CompletionStage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

// import com.fasterxml.jackson.databind.JsonNode;

public class GithubHelper {
  private final WSClient ws;

  private static String endpoint = "https://api.github.com/search/repositories";
  private static String endpointRepo = "https://api.github.com/repos/";
  private static String endpointIssues = "https://api.github.com/repos/REPO_NAME/issues";

  @Inject
  public GithubHelper(WSClient ws) {
    this.ws = ws;
  }

  /**
   * This method returns the search result from Github API
   * @param query
   * @return
   */
  public WSRequest getSearchResult(String query) {
  	System.out.println("query --" + query);

    WSRequest req = ws.url(endpoint);
    req.addQueryParameter("q", query);
     System.out.println("Request Object: "+req);
    return req;
  }

  /**
   * This method returns the details about Repository
   * @param query
   * @return
   */
  
  public WSRequest getRepoResult(String query) {
	  System.out.println("query --" + query);
	  
	  WSRequest req = ws.url(endpointRepo+query);
	  System.out.println("Request Object: "+req);
	  return req;
  }

  /**
   * This method returns the issues from Github API
   * @author Varshini
   * @param repo
   * @return
   */
  
  public CompletionStage<List<RepoIssues>> getIssues(String repo) {
	// TODO Auto-generated method stub
	WSRequest request = ws.url("https://api.github.com/repos"+ "/" + repo + "/issues");
	ObjectMapper objectMapper = new ObjectMapper();

	return request.addHeader("Accept", "application/vnd.github.v3+json").get().thenApply(r -> {
		List<RepoIssues> issues = null;
		try {
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			issues = objectMapper.readValue(r.asJson().toPrettyString(), new TypeReference<List<RepoIssues>>() {
			});

		} catch (Exception e) {
			return null;
		}
		return issues;
	});
}
  
  /**
   * This method returns the Topics from Github API
   * @author Heet Patel
   * @param repo
   * @return
   */
  
public CompletionStage<List<Topics>> getTopic(String repo) {
	// TODO Auto-generated method stub
	WSRequest request = ws.url(endpoint);
	ObjectMapper objectMapper = new ObjectMapper();
	request.addQueryParameter("q", repo);
	return request.addHeader("Accept", "application/vnd.github.v3+json").get().thenApply(r -> {
		List<Topics> issues = null;
		try {
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			issues = objectMapper.readValue(r.asJson().get("items").toString(), new TypeReference<List<Topics>>() {
			});
			
		} catch (Exception e) {
			return null;
		}
		return issues;
	});
}


}