
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

object Userinfo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[User,List[Repository],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user : User, repositories : List[Repository]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
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

"""),_display_(/*16.2*/main("Issue Statistics")/*16.26*/ {_display_(Seq[Any](format.raw/*16.28*/("""
"""),format.raw/*17.1*/("""<head>
<style>
a:link """),format.raw/*19.8*/("""{"""),format.raw/*19.9*/("""
  """),format.raw/*20.3*/("""color: black;
  background-color: transparent;
"""),format.raw/*22.1*/("""}"""),format.raw/*22.2*/("""
"""),format.raw/*23.1*/("""a:hover """),format.raw/*23.9*/("""{"""),format.raw/*23.10*/("""
  """),format.raw/*24.3*/("""color: blue;
 """),format.raw/*25.2*/("""}"""),format.raw/*25.3*/("""
 """),format.raw/*26.2*/("""table tr th"""),format.raw/*26.13*/("""{"""),format.raw/*26.14*/("""
 	"""),format.raw/*27.3*/("""text-align: left;
 """),format.raw/*28.2*/("""}"""),format.raw/*28.3*/("""
"""),format.raw/*29.1*/("""</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="topbar">
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      
</nav>
<div class='repository-details' style="padding-top: 1vh;">
<div class="row">  
  <div class = "col-sm-3">
 <div class="repo-url-class" style="padding-left: 2vh;">   
   <img src=""""),_display_(/*40.15*/user/*40.19*/.avatar_url),format.raw/*40.30*/("""" style="width:200px;height:200px;" alt="githuburl">
</div>
</div>
<div class="col-sm-8">
  <table class="table table-bordered" style="margin-right: 3vh;">
    <tbody>
        <tr>
			<th>UserName</th>
            <td>"""),_display_(/*48.18*/user/*48.22*/.login),format.raw/*48.28*/("""</td>
		    <th>Location</th>
            <td>"""),_display_(/*50.18*/user/*50.22*/.location),format.raw/*50.31*/("""</td>
        </tr>
        <tr>
          <th>ID</th>
            <td>"""),_display_(/*54.18*/user/*54.22*/.id),format.raw/*54.25*/("""</td>
          <th>Followers</th>
            <td>"""),_display_(/*56.18*/user/*56.22*/.followers),format.raw/*56.32*/("""</td>  
        </tr>
        <tr>
          <th>Email</th>
		   <td>"""),_display_(/*60.11*/user/*60.15*/.email),format.raw/*60.21*/("""</td>
           <th>Following</th>
            <td>"""),_display_(/*62.18*/user/*62.22*/.following),format.raw/*62.32*/("""</td>
        </tr>
	    <tr>
          <th>Bio</th>
            <td colspan=3>"""),_display_(/*66.28*/user/*66.32*/.bio),format.raw/*66.36*/("""</td>     
        </tr> 
    </tbody>
  </table>
</div>
<div class="col-sm-1"></div>
</div>
</div>
 <hr>
   <div class="row" style="padding-top:3vh">
  <div class="col-sm-10" style="padding-left:5vh">
    <table class="table">
  <thead class="table-dark">
    <tr>
    <th scope="col">Repos Under User</th>
  </tr>
   
  </thead>
  <tbody>
     """),_display_(/*85.7*/for(repository <- repositories) yield /*85.38*/{_display_(Seq[Any](format.raw/*85.39*/("""

    """),format.raw/*87.5*/("""<tr>
      
<td><a href="/issue/"""),_display_(/*89.22*/user/*89.26*/.login),format.raw/*89.32*/("""/"""),_display_(/*89.34*/repository/*89.44*/.name),format.raw/*89.49*/("""">"""),_display_(/*89.52*/repository/*89.62*/.name),format.raw/*89.67*/("""</a></td>
      
    </tr>
  """)))}),format.raw/*92.4*/("""
  """),format.raw/*93.3*/("""</tbody>
</table>
  </div>
 
</div>
</body>
""")))}),format.raw/*99.2*/("""
"""),format.raw/*100.1*/("""</html>"""))
      }
    }
  }

  def render(user:User,repositories:List[Repository]): play.twirl.api.HtmlFormat.Appendable = apply(user,repositories)

  def f:((User,List[Repository]) => play.twirl.api.HtmlFormat.Appendable) = (user,repositories) => apply(user,repositories)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/Userinfo.scala.html
                  HASH: 28ce76bde11223c8843515926eb3f9a1af067c07
                  MATRIX: 925->1|1065->48|1708->666|1741->690|1781->692|1809->693|1858->715|1886->716|1916->719|1990->766|2018->767|2046->768|2081->776|2110->777|2140->780|2181->794|2209->795|2238->797|2277->808|2306->809|2336->812|2382->831|2410->832|2438->833|3088->1456|3101->1460|3133->1471|3379->1690|3392->1694|3419->1700|3493->1747|3506->1751|3536->1760|3635->1832|3648->1836|3672->1839|3751->1891|3764->1895|3795->1905|3892->1975|3905->1979|3932->1985|4012->2038|4025->2042|4056->2052|4163->2132|4176->2136|4201->2140|4574->2487|4621->2518|4660->2519|4693->2525|4753->2558|4766->2562|4793->2568|4822->2570|4841->2580|4867->2585|4897->2588|4916->2598|4942->2603|5002->2633|5032->2636|5107->2681|5136->2682
                  LINES: 27->1|32->2|46->16|46->16|46->16|47->17|49->19|49->19|50->20|52->22|52->22|53->23|53->23|53->23|54->24|55->25|55->25|56->26|56->26|56->26|57->27|58->28|58->28|59->29|70->40|70->40|70->40|78->48|78->48|78->48|80->50|80->50|80->50|84->54|84->54|84->54|86->56|86->56|86->56|90->60|90->60|90->60|92->62|92->62|92->62|96->66|96->66|96->66|115->85|115->85|115->85|117->87|119->89|119->89|119->89|119->89|119->89|119->89|119->89|119->89|119->89|122->92|123->93|129->99|130->100
                  -- GENERATED --
              */
          