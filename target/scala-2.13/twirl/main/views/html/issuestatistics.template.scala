
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

object issuestatistics extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(issuesStatistics: Map[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.42*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
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
    """),format.raw/*27.5*/("""text-align: left;
 """),format.raw/*28.2*/("""}"""),format.raw/*28.3*/("""
"""),format.raw/*29.1*/("""</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="topbar">
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific/Issue Statistics</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      
</nav>
<div class='repository-details' style="padding-top: 1vh;">
<div class="row">  
   <div class="col-sm-8">
   <table class="table">
   <thead class="table-dark">
   <tr>
   	<th>Issue</th>
   	<th>Count</th>
   </tr>
   </thead>
   <tbody>
   """),_display_(/*47.5*/for((key, value) <- issuesStatistics) yield /*47.42*/{_display_(Seq[Any](format.raw/*47.43*/("""
    """),format.raw/*48.5*/("""<tr>
    <td>"""),_display_(/*49.10*/key),format.raw/*49.13*/("""</td>
    <td>"""),_display_(/*50.10*/value),format.raw/*50.15*/("""</td>
    </tr>
    """)))}),format.raw/*52.6*/("""
    """),format.raw/*53.5*/("""</tbody>
    </table>
 </div>
</div>
</body>
""")))}),format.raw/*58.2*/("""
"""),format.raw/*59.1*/("""</html>

"""))
      }
    }
  }

  def render(issuesStatistics:Map[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(issuesStatistics)

  def f:((Map[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (issuesStatistics) => apply(issuesStatistics)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/issuestatistics.scala.html
                  HASH: 5f15e412455e5462819f9ee496cf35bbc09440af
                  MATRIX: 610->1|967->32|1102->72|1130->74|1785->704|1818->728|1858->730|1887->732|1938->756|1966->757|1997->761|2073->810|2101->811|2130->813|2165->821|2194->822|2225->826|2267->841|2295->842|2325->845|2364->856|2393->857|2426->863|2473->883|2501->884|2530->886|3276->1606|3329->1643|3368->1644|3401->1650|3443->1665|3467->1668|3510->1684|3536->1689|3589->1712|3622->1718|3703->1769|3732->1771
                  LINES: 23->1|28->2|33->2|34->3|47->16|47->16|47->16|48->17|50->19|50->19|51->20|53->22|53->22|54->23|54->23|54->23|55->24|56->25|56->25|57->26|57->26|57->26|58->27|59->28|59->28|60->29|78->47|78->47|78->47|79->48|80->49|80->49|81->50|81->50|83->52|84->53|89->58|90->59
                  -- GENERATED --
              */
          