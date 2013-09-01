package algs.model.tests.eightpuzzle;

import org.junit.Test;

import algs.model.problems.eightpuzzle.BadEvaluator;
import algs.model.problems.eightpuzzle.EightPuzzleNode;
import algs.model.problems.eightpuzzle.GoodEvaluator;
import algs.model.problems.eightpuzzle.WeakEvaluator;

import junit.framework.TestCase;

public class EvaluationTest extends TestCase {

	@Test
	public void testGoodEvaluator() {
		EightPuzzleNode state = new EightPuzzleNode(new int[][]{
				{8,1,3},{0,2,4},{7,6,5}
		});
		
		EightPuzzleNode two = new EightPuzzleNode(new int[][]{
				{0,1,3},{8,2,4},{7,6,5}
		});
		GoodEvaluator eval = new GoodEvaluator();
		BadEvaluator bad = new BadEvaluator();
		WeakEvaluator weak = new WeakEvaluator();
		
		int rc;
		
		rc = eval.eval(state);
		assertEquals (18, rc);
		rc = bad.eval(state);
		assertEquals (14, rc);
		rc = weak.eval(state);
		assertEquals (3, rc);
		
		rc = eval.eval(two);
		assertEquals (17, rc);
		rc = bad.eval(two);
		assertEquals (2, rc);
		rc = weak.eval(two);
		assertEquals (2, rc);

		
		
	}
}
