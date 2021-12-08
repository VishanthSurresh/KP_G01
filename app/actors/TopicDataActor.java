package actors;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.*;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.libs.ws.WSClient;
import models.*;

/**
 * This class Acts as Actor for Topics page
 * @author Heet Patel
 */

public class TopicDataActor extends AbstractActor {
	
	static public class TopicDetails {
		public final String topicName;
		public TopicService t;
		public TopicDetails(String topicName,TopicService t) {
			this.topicName = topicName;
			this.t=t;

		}
	}
	
	private final TopicService a;
	@Inject
	public TopicDataActor(TopicService a) {
		this.a = a;
	}

	public static Props getProps(TopicService s) {
		return Props.create(TopicDataActor.class, () -> new TopicDataActor(s));
	}

	@Override
	public Receive createReceive() {
		 return receiveBuilder()
			        .match(TopicDetails.class, this::sendRepoData)
			        .build();
	}
	
	private void sendRepoData(TopicDetails topicData) {
		try {
		CompletionStage<List<String>> response = topicData.t.getTopics(topicData.topicName);
		System.out.println("Response from Topic Data ACTOR --> "+response.toCompletableFuture().get());
		sender().tell(response.toCompletableFuture().get(), self());
		}
		catch(InterruptedException e) {
			sender().tell(new ArrayList<String>(), self());
		}
		catch(ExecutionException e) {
			sender().tell(new ArrayList<String>(), self());
		}
	}

}