package algs.model.performance.segments;

import java.util.Hashtable;
import java.util.Iterator;

import org.junit.Test;

import algs.model.ILineSegment;
import algs.model.IPoint;
import algs.model.data.segments.GridGenerator;
import algs.model.data.segments.HubGenerator;
import algs.model.data.segments.SlidingLadderGenerator;
import algs.model.problems.segmentIntersection.LineSweep;
import algs.model.twod.TwoDPoint;

import junit.framework.TestCase;

public class MaximumIntersectionsTest extends TestCase {

	/** Grid test. */
	@Test
	public void testGrid() {
		LineSweep dba = new LineSweep();
		
		GridGenerator gg = new GridGenerator(20, 0);
		
		// standard intersection..
		ILineSegment[] segments = gg.generate(20);
		
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		int n = segments.length;
		assertEquals ((n*n)/4, res.size());
	}
	
	/** Grid test with skew. */
	@Test
	public void testGridWithSkew() {
		LineSweep dba = new LineSweep();
		
		GridGenerator gg = new GridGenerator(200, 17);
		
		// standard intersection..
		ILineSegment[] segments = gg.generate(20);
		
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		int n = segments.length;
		assertEquals ((n*n)/4, res.size());
	}
	
	/** Sliding ladder example. */
	@Test
	public void testSlidingLadder() {
		LineSweep dba = new LineSweep();
	
		SlidingLadderGenerator hg = new SlidingLadderGenerator(50);
		ILineSegment[] segments = hg.generate(100);
		
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		//dba.output(res);
		
		int n = segments.length;
		assertEquals ((n*(n-1))/2, res.size());
	}
	
	/** The hub test. */
	@Test
	public void testHubIntersection() {
		LineSweep dba = new LineSweep();
		
		HubGenerator hg = new HubGenerator(50, 0, 0);
		ILineSegment[] segments = hg.generate(100);
		
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		//dba.output(res);
		
		assertEquals (1, res.size());
		
		Iterator<IPoint> pts = res.keySet().iterator();
		assertTrue (pts.hasNext());
		IPoint pt = pts.next();
		assertFalse (pts.hasNext());
		assertEquals (new TwoDPoint(0,0), pt);
		
		assertEquals (segments.length, res.get(pt).length);
	}
}
