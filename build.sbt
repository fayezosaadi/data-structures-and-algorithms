ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "data-structures-and-algorithms",
    idePackagePrefix := Some("com.github.fayezosaadi.scala.algorithms")
  )
