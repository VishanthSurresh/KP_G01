
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

object topic extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(titles: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.24*/("""
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
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      
</nav>
<div class='repository-details' style="padding-top: 1vh;">
<div class="row">  
   <div class="col-sm-8">
   <table class="table">
   <thead class="table-dark">
   <tr><th>Top 10 Topic Repositories</th></tr>
   </thead>
   <tbody>
   """),_display_(/*44.5*/for(t <- titles) yield /*44.21*/{_display_(Seq[Any](format.raw/*44.22*/("""
    """),format.raw/*45.5*/("""<tr>
    <td>"""),_display_(/*46.10*/t),format.raw/*46.11*/("""</td>
    </tr>
    """)))}),format.raw/*48.6*/("""
    """),format.raw/*49.5*/("""</tbody>
    </table>
 </div>
</div>
</body>
""")))}),format.raw/*54.2*/("""
"""),format.raw/*55.1*/("""</html>"""))
      }
    }
  }

  def render(titles:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(titles)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (titles) => apply(titles)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/topic.scala.html
                  HASH: c4e855222b7740e19d5e4c08be76164ddc12f84d
                  MATRIX: 610->1|949->32|1066->54|1094->56|1749->686|1782->710|1822->712|1851->714|1902->738|1930->739|1961->743|2037->792|2065->793|2094->795|2129->803|2158->804|2189->808|2231->823|2259->824|2289->827|2328->838|2357->839|2390->845|2437->865|2465->866|2494->868|3212->1560|3244->1576|3283->1577|3316->1583|3358->1598|3380->1599|3433->1622|3466->1628|3547->1679|3576->1681
                  LINES: 23->1|28->2|33->2|34->3|47->16|47->16|47->16|48->17|50->19|50->19|51->20|53->22|53->22|54->23|54->23|54->23|55->24|56->25|56->25|57->26|57->26|57->26|58->27|59->28|59->28|60->29|75->44|75->44|75->44|76->45|77->46|77->46|79->48|80->49|85->54|86->55
                  -- GENERATED --
              */
          