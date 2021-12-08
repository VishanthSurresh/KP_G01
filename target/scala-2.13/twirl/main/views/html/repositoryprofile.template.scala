
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._
/*1.2*/import play.mvc.Http.Request

object repositoryprofile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[String],String,RepoProfile,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(issuesStatistics: List[String],owner : String, y : RepoProfile,repo : String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title></title>
</head>

"""),_display_(/*17.2*/main("Issue Statistics")/*17.26*/ {_display_(Seq[Any](format.raw/*17.28*/("""
"""),format.raw/*18.1*/("""<head>
<style>
a:link """),format.raw/*20.8*/("""{"""),format.raw/*20.9*/("""
  """),format.raw/*21.3*/("""color: black;
  background-color: transparent;
"""),format.raw/*23.1*/("""}"""),format.raw/*23.2*/("""
"""),format.raw/*24.1*/("""a:hover """),format.raw/*24.9*/("""{"""),format.raw/*24.10*/("""
  """),format.raw/*25.3*/("""color: blue;
 """),format.raw/*26.2*/("""}"""),format.raw/*26.3*/("""
 
"""),format.raw/*28.1*/("""</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="topbar">
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      
</nav>
<div class='repository-details' style="padding-top: 1vh;">
<div class="row">  
  <div class = "col-sm-3">
 <div class="repo-url-class" style="padding-left: 2vh;">   
   <img src=""""),_display_(/*39.15*/y/*39.16*/.avatar_url),format.raw/*39.27*/("""" style="width:200px;height:200px;" alt="githuburl"> 
</div>
</div>
<div class="col-sm-8">
  <table class="table table-bordered" style="margin-right: 3vh;">
  
    <tbody>
        <tr>
          <th>Name</th>
            <td>"""),_display_(/*48.18*/y/*48.19*/.name),format.raw/*48.24*/("""</td>
            
        </tr>
        <tr>
          <th>Size</th>
            <td>"""),_display_(/*53.18*/y/*53.19*/.size),format.raw/*53.24*/("""</td>
            
        </tr>
        <tr>
          <th>Visibility</th>
            <td>"""),_display_(/*58.18*/y/*58.19*/.visibility),format.raw/*58.30*/("""</td>
           
        </tr>
         <tr>
          <th>Watchers</th>
            <td>"""),_display_(/*63.18*/y/*63.19*/.watchers_count),format.raw/*63.34*/("""</td>
            
        </tr>
        <tr>
          <th>Forks</th>
            <td>"""),_display_(/*68.18*/y/*68.19*/.forks),format.raw/*68.25*/("""</td>
            
        </tr>
        <tr>
          <th>Stargazers Count</th>
            <td>"""),_display_(/*73.18*/y/*73.19*/.stargazers_count),format.raw/*73.36*/("""</td>
            
        </tr>
        <tr>
          <th>Language</th>
            <td>"""),_display_(/*78.18*/y/*78.19*/.language),format.raw/*78.28*/("""</td>
            
        </tr>
        <tr>
          <th>Open Issues</th>
            <td>"""),_display_(/*83.18*/y/*83.19*/.open_issues),format.raw/*83.31*/("""</td>
            
        </tr>
        <tr>
          <th>Network Count</th>
            <td>"""),_display_(/*88.18*/y/*88.19*/.network_count),format.raw/*88.33*/("""</td>
            
        </tr>
        <tr>
          <th>Subscribers Count</th>
            <td>"""),_display_(/*93.18*/y/*93.19*/.subscribers_count),format.raw/*93.37*/("""</td>
            
        </tr>
          </tbody>
</table>

</div>
<div class="col-sm-1"></div>
</div>
</div>
 <hr>
<div class="row" style="padding-top:3vh">
  <h5 style="padding-left:5vh">Top 20 Issues 
  <a href ="/issuestatistics"  style="text-decoration:none;">&emsp;&emsp;&emsp;Issue Stats</a>
  <a href ="/repos/"""),_display_(/*107.21*/repo),format.raw/*107.25*/("""/commits" style="text-decoration:none;" >&emsp;&emsp;&emsp; Commits</a>
  </h5> 
  <div class="col-sm-10" style="padding-left:5vh">
    <table class="table">
  <thead class="table-dark">
    <tr>
    <th scope="col">Issues</th>
  </tr>
   
  </thead>
  <tbody>
     """),_display_(/*118.7*/for(key <- issuesStatistics) yield /*118.35*/{_display_(Seq[Any](format.raw/*118.36*/("""

    """),format.raw/*120.5*/("""<tr>
      
<td>"""),_display_(/*122.6*/key),format.raw/*122.9*/("""</td>
      
    </tr>
  """)))}),format.raw/*125.4*/("""
  """),format.raw/*126.3*/("""</tbody>
</table>
  </div>
 
</div>
</body>
""")))}),format.raw/*132.2*/("""
"""),format.raw/*133.1*/("""</html>"""))
      }
    }
  }

  def render(issuesStatistics:List[String],owner:String,y:RepoProfile,repo:String): play.twirl.api.HtmlFormat.Appendable = apply(issuesStatistics,owner,y,repo)

  def f:((List[String],String,RepoProfile,String) => play.twirl.api.HtmlFormat.Appendable) = (issuesStatistics,owner,y,repo) => apply(issuesStatistics,owner,y,repo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repositoryprofile.scala.html
                  HASH: 1ab9fb04085fc243d2c28398f745bcd282a0ca31
                  MATRIX: 610->1|987->31|1159->110|1802->728|1835->752|1875->754|1903->755|1952->777|1980->778|2010->781|2084->828|2112->829|2140->830|2175->838|2204->839|2234->842|2275->856|2303->857|2333->860|2983->1483|2993->1484|3025->1495|3278->1721|3288->1722|3314->1727|3428->1814|3438->1815|3464->1820|3584->1913|3594->1914|3626->1925|3744->2016|3754->2017|3790->2032|3905->2120|3915->2121|3942->2127|4068->2226|4078->2227|4116->2244|4234->2335|4244->2336|4274->2345|4395->2439|4405->2440|4438->2452|4561->2548|4571->2549|4606->2563|4733->2663|4743->2664|4782->2682|5131->3003|5157->3007|5451->3274|5496->3302|5536->3303|5570->3309|5614->3326|5638->3329|5695->3355|5726->3358|5802->3403|5831->3404
                  LINES: 23->1|28->2|33->3|47->17|47->17|47->17|48->18|50->20|50->20|51->21|53->23|53->23|54->24|54->24|54->24|55->25|56->26|56->26|58->28|69->39|69->39|69->39|78->48|78->48|78->48|83->53|83->53|83->53|88->58|88->58|88->58|93->63|93->63|93->63|98->68|98->68|98->68|103->73|103->73|103->73|108->78|108->78|108->78|113->83|113->83|113->83|118->88|118->88|118->88|123->93|123->93|123->93|137->107|137->107|148->118|148->118|148->118|150->120|152->122|152->122|155->125|156->126|162->132|163->133
                  -- GENERATED --
              */
          