package algs.model.performance.chapter7;

import org.junit.Test;

import algs.debug.DottyDebugger;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.problems.eightpuzzle.WeakEvaluator;
import algs.model.searchtree.Solution;
import algs.model.searchtree.debug.AStarSearch;

public class Figure7_11Test {
	@Test
	public void testFigure() {
		System.out.println ("Real Figure 7_11");
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});

		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		DottyDebugger std = new DottyDebugger();
		GoodEvaluator ge = new GoodEvaluator();
		AStarSearch as = new AStarSearch(ge);
		as.debug(std);
		
		Solution sol = as.search(start, goal);
		System.out.println (std.getInputString());
		System.out.println (sol.toString());
		
		System.out.println ("-------------second--------------\n\n");
		WeakEvaluator we = new WeakEvaluator();
		std = new DottyDebugger();
		as = new AStarSearch(we);
		as.debug(std);
		
		sol = as.search(start, goal);
		System.out.println (std.getInputString());
		System.out.println (sol.toString());
	}
}
