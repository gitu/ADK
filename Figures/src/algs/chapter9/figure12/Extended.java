package algs.chapter9.figure12;

import java.util.Arrays;

import algs.model.IPoint;
import algs.model.data.Generator;
import algs.model.data.points.*;
import algs.model.heap.HeapSort;
import algs.model.problems.convexhull.IConvexHull;
import algs.model.problems.convexhull.andrew.ConvexHullScan;
import algs.model.problems.convexhull.balanced.BalancedTreeAndrew;
import algs.model.problems.convexhull.bucket.BucketAndrew;
import algs.model.problems.convexhull.heap.HeapAndrew;
import algs.model.tests.common.TrialSuite;

/**
 * Show what happens to BucketSort on SMALL data sets.
 *  
 * @author George Heineman
 */
public class Extended {
	
	
	@SuppressWarnings("unchecked")
	public static void main (String []args) {

		// to avoid floating point issues with very large sets, we use a
		// large circle generator.
		Generator<IPoint> generator[] = new Generator[3]; 
		generator[0] = new SliceGenerator();
		generator[1] = new UniformGenerator();
		generator[2] = new CircleGenerator(1000);
		int NUM_TRIALS = 100;
		
		System.out.println ("Trials with " + generator);
		for (int g = 0; g < generator.length; g++) {
			System.out.println ("Generator:" + generator[g] + "\n");
			System.out.println ("-----------------------------------------");
			int n = 2048;
			
			TrialSuite sorting = new TrialSuite();
			TrialSuite andrew = new TrialSuite();
			TrialSuite heap   = new TrialSuite();
			TrialSuite balanced = new TrialSuite();
			TrialSuite buckets = new TrialSuite();
			
			IConvexHull convexHullScan = new ConvexHullScan();
			IConvexHull heapConvexHull = new HeapAndrew();
			IConvexHull bucketConvexHull = new BucketAndrew();
			IConvexHull balancedConvexHull = new BalancedTreeAndrew();
			for (int i = 1; i < 6; i++) {
				IPoint []points = generator[g].generate(n);
			
				System.out.println ("\n" + i + "...");
			
				System.gc();  // prepare
				for (int t = 0; t < NUM_TRIALS; t++) {
					// copies on which to process
					IPoint[] points1 = Arrays.copyOf(points, points.length);
					IPoint[] points2 = Arrays.copyOf(points, points.length);
					IPoint[] points3 = Arrays.copyOf(points, points.length);
					IPoint[] points4 = Arrays.copyOf(points, points.length);
					IPoint[] points5 = Arrays.copyOf(points, points.length);
					
					System.out.print(".");
					System.gc();
					long now = System.currentTimeMillis();
					IPoint[] hulls0 = convexHullScan.compute(points1);
					long now2 = System.currentTimeMillis();
					andrew.addTrial(n, now, now2);
					
					System.gc();
					now = System.currentTimeMillis();
					IPoint[] hulls1 = heapConvexHull.compute(points2);
					now2 = System.currentTimeMillis();
					heap.addTrial(n, now, now2);
					
					System.gc();
					now = System.currentTimeMillis();
					IPoint[] hulls2 = balancedConvexHull.compute(points3);
					now2 = System.currentTimeMillis();
					balanced.addTrial(n, now, now2);

					System.gc();
					now = System.currentTimeMillis();
					IPoint[] hulls3 = bucketConvexHull.compute(points4);
					now2 = System.currentTimeMillis();
					buckets.addTrial(n, now, now2);

					System.gc();
					now = System.currentTimeMillis();
					new HeapSort<IPoint>().sort(points5, 0, n-1, IPoint.xy_sorter);
					now2 = System.currentTimeMillis();
					sorting.addTrial(n, now, now2);

					if (hulls0.length != hulls1.length || hulls0.length != hulls2.length) {
						System.err.println ("FAILED with different sizes");
					} 
					
					// assert all arrays are the same.
					new HeapSort<IPoint>().sort(hulls0, 0, hulls0.length-1, IPoint.xy_sorter);
					new HeapSort<IPoint>().sort(hulls1, 0, hulls1.length-1, IPoint.xy_sorter);
					new HeapSort<IPoint>().sort(hulls2, 0, hulls2.length-1, IPoint.xy_sorter);
					new HeapSort<IPoint>().sort(hulls3, 0, hulls3.length-1, IPoint.xy_sorter);
					
					for (int h = 0; h < hulls0.length; h++) {
						if (!hulls0[h].equals(hulls1[h])) {
							System.err.println ("FAILED with different points:" + hulls0[h] + "," + hulls1[h]);
							outputDiff(hulls0,hulls1);
						}
						if (!hulls0[h].equals(hulls2[h])) {
							System.err.println ("FAILED with different points:" + hulls0[h] + "," + hulls2[h]);
							outputDiff(hulls0,hulls2);
						}
						if (!hulls0[h].equals(hulls3[h])) {
							System.err.println ("FAILED with different points:" + hulls0[h] + "," + hulls3[h]);
							outputDiff(hulls0,hulls3);
						}
					}
				}
				
				n /= 2; // continue!
			}

			System.out.println ("Andrew");
			System.out.println (andrew.computeTable());
			
			System.out.println ("Heap");
			System.out.println (heap.computeTable());
			
			System.out.println ("Balanced");
			System.out.println (balanced.computeTable());
		
			System.out.println ("Bucket");
			System.out.println (buckets.computeTable());
					
			System.out.println ("Sorting only");
			System.out.println (sorting.computeTable());
		}
	}

	private static void outputDiff(IPoint[] hulls0, IPoint[] hulls1) {
		for (int i = 0; i < hulls0.length; i++) {
			if (hulls0[i].equals(hulls1[i])) { continue; }
			
			System.out.println (i + ". "+ hulls0[i] + " : " + hulls1[i] + " **");
		}
		System.exit(2);
	}
}
