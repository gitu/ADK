package algs.chapter7.figure3;

import algs.debug.DottyDebugger;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.WeakEvaluator;
import algs.model.searchtree.debug.AStarSearch;

public class Main {
	public static void main(String[] args) {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		DottyDebugger std = new DottyDebugger();
		AStarSearch as = new AStarSearch(new WeakEvaluator());
		as.debug(std);
		
		as.search(start, goal);
		System.out.println (std.getInputString());
	}
}
