package algs.model.performance.segments;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import algs.model.ILineSegment;
import algs.model.problems.segmentIntersection.IntersectionDetection;
import algs.model.problems.segmentIntersection.LineSweep;
import algs.model.twod.TwoDLineSegment;

/** Use this to load up a file containing LineSegment information .*/
public class BadTrialMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<ILineSegment> ar = new ArrayList<ILineSegment>();
		Scanner sc = new Scanner (new File("BadRun.txt"));
		while (sc.hasNextLine()) {
			// <252.11185971061548,16.49066282716644,249.59081290113116,11.046002784116094>
			String s = sc.nextLine();
			s = s.substring(1,s.length()-1);
			StringTokenizer st = new StringTokenizer(s, ",");
			double d1 = Double.valueOf(st.nextToken());
			double d2 = Double.valueOf(st.nextToken());
			double d3 = Double.valueOf(st.nextToken());
			double d4 = Double.valueOf(st.nextToken());
			
			ar.add(new TwoDLineSegment (d1,d2,d3,d4));
		}
		
		ILineSegment[] segments = ar.toArray(new ILineSegment[]{});
		IntersectionDetection alg1 = new LineSweep();
		/* Hashtable<IPoint,ILineSegment[]> res1 = */ alg1.intersections(segments);
		
		System.out.println("DONE");

	}

}
