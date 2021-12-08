package models;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the code written for fetching the details of User.
 * @author Varshini
 * */
public class RepoIssuesTest {
    @Test
    public void constructorTest(){
        RepoIssues issue = new RepoIssues();
        assertNotNull(issue);
    }
    public void testSetter(){
        RepoIssues rt=new RepoIssues();
        rt.setTitle("wooo");
        assertTrue(rt.getTitle()=="wooo");
    }
    public void testGetter(){
        RepoIssues rt=new RepoIssues();
        rt.setTitle("wooo");
        assertTrue(rt.getTitle()=="wooo");
    }
   @Test
    public void repoissues()
    {
    	String issues="vishanth";
    	RepoIssues ex = new RepoIssues(issues);
    	assertNotNull(ex);
    	
    }
}