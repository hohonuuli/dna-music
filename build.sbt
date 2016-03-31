// PROJECT PROPERTIES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
organization in ThisBuild := "hohonuuli"

name := "dna-music"

version in ThisBuild := "1.0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

// BUILD SETTINGs ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
javacOptions in ThisBuild ++= Seq("-target", "1.8", "-source","1.8")

incOptions := incOptions.value.withNameHashing(true)

// DEPENDENCIES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies ++= Seq("junit" % "junit" % "4.12" % "test",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test") 


resolvers in ThisBuild ++= Seq(Resolver.mavenLocal,
    Resolver.bintrayRepo("hohonuuli", "maven"))
    
// OTHER SETTINGS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// -- PROMPT
// set the prompt (for this build) to include the project id.
shellPrompt in ThisBuild := { state =>
  val user = System.getProperty("user.name")
  user + "@" + Project.extract(state).currentRef.project + ":sbt> "
}

// -- SCALARIFORM
// Format code on save with scalariform
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

SbtScalariform.scalariformSettings

SbtScalariform.ScalariformKeys.preferences := SbtScalariform.ScalariformKeys.preferences.value
  .setPreference(IndentSpaces, 2)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
  .setPreference(DoubleIndentClassDeclaration, true)
  
// -- CONSOLE
initialCommands in console :=
  """
    |import hohonuuli.fasta._
  """.stripMargin