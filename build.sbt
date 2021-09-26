ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / idePackagePrefix := Some("course")
ThisBuild / organization := "course"
ThisBuild / scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:postfixOps"
)

val oldScala2 = project.settings(
  name := "Old Scala 2",
  scalaVersion := "2.13.6"
)

val scala2 = project.settings(
  name := "Scala 2",
  scalaVersion := "2.13.6"
)

val scala3 = project.settings(
  name := "Scala 3",
  scalaVersion := "3.0.2"
)

val root = project.in(file("."))
  .settings(name := "Course")
  .aggregate(oldScala2, scala2, scala3)
  .dependsOn(oldScala2, scala2, scala3)
