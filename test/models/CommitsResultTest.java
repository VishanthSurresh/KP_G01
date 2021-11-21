package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the search results.
 * @author Vishanth Surresh
 * */
public class CommitsResultTest {
    @Test
    public void constructorTest(){
        CommitsResult commitresult = new CommitsResult();
        assertNotNull(commitresult);
    }
    @Test
    public void testSetter(){
		CommitsResult cr1=new CommitsResult();
		String uname=cr1.get_user_name();
		String uadd=cr1.get_additions();
		String udel=cr1.get_deletions();
        CommitsResult cr=new CommitsResult("vishanth","surresh","titu");
        assertTrue(cr.get_user_name()=="vishanth");
        assertTrue(cr.get_additions()=="surresh");
        assertTrue(cr.get_deletions()=="titu");
    }
}
