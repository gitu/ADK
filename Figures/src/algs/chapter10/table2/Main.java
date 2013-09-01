package algs.chapter10.table2;

import algs.model.tests.common.TrialSuite;

/**
 * Compute Knuth's walk for n-queen problem estimation.
 * 
 * @author George Heineman
 */
public class Main {
	
	
	/** Generate table. */
	public static void main (String []args) {
		
		int LOW_T = 1024; 
		int HIGH_T = 65536;
		
		for (int n = 1; n <= 20; n++) {
			for (int m = LOW_T; m <= HIGH_T; m *= 8) {
				TrialSuite ts = new TrialSuite();
				for (int t = 0; t < m; t++) {
					// compute estimate of number of n-by-n queens
					Board b = new Board(n);
					
					int r = 0;
					long lastEstimate = 1;
					while (r < n) {
						int numChildren = b.numChildren(r);
						
						// no more to go, so no solution found.
						if (!b.randomNextBoard(r)) {
							lastEstimate = 0;
							break; 
						}
						
						lastEstimate = lastEstimate*numChildren;
						r++;
					}
					
					ts.addTrial(n, 0, lastEstimate);
				}
				
				System.out.println(n + "," + m + "," + ts.computeTable());
			}
		}
	}
}
