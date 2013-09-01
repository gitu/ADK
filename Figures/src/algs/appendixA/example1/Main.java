package algs.appendixA.example1;

import algs.model.tests.common.TrialSuite;

public class Main {
	public static void main(String[] args) {
		TrialSuite ts = new TrialSuite();
	    for (long len = 1000000; len <= 5000000; len += 1000000) {
	      for (int i = 0; i < 30; i++) {
	        System.gc();
	        long now = System.currentTimeMillis();

	        /** Task to be timed. */
	        long sum = 0;
	        for (int x = 1; x <= len; x++) { sum += x; } 

	        long end = System.currentTimeMillis();
	        ts.addTrial(len, now, end);
	      }
	    }        
	    System.out.println (ts.computeTable());
	}

}
