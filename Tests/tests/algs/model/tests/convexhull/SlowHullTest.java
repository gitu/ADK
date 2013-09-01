package algs.model.tests.convexhull;

import org.junit.Test;

import algs.model.IPoint;
import algs.model.problems.convexhull.slowhull.SlowHull;
import algs.model.twod.TwoDPoint;

import junit.framework.TestCase;

public class SlowHullTest extends TestCase {

	@Test
	public void testSlowHull() {
		
		IPoint[] points = new TwoDPoint[]{
				new TwoDPoint(10, 10),
				new TwoDPoint(10, 40),
				new TwoDPoint(10, 30),
				new TwoDPoint(10, 20),
		};
		
		IPoint hull[]= new SlowHull().compute(points);
		assertEquals (2, hull.length);
		assertEquals (new TwoDPoint(10,10), hull[0]);
		assertEquals (new TwoDPoint(10,40), hull[1]);
	}
}
