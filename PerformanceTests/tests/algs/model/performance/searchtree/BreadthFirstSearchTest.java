package algs.model.performance.searchtree;

import org.junit.Test;

import algs.debug.DottyDebugger;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.searchtree.debug.BreadthFirstSearch;

import junit.framework.TestCase;

public class BreadthFirstSearchTest extends TestCase {

	// searches just 47 nodes.
	@Test
	public void testBFS() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{2,8,3},{1,6,4},{7,0,5}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		DottyDebugger std = new DottyDebugger();
		bfs.debug(std);
		/* Solution sol = */ bfs.search(start, goal);
		
		System.out.println (std.numNodes() + " nodes searched.");
		System.out.println (std.getInputString());
		
	}
}
