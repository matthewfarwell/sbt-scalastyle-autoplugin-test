package sbt
package common

import Keys._

import org.scalastyle.sbt.ScalastylePlugin
import org.scalastyle.sbt.ScalastylePlugin._

object ScalastylePluginSettings extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  // ScalastylePlugin is not an AutoPlugin, so we manually add its settings here
  override def projectSettings =
    ScalastylePlugin.projectSettings ++
    baseSettings ++
    testSettings ++
    Project.inConfig(Compile)(baseSettings) ++
    Project.inConfig(Test)(testSettings)

  lazy val baseSettings = Seq(
    scalastyleConfig := sbtCommonDir.value / "scalastyle-config.xml",
    scalastyleTarget := target.value / "checkstyle-scalastyle.xml"
  )

  lazy val testSettings = Seq(
    (scalastyleConfig in Test) := sbtCommonDir.value / "scalastyle-test-config.xml",
    (scalastyleTarget in Test) := target.value / "checkstyle-scalastyle-test.xml"

    // Temporary fix for https://github.com/scalastyle/scalastyle-sbt-plugin/issues/44
    // (scalastyleConfig in scalastyle) := sbtCommonDir.value / "scalastyle-test-config.xml",
    // (scalastyleTarget in scalastyle) := target.value / "checkstyle-scalastyle-test.xml"
  )

  lazy val sbtCommonDir = baseDirectory { _ / "project" / "sbt-common" }
}
