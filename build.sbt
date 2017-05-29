import Dependencies._

val finagleVersion = "6.44.0"
val circeVersion = "0.8.0"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.2",
      version      := "0.1"
    )),
    name := "Predix-Hello-Scala",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-core",
      "com.twitter" %% "finagle-http"
    ).map(_ % finagleVersion),
    libraryDependencies += "io.circe" %% "circe-parser" % circeVersion

  )
  .enablePlugins(JavaAppPackaging)
