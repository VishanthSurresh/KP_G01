package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test method will be used to test the code written for fetching the details of User.
 * @author Bhavitha Yarlagadda
 * */
public class UserTest {
    @Test
    public void constructorTest(){
        User user = new User();
        assertNotNull(user);
    }
	/*int id=1;
	String login="Bhavitha";
	String url="dummy";
	String email="bhavithayarlagadda98@gmail.com";
	String bio="Student";
	String location="India";
	String followers="0";
	String following="0";
	String html_url="dummy1";
	String avatar_url="dummy2";*/
	@Test
	public void constructorTest1(){
	User user1 =new User(1,"Bhavitha","dummy","bhavithayarlagadda98@gmail.com","Student","India","0","0","dummy1","dummy2");
    assertNotNull(user1);
	String result= user1.toString();
	}
	
}