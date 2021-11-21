
# Gitterific

![read](https://user-images.githubusercontent.com/35566310/142740237-d53da630-dc37-478a-bcc5-23cee595d510.jpg)


#### Introduction

Gitterrific is a web application that analyzes the contents on GitHub using REST API. A simple web interface is developed that takes a string with one or multiple search keywords and then displays the Author name, latest repositories and Topics matching the keyword(s) below the search. The user can enter new search terms on the output page, which will result in 10 more results being displayed (i.e., a second search will add 10 more results above the 10 results from the first search. We have implemented this using Java 8 Streams.

##### This web appliction has several web pages with different individual funtionalities as mentioned bellow

###### 1. User Profile
This web page contains all available information about the user, and other repositories information about the user. The user page is hyperlinked from the username from the results on the main search page. The repositories are also hyperlinked to their repository profile page respectively.

###### 2. Repository Profile
This page contains details about a repository and 20 latest issues of the repository with their information and a hyperlink for the issues statistics page. It also contains a hyperlink for the names of the collaborators of the repository to their user profile page and add a hyperlink to the repository commits page.

###### 3. Repository Issues
This page fetches the issues about repository and computes a word-level statistics of the issue titles. This page also count all unique words in descending order (by frequency of the words). This page is hyperlinked with repository profile page.

###### 4. Topics
For a topic, this page will display the latest 10 repositories containing this topic, in the same format as the results on the main search page.

###### 5. Repository Commits
For a repository (hyperlinked from the repository page), the top 100 newest commits are fetched by authorizing github tokens which will compile statistics about the top-10 committers who had the most number of commits, the minimum, maximum, and average number of additions and deletions across all these commits are also displayed. We have used Java 8 Streams to implement these functions.


### 1. Play Framework - Installation

Install SBT into your system before proceeding with running the program.
https://www.scala-sbt.org/download.html


## 2. Eclipse and Play
To use Eclipse for Play development, you have to configure the "sbteclipse" plugin. Open the file project/plugins.sbt and add:

Eclipse plugin, see https://github.com/typesafehub/sbteclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
Then, you can run

sbt eclipse
to generate the Eclipse project files. Note that the project must have been compiled for this to work. Finally, import the project in Eclipse through File → Import (General/Existing project); here, select the Play starter project directory.

Play supports mixed-language projects (both Scala and Java in one project); for Java-only projects, you should add the additional configuration options as shown on the Play IDE page.

For more information on Play and IDEs, see https://www.playframework.com/documentation/2.8.x/IDE.


## 3. The Scala Build Tool (sbt)
As Play is written in Scala, it uses sbt, the Scala Build Tool. You can use sbt as a command-line tool, e.g.:

sbt run       # compile and run the project
sbt compile   # only compile the project
sbt clean     # clean generated files
sbt test      # run tests
However, sbt is meant to be used as a shell (REPL): simply type sbt and you are in a shell where you can issue commands like run, test, etc.

Note that Play supports hot reload (hot redeploy): when you run a Play project and change the code, it will automatically re-compile and re-deploy your project when you hit "refresh" in your browser – no need to stop the project and manually re-start it!

For more details, refer to the Play build documentation at https://playframework.com/documentation/2.8.x/Build, as well as the sbt documentation at https://www.scala-sbt.org/.

## 4. Testing
The starter project comes with some tests, which you can find under the test/ directory. Type

sbt test
to run the test cases (for additional options, such as only running a single test, see the documentation under https://playframework.com/documentation/2.8.x/JavaTest)

The test output is located in target/test-reports.

## 5. Computing Test Coverage with JaCoCo
To use JaCoCo with Play, you need to install another sbt module, sbt-jacoco. 

// The JaCoCo Plugin, see https://github.com/sbt/sbt-jacoco
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.2.0")
Then, you can run the tests with coverage computation using

sbt jacoco
Sample report is showned below:

********************
[info] Passed: Total 26, Failed 0, Errors 0, Passed 26
[info]
[info] ------- Jacoco Coverage Report -------
[info]
[info] Lines: 50.4% (>= required 0.0%) covered, 368 of 742 missed, OK
[info] Instructions: 42.48% (>= required 0.0%) covered, 3870 of 6728 missed, OK
[info] Branches: 27.27% (>= required 0.0%) covered, 128 of 176 missed, OK
[info] Methods: 31.93% (>= required 0.0%) covered, 275 of 404 missed, OK
[info] Complexity: 27.44% (>= required 0.0%) covered, 357 of 492 missed, OK
[info] Class: 69.23% (>= required 0.0%) covered, 12 of 39 missed, OK
[info]
[info] Check C:\Users\visha\eclipse-workspace\Gitterrific\Gitterrific_project_KPG01\target\scala-2.13\jacoco\report for detailed report
[info]
[success] Total time: 39 s, completed 21-Nov-2021, 6:04:58 PM
********************

The report directory (see above) contains the detailed HTML report in the familiar JaCoCo format.



## 6. Adding Library Dependencies
If you want to use additional libraries in your project, this is done in the file build.sbt (located in the top-level of your project directory). Simply find the library on Maven Central, like before when you configured ivy, but now select the "SBT" tab to find the configuration line for sbt. For example, to use the Apache Commons Lang library v3.11 in your project, you would add:

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.11"
to your build.sbt.



## 7. A Note on Configuration Files

project/plugins.sbt: This file contains plugins for the sbt build tool. Here, you configure the build process (such as integration with Eclipse), as well as the version of Play being used for the project.
﻿project/build.properties: This file contains the version of sbt being used (this is different from the version of Play!). Note that the plugins configured above must be compatible with the sbt version you are using in your project – in general, you can't mix plugins for sbt v0.x and v1.x.
build.sbt: This file contains references to libraries and settings used within your application, as explained above under "Adding Library Dependencies". See the documentation on the build.sbt file and sbt settings.
conf/application.conf (as well as production.conf): These files contain the configurations for your specific Play application, such as languages, keys, databases, and security policies. They use the HOCON (Human-Optimized Config Object Notation) format; see Configuration file syntax and features.


## 8. Generating Documentation
The command to generate the documentation is

sbt doc
However, as Play supports mixed-language projects (using both Scala and Java), this defaults to generating Scaladoc, not Javadoc. You can find the output in target/scala-2.13/api/.

To generate the documentation for the test source files, use:

sbt test:doc


## 9. Running / Development

We can run this play framework application in http://localhost:9000/ on any web browser.


### 10. Deployments

**Master branch**

The master branch is the main branch where production ready code is present

**Feature/Development branch**

The Feature/Development is where all other feature developments occur and is finally merged to Master



## 11. Further Reading / Useful Links

- [Play Framework](https://www.playframework.com)

- [Play Framework Documentation](https://www.playframework.com/documentation/2.8.x/Home)

- [Play Framework Console](https://www.playframework.com/documentation/2.8.x/PlayConsole)

- [Github API](https://codesnippet.io/github-api-tutorial/)

- [GitHub API endpoints](https://docs.github.com/en/rest/overview/endpoints-available-for-github-apps)
