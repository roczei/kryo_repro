ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala_project",
    idePackagePrefix := Some("com.roczei.testing")
  )

libraryDependencies += "com.esotericsoftware" % "kryo-shaded" % "4.0.2"