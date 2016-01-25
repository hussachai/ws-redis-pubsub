name := """ws-redis-pubsub"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "rediscala" at "http://dl.bintray.com/etaty/maven"
)

libraryDependencies ++= Seq(
  "com.github.etaty" %% "rediscala" % "1.6.0",
  "org.webjars" %% "webjars-play" % "2.4.0-2",
  "org.webjars" % "jquery" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.3.6"
)

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)

