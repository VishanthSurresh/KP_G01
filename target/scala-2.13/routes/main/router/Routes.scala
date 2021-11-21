// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:20
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:20
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """lookup/""" + "$" + """query<[^/]+>""", """controllers.HomeController.search(query:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """topic/""" + "$" + """query<[^/]+>""", """controllers.HomeController.topics(query:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """issue/""" + "$" + """query<[^/]+>/""" + "$" + """q1<[^/]+>""", """controllers.HomeController.issues(query:String, q1:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """issuestatistics""", """controllers.HomeController.issuesstat()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """login<[^/]+>""", """controllers.HomeController.fetchUser(login:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repos/""" + "$" + """owner<[^/]+>/""" + "$" + """repo<[^/]+>/commits""", """controllers.HomeController.commits(owner:String, repo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_0.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_search1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("lookup/"), DynamicPart("query", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_search1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_0.search(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "search",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """lookup/""" + "$" + """query<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_topics2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("topic/"), DynamicPart("query", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_topics2_invoker = createInvoker(
    HomeController_0.topics(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "topics",
      Seq(classOf[String]),
      "GET",
      this.prefix + """topic/""" + "$" + """query<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_issues3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("issue/"), DynamicPart("query", """[^/]+""",true), StaticPart("/"), DynamicPart("q1", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_issues3_invoker = createInvoker(
    HomeController_0.issues(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "issues",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """issue/""" + "$" + """query<[^/]+>/""" + "$" + """q1<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_issuesstat4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("issuestatistics")))
  )
  private[this] lazy val controllers_HomeController_issuesstat4_invoker = createInvoker(
    HomeController_0.issuesstat(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "issuesstat",
      Nil,
      "GET",
      this.prefix + """issuestatistics""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_fetchUser5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("login", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_fetchUser5_invoker = createInvoker(
    HomeController_0.fetchUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "fetchUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users/""" + "$" + """login<[^/]+>""",
      """GET      /user/:id                     controllers.HomeController.searchUser(id: String)""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_commits6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repos/"), DynamicPart("owner", """[^/]+""",true), StaticPart("/"), DynamicPart("repo", """[^/]+""",true), StaticPart("/commits")))
  )
  private[this] lazy val controllers_HomeController_commits6_invoker = createInvoker(
    HomeController_0.commits(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "commits",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """repos/""" + "$" + """owner<[^/]+>/""" + "$" + """repo<[^/]+>/commits""",
      """ GET    /explore                     controllers.HomeController.explore
 GET    /tutorial                    controllers.HomeController.tutorial
GET     /search/repository/:name    controllers.HomeController.Name(name: String)""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_0.index(req))
      }
  
    // @LINE:7
    case controllers_HomeController_search1_route(params@_) =>
      call(params.fromPath[String]("query", None)) { (query) =>
        controllers_HomeController_search1_invoker.call(
          req => HomeController_0.search(query, req))
      }
  
    // @LINE:8
    case controllers_HomeController_topics2_route(params@_) =>
      call(params.fromPath[String]("query", None)) { (query) =>
        controllers_HomeController_topics2_invoker.call(HomeController_0.topics(query))
      }
  
    // @LINE:9
    case controllers_HomeController_issues3_route(params@_) =>
      call(params.fromPath[String]("query", None), params.fromPath[String]("q1", None)) { (query, q1) =>
        controllers_HomeController_issues3_invoker.call(HomeController_0.issues(query, q1))
      }
  
    // @LINE:10
    case controllers_HomeController_issuesstat4_route(params@_) =>
      call { 
        controllers_HomeController_issuesstat4_invoker.call(HomeController_0.issuesstat())
      }
  
    // @LINE:12
    case controllers_HomeController_fetchUser5_route(params@_) =>
      call(params.fromPath[String]("login", None)) { (login) =>
        controllers_HomeController_fetchUser5_invoker.call(HomeController_0.fetchUser(login))
      }
  
    // @LINE:16
    case controllers_HomeController_commits6_route(params@_) =>
      call(params.fromPath[String]("owner", None), params.fromPath[String]("repo", None)) { (owner, repo) =>
        controllers_HomeController_commits6_invoker.call(HomeController_0.commits(owner, repo))
      }
  
    // @LINE:20
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
