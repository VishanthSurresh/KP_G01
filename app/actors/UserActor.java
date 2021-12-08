package actors;
import models.*;
import actors.TopicDataActor;
import actors.RepoProfileActor;
import actors.RepoProfileActor.RepoInfo;
import actors.TopicDataActor.TopicDetails;
import actors.UserActor;
import actors.UserActor.UserInfo;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import services.Commitservices;
import services.Userservices;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import github.GithubHelper;
import java.io.IOException;
import play.api.libs.json.Json;
import play.libs.ws.*;
import akka.actor.*;
import akka.stream.Materializer;
import actors.CommitsActor;
import actors.CommitsActor.CommitInfo;
import static akka.pattern.Patterns.ask;

/**
 * This class acts as Actor for User page
 * @author Bhavitha
 *
 */

public class UserActor extends AbstractActor{
	
	static public class UserInfo{
		public final String owner;
		Userservices uService;
		public UserInfo(String owner,Userservices uService) {
			this.owner=owner;
			this.uService=uService;
		}
	}
	
	private final Userservices userService;
	
	@Inject
	public UserActor(Userservices userService) {
		this.userService = userService;
	}
	
	public static Props getProps(Userservices us) {
		return Props.create(UserActor.class, () -> new UserActor(us));
	}

	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(UserInfo.class, this::sendUserData)
				.build();
	}
	
	private void sendUserData(UserInfo uInfo) {
		try {
			CompletionStage<User> uData = uInfo.uService.getUserData(uInfo.owner);
			//uInfo.uService.getUserData(uInfo.owner);
			//User up = uInfo.uService.getData();
			System.out.println("Response From USER ACTOR!!--> " + uData.toCompletableFuture().get());
			sender().tell(uData.toCompletableFuture().get(), self());
		}
		catch(Exception e) {
			sender().tell(new User(), self());
		}
		/*catch(ExecutionException e) {
			sender().tell(new User(), self());
		}*/
	}

}