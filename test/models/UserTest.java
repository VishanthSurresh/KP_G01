package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * This test method will be used to test the code written for fetching the details of User.
 * @author Bhavitha Yarlagadda
 * */
public class UserTest {
    @Test
    public void userConstructorTest(){
        User user = new User(1,"Bhavitha","dummy","bhavithayarlagadda98@gmail.com","Student","India","0","0","dummy1","dummy2");
        assertNotNull(user);
		String result= user.toString();
		
		user.setAvatar_url("dummy2");
		assertNotNull(user.getAvatar_url());

		user.sethtml_url("dummy1");
		assertNotNull(user.gethtml_url());	
	
		user.setfollowing("0");
		assertNotNull(user.getfollowing());	

		user.setfollowers("0");
		assertNotNull(user.getfollowers());	
	
		user.setlocation("India");
		assertNotNull(user.getlocation());	
	
		user.setbio("Student");
		assertNotNull(user.getbio());	

		user.setemail("bhavithayarlagadda98@gmail.com");
		assertNotNull(user.getemail());	

		user.seturl("dummy");
		assertNotNull(user.geturl());	

		user.setlogin("Bhavitha");
		assertNotNull(user.getlogin());	

		user.setid(1);
		assertNotNull(user.getid());

		User user1 = new User();
		assertNotNull(user1);
    }
	
	
	
}