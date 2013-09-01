Some images found in this chapter are generated. If the figure is 
drawn manually then it is not included in this list. For examples, 
we show where in the code repository to locate the code.

Example 5-1: Sequential Search in Ruby

  find in algs.chapter5.example1.search.rb

Example 5-2: Sequential Search in Java

  find in algs.model.search.SequentialSearch

Example 5-3: Sequential Search in C

  cd Code/Search/
  find code in search.c
   
  slightly different since dsIdx is used instead of n as the value for
  the number of items in the collection.

Example 5-4. Sequential search with check for empty slot

  find in algs.chapter5.example4.search.rb

Table 5-1: Sequential Search Performance (in seconds)

  cd Code/Search/Chapter-5-Figures
  bash table5-1.batcher.sh

Example 5-5: Binary Search implementation in Java

  find in algs.model.search.BinarySearch
  
Table 5-2: In-memory Binary Search compared to Sequential Search

  cd Code/Search/Chapter-5-Figures
  bash table5-2.batcher.sh
  
Table 5-3: Secondary-storage Binary Search performance 

  cd Code/Search/Chapter-5-Figures
  bash table5-3.batcher.sh
  
Example 5-6: Sample Java hashCode

  find in algs.chapter5.example6.SimpleString
  
Table 5-4: Hash distribution using Java String.hashCode() function

  java algs.chapter5.table4.Main
    
Example 5-7: Loading the hash table	

  The code from ListHashTable was altered while preparing this example,
  for simplicity.

  find in algs.model.search.ListHashTable

Example 5-8: Searching for an element

  find in algs.model.search.ListHashTable

Table 5-5: Search time (ms) for various hash table sizes

  java algs.chapter5.table5.Main -Xms512m -Xmx512m    
  java algs.chapter5.table5.Extended -Xms512m -Xmx512m
  java algs.chapter5.table5.ExtendedNoRehash -Xms512m -Xmx512m
  java algs.chapter5.table5.ExtendedModestRehash -Xms512m -Xmx512m

Table 5-6: Statistics of hash tables created by example code

  java algs.chapter5.table5.Extended -Xms512m -Xmx512m
  
  all of the information in this table can be extracted from the output
  from the Extended application.
  
Table 5-7: Comparable times (in milliseconds) to build hash tables

  java algs.chapter5.table5.HashTableBuildTimes -Xms512m -Xmx512m
  
Figure 5-10: Sample red-black tree

  The code in algs.chapter5.figure10 is an interesting example of putting 
  algorithms to work. I had forgotten the order in which I had inserted
  the seven numbers into the red-black tree. How could I recover the original
  order in which the numbers were inserted? execute following to see how 
  
  java algs.chapter5.figure10.Reconstruct 

  insert the following in order: 13, 26, 43, 17, 25, 15, 16
  
Example 5-9: Java implementation of search

  find in algs.model.tree.BalancedTree
  
Example 5-10: Java implementation of rotating a node left

  find in algs.model.tree.BalancedTree
  
