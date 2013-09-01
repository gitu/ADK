package algs.model.tests.convexhull;

import junit.framework.TestCase;

import org.junit.Test;

import algs.model.IPoint;
import algs.model.data.Generator;
import algs.model.data.points.UniformGenerator;
import algs.model.problems.convexhull.AklToussaint;
import algs.model.problems.convexhull.andrew.ConvexHullScan;
import algs.model.problems.convexhull.balanced.BalancedTreeAndrew;
import algs.model.problems.convexhull.bucket.BucketAndrew;
import algs.model.problems.convexhull.heap.HeapAndrew;

/**
 * note that SlowHull still may return different hull points because of the
 * errors inherent in floating point computations. For this reason, SlowHull
 * is not considered in this test case.
 *  
 */
public class HullComparisonsTest extends TestCase {

	@Test
	public void testSizeOfRandomHull() {
		Generator<IPoint> g = new UniformGenerator();

		int n = 75;
		for (int t = 0; t < 5; t++) {
			IPoint[] max = g.generate(n);

			IPoint[] hull = new ConvexHullScan().compute(max);

			// Compute Andrew scan with heuristic
			IPoint[] points = AklToussaint.reduce(max);
			IPoint[] hullRegular = new ConvexHullScan().compute(points);

			points = AklToussaint.reduce(max);
			IPoint hullBalanced[]= new BalancedTreeAndrew().compute(points);

			points = AklToussaint.reduce(max);
			IPoint hullHeap[]= new HeapAndrew().compute(points);
			
			// Fast enough that it could compare favorably w/ AKL
			points = AklToussaint.reduce(max);
			IPoint hullBucket[]= new BucketAndrew().compute(points);

			assertEquals(hull.length, hullRegular.length);
			assertEquals(hull.length, hullBucket.length);
			assertEquals(hull.length, hullBalanced.length);
			assertEquals(hull.length, hullHeap.length);

			// point for point. 
			for (int i = 0; i < hull.length; i++) {
				assertEquals (hull[i], hullRegular[i]);
				assertEquals (hull[i], hullBucket[i]);
				assertEquals (hull[i], hullBalanced[i]);
				assertEquals (hull[i], hullHeap[i]);
			}
		}
	}
}
