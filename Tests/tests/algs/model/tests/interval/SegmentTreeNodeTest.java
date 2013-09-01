package algs.model.tests.interval;

import org.junit.Test;

import algs.model.IInterval;
import algs.model.interval.DiscreteInterval;
import algs.model.interval.IConstructor;
import algs.model.interval.SegmentTree;
import algs.model.interval.SegmentTreeNode;

import junit.framework.TestCase;


@SuppressWarnings("unchecked")
public class SegmentTreeNodeTest extends TestCase {

	@Test
	public void testContains() {
		SegmentTree st = new SegmentTree(1,15);
		assertFalse (st.isEmpty());
		
		// test contains operates not on the intervals in the tree but the
		// nodes themselves. [14,15) is in the tree; so is [1,15), but [2,15) isn't
		assertTrue (st.contains (new DiscreteInterval(14,15)));
		assertTrue (st.contains (new DiscreteInterval(1,15)));
		assertFalse (st.contains (new DiscreteInterval(2,15)));		
	}
	
	@Test
	public void testDefault() {
		SegmentTree st = new SegmentTree(1,15);
		assertFalse (st.isEmpty());
		
		st.add(new DiscreteInterval(8,13));
		st.add(new DiscreteInterval(4,10));

		//test remove
		st.remove(new DiscreteInterval(4,13));

	}
	
	@Test
	public void testRanges() {
		SegmentTree st = new SegmentTree(1,15);
		SegmentTreeNode root = st.getRoot();
		assertEquals (0, root.getCount());
		SegmentTreeNode expected = st.getConstructor().construct(1, 15);
		assertEquals (expected.getLeft(), root.getLeft());
		assertEquals (expected.getRight(), root.getRight());
		DiscreteInterval di = new DiscreteInterval(4,8);
		st.add(di);
		assertEquals (0, root.getCount());
		
		SegmentTreeNode tgt = root.getNode(4);
		assertEquals (0, tgt.getCount());
		assertEquals (4, tgt.getLeft());
		assertEquals (5, tgt.getRight());
		
		SegmentTreeNode left = root.getLeftSon();
		assertEquals (1, left.getLeft());
		assertEquals (8, left.getRight());
		
		tgt = left.getNode(6);
		assertEquals (6, tgt.getLeft());
		assertEquals (7, tgt.getRight());
		
		SegmentTreeNode right = left.getRightSon();
		assertEquals (4, right.getLeft());
		assertEquals (8, right.getRight());
		assertEquals (1, right.getCount());   // Here is where edge was added.		
	}
	
	@Test
	public void testSimple () {
		SegmentTree st = new SegmentTree(1,15);
		IConstructor cons = st.getConstructor();
		
		SegmentTreeNode stn = cons.construct(10, 20);
		
		assertEquals (10, stn.getLeft());
		assertEquals (20, stn.getRight());
		
		assertTrue (stn.getLeftSon() == null);
		assertTrue (stn.getRightSon() == null);
		
		assertTrue (stn.toTheLeft(5));
		assertTrue (stn.intersects(15));
		assertTrue (stn.toTheRight(30));
		
		// invariants.
		assertFalse (stn.toTheLeft(stn.getLeft()));
		assertTrue (stn.toTheRight(stn.getRight()));
		assertTrue (stn.intersects(stn.getLeft()));
		
		assertTrue (stn.equals(stn));
		assertTrue (stn.equals(new DiscreteInterval(10,20)));
	}
	
	/**
	 * This test ensures that SegmentTree node performs rudimentary checks on the
	 * IInterval structure.
	 */
	public void testBadIInterval() {
		SegmentTree st = new SegmentTree(1,15);
		IConstructor cons = st.getConstructor();
		
		SegmentTreeNode stn = cons.construct(10, 20);
		
		try {
			stn.checkInterval(new IInterval() {
	
				// BAD because LEFT is greater than RIGHT
				public int getLeft() { return 30; }
				public int getRight() {	return 0; }

				// NO meaningful implementations
				public boolean intersects(int q) {	return false; }
				public boolean equals(Object o) {
					if (o == null) { return false; }
					if (o instanceof IInterval) {
						IInterval i = (IInterval) o;
						return getLeft() == i.getLeft() && getRight() == i.getRight();
					}
					return false; 
				}
				public boolean toTheLeft(int q) { return false;	}
				public boolean toTheRight(int q) { return false; }
			});
			fail ("Not proper checks for SegmentTreeNode");
		} catch (IllegalArgumentException iae) {
			
		}
	}
}
