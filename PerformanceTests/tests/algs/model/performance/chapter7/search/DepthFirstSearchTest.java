package algs.model.performance.chapter7.search;

import org.junit.Test;

import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.tictactoe.debug.TicTacToeDebugger;
import algs.model.searchtree.Solution;

import junit.framework.TestCase;

public class DepthFirstSearchTest extends TestCase {

	@Test
	public void testDFS() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});

		algs.model.searchtree.debug.DepthFirstSearch dfs =
			new algs.model.searchtree.debug.DepthFirstSearch(9);
		TicTacToeDebugger std = new TicTacToeDebugger();
		std.ordering(TicTacToeDebugger.DepthFirstOrdering);  // needed to ensure proper ordering for depth-first search.
		dfs.debug(std);
		Solution sol = dfs.search(start, goal);
		System.out.println (sol.toString());
		
		System.out.println (std.getInputString());
//		String s1 = sol.toString();
//		
//		algs.model.searchtree.DepthFirstSearch dfs2 = new algs.model.searchtree.DepthFirstSearch(10);
//		Solution sol2 = dfs2.search(start, goal);
//		String s2 = sol2.toString();
//		
//		assertEquals (s1, s2);
	}
}
