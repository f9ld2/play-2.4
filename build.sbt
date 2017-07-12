name := """play24"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaJdbc,
  "org.mybatis" % "mybatis" % "3.4.4",
  "org.mybatis" % "mybatis-guice" % "3.9",
  "mysql" % "mysql-connector-java" % "6.0.6",
  "com.google.inject.extensions" % "guice-multibindings" % "4.1.0"
)

routesGenerator := InjectedRoutesGenerator