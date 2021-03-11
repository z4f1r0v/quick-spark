name := "quick-spark"

version := "0.1"

scalaVersion := "2.12.13"

def sparkDep(moduleName: String): ModuleID = "org.apache.spark" %% s"spark-${moduleName}" % "3.0.1"

libraryDependencies ++= Seq(
  sparkDep("core"),
  sparkDep("sql"),
)