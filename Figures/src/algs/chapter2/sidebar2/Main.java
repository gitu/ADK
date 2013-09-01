package algs.chapter2.sidebar2;

import algs.model.tests.common.TrialSuite;

/** 
 * Launch application to generate results for Figure 2-3
 *  
 * @author George Heineman
 * @version 1.0, 7/17/08
 * @since 1.0
 */
public class Main {

	/** random name queries. */
	private static Object[][] nameQuery;
	
	/** Random number queries. */
	private static Object[][] numberQuery;

	/** Random weight queries. */
	private static Object[][] weightQuery;

	/** object to alternate between encodings. */
	private static IQuery q;
	
	/** Number of trials to run. */
	private static int NUM_TRIALS = 32;
	
	/**
	 * Number of queries to run is SQ*TRIAL_SIZE. We randomly generate SQ=100 
	 * queries from the periodic table of 117 elements. We draw the query 
	 * elements from the range [-3, 122) so we include some bad ones. Then we
	 * replicate these queries TRIAL_SIZE=1000 times to be able to run for 
	 * a long enough time to generate meaningful time averages.
	 */
	private static int SQ = 100;
	private static int TRIAL_SIZE = 1000;

	/** Set up for each test. */
	public static void setup() {
		// generate SQ sample queries
		numberQuery = new Object[SQ][2];
		nameQuery =  new Object[SQ][2];
		weightQuery =  new Object[SQ][2];
		EncodingOne tbl = new EncodingOne (); 
		for (int i = 0; i < SQ; i++) {
			int r = (int) (Math.random() * 125) - 3;  // include bad ones.
			numberQuery[i][0] = tbl.name(r);
			numberQuery[i][1] = r;
			if (r <= 0) { numberQuery[i][1] = -1; }
			if (r == 117) { numberQuery[i][1] = -1; }
			if (r > 118) { numberQuery[i][1] = -1; }
			
			nameQuery[i][0] = r;
			nameQuery[i][1] = tbl.name(r);
			
			weightQuery[i][0] = r;
			weightQuery[i][1] = tbl.weight(r);
		}
		
		
	}

	// specialized for this output.
	public static void output (String header, String contents) {
		System.out.println (header);
		System.out.println (contents);
	}
	
	// helper method
	private static void numberQueries() {
		TrialSuite suite = new TrialSuite();
		for (int t = 0; t < NUM_TRIALS; t++) {

			System.gc();
			long addS = System.currentTimeMillis();
			for (int s= 0; s < TRIAL_SIZE; s++) {
				for (int i = 0; i < numberQuery.length; i++) {
					int ne = q.number((String)numberQuery[i][0]);
					int nq = ((Integer)numberQuery[i][1]).intValue();
					assert (ne == nq);
				}
			}
			long addE = System.currentTimeMillis();			
			suite.addTrial(TRIAL_SIZE, addS, addE);
		}

		output ("Number " + q, suite.computeTable());
	}
	
	// helper method
	private static void weightQueries() {
		TrialSuite suite = new TrialSuite();
		for (int t = 0; t < NUM_TRIALS; t++) {

			float results[] = new float[TRIAL_SIZE];
			System.gc();
			long addS = System.currentTimeMillis();
			for (int s = 0; s < TRIAL_SIZE; s++) {
				for (int i = 0; i < weightQuery.length; i++) {
					results[i] = q.weight((Integer)weightQuery[i][0]);
				}
			}
			long addE = System.currentTimeMillis();
			suite.addTrial(TRIAL_SIZE, addS, addE);
			
			for (int i = 0; i < weightQuery.length; i++) {
				assert((Float)(weightQuery[i][1]) == results[i]);
			}
		}

		output ("Weight " + q, suite.computeTable());
	}

	// helper method
	private static void nameQueries() {
		TrialSuite suite = new TrialSuite();
		for (int t = 0; t < NUM_TRIALS; t++) {
			
			String results[] = new String[TRIAL_SIZE];
			System.gc();
			long addS = System.currentTimeMillis();
			for (int s = 0; s < TRIAL_SIZE; s++) {
				for (int i = 0; i < nameQuery.length; i++) {
					results[i] = q.name((Integer)nameQuery[i][0]);
				}
			}
			long addE = System.currentTimeMillis();
			suite.addTrial(TRIAL_SIZE, addS, addE);
			
			for (int i = 0; i < nameQuery.length; i++) {
				assert (nameQuery[i][1].equals(results[i]));
			}
		}

		output ("Name " + q, suite.computeTable());

	}
	
	public static void testEncodingOneQueries( )  {
		q = new EncodingOne();
		numberQueries();
		weightQueries();
		nameQueries();
	}
	
	public static void testEncodingTwoQueries() {
		q = new EncodingTwo();
		numberQueries();
		weightQueries();
		nameQueries();
	}
	
	public static void main (String []args) {
		setup();
		testEncodingOneQueries();
		testEncodingTwoQueries();
		
	}
	
	
}
