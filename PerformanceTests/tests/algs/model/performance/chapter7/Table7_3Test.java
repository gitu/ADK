package algs.model.performance.chapter7;

import org.junit.Test;

import algs.model.problems.eightpuzzle.BadEvaluator;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.problems.eightpuzzle.WeakEvaluator;
import algs.model.searchtree.Solution;
import algs.model.searchtree.AStarSearch;

public class Table7_3Test {
	@Test
	public void testFigure() {
		System.out.println ("Table7_3");
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{1,4,8},{7,3,0},{6,5,2}
		});

		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		GoodEvaluator ge = new GoodEvaluator();
		AStarSearch as = new AStarSearch(ge);
		
		Solution sol = as.search(start, goal);
		System.out.println ("GoodEvaluator:" + sol.numMoves() + " moves.");
		System.out.println ("closed:" + as.numClosed + ", open:" + as.numOpen +"\n");
		
		WeakEvaluator we = new WeakEvaluator();
		as = new AStarSearch(we);
		
		sol = as.search(start, goal);
		System.out.println ("WeakEvaluator:" + sol.numMoves() + " moves.");
		System.out.println ("closed:" + as.numClosed + ", open:" + as.numOpen + "\n");
		
		BadEvaluator be = new BadEvaluator();
		as = new AStarSearch(be);
		
		sol = as.search(start, goal);
		System.out.println ("BadEvaluator:" + sol.numMoves() + " moves.");
		System.out.println ("closed:" + as.numClosed + ", open:" + as.numOpen + "\n");
		
	}
	
}
