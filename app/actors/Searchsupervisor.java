package actors;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.QuerySearchResult;
import play.Logger;
import play.libs.Json;
import java.util.*;

public class Searchsupervisor extends AbstractActor {
    private final ActorRef ws;

    public Searchsupervisor(ActorRef ws) {
    	System.out.println("Inside SearchSupervisor Constructor!");
        this.ws = ws;
    }

    static public Props props(ActorRef ws){
        return Props.create(Searchsupervisor.class, ws);
    }

    @Override
    public void preStart() throws Exception {
    	System.out.println("In SearchSupervisor Pre-Start!!-------------->");
        context().actorSelection("/user/searchResultActor")
        .tell(new SearchResultActor.RegisterMsg(), self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(GithubSearchMessage.class, this::sendTime)
                .build();
    }

    static public class CommitMessage {
        public final ArrayList<Map<String,Integer>> list;
        public CommitMessage(ArrayList<Map<String, Integer>> list){
            this.list = list;
        }
    }
    
    static public class RegisterMsg{

    }
 
    static public class NotifyMessage {
        public final String demo;
        public NotifyMessage(String demotest){
            this.demo = demotest;
        }
    }
    
    static public class GithubSearchMessage {
        public ObjectNode response = Json.newObject();
         public GithubSearchMessage(ObjectNode msg){
             this.response = msg;
         }
     }

     private void sendTime(GithubSearchMessage msg) {
     	System.out.println("Here in SEARCHSUPERVISOR :: " + msg.response.size());
         ws.tell(msg.response, self());
     }

}