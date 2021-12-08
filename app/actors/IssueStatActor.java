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
import models.IssueSearchResult;
import models.RepoProfile;
import play.libs.ws.WSClient;

/**
 * This class acts as Actor for Repository Issues Statistics Page
 * @author Varshini
 */
public class IssueStatActor extends AbstractActor{
	
	static public class IssueStatInfo{
		IssueSearchResult cService;
		public IssueStatInfo(IssueSearchResult cService) {
			this.cService = cService;
		}
	}
	
	private final IssueSearchResult issueService;
	
	@Inject
	public IssueStatActor(IssueSearchResult issueService) {
		this.issueService = issueService;
	}
	
	public static Props getProps(IssueSearchResult cs) {
		return Props.create(IssueStatActor.class, () -> new IssueStatActor(cs));
	}

	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(IssueStatInfo.class, this::sendCommitsData)
				.build();
	}
	
	private void sendCommitsData(IssueStatInfo cInfo) {
		try {
			CompletionStage<Map<String, Integer>> cData = cInfo.cService.getIssueStatisticss();
			System.out.println("Output from Issue Statistics ACTOR!!---------> " + cData.toCompletableFuture().get());
			sender().tell(cData.toCompletableFuture().get(), self());
		}
		catch(Exception e) {
			sender().tell(new HashMap<String, Integer>(), self());
		}

	}

}