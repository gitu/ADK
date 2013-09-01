package algs.model.tests.segments;


import java.util.Hashtable;

import junit.framework.TestCase;

import org.junit.Test;

import algs.model.ILineSegment;
import algs.model.IPoint;
import algs.model.problems.segmentIntersection.BruteForceAlgorithm;
import algs.model.problems.segmentIntersection.IntersectionDetection;
import algs.model.problems.segmentIntersection.LineSweep;
import algs.model.twod.TwoDLineSegment;
import algs.model.twod.TwoDPoint;

/** 
 * Test sample use of line segments.
 * 
 * @author George Heineman
 */
public class InterestingFailureCaseTest extends TestCase {
	
	/**
	 * Zero-length segments? Note that the intersection point will 
	 * be reported multiple times (once for the start of the line segment
	 * and once for the end of the line segment)
	 */
	public void testZeroLength() {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[] {
				new TwoDLineSegment (0, 0, 5, 5),
				new TwoDLineSegment (2, 2, 2, 2)
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (1, res.size());
		
		
	}
	
	/**
	 * Collinear points shouldn't cause problems.
	 */
	public void testCollinear() {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[] {
				new TwoDLineSegment (0, 0, 5, 5),
				new TwoDLineSegment (2, 2, 10, 10)
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (2, res.size());
		
		
	}
	
	/**
	 * Horizontal edges cause PROBLEMS!
	 */
	public void testHorizontal2() {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[]{
				new TwoDLineSegment(new TwoDPoint(2,20),new TwoDPoint(5,17)),
				new TwoDLineSegment(new TwoDPoint(0,18),new TwoDPoint(6,18)),
				new TwoDLineSegment(new TwoDPoint(6, 3),new TwoDPoint(8,4)),
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (1, res.size());
	}
	
	/**
	 * Horizontal edges cause PROBLEMS!
	 */
	public void testHorizontal() {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[]{
				new TwoDLineSegment(new TwoDPoint(10,10),new TwoDPoint(20,10)),
				new TwoDLineSegment(new TwoDPoint(15,20),new TwoDPoint(17,3)),
				new TwoDLineSegment(new TwoDPoint(6, 12),new TwoDPoint(12,7)),
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (1, res.size());
	}
	
	/**
	 * Small enough to avoid many intersections
	 */
	@Test
	public void testAnotherBadOne () {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[]{
				new TwoDLineSegment(new TwoDPoint(1.461506443083405,0.9847945488564088), new TwoDPoint(0.5693889367480982,0.6198415086510745)),
				new TwoDLineSegment(new TwoDPoint(0.979994927758071,0.03463813282543149), new TwoDPoint(1.6392250880036716,-0.7124228424528021 )),
				new TwoDLineSegment(new TwoDPoint(0.602460184866246,0.6739281946780163), new TwoDPoint(1.4223450237286137,0.2344020791182252)),
		};
		 
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (1, res.size());
		
	}
	
	
	/**
	 * Small enough to avoid many intersections
	 */
	@Test
	public void testStructure () {
		LineSweep dba = new LineSweep();
		
		
		// showed a problem
		ILineSegment[] segments = new ILineSegment[]{
				new TwoDLineSegment(new TwoDPoint(112,101), new TwoDPoint(13,91)),
				new TwoDLineSegment(new TwoDPoint(142,138), new TwoDPoint(71,57)),
				new TwoDLineSegment(new TwoDPoint(173,119), new TwoDPoint(78,83)),

				//				new TwoDLineSegment(new TwoDPoint(1.129938061390374,1.0183184263291296), new TwoDPoint(0.1384920933184508,0.9187394179920665)),
//				new TwoDLineSegment(new TwoDPoint(1.4210335947362847,1.380527755666979), new TwoDPoint(0.7143697503374674,0.5752451090756914)),
//				new TwoDLineSegment(new TwoDPoint(1.7385005602922057,1.1960079567374702), new TwoDPoint(0.7864088447098906,0.8351516393087302)),
		};
		
		Hashtable<IPoint, ILineSegment[]> res = null;
		try {
			res = dba.intersections(segments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (IPoint ip : res.keySet()) {
			ILineSegment[] ilss = res.get(ip);
			System.out.println (ip);
			for (ILineSegment ils : ilss) {
				System.out.println ("  " + ils);
			}
			System.out.println();
		}
		
		assertEquals (2, res.size());
		
	}

	// detected when three way-intersections caused duplicate reporting...
	@Test
	public void testDuplicateReporting() {
		LineSweep dba = new LineSweep();
		BruteForceAlgorithm dba3 = new BruteForceAlgorithm();

		// showed a problem
		ILineSegment[] segments = new ILineSegment[]{
				  new TwoDLineSegment(32.0,97.0,60.0,74.0),
				  new TwoDLineSegment(51.0,76.0,69.0,72.0),
				  new TwoDLineSegment(72.0,78.0,51.0,71.0),
				  new TwoDLineSegment(72.0,83.0,46.0,63.0),
		};
		
		Hashtable<IPoint, ILineSegment[]> res = dba.intersections(segments);
		Hashtable<IPoint, ILineSegment[]> res3 = dba3.intersections(segments);
		
		assertTrue (IntersectionDetection.sameWithinEpsilon(res, res3));
		
		assertEquals (res.size(), res3.size());  // 
	}
	
}
