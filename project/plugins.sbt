addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.8")

// Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

// Defines scaffolding (found under .g8 folder)
// http://www.foundweekends.org/giter8/scaffolding.html
// sbt "g8Scaffold form"
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.11.0")
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.2.0")
libraryDependencies += "io.methvin" % "directory-watcher" % "0.15.0"