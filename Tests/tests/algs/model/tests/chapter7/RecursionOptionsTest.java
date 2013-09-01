package algs.model.tests.chapter7;



import java.util.ArrayList;

import junit.framework.TestCase;
import algs.model.IMultiPoint;
import algs.model.IPoint;
import algs.model.data.points.CircleGenerator;
import algs.model.kdtree.KDFactory;
import algs.model.kdtree.KDTree;
import algs.model.kdtree.TwoDFactory;
import algs.model.kdtree.TwoDNode;
import algs.model.kdtree.TwoDTraversal;
import algs.model.kdtree.TwoDTree;
import algs.model.nd.Hypercube;
import algs.model.twod.TwoDPoint;
import algs.model.twod.TwoDRectangle;

public class RecursionOptionsTest extends TestCase {

// for generateUniqueRandom with 50 trials, got this...	
//	
//	2,49,0
//	4,100,50
//	8,100,0
//	16,150,0
//	32,200,0
//	64,250,0
//	128,300,100
//	256,300,50
//	512,400,0
//	1024,550,100
//	2048,500,50
//	4096,550,50
//	8192,650,100
//	16384,650,0
//	32768,700,0
//	65536,750,50
//	131072,800,0
//	262144,850,0

	
	public void testRecursion() {
		for (int n = 2; n < 32768; n*= 2) {
			
			CircleGenerator cg = new CircleGenerator(1);
			assertTrue (cg.parameters() != null);
			cg = (CircleGenerator) cg.construct(new String[]{"1"});
			
			IPoint[] points = cg.generate(n);
			KDTree tree = KDFactory.generate(points);
	
			// now run a series of queries.
			int numTrials = 50;
			int totalDR = 0;
			int totalR  = 0;
			for (int j = 0; j < numTrials; j++) {
				TwoDPoint tp = new TwoDPoint(Math.random(), Math.random());
				tree.nearest(tp);
				totalDR += tree.getNumDoubleRecursion();
				totalR  += tree.getNumRecursion();				
			}
			
			System.out.println (n + "," + totalR + "," + totalDR);
		}
	}
	
	public void testCompatibility() {
		int square = 10;
		IPoint[] points = new IPoint[] {
				new TwoDPoint(0,0),
				new TwoDPoint(-10,3),
				new TwoDPoint (-7, -5),
				new TwoDPoint (-5, -9),
				new TwoDPoint (3, -4),
				new TwoDPoint (6, 3),
				new TwoDPoint (9, 12),
		};
		
		KDTree tree = KDFactory.generate(points);
		TwoDTree tree2D = TwoDFactory.generate(points);

		ArrayList<IPoint> res2D = tree2D.search(new TwoDRectangle(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY,
				Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
		ArrayList<IMultiPoint> res = tree.search(new Hypercube(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY,
				Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));
		assertEquals (res2D.size(), res.size());
		
		// minor things
		assertTrue (tree2D.toString() != null);
		assertTrue (tree.toString() != null);
		assertTrue (tree.nearest(null) == null);
		assertTrue (tree2D.nearest(null) == null);
		
		// now run a series of queries.
		int numTrials = 200;
		for (int j = 0; j < numTrials; j++) {
			TwoDPoint tp = new TwoDPoint(Math.random()*square, Math.random()*square);
			IMultiPoint s = tree.nearest(tp);
			IPoint p2 = tree2D.nearest(tp);
			
			assertEquals (s, p2);
		}
		
		// show traversal.
		
		// deal with traversal.
		final StringBuffer sb = new StringBuffer();
		TwoDTraversal tdt = new TwoDTraversal(tree2D) {
			public void visit(TwoDNode node) { sb.append("*"); }
		};
		tdt.traverse();
		assertEquals ("*******", sb.toString());

	}
	
}