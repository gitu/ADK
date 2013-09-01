package algs.chapter10.table1;

import java.util.Hashtable;

import algs.model.tests.common.TrialSuite;

/**
 * Compute table to show execution of probabilistic counting algorithm
 * 
 * @author George Heineman
 */
public class Main {
	/** 
	 * Heart of the probabilistic algorithm to sample elements from a set 
	 * of size n.
	 * 
	 * Randomly selects integers for k steps until the same integer is found twice.
	 * Then approximate the original value of n from the equation 2*k*k/PI.
	 * 
	 * Note: using ArrayList instead of Hashtable drags this implementation 
	 * to a crawl because of the inherent inefficiencies of the "contains" 
	 * operation.
	 */
	public static double computeK (int n) {
		// Make sure we use data structure with efficient lookup.
		Hashtable<Integer,Boolean> setS = new Hashtable<Integer,Boolean>();

		// Repeatedly probe to see if already located
		int y = 1+((int)(Math.random()*n));
		while (!setS.containsKey(y)) {
			setS.put(y, Boolean.TRUE);
			y = 1+((int)(Math.random()*n));
		}

		// return estimate of original size
		int k = setS.size();
		return 2.0*k*k/Math.PI;
	}
	
	/** Generate table. */
	public static void main (String []args) {
		int MAX_SIZE = 16777216;
		
		for (int numAvg = 32; numAvg <= 256; numAvg *= 2) {
			System.out.println("Num Average:" + numAvg);
			TrialSuite ts = new TrialSuite();
			for (int n = 256; n <= MAX_SIZE; n *= 2) {
				System.out.println("  n:" + n);

				for (int i = 0; i <numAvg; i++) {
					double estimate = computeK(n);
					
					// convert to an integer
					ts.addTrial(n, 0, (int) estimate);
				}
			}
			
			System.out.println("numAvg:" + numAvg);
			System.out.println(ts.computeTable());
		}
	}
}
