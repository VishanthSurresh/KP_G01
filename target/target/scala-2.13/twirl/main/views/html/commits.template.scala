
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

object commits extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.CommitsResult,List[String],Map[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(results: models.CommitsResult, keys: List[String], commitData: Map[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
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
 
"""),format.raw/*30.1*/("""</style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="topbar">
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific/Repository Commits</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      
</nav>
 <div class='repository-details' style="padding-top: 1vh;">
<div class="row">  
 
<div class="col-sm-8" style="margin-left:0.8vh">
   
  		
			<table class="table table-bordered" style="margin-right: 1vh;margin-top: 3vh">
			  <tbody>
					<tr>
						<th>Maximum no.of additions </th>
						<td>"""),_display_(/*48.12*/results/*48.19*/.maxAdd),format.raw/*48.26*/("""</td>
  
						<th>Minimum no.of additions</th>
						<td>"""),_display_(/*51.12*/results/*51.19*/.minAdd),format.raw/*51.26*/("""</td>

						<th>Average no.of additions </th>
						<td>"""),_display_(/*54.12*/results/*54.19*/.avgAdd),format.raw/*54.26*/("""</td>
					  </tr> 

					  <tr>
						<th>Maximum no.of deletions</th>
						<td>"""),_display_(/*59.12*/results/*59.19*/.maxDel),format.raw/*59.26*/("""</td>
  
						<th>Minumum no.of deletions</th>
						<td>"""),_display_(/*62.12*/results/*62.19*/.minDel),format.raw/*62.26*/("""</td>

						<th>Average no.of deletions</th>
						<td>"""),_display_(/*65.12*/results/*65.19*/.avgDel),format.raw/*65.26*/("""</td>
					  </tr> 

 
				  </tbody> 
				</table>
			</div>

		</div>
		<div class="col-sm-1"></div>
</div>
</div>
 <hr>
<div class="row" style="padding-top:3vh">
  <div class="col-sm-10">
    <table class="table">
  <thead class="table-dark">
    <tr>
    <th colspan=3>Showing Top """),_display_(/*83.32*/keys/*83.36*/.size()),format.raw/*83.43*/(""" """),format.raw/*83.44*/("""users with highest no.of commits</th>
  </tr>
   
  </thead>
  <tbody>
  <tr>
				<th>User name</th>
                <th>Commits count</th>
                <th>User Profile Link</th>

              </tr>
                       
             """),_display_(/*95.15*/for(key<-keys) yield /*95.29*/{_display_(Seq[Any](format.raw/*95.30*/("""
					"""),format.raw/*96.6*/("""<tr>	
						<td>"""),_display_(/*97.12*/key),format.raw/*97.15*/("""</td>
						<td>"""),_display_(/*98.12*/commitData/*98.22*/.get(key)),format.raw/*98.31*/("""</td>
						<td><a href='/users/"""),_display_(/*99.28*/key),format.raw/*99.31*/("""'>"""),_display_(/*99.34*/key),format.raw/*99.37*/("""</td>						
					</tr>				
				""")))}),format.raw/*101.6*/("""
               
            
            """),format.raw/*104.13*/("""</tbody> 
</div>
</body>
""")))}),format.raw/*107.2*/("""
"""),format.raw/*108.1*/("""</html>"""))
      }
    }
  }

  def render(results:models.CommitsResult,keys:List[String],commitData:Map[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(results,keys,commitData)

  def f:((models.CommitsResult,List[String],Map[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (results,keys,commitData) => apply(results,keys,commitData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/commits.scala.html
                  HASH: 034a137f124805c0392a66bfb2c5eb12c1902de2
                  MATRIX: 957->1|1137->86|1165->88|1822->720|1855->744|1895->746|1924->748|1975->772|2003->773|2034->777|2110->826|2138->827|2167->829|2202->837|2231->838|2262->842|2304->857|2332->858|2362->861|2401->872|2430->873|2461->877|2508->897|2536->898|2568->903|3372->1680|3388->1687|3416->1694|3505->1756|3521->1763|3549->1770|3637->1831|3653->1838|3681->1845|3796->1933|3812->1940|3840->1947|3929->2009|3945->2016|3973->2023|4060->2083|4076->2090|4104->2097|4435->2401|4448->2405|4476->2412|4505->2413|4786->2667|4816->2681|4855->2682|4889->2689|4934->2707|4958->2710|5003->2728|5022->2738|5052->2747|5113->2781|5137->2784|5167->2787|5191->2790|5256->2824|5330->2869|5390->2898|5420->2900
                  LINES: 27->1|32->1|33->2|47->16|47->16|47->16|48->17|50->19|50->19|51->20|53->22|53->22|54->23|54->23|54->23|55->24|56->25|56->25|57->26|57->26|57->26|58->27|59->28|59->28|61->30|79->48|79->48|79->48|82->51|82->51|82->51|85->54|85->54|85->54|90->59|90->59|90->59|93->62|93->62|93->62|96->65|96->65|96->65|114->83|114->83|114->83|114->83|126->95|126->95|126->95|127->96|128->97|128->97|129->98|129->98|129->98|130->99|130->99|130->99|130->99|132->101|135->104|138->107|139->108
                  -- GENERATED --
              */
          