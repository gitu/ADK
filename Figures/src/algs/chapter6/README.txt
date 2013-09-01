Some images found in this chapter are generated. If the figure is 
drawn manually then it is not included in this list. For examples, 
we show where in the code repository to locate the code.

Figure 6-6: Core graph operations

  cd Code/Graph
  find definitions for enums, typedefs and Graph class in Graph.h
  
Figure 6-7: A small maze to get from s to t
Figure 6-8: Graph representation of maze from Figure 6-7 

Figure 6-10: Computed d, f, and pred data for a sample undirected graph; 
  vertices are colored when counter reaches 18
  
  cd Code/Graph/DepthFirstSearch
  ./figure6_10
  
  To validate that the colors are drawn appropriately, set a breakpoint
  within dfs.cxx at line 12 in dfs_visit and inspect when counter reaches 18
  
Example 6-1: Depth-First Search implementation
     
  cd Code/Graph/DepthFirstSearch
  find code in dfs.cxx
  
Figure 6-12: Breadth-First Search progress on graph when counter reaches 18

  cd Code/Graph/BreadthFirstSearch
  find code in figure6_12.cxx
  
  execute figure6_12 in debugger to see values of ctr
  
Example 6-2: Breadth-First Search Implementation

  cd Code/Graph/BreadthFirstSearch
  find code in bfs.cxx
  
Figure 6-13: Fact Sheet

  cd Code/Graph/SingleSourceShortestPath
  ./testGraph -v -f Graphs/figure6-13.dat
  
Figure 6-14: Dijkstra's Algorithm expands the set S

  cd Code/Graph/SingleSourceShortestPath
  ./testGraph -v -f Graphs/figure6-14.dat
  
Example 6-3: Dijkstra's Algorithm with priority queue implementation

  cd Code/Graph/SingleSourceShortestPath
  find code in singleSourceShortest.cxx

Example 6-4: Dijkstra's Algorithm for dense graphs

  cd Code/Graph/SingleSourceShortestPath
  find code in dense.cxx

Example 6-5: Optimized Dijkstra's Algorithm for dense graphs

  cd Code/Graph/SingleSourceShortestPath
  find code in rawDense.cxx
    
Example 6-6: Bellman-Ford algorithm for Single Source Shortest Path

  cd Code/Graph/SingleSourceShortestPath
  find code in bellmanFord.cxx
  
Figure 6-17: Different executions of Bellman-Ford have same result

  cd Code/Graph/SingleSourceShortestPath
  ./testBellmanFord -v -f Graphs/figure6-17-left.dat
  ./testBellmanFord -v -f Graphs/figure6-17-right.dat
  
  The results are the same, if you consider the relabing of 1 <=> 4
  
Table 6-2: Time (in seconds) to compute single source shortest path
     on benchmark graphs
     
  cd Code/Graph/SingleSourceShortestPath/Tables
  bash Table6-2.sh
  
Table 6-3: Time (in seconds) to compute single source shortest path
     on dense graphs
     
  cd Code/Graph/SingleSourceShortestPath/Tables
  bash Table6-3.sh
  
Table 6-4: Time (in seconds) to compute single source shortest path
     on dense graphs
     
  cd Code/Graph/SingleSourceShortestPath/Tables
  bash Table6-4.sh
  
Figure 6-18: Floyd-Warshall fact sheet

  cd Code/Graph/AllPairsShortestPath
  ./testGraph pseudoCodeFigure.dat   
  
Example 6-7: Floyd-Warshall algorithm for computing all pairs shortest path

  cd Code/Graph/AllPairsShortestPath
  find code in allPairsShortest.cxx
  
Example 6-8: Code to recover shortest path from the computed pred[][]

  cd Code/Graph/AllPairsShortestPath
  find code in allPairsShortest.cxx
  
Figure 6-19: Prim's Algorithm fact sheet

  cd Code/Graph/MinimumSpanningTree
  ./process -v -f figure6-19.dat
  
Example 6-9: Prim's Algorithm implementation with binary heap

  cd Code/Graph/MinimumSpanningTree
  find code in mst.cxx
  
  
