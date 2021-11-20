package models;

// import models.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import com.fasterxml.jackson.databind.*;

import github.GithubHelper;
import play.libs.Json;

import static java.util.stream.Collectors.*;

/**
 * This class will store all the data regarding all the Github repo pertaining to a particular search term.
 * @author Varshini
 * @author Vishanth
 * @author Bhavitha
 * @author Heet Patel
 * @author Shail Patel
*/


public class QuerySearchResult {
  private String searchTerm;
  private List<SearchResult> posts;

  public QuerySearchResult(String query) {
    this.searchTerm = query;
    this.posts = new ArrayList<>();
  }

  /**
   * This is the getter method to get the search term associated with the search results
   * @author Varshini
   * @author Vishanth
   * @author Bhavitha
   * @author Heet Patel
   * @author Shail Patel
   * @return The search term associated with this search result
   */
  
  public String getSearchTerm() {
    return searchTerm;
  }

  /**
   * This method is used to fetch the required data associated with a search term from Github, map it to the model class {@link SearchResult},
   * <p>
   * @author Varshini
   * @author Vishanth
   * @author Bhavitha
   * @author Heet Patel
   * @author Shail Patel
   * @param helper - This is the corresponding implementation you want to use to fetch data
   * @return The Github repos under a given search term
   */
  
  public void PopulateData(GithubHelper helper) {
    var response = helper.getSearchResult(this.searchTerm);
    CompletionStage<List<SearchResult>> posts = response.get().thenApplyAsync((WSResponse r) -> {
      try {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> postList = new ArrayList<SearchResult>();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println("Response: *****************"+r.asJson());
		//System.out.println("************************************************************************************8"+r.asJson().get("items").findPath("owner").toString());

        postList = Arrays.asList(mapper.readValue(r.asJson().get("items").toString(), SearchResult[].class));
        //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+mapper.readValue(r.asJson().get("owner").findpath("login").toString()));
        this.posts = postList;
       System.out.println(postList);
        return postList;

      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    });



    // response.get().thenApply(r -> {

    // });
    // FIXME: https://www.playframework.com/documentation/2.8.x/api/java/play/libs/ws/WSRequest.html#stream--
//     response.map(this::mapKeyTermData);
//     this.posts = response;
//         .map(SearchListResponse::getItems)
//         .flatMap(List::parallelStream)
//         .map(this::mapKeyTermData).collect(toList());
  }

  // private SearchResult mapKeyTermData(SearchResult e){
  //   return new SearchResult(e.getId().getVideoId(),e.getSnippet().getChannelId(),e.getSnippet().getChannelTitle(),e.getSnippet().getTitle(), Utility.GetTimeElapsedTillNow(e.getSnippet().getPublishedAt()));
  // }

  /**
   * This is the getter method to return all the repos along with their data under a given search term
   * @return A list of all Github data({@link SearchResult})
   */
  
  public List<SearchResult> getData(){

    System.out.println("Reponse*****"+posts);
    return this.posts;
  }

  /**
   * This is setter method that can be used to set the Github data for given search term
   * @author Vishanth
   * @param posts - List of Github data({@link SearchResult}) for given search term
   */
  
  
  public void setKeyTermData(List<SearchResult> posts) {
    this.posts = posts;
  }

 
}
