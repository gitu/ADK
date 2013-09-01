package algs.model.tests.searchtree;

import junit.framework.TestCase;

import org.junit.Test;

import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.searchtree.AStarSearch;
import algs.model.searchtree.BreadthFirstSearch;
import algs.model.searchtree.DepthFirstSearch;
import algs.model.searchtree.Solution;

// experiment with different values as well as different approaches.

public class SmallTest extends TestCase {

	// failure test. These can never make a solution.
	@Test
	public void testNeverSucceeed() {
		EightPuzzleNode initial = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,5,6}
		});
		
		DepthFirstSearch dfs = new DepthFirstSearch(4);
		Solution sol = dfs.search(initial, goal);
		assertFalse (sol.succeeded());
		
		assertEquals (0, sol.moves().size());
	}
	
	// test initial as goal.
	@Test
	public void testAStarExampleInitial() {
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		//BreadthFirstSearch<EightPuzzleNode> bfs = new BreadthFirstSearch<EightPuzzleNode>(start, goal);
		//DepthFirstSearch<EightPuzzleNode> bfs = new DepthFirstSearch<EightPuzzleNode>(start, goal, 16);
		AStarSearch as = new AStarSearch(new GoodEvaluator());
		//OrderedSearch<EightPuzzleNode> bfs = new OrderedSearch<EightPuzzleNode>(start, goal);
		Solution sol = as.search(goal, goal);
		assertTrue (sol.succeeded());
		
		assertEquals (0, sol.moves().size());
	}

	@Test
	public void testDFSExampleInitial() {
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		DepthFirstSearch dfs = new DepthFirstSearch(8);
		Solution sol = dfs.search(goal, goal);
		assertTrue (sol.succeeded());
		
		assertEquals (0, sol.moves().size());
	}
	
	@Test
	public void testBFSExampleInitial() {
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Solution sol = bfs.search(goal, goal);
		assertTrue (sol.succeeded());
		
		assertEquals (0, sol.moves().size());
		
	}

	
	@Test
	public void testAStarExample() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		//BreadthFirstSearch<EightPuzzleNode> bfs = new BreadthFirstSearch<EightPuzzleNode>(start, goal);
		//DepthFirstSearch<EightPuzzleNode> bfs = new DepthFirstSearch<EightPuzzleNode>(start, goal, 16);
		AStarSearch as = new AStarSearch(new GoodEvaluator());
		//OrderedSearch<EightPuzzleNode> bfs = new OrderedSearch<EightPuzzleNode>(start, goal);
		Solution sol = as.search(start, goal);
		assertEquals ("move 7,move 6,move 5,move 4,move 2,move 8,move 1,move 2",
					   sol.toString());
	}
	
	@Test
	public void testDFSExample() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		DepthFirstSearch dfs = new DepthFirstSearch(8);
		Solution sol = dfs.search(start, goal);
		assertEquals ("move 7,move 6,move 5,move 4,move 2,move 8,move 1,move 2",
					   sol.toString());
	}
	
	@Test
	public void testBFSExample() {
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{2,4,5},{0,7,6}
		});
		
		EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
				{1,2,3},{8,0,4},{7,6,5}
		});
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Solution sol = bfs.search(start, goal);
		assertEquals ("move 7,move 6,move 5,move 4,move 2,move 8,move 1,move 2",
					   sol.toString());
	}
}
