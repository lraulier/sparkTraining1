name := "first test"

version := "0.1"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1"

mainClass in (Compile,run) := Some("org.kzone.sparkTraining1.test1")


