
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template takes a two arguments, a String containing a
* message to display and an AssetsFinder to locate static assets.
*/
  def apply/*5.2*/(message: String)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html>
<body>
<main>
    <link rel="stylesheet" type="text/css" href="/assets/stylesheets/style.css">
    <div class="container">
        <h1>Gitterific</h1>
        <h2>Enter the Text</h2>
        <div class="search-box">
            <div class="search-icon"><i class="fa fa-search search-icon"></i></div>
            <form action="" class="search-form">
                <input type="text" placeholder="Search" id="search" autocomplete="off">
            </form>
            <svg class="search-border" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:a="http://ns.adobe.com/AdobeSVGViewerExtensions/3.0/" x="0px" y="0px" viewBox="0 0 671 111" style="enable-background:new 0 0 671 111;"
             xml:space="preserve">
          <path class="border" d="M335.5,108.5h-280c-29.3,0-53-23.7-53-53v0c0-29.3,23.7-53,53-53h280"/>
          <path class="border" d="M335.5,108.5h280c29.3,0,53-23.7,53-53v0c0-29.3-23.7-53-53-53h-280"/>
        </svg>
            <div class="go-icon"><i class="fa fa-arrow-right"></i></div>
        </div>

    </div>
</main>
</body>
</html>
"""))
      }
    }
  }

  def render(message:String,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(message)(assetsFinder)

  def f:((String) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (message) => (assetsFinder) => apply(message)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 88f49ea8c96f8c8551d3005e8457d6276d31030b
                  MATRIX: 1048->134|1196->189|1223->190
                  LINES: 30->5|35->6|36->7
                  -- GENERATED --
              */
          