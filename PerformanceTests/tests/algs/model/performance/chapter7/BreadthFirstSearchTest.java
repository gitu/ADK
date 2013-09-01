package algs.model.performance.chapter7;

import org.junit.Test;

import algs.debug.DottyDebugger;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.searchtree.Solution;

import junit.framework.TestCase;

public class BreadthFirstSearchTest extends TestCase {

	// searches 282 nodes: (7,6,5,4,2,8,1,2)
	@Test
	public void testBFS() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		algs.model.searchtree.debug.BreadthFirstSearch bfs = new algs.model.searchtree.debug.BreadthFirstSearch();
		DottyDebugger std = new DottyDebugger();
		bfs.debug(std);
		Solution sol = bfs.search(start, goal);
		
		System.out.println (std.numNodes() + " nodes searched.");
		System.out.println (bfs.numOpen + " open, " + bfs.numClosed + " closed");
		System.out.println (std.getInputString());
		System.out.println (sol.toString());
		
	}
	
//	 searches 282 nodes: (7,6,5,4,2,8,1,2)
	@Test
	public void testBFSNonDebug() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		algs.model.searchtree.BreadthFirstSearch bfs = new algs.model.searchtree.BreadthFirstSearch();
		Solution sol = bfs.search(start, goal);
		System.out.println (sol.toString());
		
	}
}
