
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[QuerySearchResult],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : List[QuerySearchResult]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import scala.collection.View._
/*3.2*/import helper._


Seq[Any](format.raw/*4.1*/("""<!DOCTYPE html>
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
<body>
"""),_display_(/*18.2*/main("Welcome")/*18.17*/ {_display_(Seq[Any](format.raw/*18.19*/("""
"""),format.raw/*19.1*/("""<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="topbar">
    <div class="container-fluid" > <a class="navbar-brand" href="#">Gitterrific</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="justify-content: right;margin-right: 2vh;">
           
             <div class="search-wrapper">
    <div class="search-wrapper__box">
      <div style="margin-bottom: 1em">
        <input
          type="text"
          class="search-wrapper__input"
          name="q"
          placeholder="Enter Search Term"
          id="searchBox"
        />
        <button><a href="#" class="search-wrapper__action" id="go">Search</a></button>
      </div>
    </div>  
</div>
        </div>
    </div>
</nav>
<div class="container" style="margin-top:10vh;"> 

 """),_display_(/*42.3*/for((record,index) <- data.zipWithIndex) yield /*42.43*/{_display_(Seq[Any](format.raw/*42.44*/(""" 
"""),format.raw/*43.1*/("""<div class="table-div" style="padding: 2vh;">
  
<caption >Search terms: """),_display_(/*45.26*/record/*45.32*/.getSearchTerm()),format.raw/*45.48*/(""" """),format.raw/*45.49*/("""</caption>    

<table style="margin-top:1vh;" class="m-auto table table-striped table-hover">
  
  <thead>
    <tr>

      <th scope="col" style="width:40%">User Name</th>
      <th scope="col" style="width:40%">Repo Name</th>
      <th scope="col" style="width:40%">Topic</th>
      
    </tr>
  </thead>
  <tbody>
    """),_display_(/*59.6*/for(post  <- record.getData()) yield /*59.36*/ {_display_(Seq[Any](format.raw/*59.38*/("""
    """),format.raw/*60.5*/("""<tr>
	  <td><span id = """),_display_(/*61.20*/index),_display_(/*61.26*/post/*61.30*/.full_name),format.raw/*61.40*/("""></span>
      </td>
      <td><span><a  href="/issue/"""),_display_(/*63.35*/post/*63.39*/.full_name),format.raw/*63.49*/("""">"""),_display_(/*63.52*/post/*63.56*/.name),format.raw/*63.61*/("""</a></span>
      </td>
      
      <td>"""),_display_(/*66.12*/for(topic<- post.topics) yield /*66.36*/{_display_(Seq[Any](format.raw/*66.37*/("""
              """),format.raw/*67.15*/("""<span><a href="/topic/"""),_display_(/*67.38*/topic),format.raw/*67.43*/(""" """),format.raw/*67.44*/("""">["""),_display_(/*67.48*/topic),format.raw/*67.53*/("""]</a></span>
              """)))}),format.raw/*68.16*/("""</td>
        <script>
        var names = """"),_display_(/*70.23*/post/*70.27*/.full_name),format.raw/*70.37*/("""";
        var profile_name = names.split("/")[0];
        var mydiv = document.getElementById(""""),_display_(/*72.47*/index),_display_(/*72.53*/post/*72.57*/.full_name),format.raw/*72.67*/("""");
        var aTag = document.createElement('a');
        aTag.setAttribute('href',"/users/"+profile_name);
        aTag.innerText = profile_name;
        mydiv.appendChild(aTag);
        
        // console.log(variable_name);
       </script>         
    </tr>
    """)))}),format.raw/*81.6*/("""
  """),format.raw/*82.3*/("""</tbody>
</table>

</div>

""")))}),format.raw/*87.2*/("""
"""),format.raw/*88.1*/("""</div>
""")))}),format.raw/*89.2*/("""

"""),format.raw/*91.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(data:List[QuerySearchResult]): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((List[QuerySearchResult]) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: deff5344bff42dd50908f992819fa3c898052420
                  MATRIX: 924->1|1029->35|1067->67|1111->83|1760->707|1784->722|1824->724|1852->725|2919->1766|2975->1806|3014->1807|3043->1809|3144->1883|3159->1889|3196->1905|3225->1906|3573->2228|3619->2258|3659->2260|3691->2265|3742->2289|3768->2295|3781->2299|3812->2309|3894->2364|3907->2368|3938->2378|3968->2381|3981->2385|4007->2390|4076->2432|4116->2456|4155->2457|4198->2472|4248->2495|4274->2500|4303->2501|4334->2505|4360->2510|4419->2538|4491->2583|4504->2587|4535->2597|4659->2694|4685->2700|4698->2704|4729->2714|5030->2985|5060->2988|5118->3016|5146->3017|5184->3025|5213->3027
                  LINES: 27->1|30->2|31->3|34->4|48->18|48->18|48->18|49->19|72->42|72->42|72->42|73->43|75->45|75->45|75->45|75->45|89->59|89->59|89->59|90->60|91->61|91->61|91->61|91->61|93->63|93->63|93->63|93->63|93->63|93->63|96->66|96->66|96->66|97->67|97->67|97->67|97->67|97->67|97->67|98->68|100->70|100->70|100->70|102->72|102->72|102->72|102->72|111->81|112->82|117->87|118->88|119->89|121->91
                  -- GENERATED --
              */
          