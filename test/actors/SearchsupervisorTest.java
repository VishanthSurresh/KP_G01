package actors;
import org.junit.Test;
import static org.junit.Assert.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;
import org.junit.Test;
import org.mockito.Mockito;
import actors.Searchsupervisor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


public class SearchsupervisorTest {
	private final ActorRef ws = null;
	@Test
	public void searchsupervisortest()
	{
        final ActorSystem actorSystem = ActorSystem.create();
        try {
        	new TestKit(actorSystem) {{
        		 System.out.println(actorSystem);
                 final Props props = Searchsupervisor.props(ws);
                 final ActorRef search_supervisor = actorSystem.actorOf(props);
                 search_supervisor.tell(new Searchsupervisor.RegisterMsg(), getRef());
                 search_supervisor.tell("data",getRef());
        	}};
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            TestKit.shutdownActorSystem(actorSystem);
        }
	}
}
