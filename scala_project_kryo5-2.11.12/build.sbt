ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    name := "scala_project",
    idePackagePrefix := Some("com.roczei.testing")
  )

libraryDependencies += "com.esotericsoftware.kryo" % "kryo5" % "5.4.0"
