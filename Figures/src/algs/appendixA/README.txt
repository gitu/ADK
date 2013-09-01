Some images found in this chapter are generated. If the figure is 
drawn manually then it is not included in this list. For examples, 
we show where in the code repository to locate the code.

Example A-1: Java example to time execution of task

  find in algs.appendixA.example1.Main

Example A-5: compare.sh benchmarking script 

  find in Code/bin/compare.sh
  
Example A-6: suiteRun.sh benchmarking script

  find in Code/bin/suiteRun.sh
  
Example A-7: Helper functions for Scheme timing
Example A-8: Timing Scheme code
Example A-9: largeAdd Scheme function

  find in Code/Scheme/chapter2.ss
  
Table A-2: Execution time for 30 trials of large Add


  cd Code/Scheme
  mzscheme
  > (load "chapter2.ss")
  > (briefReport largeAdd millionplus 30 1000000 5000000)
  
Table A-4: Timing results of 30 computations in Java  

  java algs.appendixA.example1.Main

Table A-5: Timing results of 30 computations in C

  cd Code/Clock
  ./sample

Table A-6: same as Table A-2, just with more detail

Table A-7: Results using nanosecond timers

  find in PerformanceTests
  java algs.model.performance.timing.MeasureTiming
  

  

