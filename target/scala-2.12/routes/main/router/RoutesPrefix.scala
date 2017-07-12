
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/hoang-hd/Working/play-2.4/conf/routes
// @DATE:Wed Jul 12 11:47:35 ICT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
