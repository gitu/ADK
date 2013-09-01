Some images found in this chapter are generated. If the figure is 
drawn manually then it is not included in this list. For examples, 
we show where in the code repository to locate the code.

Figure 9-1: Core interfaces for computational geometry

  find in algs.model.IPoint
  find in algs.model.IRectangle
  find in algs.model.ILineSegment

Figure 9-2: Interfaces to represent multiple dimensional data

  find in algs.model.IMultiPoint
  find in algs.model.IHypercube
  find in algs.model.IMultiLineSegment
  
Figure 9-3: Interface to represent interval [left, right)

  find in algs.model.IInterval
  
Example 9-1: Brute Force Intersection implementation

  find in algs.model.problems.segmentIntersection.BruteForceAlgorithm

Table 9-2: API definition of problems discussed in this chapter

  find in algs.model.problems.convexhull.IConvexHull
  find in algs.model.problems.segmentIntersection.IntersectionDetection
  find in algs.model.kdtree.KDTree

Figure 9-11: PartialHull supporting class

  find in algs.model.problems.convexhull.PartialHull

Example 9-2: Convex Hull Scan solution to convex hull

  find in algs.model.problems.convexhull.andrew.ConvexHullScan

Table 9-3: Example showing running times and applies Akl-Toussaint heuristic

  java algs.chapter9.table3.Main 
  
  Information regarding the number of points removed and points on hull
  INCLUDE the trials that were the best and worst performers, but that is
  not so serious an issue I think. Nonetheless, be sure to compute averages
  on these numbers using a denominator of 100.

Figure 9-12: Performance of convex hull variations

  java algs.chapter9.figure12.Main
  
  the results are then processed using GnuPlot to produce results. 
  
    cd Code/GnuPlot/Chapter-9
    make
  
  Find output in 9-12.ps

Figure 9-13: Detecting Seven Intersections for six line segments

  java algs.chapter9.figure13.Main and read the generated output
  
Figure 9-16: EventPoint class

  find in algs.model.problems.segmentIntersection.EventPoint
  find in algs.model.problems.segmentIntersection.EventQueue
  find in java.util.Comparator  
  
Figure 9-17: LineState Class

  find in algs.model.problems.segmentIntersection.LineState  
  
Example 9-3: LineSweep Java Implementation

  find in algs.model.problems.segmentIntersection.LineSweep
  
Table 9-4: Timing comparison (in milliseconds) between algorithms on Buffon’s needle problem

  java algs.chapter9.table4.Main
 
Table 9-5: Worst-case comparison of LineSweep versus BruteForce (in ms)

  java algs.chapter9.table5.Main
 
Example 9-4: Recursively construct a balanced kd-tree

  find in algs.model.kdtree.KDFactory
  
Figure 9-21: kd-tree core concepts
  
  find in algs.model.kdtree.KDTree
  find in algs.model.kdtree.DimensionalNode
  
Example 9-5: Nearest Neighbor Queries implemented with kd-tree

  find in algs.model.kdtree.KDTree
  find in algs.model.kdtree.DimensionalNode
  
Table 9-6: Ratio of double recursion invocations to single

  java algs.chapter9.table6.Main -Xms512m -Xmx512m
  
Figure 9-22: Number of double recursions as n and d increase 

  java algs.chapter9.figure22.Main -Xms1024m -Xmx2048m
    
Figure 9-23: Comparing kd-tree versus brute-force implementation
  
  java algs.chapter9.figure23.Main -Xms512m -Xmx512m
  
Example 9-6: Range Query implementation

  find in algs.model.kdtree.DimensionalNode
  
Table 9-7: Comparing Range Query approaches (kd-tree versus brute force) for situation 1

  java algs.chapter9.table7.Main

Figure 9-25: Expected performance for O(n^1-1/d) algorithm

  The values that are plotted are simply computed from Excel and saved
  to a file for plotting.

  cd Code/GnuPlot/Chapter-9
  make
  
  Find output in 9-25.ps

Figure 9-26: Comparing kd-tree versus brute force for situation 2

  java algs.chapter9.figure26.Main

  This will create five sets of information (for each of the ratios). Save 
  the results into Excel and then massage the data to create the figure9-26.dat
  file to be used for graphing.
  
  cd Code/GnuPlot/Chapter-9
  make
  
  Find output in 9-26.ps 

Table 9-8: Brute force Range Query for situation 3

  java algs.chapter9.table8.Main
  
