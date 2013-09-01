Images found in this chapter are generated in various ways. Once all data
figures are placed into Code/GnuPlot/Chapter-2 then you can type make there
to create the required postscript files using GnuPlot. These postscript files
are then converted (using Adobe Distiller) to create the required PDF image.


Sidebar Two: Effect of encoding on performance

  java algs.chapter2.sidebar2.Main
  
Figure 2-2: Comparing four sort algorithms on small data sets

  cd Code/Sorting/Chapter-2-Figures
  ../../bin/suiteRun.sh figure2-2.rc
  
  place results into Code/GnuPlot/Chapter-2 as figure2-2.dat
  
Figure 2-3: Comparing sort algorithms on sorted and nearly sorted data

  cd Code/Sorting/Chapter-2-Figures
  ../../bin/suiteRun.sh figure2-3a.rc
  ../../bin/suiteRun.sh figure2-3b.rc
    
  concatenate the resulting output (with two blank lines separating the values)
  into file figure2-3.dat within Code/GnuPlot/Chapter-2  

Figure 2-4: Sort-4 wins on nearly sorted data

  cd Code/Sorting/Chapter-2-Figures/Figure2-4
  ./buildAll.sh
  ./runAll.sh
   
  place resulting output within figure2-4.dat in Code/GnuPlot/Chapter-2
  
Table 2-1: Sample Behavior for guessing number from 1-10

  java algs.chapter2.table1.Main
  
  note that this operates on the range [1,1000000] not the [1,10] in table.

Example 2-1: Java code to guess number in range [low,high]

  java algs.chapter2.example1.Main

  note that this operates on the range [1,1000000]

Table 2-2: Newton's Method 

  cd Code/Chapter2
  java Newton
  
Example 2-2: Java implementation of add

  java algs.chapter2.example2.Main
  
Example 2-3: Java implementation of last

  java algs.chapter2.example2.Main

  note: also found in the example2.Main class
  
Figure 2-5: Comparing add and last in different scenarios
Table 2-3: Time (in milliseconds) to execute 10,000 add/last invocations
           on random digits of size N.
           
  cd Code/Chapter2
  make FullReport
  
  Information in files "report.pc.visualStudio.*" were generated using MS
  Visual Studio C++ edition on Desktop PC. Data in "report.pc.Java' generated 
  in Eclipse on same Desktop PC.
  
  Once all reporting information is available then run "combining.sh" to prepare
  the "figure2-5.dat" file that combines everything in proper order. See the
  "2-5.plot" file in Code/GnuPlot/Chapter-2 to see the proper order. 
  
  Combine the results properly into a single file as determined by 2-5.plot
  within Code/GnuPlot/Chapter-2. These results are combined into table 2-3.
  
Example 2-4: mult implementation of Multiplication in Java
Table 2-4: Time to execute 10,000 multiplications
Figure 2-6: Comparison of mult vs. alt

  java algs.chapter2.table4.Main

Example 2-5: Euclid's GCD algorithm
Example 2-6: ModGCD algorithm for GCD computation.
Table 2-5: Time (in milliseconds() to execute 10,011 gcd computations
Figure 2-7: Comparison of gcd versus modgcd

  java algs.chapter2.table5.Main
  
Table 2-6: Comparing operations from different implementations

  This is performed by hand without using any actual code.
  
Example 2-7: Expensive computations
Figure 2-8: Execution times for computing 2^X

  This code executes using the scheme interpreter:
    Welcome to MzScheme v371 [3m], Copyright (c) 2004-2007 PLT Scheme Inc.
    
  cd Code/Scheme
  mzscheme
  Welcome to MzScheme v371 [3m], Copyright (c) 2004-2007 PLT Scheme Inc.
  > (load "chapter2.ss")
  > (briefReport testfunc plus1 50 1 64)
  
  note that testfunc invokes twotothen 10,000 times.

Figure 2-9: Execution times for computing large multiplications

  This code executes using the scheme interpreter:
    Welcome to MzScheme v371 [3m], Copyright (c) 2004-2007 PLT Scheme Inc.
  
  cd Code/Scheme
  mzscheme
  Welcome to MzScheme v371 [3m], Copyright (c) 2004-2007 PLT Scheme Inc.
  > (load "chapter2.ss")
  > (customReport plus1 50 1 128)          
  
  note that customReport pre-calculates 2^n and computed the multiplication
  10,000 times.
   
