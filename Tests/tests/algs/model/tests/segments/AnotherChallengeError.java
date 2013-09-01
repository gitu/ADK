package algs.model.tests.segments;


import java.util.Hashtable;

import junit.framework.TestCase;

import algs.model.ILineSegment;
import algs.model.IPoint;
import algs.model.problems.segmentIntersection.LineSweep;
import algs.model.twod.TwoDLineSegment;

/** 
 * Test sample use of line segments.
 * 
 * @author George Heineman
 */
public class AnotherChallengeError extends TestCase {
	
	/**
	 * Zero-length segments? Note that the intersection point will 
	 * be reported multiple times (once for the start of the line segment
	 * and once for the end of the line segment)
	 * 
	 * This should FAIL in JUnit because of the unexpected issues with
	 * floating point computations.
	 */
	public void testBizarreCaseError() {
		LineSweep dba = new LineSweep();
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[] {
				new TwoDLineSegment(659.0,3364.0,659.0,3364.0),
				new TwoDLineSegment(659.0,2202.0,660.0,2202.0),
				new TwoDLineSegment(1225.0,1020.0,1226.0,1019.0) 
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		// for coverage purposes.
		dba.output(res);
		
		// causes failure. Lesson is to be VERY WARY of zero-length line segments. 
		// Sometimes they don't cause problems; but in some circumstances they wreak
		// unholy havoc on the code. Lesson is to avoid them altogether.
		assertEquals (0, res.size());
	}
}
