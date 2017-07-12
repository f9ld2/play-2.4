
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

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html lang="en">
    <head>
        <title>Users</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.59*/routes/*9.65*/.Assets.versioned("images/favicon.png")),format.raw/*9.104*/("""">
    </head>
    <body>
        """),_display_(/*12.10*/if(!users.isEmpty())/*12.30*/ {_display_(Seq[Any](format.raw/*12.32*/("""
            """),format.raw/*13.13*/("""<ul>
                """),_display_(/*14.18*/for(user <- users) yield /*14.36*/ {_display_(Seq[Any](format.raw/*14.38*/("""
                    """),format.raw/*15.21*/("""<li>"""),_display_(/*15.26*/{user.getName()}),format.raw/*15.42*/("""</li>
                """)))}),format.raw/*16.18*/("""
            """),format.raw/*17.13*/("""</ul>
        """)))}),format.raw/*18.10*/("""
    """),format.raw/*19.5*/("""</body>
</html>
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
                  DATE: Wed Jul 12 11:47:35 ICT 2017
                  SOURCE: /Users/hoang-hd/Working/play-2.4/app/views/users.scala.html
                  HASH: 1e0d6030043514efcd669b003d063ade7e508e34
                  MATRIX: 958->1|1078->26|1106->28|1259->155|1273->161|1335->202|1422->263|1436->269|1496->308|1558->343|1587->363|1627->365|1668->378|1717->400|1751->418|1791->420|1840->441|1872->446|1909->462|1963->485|2004->498|2050->513|2082->518
                  LINES: 28->1|33->1|35->3|40->8|40->8|40->8|41->9|41->9|41->9|44->12|44->12|44->12|45->13|46->14|46->14|46->14|47->15|47->15|47->15|48->16|49->17|50->18|51->19
                  -- GENERATED --
              */
          