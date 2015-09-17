lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.11.4",
  libraryDependencies ++= commonDependencies
)

lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "helloworld"
  )

