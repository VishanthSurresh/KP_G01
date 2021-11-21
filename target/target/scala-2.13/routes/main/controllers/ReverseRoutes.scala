// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def topics(query:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "topic/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("query", query)))
    }
  
    // @LINE:12
    def fetchUser(login:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("login", login)))
    }
  
    // @LINE:7
    def search(query:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "lookup/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("query", query)))
    }
  
    // @LINE:9
    def issues(query:String, q1:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "issue/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("query", query)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("q1", q1)))
    }
  
    // @LINE:10
    def issuesstat(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "issuestatistics")
    }
  
    // @LINE:16
    def commits(owner:String, repo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "repos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("owner", owner)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repo", repo)) + "/commits")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
