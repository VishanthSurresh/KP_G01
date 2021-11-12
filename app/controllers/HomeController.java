package controllers;

import java.util.Map;

import javax.inject.Inject;

import model.KeyTermData;
import model.SearchRepo;
import play.data.DynamicForm;
import play.data.Form;
import play.data.Form.*;
import play.data.FormFactory;
import play.mvc.*;
import views.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	@Inject
	FormFactory formFactory;
	Form<KeyTermData> searchForm = formFactory.form(KeyTermData.class);
	/**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	
    	return ok(views.html.index.render(searchForm));
    }

    public Result result(Http.Request request) {
    	KeyTermData loginForm = searchForm.bindFromRequest(request).get();
        String result = SearchRepo.getReposByKeyword(loginForm.keyTerm);
        return ok(result);
    }
}
