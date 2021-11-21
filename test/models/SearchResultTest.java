package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the search results.
 * @author Vishanth 
 * @author Varshini
 * @author Bhavitha
 * @author Shail 
 * @author Heet
 * */
public class SearchResultTest {
    @Test
    public void constructorTest(){
        SearchResult searchResult = new SearchResult();
        assertNotNull(searchResult);
    }
   
}
