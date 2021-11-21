package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the search results.
 * */
public class CacheManagerTest {
    @Test
    public void CacheManagerTest(){
        CacheManager cm = new CacheManager();
        assertNotNull(cm);
    }
   
}