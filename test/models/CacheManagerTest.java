package models;

import org.junit.Test;

import com.google.inject.Inject;

import play.libs.ws.WSClient;

import static org.junit.Assert.*;

/**
 * This test method will be used to test the search results.
 * */
public class CacheManagerTest {
	@Inject
    private WSClient ws;
	
    @Test
    public void CacheManagerTest(){
        CacheManager cm = new CacheManager(ws);
        assertNotNull(cm);
    }
   
}