package controllers;

import models.*;

import play.mvc.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


import javax.inject.Inject;
import java.io.IOException;

import play.api.libs.json.Json;
import play.libs.ws.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {
    private final WSClient ws;

    @Inject
    public HomeController(WSClient ws) {
        this.ws = ws;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(Http.Request request) {
        var sessionData = request.session().get("searchedTerms");
        System.out.println(sessionData);

        if(!sessionData.isPresent()) {
            System.out.println("23"+request);
            System.out.println(ws);
            return ok(views.html.index.render(new ArrayList<QuerySearchResult>()));
            //  return ok(views.html.index.render();
         } else {
             return ok(views.html.index.render(
                 Arrays.stream(sessionData.get().split(","))
                    .filter(e->!e.isEmpty())
                    .parallel()
                    .map(CacheManager.GetCache(ws)::GetTrimmedSearchResult)
                    .collect(Collectors.toList()))
             );
         }
    }

    public Result search(String query, Http.Request request) {
        var currentSession = request.session().get("searchedTerms").orElse("");
        currentSession += "," + query;
        return redirect("/")
            .addingToSession(request, "searchedTerms", currentSession);
    }
 public Result topic(String query, Http.Request request) {
        var currentSession = request.session().get("searchedTerms").orElse("");
        currentSession += "," + query;
        return redirect("/models/topic.scala.html")
            .addingToSession(request, "searchedTerms", currentSession);
    }


    public Result searchUser(String user, Http.Request request)  {
        // return ok(views.html.index.render());
        return ok(views.html.index.render(new ArrayList<QuerySearchResult>()));
    }

}
