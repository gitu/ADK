package algs.chapter7.table4;

import java.util.ArrayList;
import java.util.Iterator;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.searchtree.*;

/*

 for 100 trials
 
cs:~/Table7-4 ./launch.sh
2,454,300,622,500,2.0,2.0,2.0,2.0
3,1272,734,2970,700,3.0,3.0,3.0,3.0
4,2486,1263,6895,894,4.0,4.0,4.88,4.0
5,4744,1980,17610,1090,5.0,5.0,5.88,5.0
6,7627,3239,33509,1250,6.0,6.0,9.575758(1),6.0
7,13476,5651,72056,1469,6.78,6.92,9.138889(28),6.78
8,23541,7512,98215,1721,7.86,7.897959(2),12.894117(15),7.86
9,35169,14025,261413,2227,8.48,8.770833(4),12.630769(35),8.54
10,57788,19973,316073,2531,9.5,9.789474(24),16.461538(35),9.64
11,96721,26203,571013,3470,10.48,10.407408(46),16.352112(29),10.8
12,140893,45608,626531,4061,11.08,11.6(40),19.233334(40),11.72
13,222660,50250,1137973,5648,12.12,12.125(52),21.816902(29),12.96
14,383195,90975,1424586,6929,13.36,13.657143(65),26.140844(29),15.48
15,585555,120741,2370506,7420,13.84,13.75(68),26.37143(30),15.82
16,859348,160943,2170909,8103,14.86,15.133333(70),30.557377(39),17.8

 
 
 * 
 */

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
public class Main  {

	static EightPuzzleNode goal = new EightPuzzleNode(new int[][]{
			{1,2,3},{8,0,4},{7,6,5}
	});

	
	public static INode randomize (int n) {
		
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
	
	public static void main(String[] args) {
		int T = 1000;
		
		System.out.println ("n,statesA*,statesB,statesD,statesD2,avgA,avgB,avgD,avgD2");
		for (int n = 2; n <= 14; n += 1) {			
			float totalsB=0, totalsD=0, totalsD2N = 0, totalsA = 0;
			float statesB=0, statesD=0, statesD2N = 0, statesA = 0;
			int failedB=0, failedD=0, failedD2N = 0, failedA = 0;
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
					
				DepthFirstSearch dfs = new DepthFirstSearch(n);
				Solution ds = dfs.search(start.copy(), goal);
				if (!ds.succeeded()) {
					failedD++;
				}
				totalsD += ds.numMoves();
				statesD += dfs.numClosed + dfs.numOpen;
				
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
			
			totalsB /= (T - failedB);
			totalsA /= (T - failedA);
			totalsD /= (T - failedD);
			totalsD2N /= (T - failedD2N);
			
			// these are still derived from T even though failure to find move
			statesB /= T;
			statesA /= T;
			statesD /= T;
			statesD2N /= T;
			
			System.out.print (n + "," + statesA + "," + statesB + "," + statesD + "," + statesD2N + ",");
			System.out.print (totalsA); if (failedA != 0) { System.out.print ("(" + failedA + ")");}
			System.out.print (",");
			System.out.print (totalsB); if (failedB != 0) { System.out.print ("(" + failedB + ")");}
			System.out.print (",");
			System.out.print (totalsD); if (failedD != 0) { System.out.print ("(" + failedD + ")");	}
			System.out.print (",");
			System.out.print (totalsD2N); if (failedD2N != 0) { System.out.print ("(" + failedD2N + ")");	}
			System.out.print (",");
			System.out.println();
		}
	}
}
