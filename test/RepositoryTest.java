package models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class RepositoryTest {

	@Test
	public void repoConstructortest() {
		int id = 1;
		String name = "Varshini";
		User owner = null;
		String url = "varshini";
		String desc = "desc";
		List<String> topics = new ArrayList<String>();
		topics.add("hello");
		Repository repo_name = new Repository(name,url);
		repo_name.toString();
	}

}
