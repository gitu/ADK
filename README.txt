Welcome
=======

Welcome to the Algorithm Development Kit, the associated code repository to
the "Algorithms in a Nutshell" book published by O'Reilly Media, Inc.

  http://oreilly.com/catalog/9780596516246

This repository is freely available for you to use (as per the "Using Code
Examples" from the preface of the book. We quote:

  This book is here to help you get your job done. In general, you may
  use the code in this book in your programs and documentation. You do
  not need  to contact us  for permission unless you're  reproducing a
  significant portion of the code. For example, writing a program that
  uses  several  chunks  of  code  from this  book  does  not  require
  permission.  Selling  or  distributing  a CD-ROM  of  examples  from
  O'Reilly  books does  require  permission. Answering  a question  by
  citing  this  book  and   quoting  example  code  does  not  require
  permission. Incorporating a significant  amount of example code from
  this book into your product's documentation does require permission.

  We  appreciate,  but do  not  require,  attribution. An  attribution
  usually  includes  the  title,  author,  publisher,  and  ISBN.  For
  example:  "Algorithms in  a Nutshell"  by George  T.  Heineman, Gary
  Pollice, and  Stanley Selkow.  Copyright 2009 George  Heineman, Gary
  Pollice, and Stanley Selkow, 978-0-596-51624-6

  If you feel your use of  code examples falls outside fair use or the
  permission   given    here,   feel    free   to   contact    us   at
  permissions@oreilly.com

Within this repository you will find the following directories:

  README.txt         This file
  Code               Implementation of algorithms using C/C++
  PerformanceTests   Tests to stress-test JavaCode
  Tests              JUnit tests cases for JavaCode
  dist               compiled JAR files for JavaCode
  Examples           Examples showing JavaCode in action
  Figures            Shows how to generate nearly all Book Figures
  JavaCode           Implementation of algorithms using Java
  no_ant.sh          Shell script to compile JavaCode and package dist
  no_ant.bat         Windows batch file to launch no_ant_build (RUN THIS)
  no_ant_build.bat   Windows batch file that packages dist 
  build.xml          Ant buildfile to compile, test, and package JavaCode
  VERSION.txt        Version information about this Development Kit
  Makefile           Makefile to compile C/C++ code using gcc/g++
  codeIndex.txt      Code index for Java/C/C++ code references in book

The repository is provided for you as a ZIP file which you must unzip (and
likely have already done so, since you are reading this README file). Your
next goal is to compile all of the source code. This is described next.

Primary Task
============

1. Make sure JAVA_HOME is set to your JDK installation. For example the
   following shows how to set JAVA_HOME using C-Shell:

     setenv JAVA_HOME /usr/local/jdk1.6.0_07

   Note that the code repository will not compile using JDK 1.5 because of
   the use of "@Override" annotation tags for classes that implement an
   interface. Compiling the repository requires a JDK-1.6 compatible javac
   compiler. Download the latest JDK from [http://java.sun.com/javase]

   Make sure that $JAVA_HOME/bin is in your PATH so the proper java and
   javac executables can be located.

2. Make sure ant is in your PATH. This installation was tested with:

      Apache Ant version 1.7.1 compiled on June 27 2008

   Download the latest version from:

      http://ant.apache.org/
 
   If you don't have 'ant' available, you may be able to use the
   "no_ant.sh" script to compile all Java classes. Read that file for
   instructions on its use. If you are on a Microsoft XP Windows machine,
   you can launch the "no_ant.bat" batch file and it will provide
   instructions on how to build the code (provided you have an available
   JDK of version 1.6 or higher).

3. Make sure that JUnit is available.

   The ant build script assumes there is a directory ../junit4.0 which 
   contains the JUnit installation as found from [http://www.junit.org].
   If your JUnit installation is in a different location, simply modify
   the line defining 

      <property name="junit.home"   value="${basedir}/../junit4.0"/>

   If you are using ant version 1.6.5 (and possibly others) you will have
   to also ensure that the junit-4.0.jar JAR file is already in your
   CLASSPATH before launching ant. To do this using Bash, you would type
   something like:

      export CLASSPATH=.:/path/to/junit/junit-4.0.jar

   Apparently, ant 1.7 does not have this second CLASSPATH requirement.

4. Type 'ant' to compile all Java code (in JavaCode directory)

5. Type 'make' to compile all C/C++ code (in Code directory)

   You will need both a 'gcc' C compiler and a 'g++' C++ compiler. Tested
   on 'g++' version 3.4.6 and 'gcc' version. Also tested on versions 4.2.1
   of both.

The pre-generated javadoc Documentation can be found in docs/api/

The pre-generated doxygen Documentation be found in Code/docs/html/

Review Figures and Examples
===========================

You can reproduce all of the computer-generated figures in the book using
code provided with this deployment. We also provide a number of example
programs showing the algorithms in practice.

For figures, review the information found in

  * Figures/src/algs/chapterN/README.txt        for N=1 to 10
  * Figures/src/algs/appendixA/README.txt       benchmark code contained here

For examples, review the information found in

  * Examples/src/algs/example/README.txt

To run any of the java examples, type:

  java -cp dist/ADK-1.0-ExamplesAndFigures.jar [ExampleMain]

For example, to regenerate the information found in chapter 3, table 1, type:

  java -cp dist/ADK-1.0-ExamplesAndFigures.jar   algs.chapter3.table1.Main

And to show a code example, type:

  java -cp dist/ADK-1.0-ExamplesAndFigures.jar algs.example.chapter5.ModuloSurprise

Some figures and examples require resources that are stored on the
disk. These examples must be run within the appropriate Examples/build or
Figures/build directory. For example, to regenerate the data from sidebar 2
in chapter 2, type:

  cd Figures
  java -cp ../dist/ADK-1.0-ExamplesAndFigures.jar algs.chapter2.sidebar2.Main

Optional Tasks
==============

1. Type 'ant junitreport' to produce a full Report on the JUnit
   progress. Find the compiled JUnit report in:

       ./Tests/build/report/ 

   This option is likely only available for ant 1.7 users.

Final Words
===========

Once the book is published, the authors will publish a "Monthly Column"
Blog to further expand on the algorithms described in the book. The Blog
will be linked from the book's web page:

  http://oreilly.com/catalog/9780596516246

We intend to release updated versions of the repository based upon any
identified problems. You likely are already aware of the SVN repository
from which you downloaded this release:

  http://examples.oreilly.com/svn/examples/9780596516246/

Each numbered-release will be available in this directory for free
download. A README.txt file will describe the status of each release and
there will be CHANGELOG file describing the defects fixed or added
enhancements. 

Should you find an issue in either the code or the book, please let us know
using the book's web site:

  http://oreilly.com/catalog/9780596516246/errata/

You can post Errata and see the list of errors/corrections that were found
after the book was printed.  Should you wish to also post a review of the
book (and this code) visit the book's webpage:

  http://oreilly.com/catalog/9780596516246



