package algs.chapter9.table4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;

import algs.model.ILineSegment;
import algs.model.IPoint;
import algs.model.data.Generator;
import algs.model.tests.common.TrialSuite;
import algs.model.twod.TwoDPoint;
import algs.model.twod.TwoDLineSegment;
import algs.model.data.segments.DoubleGenerator;
import algs.model.problems.segmentIntersection.BruteForceAlgorithm;
import algs.model.problems.segmentIntersection.LineSweep;
import algs.model.problems.segmentIntersection.IntersectionDetection;

/**
 * This class determines whether BruteForce beats LineSweep by running 
 * sample computations that involve line segment intersections.
 * <p>
 * <a href="http://mathworld.wolfram.com/BuffonsNeedleProblem.html">Count Buffon's problem</a>
 * shows how to compute the value of PI. You are given an infinite set of toothpicks 
 * of length <code>len</code> and a paper with <code>n</code> vertical lines drawn 
 * on a grid at <code>y=d</code>, <code>2*d</code>, etc...
 * <p>
 * Randomly drop the toothpicks on the paper such that you are guaranteed that the
 * toothpicks land in the upper right quadrant x range: [0, max] and y range [0,max].
 * Now, count the number of intersections with the horizontal segments.
 * <p>
 * By framing the question in this way, we have:
 * <ul>
 * <li>toothpick length --           len
 * <li>line separation  --           d
 * <li>number of toothpicks --       n
 * <li>number of intersections --    K
 * </ul>
 * Now, <code>K/n = 2*len/PI*d</code> which means that <code>PI = 2*len*n/d*K</code>
 * <p>
 * We must be careful to only consider intersections with the two horizontal lines, rather
 * than the other toothpicks. To reduce the 'noise' we choose len << d so the only 
 * intersections are likely to be with lines.  
 * <p>
 * A useful paper on line segment intersection is:
 * <ul><li>
 * Gavrilova, M. and Rokne, J. (2000) "Reliable line segment intersection testing," 
 * Journal of Computer Aided Design, Elsevier, vol. 32, pp. 737-745.
 * http://www.cpsc.ucalgary.ca/~marina/papers/Segment_intersection.ps
 * </li></ul>
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class Extended {
	
	/**
	 * Compute result and output table to the screen.
	 * <p>
	 * If error fails for any reason, a file "ErrorRun.txt" is created.
	 *  
	 * @param args
	 * @throws Exception
	 */
	public static void main (String []args) throws FileNotFoundException {
		IntersectionDetection alg1 = new LineSweep();
		IntersectionDetection alg2 = new BruteForceAlgorithm();
		
		int len = 6; 
		int d = 60;
		int max = 600;  // ten lines.
		int numVertical = max/d;
		int NUM_TRIALS = 100;
		int max_N = 8192;
		
		TrialSuite lineSweep_ts = new TrialSuite();
		TrialSuite bf_ts = new TrialSuite();
		
		boolean printedAlready = false;
		
		System.out.println("n,numIntersections,numWithVertical,Estimate of PI,LineSweepTime,BruteForceTime");
		for (int n = 16; n <= max_N; n *= 2) {
			int totalInts = 0;
			int totalSegInts = 0;
			
			for (int t = 0; t < NUM_TRIALS; t++) {
				Generator<ILineSegment> generator = new DoubleGenerator(max, len);
				ILineSegment[] ils = generator.generate(n+numVertical);
				
				// put in verticals: Make sure they aren't flush left or right
				// so we don't have lines that can't be intersected with.
				for (int i = 0; i < numVertical; i++) {
					ils[n+i] = new TwoDLineSegment(new TwoDPoint(d/2+d*i, 0), new TwoDPoint(d/2+d*i, max));
				}
				
				try {
					Hashtable<IPoint,ILineSegment[]> res1 = alg1.intersections(ils);
					lineSweep_ts.addTrial(n, 0, alg1.time());
					/* Hashtable<IPoint,ILineSegment[]> res2 = */ alg2.intersections(ils);
					bf_ts.addTrial(n, 0, alg2.time());
					
					totalInts += res1.size();
					// compute which ones are between toothpicks and lines.
					for (IPoint pt: res1.keySet()) {
						// validate this is an intersection with vertical line segment.
						boolean isValid = false;
						ILineSegment[] lines = res1.get(pt);
						for (ILineSegment line : lines) {
							if (line.getStart().getY() - line.getEnd().getY() == max) {
								isValid = true;
								break;
							}
						}
			
						if (isValid) {
							totalSegInts += (lines.length-1); // don't add vertical line
						}
					}
				} catch (NullPointerException nfe) {
					System.out.println(n + "," + t + ",ERROR");
					if (!printedAlready) {
						printedAlready = true;
						System.out.println("canceled session for null pointer.");
						File f = new File ("ErrorRun.txt");
						PrintWriter pw = new PrintWriter (f);
								
						for (int i = 0; i < ils.length; i++) {
							pw.println(ils[i].toString());
						}
						
						pw.close();
					}
				}
			}
			
			double estimate = 2.0*len*n/(totalSegInts*d/NUM_TRIALS);
			double error = (Math.PI*Math.PI/(2*n))*(Math.PI*d/len-2);
			System.out.println(n + "," + totalInts*1.0/NUM_TRIALS + "," + totalSegInts*1.0/NUM_TRIALS + "," + estimate + ", +/- " + error);			
		}
		
		System.out.println("Line Sweep Stats");
		System.out.println(lineSweep_ts.computeTable());
		
		System.out.println("Brute Force Stats");
		System.out.println(bf_ts.computeTable());
		
	}
}
