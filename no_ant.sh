#!/bin/bash
#
# Use this bash script to compile all files if you don't have ant. This
# is meant as a poor substitute since it only compiles the code, but 
# doesn't run any of the JUnit test cases. Note: We even exclude any
# dependence upon JUnit (http://www.junit.org) so the test cases are 
# not even compiled. 
#
# Note: The code still requires a JDK 1.6-compliant javac compiler.
# -----------------------------------------------------------------

which javac
if [ $? -eq 1 ]
then
   exit 1
fi

# determine path separator to use
# -------------------------------
echo "public class Sep { public static void main (String args[]) { System.out.print (java.io.File.pathSeparatorChar);}}" >> Sep.java
javac Sep.java
SEP=`java Sep`
rm -f Sep.java Sep.class

# all compilation within the 'src' directories
# --------------------------------------------
DIRS=`echo JavaCode Examples Figures`
CLASSPATH=.
for i in $DIRS
do
  CLASSPATH=../$i/src$SEP$CLASSPATH
done

export CLASSPATH
echo "CLASSPATH: $CLASSPATH"

for i in $DIRS
do
  echo "compiling $i..."
  cd $i
  javac `find src -name "*.java"` > /dev/null
  cd ..
done

# Create JAR file
# ---------------
if [ ! -d dist ]
then
  mkdir dist
fi

# Make the various JAR files
# --------------------------------------------------
(cd JavaCode/src; jar cf ../../dist/ADK-1.0.jar `find . -name "*.class"`)
cp dist/ADK-1.0.jar dist/ADK-1.0-ExamplesAndFigures.jar 
(cd Examples/src; jar uf ../../dist/ADK-1.0-ExamplesAndFigures.jar `find . -name "*.class"`)
(cd Figures/src; jar uf ../../dist/ADK-1.0-ExamplesAndFigures.jar `find . -name "*.class"`)

