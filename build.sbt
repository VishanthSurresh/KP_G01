name := """play-java-hello-world-tutorial"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies ++= Seq(
  javaWs
)
libraryDependencies ++= Seq(
  javaWs,
  "org.mockito" % "mockito-core" % "4.0.0" % "test",
   "com.typesafe.akka" %% "akka-actor" % "2.6.14",
  "com.typesafe.akka" %% "akka-testkit" % "2.6.14" % Test,

  // For testing web socket
  "org.awaitility" % "awaitility" % "4.0.1" % Test,
)
libraryDependencies += ehcache
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.11.4"
PlayKeys.fileWatchService := play.dev.filewatch.FileWatchService.jdk7(play.sbt.run.toLoggerProxy(sLog.value))