lazy val commonSettings = Seq(
  version := "0.1.0"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings ++
    addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")
  : _*).
  settings(
    sbtPlugin := true,
    name := "sbt-common"
  )
