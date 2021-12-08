package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import org.junit.Test;
import org.mockito.Mockito;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import actors.SearchResultActor;


public class SearchResultActorTest {
	@Test
	public void searchresultactor()
	{
		final ActorSystem actor_searchresult = ActorSystem.create();
		try
		{
			new TestKit(actor_searchresult) {{
                System.out.println(actor_searchresult);
                final Props props = SearchResultActor.getProps();
                final ActorRef searchresultref = actor_searchresult.actorOf(props);
                searchresultref.tell(new SearchResultActor.registration_message(), getRef());
                searchresultref.tell("data",getRef());
                
                within(Duration.ofSeconds(5),()->{
                	expectNoMessage();
                	return null;
                });

            }};
			
		}
		catch (Exception e){
            e.printStackTrace();
        }
        finally {
            TestKit.shutdownActorSystem(actor_searchresult);
        }
	}

}
