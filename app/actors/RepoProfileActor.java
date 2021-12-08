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
 * This class Acts as Actor for Repository Profile Page
 * @author Shail Patel
 */

public class RepoProfileActor extends AbstractActor{
	
	static public class RepoInfo{
		public final String reponame;
		IssueSearchResult cService;
		public RepoInfo( String reponame, IssueSearchResult cService) {
			this.reponame = reponame;
			this.cService = cService;
		}
	}
	
	private final IssueSearchResult issueService;
	
	@Inject
	public RepoProfileActor(IssueSearchResult issueService) {
		this.issueService = issueService;
	}
	
	public static Props getProps(IssueSearchResult cs) {
		return Props.create(RepoProfileActor.class, () -> new RepoProfileActor(cs));
	}

	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(RepoInfo.class, this::sendCommitsData)
				.build();
	}
	
	private void sendCommitsData(RepoInfo cInfo) {
		try {
			CompletionStage<List<String>> cData = cInfo.cService.getIssueStatistics(cInfo.reponame);
			cInfo.cService.repoDetail(cInfo.reponame);
			RepoProfile rp = cInfo.cService.getData();
			System.out.println("Output from Repository Profile ACTOR!!-----> " + cData.toCompletableFuture().get() + " Repository details from Actor!!--> " + rp.toString());
			sender().tell(cData.toCompletableFuture().get(), self());
		}
		catch(Exception e) {
			sender().tell(new ArrayList<String>(), self());
		}
//		catch(ExecutionException e) {
//			sender().tell(new RepoProfile(), self());
//		}
	}

}