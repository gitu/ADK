package algs.model.tests.convexhull;

import org.junit.Test;

import algs.model.IPoint;
import algs.model.problems.convexhull.andrew.ConvexHullScan;
import algs.model.problems.convexhull.slowhull.SlowHull;
import algs.model.twod.TwoDPoint;

import junit.framework.TestCase;

/**
 * This example shows the ways floating point arithmetic causes headaches.
 * Note that points P3 and P4 below are not that close; however, the line  
 * formed by <P1,P2,P3> is a LEFT turn, which means that point P2 is removed
 * from consideration by Andrew's ConvexHull Scan. But now consider the line
 * <P1,P3,P4>. This is nearly a straight line! In fact, the computed cross
 * product is .00006215 which is >= 0 so this is not a right turn, so P3 is
 * removed from consideration. 
 * 
 * However, when computing the convext hull by Slow algorithm, the point P4 
 * is determined to be wholly contained within the triangle defined by points 
 * P1,P2,P3! It is a tight fit, since the computation calls for two values to 
 * be both greater or equal to zero. When computed, these values are:
 * 
 *  4.687570621247088E-9,-1.9640539647210799E-10
 * 
 * Using a floating point epsilon value of E-9, these are both greater than
 * zero, which incorrectly leads the SlowHull algorithm to consider P4 to be 
 * within the triangle and it is removed. 
 * 
 * @author George Heineman
 */
public class InterestingCaseTest extends TestCase {
	
	@Test
	public void testSmallExample() {
		IPoint [] max = new IPoint[]{
		new TwoDPoint(0.14925962165638917,0.6616295921315086), /* P1 */
		new TwoDPoint(0.3256217016924098,0.7009014640090285),  /* P2 */
		new TwoDPoint(0.5431702794298991,0.7574216115533707),  /* P3 */
		new TwoDPoint(0.5517890971243146,0.7596753459967382),  /* P4 */
		new TwoDPoint(0.8596427286829814,0.29024455131525284)
		};

		// Compute Andrew scan with heuristic
		IPoint[] hullRegular = new ConvexHullScan().compute(max);

		IPoint hullSlow[]= new SlowHull().compute(max);
		for (int i = 0; i < max.length; i++) {
			System.out.println(max[i]);
		}
		
		// this gives different results... Using the convex hull technique, there
		// is one more point on the hull. To see how this happens
		assertEquals (hullRegular.length - 1, hullSlow.length);
	}

}
