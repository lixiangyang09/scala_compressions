
lazy val root = (project in file(".")).
  settings(
    name := "SBT_Example",
    version := "1.1-SNAPSHOT"
  )

//resolvers += "Artifactory" at "http://stage-bams-sami.int.thomsonreuters.com/artifactory/default.ivy.global/"

//publishTo := Some("Artifactory Realm" at "http://localhost:8081/artifactory/libs-snapshot-local;build.timestamp=" + new java.util.Date().getTime)

 // credentials += Credentials(new File("credentials.properties"))

  //libraryDependencies += "myorg" % "hello" % "2.0"
//val url2 = "https://stage-bams-sami.int.thomsonreuters.com/artifactory/default.ivy.local/ETStest/sbt/sbt-v1.jar"
//val url1 = "http://10.184.58.164/artifactory/default.ivy.local/ETStest/sbt/1.0/libTSCanCor.so"
//
//libraryDependencies += "ETStest" % "sbt1" % "v1" from url2
//
//libraryDependencies += "ETStest" % "sbt2" % "v2" from "https://stage-bams-sami.int.thomsonreuters.com/artifactory/default.ivy.local/ETStest/sbt/v1/libTSCommon.so"

//libraryDependencies += "ETStest" % "sbt" % "1" //artifacts(Artifact("factorie", "", "so"))

//resolvers += Resolver.url("Artifactory", url("https://stage-bams-sami.int.thomsonreuters.com/artifactory/default.ivy.local"))(Patterns("[organization]/[module]/[revision]/[type]s/ivy-[revision].xml","[organization]/[module]/[revision]/[type]s/[module](-[classifier])-[revision].[ext]"))
//resolvers += Resolver.url("Artifactory") artifacts "https://stage-bams-sami.int.thomsonreuters.com/artifactory/default.ivy.local/[organization]/[module]/[revision]/[module]-[revision].[ext]"
//libraryDependencies += "net.liftweb" % "lift-json" % "2.0" from "http://repo1.maven.org/maven2/net/liftweb/lift-json/2.0/lift-json-2.0.jar"

//output dependency jars to lib_managed
//retrieveManaged := true
libraryDependencies += "org.apache.commons" % "commons-compress" % "1.12"
