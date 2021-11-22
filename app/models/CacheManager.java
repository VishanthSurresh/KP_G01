package models;

import models.*;
import play.mvc.*;
import play.libs.ws.*;

import java.util.List;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

import github.GithubHelper;

import java.util.stream.Collectors;

/**
 * This class is a Singleton class which handles caching of already searched terms
 * @author Varshini
 * @author Vishanth
 * @author Bhavitha
 * @author Heet Patel
 * @author Shail Patel
 */
@Singleton
public class CacheManager {
  private static CacheManager cache = null;
  private static HashMap<String, QuerySearchResult> results;
  private static HashMap<String,IssueSearchResult> ownerInfoResults;
  private static GithubHelper helper;
  
  /**
   * CacheManager private default Constructor. This initializes the CacheManager object only once
   * @author Varshini
   * @author Vishanth
   * @author Bhavitha
   * @author Heet Patel
   * @author Shail Patel
   */

  public CacheManager() {
  }
  
  /**
   * This will be used to get the cache object
   * @author Varshini
   * @author Vishanth
   * @author Bhavitha
   * @author Heet Patel
   * @author Shail Patel
   * @return The singleton cache object {@link CacheManager}
   * */

  @Inject
  public static CacheManager GetCache(WSClient ws){
    if (cache==null) {
      cache = new CacheManager();
      helper = new GithubHelper(ws);
      results = new HashMap<>();
    }

    return cache;
  }

    public QuerySearchResult GetFullSearchResult(String keyTerm){
      System.out.println(keyTerm);
      if(!results.containsKey(keyTerm)) AddToCache(keyTerm);
      return results.get(keyTerm);
  }
    
    /**
     * This method will return the Trimmed result set for given search term i.e only top 10 results which need to be shown to user. This will first fetch and store the data if it is not already present
     * @author Varshini
     * @author Vishanth
     * @author Bhavitha
     * @author Heet Patel
     * @author Shail Patel
     * @param keyTerm - The search term for which you want to fetch the result
     * @return The result of type {@link QuerySearchResult} which will contain only 10 results for that search term
     * */

  public QuerySearchResult GetTrimmedSearchResult(String keyTerm){
      if(!results.containsKey(keyTerm)) AddToCache(keyTerm);

      var returnData = new QuerySearchResult(keyTerm);
      returnData.setKeyTermData(results.get(keyTerm).getData().stream().limit(10).collect(Collectors.toList()));
      return returnData;
  }

  /**
   * This method will add search results for a new keyterm to the cache. This will call the PopulateData method of {@link QuerySearchResult}
   * @author Varshini
   * @author Vishanth
   * @author Bhavitha
   * @author Heet Patel
   * @author Shail Patel
   * @param keyTerm - This is the search term for which we need to add the corresponding result to cache
   * @return {@link SearchResult}
   * */

  private void AddToCache(String keyTerm){
      var result = new QuerySearchResult(keyTerm);
      result.PopulateData(helper);
      results.put(keyTerm, result);
  }

  
}
