name := """Task1"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  javaJdbc
)

//Postgre driver
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1207"

//LiquiBase
libraryDependencies += "com.ticketfly" %% "play-liquibase" % "1.0"

//Hibernate EM
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final"

//TODO how to disable autogeneration every time?
//Hibernate metamodel autogenerator
//libraryDependencies += "org.hibernate" % "hibernate-jpamodelgen" % "4.3.9.Final"

//c3p0 connection pooling for hibernate
libraryDependencies += "org.hibernate" % "hibernate-c3p0" % "4.3.9.Final"

//EHCache
libraryDependencies += "org.hibernate" % "hibernate-ehcache" % "4.3.9.Final"
libraryDependencies += "net.sf.ehcache" % "ehcache" % "2.10.1"

//Swagger
libraryDependencies += "io.swagger" %% "swagger-play2" % "1.5.1"

libraryDependencies += filters


//javacOptions ++= Seq("-s", "app")

routesGenerator := InjectedRoutesGenerator

fork in run := true