name := "ScalaCourse"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("course")

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:postfixOps"
)
