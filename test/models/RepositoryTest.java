package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class RepositoryTest {

	@Test
	public void repoConstructortest() {
		Repository rep = new Repository("Bhavitha","dummy");
        assertNotNull(rep);
		String result= rep.toString();
		
		rep.setname("Bhavitha");
		assertNotNull(rep.getname());
		
		rep.seturl("dummy");
		assertNotNull(rep.geturl());
		
		Repository rep1 = new Repository();
		assertNotNull(rep1);
		
	}

}