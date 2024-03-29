package algs.chapter9.table8;


/**
 * Try to show O(n^(1-1/d)+r) behavior where n is the number of elements in the
 * kd-tree being searched for the range query and r is the number of found
 * points.
 * 
 * Test :
 * 
 * (c) RANGE with no points (or at least, will be a range == a single point)
 */
import java.util.Random;

import algs.model.IMultiPoint;
import algs.model.kdtree.DimensionalNode;
import algs.model.kdtree.IVisitKDNode;
import algs.model.kdtree.KDFactory;
import algs.model.kdtree.KDTree;
import algs.model.nd.Hypercube;
import algs.model.nd.Hyperpoint;
import algs.model.problems.rangeQuery.BruteForceRangeQuery;
import algs.model.tests.common.TrialSuite;

class Counter implements IVisitKDNode {
	int ct;
	int numDrained;

	@Override
	public void visit(DimensionalNode node) {
		ct++;					
	}
	@Override
	public void drain (DimensionalNode node) {
		ct++;
		numDrained++;
	}
}

public class Main {
	// random number generator.
	static Random rGen;

	/** 
	 * generate array of n d-dimensional points whose coordinates are
	 * values in the range 0 .. scale
	 */
	private static IMultiPoint[] randomPoints (int n, int d, int scale) {
		IMultiPoint points[] = new IMultiPoint[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < d; j++) {
				sb.append(rGen.nextDouble()*scale);
				if (j < d-1) { sb.append (","); }
			}
			points[i] = new Hyperpoint(sb.toString());
		}

		return points;
	}	



	public static void main (String []args) {
		rGen = new Random();
		rGen.setSeed(1);  // be consistent across platforms and runs.

		// dimension for points.
		int numSearches = 128;
		int NUM_TRIALS = 10;
		int maxN = 131072;
		int scale = 4000;

		for (int d = 2; d <= 5; d++) {
			System.out.println("Dimension: " + d);
			TrialSuite kdSearch3 = new TrialSuite();
			TrialSuite bfSearch3 = new TrialSuite();

			Counter kd_count = new Counter();
			Counter bf_count = new Counter();

			for (int n=4096; n <= maxN; n*=2) {
				System.out.println (n);
				for (int t = 1; t <= NUM_TRIALS; t++) {
					long now, done;

					// create n random points in d dimensions drawn from [0,1] uniformly
					IMultiPoint[] points = randomPoints (n, d, scale);

					// Perform a number of searches drawn from same [0,1] uniformly.
					System.gc();

					// This forms the basis for the kd-tree. These are the points p. Note
					// that the KDTree generate method will likely shuffle the points. 
					KDTree tree = KDFactory.generate(points);

					// space1: Entire tree
					double lows[] = new double[d], highs[] = new double[d];

					// empty: unlikely to find another random d-dimensional point.
					for (int k = 0; k < d; k++) {
						lows[k] = rGen.nextDouble();
						highs[k] = lows[k];
					}
					Hypercube space3 = new Hypercube (lows, highs);

					System.gc();
					now = System.currentTimeMillis();
					for (int ns = 0; ns < numSearches; ns++) {
						/* results3 = */ tree.search(space3, kd_count);
					}
					done = System.currentTimeMillis();
					kdSearch3.addTrial(n, now, done);

					BruteForceRangeQuery bfrq = new BruteForceRangeQuery(points);

					System.gc();
					now = System.currentTimeMillis();
					for (int ns = 0; ns < numSearches; ns++) {
						/* results3_bf = */ bfrq.search(space3, bf_count);
					}
					done = System.currentTimeMillis();
					bfSearch3.addTrial(n, now, done);

					// weak form of comparison
					if (kd_count.ct != bf_count.ct) {
						System.out.println("result1 fails");
					}
				}
			}

			System.out.println("KD-3 search info:" );
			System.out.println(kdSearch3.computeTable());

			System.out.println("BF-3 search info:" );
			System.out.println(bfSearch3.computeTable());
		}
	}
}
