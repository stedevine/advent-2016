lazy val root = (project in file(".")).
  settings(
    name := "Advent of Code 2016",
    version := "1.0",
    scalaVersion := "2.10.6",
    libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.6",
    // Start a new JVM so we can control how much memory we use
    fork := true,
    javaOptions += "-Xmx1G")

  lazy val NoTimeForATaxicab = (project in file ("NoTimeForATaxicab")).dependsOn(root)
  lazy val BathroomSecurity = (project in file ("BathroomSecurity")).dependsOn(root)
  lazy val MedicineForRudolph = (project in file ("MedicineForRudolph")).dependsOn(root)
