
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
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object users extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[model.User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users: List[model.User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.27*/("""
"""),_display_(/*2.2*/assets/*2.8*/.put("stylesheets/index.css")),format.raw/*2.37*/("""
"""),_display_(/*3.2*/assets/*3.8*/.put("javascript/index.js", "footer")),format.raw/*3.45*/("""

"""),_display_(/*5.2*/main("Welcome to Play")/*5.25*/ {_display_(Seq[Any](format.raw/*5.27*/("""
	"""),_display_(/*6.3*/if(!users.isEmpty())/*6.23*/ {_display_(Seq[Any](format.raw/*6.25*/("""
        """),format.raw/*7.9*/("""<ul>
            """),_display_(/*8.14*/for(user <- users) yield /*8.32*/ {_display_(Seq[Any](format.raw/*8.34*/("""
                """),format.raw/*9.17*/("""<li>"""),_display_(/*9.22*/{user.getName()}),format.raw/*9.38*/("""</li>
            """)))}),format.raw/*10.14*/("""
        """),format.raw/*11.9*/("""</ul>
    """)))}),format.raw/*12.6*/("""
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(users:List[model.User]): play.twirl.api.HtmlFormat.Appendable = apply(users)

  def f:((List[model.User]) => play.twirl.api.HtmlFormat.Appendable) = (users) => apply(users)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Jul 12 11:53:56 ICT 2017
                  SOURCE: /Users/hoang-hd/Working/play-2.4/app/views/users.scala.html
                  HASH: 05e5af55b4f16200b7d957a4faf4b1ac7d140045
                  MATRIX: 958->1|1078->26|1105->28|1118->34|1167->63|1194->65|1207->71|1264->108|1292->111|1323->134|1362->136|1390->139|1418->159|1457->161|1492->170|1536->188|1569->206|1608->208|1652->225|1683->230|1719->246|1769->265|1805->274|1846->285|1878->287
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|37->5|37->5|37->5|38->6|38->6|38->6|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|43->11|44->12|45->13
                  -- GENERATED --
              */
          