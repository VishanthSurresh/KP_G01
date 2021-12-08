
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[QuerySearchResult],play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : List[QuerySearchResult],request:play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
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
<body data-ws-url=""""),_display_(/*17.21*/routes/*17.27*/.HomeController.ws.webSocketURL(request)),format.raw/*17.67*/("""">
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
	  <td><span class="Owner"""),_display_(/*61.27*/post/*61.31*/.full_name),format.raw/*61.41*/("""" id =""""),_display_(/*61.49*/index),_display_(/*61.55*/post/*61.59*/.full_name),format.raw/*61.69*/("""" ></span>
      </td>
      <td><span class="Repo"""),_display_(/*63.29*/post/*63.33*/.full_name),format.raw/*63.43*/("""" id="Name" ><a href="/issue/"""),_display_(/*63.73*/post/*63.77*/.full_name),format.raw/*63.87*/("""">"""),_display_(/*63.90*/post/*63.94*/.name),format.raw/*63.99*/("""</a></span>
      </td>
      
      <td id="Topics"""),_display_(/*66.22*/post/*66.26*/.full_name),format.raw/*66.36*/("""">"""),_display_(/*66.39*/for(topic<- post.topics) yield /*66.63*/{_display_(Seq[Any](format.raw/*66.64*/("""
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
"""),format.raw/*90.1*/("""<div id="time"></div>


<script>
  
  

  (function() """),format.raw/*97.15*/("""{"""),format.raw/*97.16*/("""
  """),format.raw/*98.3*/("""$(function() """),format.raw/*98.16*/("""{"""),format.raw/*98.17*/("""
    """),format.raw/*99.5*/("""var ws;
    console.log("Inside Custom Script");
    ws = new WebSocket($("body").data("ws-url"));
    return ws.onmessage = function(event) """),format.raw/*102.43*/("""{"""),format.raw/*102.44*/("""
      """),format.raw/*103.7*/("""var message;
      message = JSON.parse(event.data);
      if(message.status == "No-Change")"""),format.raw/*105.40*/("""{"""),format.raw/*105.41*/("""
        """),format.raw/*106.9*/("""console.log("No Change from last Update!");
        $('#time').append(message.status + "<br/>");
      """),format.raw/*108.7*/("""}"""),format.raw/*108.8*/("""else"""),format.raw/*108.12*/("""{"""),format.raw/*108.13*/("""
        """),format.raw/*109.9*/("""console.log(message.value);   
        var allChanges = JSON.parse(message.value);
        console.log("Updating "+ message.status + "Repositories" );
        for(var i =0; i< parseInt(message.status); i++)"""),format.raw/*112.56*/("""{"""),format.raw/*112.57*/("""                    
             """),format.raw/*113.14*/("""var githubResult = allChanges[i];
             console.log(githubResult);
             $("#Owner"+ githubResult.repoToChange).html("<a href='/user/"+ githubResult.full_name + "'>"+ githubResult.full_name+"</a>");
             $("#Name"+ githubResult.repoToChange).html("<a href='/issue/"+ githubResult.full_name+"'>"+ githubResult.name +"</a>");
             var data= '';
             var topics= githubResult.topics.substring(1, githubResult.topics.length-1).split(",");
             console.log("Topics :: "+topics+ " : " +topics.length);
             if(topics.length>1)"""),format.raw/*120.33*/("""{"""),format.raw/*120.34*/("""
              """),format.raw/*121.15*/("""console.log("Topics :: " +topics[4]);
               for(var j=0; j<topics.length; j++)"""),format.raw/*122.50*/("""{"""),format.raw/*122.51*/("""
                  """),format.raw/*123.19*/("""data += '<span><a href="/topic/'+ topics[j] +'">[' + topics[j] + ']</a></span> ';
               """),format.raw/*124.16*/("""}"""),format.raw/*124.17*/("""
               """),format.raw/*125.16*/("""$("#Topics"+ githubResult.repoToChange).html(data);
             """),format.raw/*126.14*/("""}"""),format.raw/*126.15*/("""
        """),format.raw/*127.9*/("""}"""),format.raw/*127.10*/("""
      """),format.raw/*128.7*/("""}"""),format.raw/*128.8*/("""
    """),format.raw/*129.5*/("""}"""),format.raw/*129.6*/(""";
  """),format.raw/*130.3*/("""}"""),format.raw/*130.4*/(""");

"""),format.raw/*132.1*/("""}"""),format.raw/*132.2*/(""").call(this);


</script>

</body>
</html>"""))
      }
    }
  }

  def render(data:List[QuerySearchResult],request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(data,request)

  def f:((List[QuerySearchResult],play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (data,request) => apply(data,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: b2475d37cee40d854ed1a3963ad16d6b1b49ec4d
                  MATRIX: 946->1|1081->65|1119->97|1163->113|1825->749|1840->755|1901->795|1931->799|1955->814|1995->816|2023->817|3090->1858|3146->1898|3185->1899|3214->1901|3315->1975|3330->1981|3367->1997|3396->1998|3744->2320|3790->2350|3830->2352|3862->2357|3920->2388|3933->2392|3964->2402|3999->2410|4025->2416|4038->2420|4069->2430|4147->2481|4160->2485|4191->2495|4248->2525|4261->2529|4292->2539|4322->2542|4335->2546|4361->2551|4440->2603|4453->2607|4484->2617|4514->2620|4554->2644|4593->2645|4636->2660|4686->2683|4712->2688|4741->2689|4772->2693|4798->2698|4857->2726|4929->2771|4942->2775|4973->2785|5097->2882|5123->2888|5136->2892|5167->2902|5468->3173|5498->3176|5556->3204|5584->3205|5622->3213|5650->3214|5732->3268|5761->3269|5791->3272|5832->3285|5861->3286|5893->3291|6063->3432|6093->3433|6128->3440|6249->3532|6279->3533|6316->3542|6447->3645|6476->3646|6509->3650|6539->3651|6576->3660|6811->3866|6841->3867|6904->3901|7507->4475|7537->4476|7581->4491|7697->4578|7727->4579|7775->4598|7901->4695|7931->4696|7976->4712|8070->4777|8100->4778|8137->4787|8167->4788|8202->4795|8231->4796|8264->4801|8293->4802|8325->4806|8354->4807|8386->4811|8415->4812
                  LINES: 27->1|30->2|31->3|34->4|47->17|47->17|47->17|48->18|48->18|48->18|49->19|72->42|72->42|72->42|73->43|75->45|75->45|75->45|75->45|89->59|89->59|89->59|90->60|91->61|91->61|91->61|91->61|91->61|91->61|91->61|93->63|93->63|93->63|93->63|93->63|93->63|93->63|93->63|93->63|96->66|96->66|96->66|96->66|96->66|96->66|97->67|97->67|97->67|97->67|97->67|97->67|98->68|100->70|100->70|100->70|102->72|102->72|102->72|102->72|111->81|112->82|117->87|118->88|119->89|120->90|127->97|127->97|128->98|128->98|128->98|129->99|132->102|132->102|133->103|135->105|135->105|136->106|138->108|138->108|138->108|138->108|139->109|142->112|142->112|143->113|150->120|150->120|151->121|152->122|152->122|153->123|154->124|154->124|155->125|156->126|156->126|157->127|157->127|158->128|158->128|159->129|159->129|160->130|160->130|162->132|162->132
                  -- GENERATED --
              */
          