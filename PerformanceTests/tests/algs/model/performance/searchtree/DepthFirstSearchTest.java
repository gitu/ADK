package algs.model.performance.searchtree;

import org.junit.Test;

import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.tictactoe.debug.TicTacToeDebugger;
import algs.model.searchtree.debug.DepthFirstSearch;

import junit.framework.TestCase;

public class DepthFirstSearchTest extends TestCase {

	@Test
	public void testDFS() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{2,8,3},{1,6,4},{7,0,5}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		DepthFirstSearch dfs = new DepthFirstSearch(5);
		TicTacToeDebugger std = new TicTacToeDebugger();
		std.ordering(TicTacToeDebugger.DepthFirstOrdering);  // needed to ensure proper ordering for depth-first search.
		dfs.debug(std);
		/* Solution sol = */ dfs.search(start, goal);
		
		System.out.println (std.getInputString());
	}
}
