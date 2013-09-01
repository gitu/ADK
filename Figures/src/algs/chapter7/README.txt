Some images found in this chapter are generated. If the figure is 
drawn manually then it is not included in this list. For examples, 
we show where in the code repository to locate the code.

In numerous of the figures in this chapter, we use the freely available
DOTTY program (www.graphviz.org) to produce high quality images for the
expanded game and search trees. In general, there are programs for each
figure that produce text suitable for input to DOTTY. We execute the
conversion manually using the PC version of the software, though I expect
that a batch-oriented Linux version would have worked as well. Using the
graphical interface provided by GraphViz we converted the DOTTY input into
postscript format. Then we ran Adobe Distiller (again on a PC) to convert
the Postscript into high quality PDF documents with embedded fonts (the
specific font was TimesNewRomanPSMT). For the final book production, it is
expected that the font will be converted into 'Myriad Pro Condensed'. 

Finally, there are parallel debugging classes for the major search classes
which can be found in packages algs.model.searchtree.debug and
algs.model.gametree.debug; these contain special logic to properly generate
the images that we see in this chapter. When computing the performance of
an algorithm, make sure you don't use these specialized debug classes. 

Figure 7-1: Partial game tree given an initial tic-tac-toe game state

  Hand drawn image

Figure 7-2: Core concepts for game tree algorithms

  These UML diagrams describe the following interfaces:
  
     algs.model.gametree.IGameState
     algs.model.gametree.IScore
     algs.model.gametree.IPlayer
     algs.model.gametree.IGameMove
     
Example 7-1: Common interface for game tree path finding

  Find class in algs.model.gametree.IEvaluation
  
Figure 7-3: Sample 8-puzzle search

  java algs.chapter7.figure3.Main      # generates DOTTY input

Figure 7-4: Core concepts for search tree algorithms

  These UML diagrams describe the follow interfaces and classes:
  
      algs.model.searchtree.IMove
      algs.model.searchtree.INode
      algs.model.searchtree.INodeSet
      algs.model.searchtree.Solution

Example 7-2: Common interface for search tree path finding

  Find class in algs.model.searchtree.ISearch
  
Figure 7-6: Sample depth-first search tree for 8-puzzle

  java algs.chapter7.figure6.Main      # generates DOTTY input
  
Example 7-3: Depth-first search implementation

  Find source code in package algs.model.searchtree.DepthFirstSearch
  
  The only piece of the code 'simplified' for the presentation is that
  in the real code the closed storage can be configured to one of a variety
  of possible structures (Stack, Queue, Hash Table, etc...). In the figure
  we just state straight up that HASH is the default storage structure, 
  although this can be configured once the Depth First Search object is
  constructed.

Table 7-1: Size of search tree (open + closed) for three initial positions
Table 7-2: Solutions for Depth-First Search tree by ply depth for three 
           initial positions.

  java algs.chapter7.table1.Main
  
  you can extract the middle column from each of the individual reports to
  form the combined table shown in Table 7-1. You can compute the approximation
  functions associated with the data by dropping rows 1-29 of the table
  into MS excel and graphing the results. Then add a trendline and choose
  the 'power' option (don't forget to show equations!). 
  
  Note that the third column of each of the outputs is used for Table 7-2.
  
  Also note that there is extra output at the end that shows the horizon effect,
  not as impressive as hoped, but it does show when the search prevents a solution
  from being found which is only a few moves away from the goal.

Figure 7-7: Search tree size for Depth-First Search as depth increases

  cd Code/GnuPlot/Chapter-7
  make 
  
  Input file "figure7-7.dat" is populated with the data from table 7-1.
  Take the generated 7-7.ps file and convert to PDF using Adobe Acrobat
  Distiller with highest quality and font-embedding.

Figure 7-9: Sample Breadth-first search tree for 8-puzzle
  
  java algs.chapter7.figure9.Main      # generates DOTTY input
  
Example 7-4: Breadth-First search implementation

  Find source code in package algs.model.searchtree.BreadthFirstSearch
  
  The only piece of the code 'simplified' for the presentation is that
  in the real code the closed storage can be configured to one of a variety
  of possible structures (Stack, Queue, Hash Table, etc...). In the figure
  we just state straight up that HASH is the default storage structure, 
  although this can be configured once the Depth First Search object is
  constructed.

Figure 7-11: Sample A*Search tree in 8-puzzle using GoodEvaluator f*(n)

  java algs.chapter7.figure11.Main
  
Figure 7-12: Sample A*Search tree in 8-puzzle using WeakEvaluator f*(n)

  java algs.chapter7.figure12.Main
 
  To see how bad the BadEvaluator is, try running the code in 
  algs.chapter7.figure12.BadEvaluationExample which returns a 129 move solution
  after exploring over 7000 nodes. 
 
Example 7-5: A*Search implementation

  Find source code in package algs.model.searchtree.AStarSearch
  
  The only piece of the code 'simplified' for the presentation is that
  in the real code the closed storage can be configured to one of a variety
  of possible structures (Stack, Queue, Hash Table, etc...). In the figure
  we just state straight up that HASH is the default storage structure, 
  although this can be configured once the Depth First Search object is
  constructed.

Table 7-3: Comparing three evaluation h*(n) functions

  java algs.chapter7.table3.Main 
  
Figure 7-13: Sample A*Search tree for 15-puzzle
  
  java algs.chapter7.figure13.Main      # generates DOTTY input
  
Table 7-4: Comparing search algorithms

  java algs.chapter7.table4.Main
  java algs.chapter7.table4.Extended
  
  The first provides all information for the table; the second is used to show
  the extended range afforded by A*Search.
  
  To see a case where DFS fails, even though it ought to find the board, consider
  running 'algs.chapter7.table4.FailedDFSSearch'
  
Figure 7-14: Comparing Search tree size for random positions

  cd Code/GnuPlot/Chapter-7
  get the output from algs.chapter7.table4.Main and place it in table7-4.dat 
  make
   
  Take the generated 7-14.ps file and convert to PDF using Adobe Acrobat
  Distiller with highest quality and font-embedding.
  
Example 7-6: Minimax Java implementation

  find in algs.model.gametree.MinimaxEvaluation

Figure 7-16: IComparator interface abstracts MAX and MIN operators

  find in algs.model.gametree.IComparator
  
Figure 7-17: Sample Minimax exploration

  java algs.chapter7.figure17.Main           # produce DOTTY output

  This image was too large to show, so it was redrawn/excerpted by 
  hand. The original image can be found in the ExtendedFigures area
  of the code repository.
    
Example 7-7: Negmax implementation

  find in algs.model.gametree.NegMaxEvaluation
  
Figure 7-19: Sample Negmax exploration

  java algs.chapter7.figure19.Main           # produce DOTTY output

  This image was too large to show, so it was redrawn/excerpted by 
  hand. The original image can be found in the ExtendedFigures area
  of the code repository.
  
Figure 7-21: AlphaBeta two-ply search

  java algs.chapter7.figure21.Main           # produce DOTTY output

  This image was too large to show, so it was redrawn/excerpted by 
  hand. The original image can be found in the ExtendedFigures area
  of the code repository.

Figure 7-22: AlphaBeta three-ply search

  java algs.chapter7.figure22.Main           # produce DOTTY output

  This image was too large to show, so it was redrawn/excerpted by 
  hand. The original image can be found in the ExtendedFigures area
  of the code repository.

Example 7-8: AlphaBeta implementation

  find in algs.model.gametree.AlphaBetaEvaluation

Table 7-5: 

  java algs.chapter7.table5.Main
  
  Now take the output and move into Excel for post-processing (specifically
  for the Stdev computations).
