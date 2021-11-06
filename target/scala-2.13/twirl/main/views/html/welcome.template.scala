
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "java"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

    """),format.raw/*5.5*/("""<section id="top">
        <div class="wrapper">
            <h1><a href="https://playframework.com/documentation/"""),_display_(/*7.67*/version),format.raw/*7.74*/("""/Home">"""),_display_(/*7.82*/message),format.raw/*7.89*/("""</a></h1>
        </div>
    </section>

    <div id="content" class="wrapper doc">
        <article>

            <h1>Welcome to Play</h1>

            <p>
                Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
            </p>

            <blockquote>
                <p>
                    You’re using Play """),_display_(/*22.40*/version),format.raw/*22.47*/("""
                """),format.raw/*23.17*/("""</p>
            </blockquote>

            <h2>Why do you see this page?</h2>

            <p>
                The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
                whenever a browser requests the <code>/</code> URI using the GET method:
            </p>

            <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>


            <p>
                Play has invoked the <code>controllers.HomeController.index</code> method:
            </p>

            <pre><code>public Result index() """),format.raw/*41.46*/("""{"""),format.raw/*41.47*/("""
    """),format.raw/*42.5*/("""return ok(
        index.render(
            "Your new application is ready.",
            assetsFinder
        ));
"""),format.raw/*47.1*/("""}"""),format.raw/*47.2*/("""</code></pre>

            <p>
                An action method handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
                Here we send a <code>200 OK</code> response, using a template to fill its content.
            </p>

            <p>
                The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a standard Java class.
            </p>

            <pre><code>@(message: String)(implicit assetsFinder: AssetsFinder)

  @main("Welcome to Play") """),format.raw/*60.29*/("""{"""),format.raw/*60.30*/("""

  """),format.raw/*62.3*/("""@welcome(message, style = "Java")

"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/("""</code></pre>

            <p>
                The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
                Then this template calls another function defined in <code>app/views/main.scala.html</code> which displays the HTML layout, and another
                function that displays this welcome message. You can freely add any HTML fragment mixed with Scala code in this file.
            </p>

            <blockquote>
                <p>
                    <strong>Note</strong> that Scala is fully compatible with Java, so if you don’t know Scala don’t panic, a Scala statement is very similar to a Java one.
                </p>
            </blockquote>

            <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*78.94*/version),format.raw/*78.101*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*78.240*/version),format.raw/*78.247*/("""/JavaActions">actions</a>.</p>

            <h2>Async Controller</h2>

            Now that you've seen how Play renders a page, take a look at <code>AsyncController.java</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.java</code>, but instead of returning <code>Result</code>, the action returns <code>CompletionStage&lt;Result&gt;</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.

            <p>
                <a href=""""),_display_(/*85.27*/routes/*85.33*/.AsyncController.message),format.raw/*85.57*/("""">Click here for the AsyncController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*89.95*/version),format.raw/*89.102*/("""/JavaAsync">asynchronous actions</a> in the documentation.
            </p>

            <h2>Count Controller</h2>

            <p>
                Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you refresh the page, so keep refreshing to see the numbers go up.
            </p>

            <p>
                <a href=""""),_display_(/*99.27*/routes/*99.33*/.CountController.count),format.raw/*99.55*/("""">Click here for the CountController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*103.95*/version),format.raw/*103.102*/("""/JavaDependencyInjection">dependency injection</a> in the documentation.
            </p>

            <h2>Need more info on the console?</h2>

            <p>
                For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*109.199*/version),format.raw/*109.206*/("""/PlayConsole">Using the Play console</a>.
            </p>

            <h2>Need to set up an IDE?</h2>

            <p>
                You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
                including modifications made to Scala source files.
            </p>

            <p>
                If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
                <a href="https://www.playframework.com/documentation/"""),_display_(/*121.71*/version),format.raw/*121.78*/("""/IDE">Setting up your preferred IDE</a> page.
            </p>

            <h2>Need more documentation?</h2>

            <p>
                Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*127.106*/version),format.raw/*127.113*/("""">https://www.playframework.com/documentation</a>.
            </p>

            <p>
                Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
            </p>

            <h2>Need more help?</h2>

            <p>
                Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
            </p>

            <p>
                The <a href="https://discuss.playframework.com">Discuss Play Forum</a>  is where Play users come to seek help,
                announce projects, and discuss issues and new features.
            </p>

            <p>
                Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
            </p>

        </article>

        <aside>
            <h3>Browse</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*154.71*/version),format.raw/*154.78*/("""">Documentation</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*155.71*/version),format.raw/*155.78*/("""/api/"""),_display_(/*155.84*/style),format.raw/*155.89*/("""/index.html">Browse the """),_display_(/*155.114*/{style.capitalize}),format.raw/*155.132*/(""" """),format.raw/*155.133*/("""API</a></li>
            </ul>
            <h3>Start here</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*159.71*/version),format.raw/*159.78*/("""/PlayConsole">Using the Play console</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*160.71*/version),format.raw/*160.78*/("""/IDE">Setting up your preferred IDE</a></li>
                <li><a href="https://playframework.com/download#examples">Example Projects</a>
            </ul>
            <h3>Help here</h3>
            <ul>
                <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
                <li><a href="https://discuss.playframework.com">Discuss Play Forum</a> </li>
                <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
            </ul>

        </aside>

    </div>
""")))}),format.raw/*173.2*/("""
"""))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/welcome.scala.html
                  HASH: e1b2c4788d2d81f08303d301c38d742ab9982a6b
                  MATRIX: 916->1|1051->43|1078->45|1125->84|1175->97|1207->103|1348->218|1375->225|1409->233|1436->240|1848->625|1876->632|1921->649|2566->1266|2595->1267|2627->1272|2770->1388|2798->1389|3374->1939|3403->1940|3434->1944|3496->1980|3524->1981|4383->2813|4412->2820|4579->2959|4608->2966|5240->3571|5255->3577|5300->3601|5504->3778|5533->3785|6182->4407|6197->4413|6240->4435|6445->4612|6475->4619|6862->4977|6892->4984|7488->5552|7517->5559|7778->5791|7808->5798|9126->7088|9155->7095|9278->7190|9307->7197|9341->7203|9368->7208|9422->7233|9463->7251|9494->7252|9672->7402|9701->7409|9845->7525|9874->7532|10464->8091
                  LINES: 27->1|32->2|33->3|33->3|33->3|35->5|37->7|37->7|37->7|37->7|52->22|52->22|53->23|71->41|71->41|72->42|77->47|77->47|90->60|90->60|92->62|94->64|94->64|108->78|108->78|108->78|108->78|115->85|115->85|115->85|119->89|119->89|129->99|129->99|129->99|133->103|133->103|139->109|139->109|151->121|151->121|157->127|157->127|184->154|184->154|185->155|185->155|185->155|185->155|185->155|185->155|185->155|189->159|189->159|190->160|190->160|203->173
                  -- GENERATED --
              */
          