package algs.model.tests.fifteenpuzzle;

import junit.framework.TestCase;
import org.junit.Test;

import algs.debug.DottyDebugger;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.fifteenpuzzle.FifteenPuzzleNode;
import algs.model.problems.fifteenpuzzle.GoodEvaluator;
import algs.model.searchtree.debug.AStarSearch;

public class FifteenPuzzleTest extends TestCase {

	@Test
	public void testState() {

		// more complex sequence of moves: just not able to make progress
		// on this one.
		FifteenPuzzleNode start = new FifteenPuzzleNode(new int[][]{
				{ 2,10, 8, 3},
				{ 1, 6, 0, 4},
				{ 5, 9, 7,11},
				{13,14,15,12}
		});
		
		FifteenPuzzleNode goal = new FifteenPuzzleNode(new int[][]{
				{ 1, 2, 3, 4},
				{ 5, 6, 7, 8},
				{ 9,10,11,12},
				{13,14,15, 0}
		});
		
		// strange cases
		assertFalse (goal.equivalent(null));
		assertFalse (goal.equals(null));
		assertFalse (goal.equals("George"));
		
		AStarSearch as = new AStarSearch(new GoodEvaluator());
		DottyDebugger std = new DottyDebugger();
		as.debug(std);
		as.search(start, goal);
		
		// false. First has no empty; second is diagonal.
		assertFalse (start.swap(0,0,0,1));
		assertFalse (start.swap(2,0,1,1));
		 
		assertTrue (start.isAdjacentAndEmpty(0, 2, 1, 2));
		assertTrue (start.isAdjacentAndEmpty(2, 2, 1, 2));
		assertFalse (start.isAdjacentAndEmpty(2, 1, 1, 2));
		
		assertEquals (0, start.compareTo(start));
		assertFalse (start.compareTo(goal) == 0);
		
		assertEquals (" 2 10  8  3 \n 1  6     4 \n 5  9  7 11 \n13 14 15 12 \n", 
					  start.toString());
		
		EightPuzzleNode.debug = false;
		assertEquals ("{2|1|5|13}|{10|6|9|14}|{8| |7|15}|{3|4|11|12}", start.nodeLabel());
		EightPuzzleNode.debug = true;
		start.score(99);
		assertEquals ("{2|1|5|13}|{10|6|9|14}|{8| |7|15}|{3|4|11|12}|{score: 99}", start.nodeLabel());
		EightPuzzleNode.debug = false;  // reset to standard default

	}
}
