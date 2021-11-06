
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/assetsFinder/*14.66*/.path("stylesheets/main.css")),format.raw/*14.95*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/assetsFinder/*15.71*/.path("images/favicon.png")),format.raw/*15.98*/("""">
        <script src=""""),_display_(/*16.23*/assetsFinder/*16.35*/.path("javascripts/hello.js")),format.raw/*16.64*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),format.raw/*20.32*/("""
        """),_display_(/*21.10*/content),format.raw/*21.17*/("""
    """),format.raw/*22.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: f148b090350bde68cb394e951f4ecd60ee8fdae9
                  MATRIX: 1178->260|1339->328|1366->329|1446->434|1482->443|1517->451|1543->456|1632->518|1653->530|1703->559|1791->620|1812->632|1860->659|1912->684|1933->696|1983->725|2077->881|2114->891|2142->898|2174->903
                  LINES: 32->7|37->8|38->9|41->12|42->13|42->13|42->13|43->14|43->14|43->14|44->15|44->15|44->15|45->16|45->16|45->16|48->20|49->21|49->21|50->22
                  -- GENERATED --
              */
          