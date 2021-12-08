package actors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.*;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import models.CommitsResult;
import play.libs.ws.WSClient;
import services.Commitservices;


/**
 * The class acts as Actor for Repository Commits
 * @author vishanth 
 */
public class CommitsActor extends AbstractActor{
	
	static public class CommitInfo{
		public final String user_name;
		public final String repository_name;
		Commitservices commits_service;
		public CommitInfo(String user_name, String repository_name, Commitservices commits_service) {
			this.user_name = user_name;
			this.repository_name = repository_name;
			this.commits_service = commits_service;
		}
	}
	
	private final Commitservices commitService;
	
	@Inject
	public CommitsActor(Commitservices commitService)
	{
		this.commitService=commitService;
	}
	
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(CommitInfo.class, this::sendCommitsData)
				.build();
	}
	
	
	public static Props getProps(Commitservices cs) {
		return Props.create(CommitsActor.class, () -> new CommitsActor(cs));
	}

	
	
	private void sendCommitsData(CommitInfo cInfo) {
		try {
			CompletionStage<List<CommitsResult>> cData = cInfo.commits_service.get_commits_data(cInfo.user_name, cInfo.repository_name);
			System.out.println("Output from COMMITS_ACTOR!!----------> ");
			sender().tell(cData.toCompletableFuture().get(), self());
		}
		catch(InterruptedException e) {
			sender().tell(new CommitsResult(), self());
		}
		catch(ExecutionException e) {
			sender().tell(new CommitsResult(), self());
		}
	}

}