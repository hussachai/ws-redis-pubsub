name := """ws-redis-pubsub"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.2"

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "rediscala" at "http://dl.bintray.com/etaty/maven"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.etaty.rediscala" %% "rediscala" % "1.4.2",
  "org.webjars" %% "webjars-play" % "2.3.0-2",
  "org.webjars" % "jquery" % "2.1.3",
  "org.webjars" % "bootstrap" % "3.3.2"
)
