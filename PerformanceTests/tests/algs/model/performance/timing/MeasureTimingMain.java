package algs.model.performance.timing;

import algs.model.tests.common.TrialSuite;

import junit.framework.TestCase;

public class MeasureTimingMain extends TestCase {
	public static void main (String[]args) {
		TrialSuite tsM = new TrialSuite();
		TrialSuite tsN = new TrialSuite();
		System.gc();
		for (long len = 1000000; len <= 5000000; len += 1000000) {
			for (int i = 0; i < 30; i++) {
				long nowM = System.currentTimeMillis();
				long nowN = System.nanoTime();
				long sum = 0;
				for (int x = 1; x <= len; x++) {
					sum += x;
				}
				
				long endM = System.currentTimeMillis();
				long endN = System.nanoTime(); 
				tsM.addTrial(len, nowM, endM);
				tsN.addTrial(len, nowN, endN);
			}
		}
		
		System.out.println (tsM.computeTable());
		System.out.println (tsN.computeTable());
		System.out.println ("MILLISECONDS");
		System.out.println (tsM.histogram());
		System.out.println ("NANOSECONDS");
		System.out.println (tsN.histogram());
	}
}

