package algs.model.performance.chapter7;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.Test;

import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.searchtree.*;

/**
 * Attempt head to head comparison of BFS/DFS.
 * 
 * For N=2,4,8,16 path lengths
 *    Generate T=10 random boards with those moves
 *         Run BFS
 *         Run DFS-depth-2*N
 *         Run DFS-depth-N
 *         Run AStarSearch
 *         
 * Compare by (a) Number of nodes searched; (b) solution length found.         
 * 
 * Sample output results on home PC
  
2,44,30,72,50,2.0,2.0,2.0,2.0
3,149,61,162,70,3.0,3.0,3.0,3.0
4,261,120,639,90,4.0,4.0,4.4,4.0
5,421,248,2228,110,5.0,5.0,6.4,5.0
6,830,365,3874,130,6.0,6.0,10.6,6.0
7,1337,524,6894,141,6.6,6.6,7.25(2),6.6
8,2091,780,9564,171,7.6,7.7777777(1),14.0(1),7.6
9,4283,1316,19705,239,9.0,9.0(1),13.25(2),9.0
10,6894,2051,29236,241,9.8,9.666667(4),16.0(4),9.8
11,11676,3194,97161,488,10.8,11.0(5),20.333334(7),11.4
12,15129,4943,63994,665,12.0,12.0(1),24.0(5),15.4
13,25468,6828,120836,576,12.4,NaN(10),21.857143(3),13.2
14,39565,8562,135193,482,13.6,14.0(5),26.222221(1),14.6
15,62229,10597,168981,512,14.2,14.2(5),25.75(2),14.2

 * @author George Heineman
 */
public class Table7_4Test extends TestCase {

	EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
			{1,2,3},{8,0,4},{7,6,5}
	});

	
	public INode randomize (int n) {
		
		INode prev = goal;
		int ctr = 0;
		ArrayList<INode> visited = new ArrayList<INode>();
		visited.add(goal);
		while (n > 0) {
			ArrayList<INode> nodes = new ArrayList<INode>();
			ctr++;
			for (Iterator<IMove> it = prev.validMoves().iterator(); it.hasNext(); ) {
				
				INode copy = prev.copy();
				IMove move = it.next();
				move.execute(copy);
				copy.storedData(new Transition (move, prev));
				
				// add only if not yet visited
				if (!visited.contains(copy)) {
					nodes.add(copy);
				}
			}
			
			// select one at random.
			int rnd = (int)(Math.random() * nodes.size());
			prev = nodes.get(rnd);
			visited.add(prev);
			n--;
		}
		
		return prev;
	}
	
	@Test
	public void testFailureCase() {
		// 8 moves away
		EightPuzzleNode start = new EightPuzzleNode(new int[][]{
				{8,1,3},{7,2,5},{0,4,6}
		});
		
		// can't find! Because the horizon effect. Need more detailed analysis to
		// see WHICH was the failed one.
		DepthFirstSearch dfs2 = new DepthFirstSearch(13);
		Solution ds2 = dfs2.search(start.copy(), goal);
		assertFalse (ds2.succeeded());
	}
		
	
	@Test
	public void testHeadtoHead() {
		int T = 10;
		
		for (int n = 2; n <= 15; n += 1) {			
			int totalsB=0, totalsD2=0, totalsD2N = 0, totalsA = 0;
			int statesB=0, statesD2=0, statesD2N = 0, statesA = 0;
			int failedB=0, failedD2=0, failedD2N = 0, failedA = 0;
			for (int t = 0; t < T; t++) {
				// Run BFS
				// Run DFS-unbounded
				// Run DFS-depth-2*N
				// Run DFS-depth-N
				INode start = randomize(n);
				BreadthFirstSearch bfs = new BreadthFirstSearch();
				Solution bs = bfs.search(start.copy(), goal);
				if (!bs.succeeded()) {
					failedB++;     // should never happen.
				}
				totalsB += bs.numMoves();
				statesB += bfs.numClosed + bfs.numOpen;
					
				DepthFirstSearch dfs2 = new DepthFirstSearch(n);
				Solution ds2 = dfs2.search(start.copy(), goal);
				if (!ds2.succeeded()) {
					failedD2++;
				}
				totalsD2 += ds2.numMoves();
				statesD2 += dfs2.numClosed + dfs2.numOpen;
				
				DepthFirstSearch dfs2n = new DepthFirstSearch(2*n);
				Solution ds2n = dfs2n.search(start.copy(), goal);
				if (!ds2n.succeeded()) {
					failedD2N++;
				}
				totalsD2N += ds2n.numMoves();
				statesD2N += dfs2n.numClosed + dfs2n.numOpen;
				
				AStarSearch as = new AStarSearch(new GoodEvaluator());
				Solution asol = as.search(start, goal);
				if (!asol.succeeded()) {
					failedA++;
				}
				totalsA += asol.numMoves();
				statesA += as.numClosed + as.numOpen;

			}
			
			float avgB = totalsB;
			float avgD2 = totalsD2;
			float avgD2N = totalsD2N;
			float avgA = totalsA;
			avgB /= (T - failedB);
			avgD2 /= (T - failedD2);
			avgD2N /= (T - failedD2N);
			avgA /= (T - failedA);
			
			System.out.print (n + "," + statesB + "," + statesD2 + "," + statesD2N + "," + statesA + ",");
			System.out.print (avgB); if (failedB != 0) { System.out.print ("(" + failedB + ")");	}
			System.out.print (",");
			System.out.print (avgD2); if (failedD2 != 0) { System.out.print ("(" + failedD2 + ")");	}
			System.out.print (",");
			System.out.print (avgD2N); if (failedD2N != 0) { System.out.print ("(" + failedD2N + ")");	}
			System.out.print (",");
			System.out.print (avgA); if (failedA != 0) { System.out.print ("(" + failedA + ")");	}
			System.out.println();
		}
	}
}
