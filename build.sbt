import sbt.Keys._

/**
  * @author Phan Van Trung
  */

//ommon settings into a sequence
lazy val commonSettings = Seq(
  name := "scala-api-lib",
  organization := "vn.co.pvt.scala-api-lib",
  version := "0.0.1",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq   (
    // A useful URL construction library
    "com.netaporter" %% "scala-uri" % "0.4.14",

    // Use scala-guice
    "net.codingwell" %% "scala-guice" % "4.1.0",

    // Add scalatest in for test framework
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,

    // Add Gatling in for laod testing
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % Test,
    "io.gatling" % "gatling-test-framework" % "2.2.2" % Test
  ),
  scalaSource in GatlingTest := baseDirectory.value / "/gatling/simulation",

  // for debugging sbt problems
  logLevel := Level.Debug,
  scalacOptions += "-deprecation"
  )

lazy val GatlingTest = config("gatling") extend Test

// The Play project itself
lazy val root = (project in file(".")).enablePlugins(Common, PlayScala, GatlingPlugin)
  .configs(GatlingTest)
  .settings(inConfig(GatlingTest)(Defaults.testSettings): _*)
  .settings(commonSettings: _*)


// Documentation for this project: 
//    sbt "project docs" "~ paradox"
//    open docs/target/paradox/site/index.html
lazy val docs = (project in file("docs")).enablePlugins(ParadoxPlugin)