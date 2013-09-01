package algs.model.tests.interval;

import algs.model.interval.IConstructor;
import algs.model.interval.SegmentTreeNode;

public class SpecialSegmentTreeNode extends SegmentTreeNode {
	
	/** Store String. */
	String lowValue;
	
	/** Store another thing for testing. */
	String highValue;

	/** Constructor for this node. */
	public static IConstructor constructor = new IConstructor() {

		public SegmentTreeNode construct(int left, int right) {
			return new SpecialSegmentTreeNode (left, right);
		}
	};
	
	/**
	 * Store additional information as a test.
	 * 
	 * @param left
	 * @param right
	 */
	SpecialSegmentTreeNode(int left, int right) {
		super(left, right);
	}

	void setLow(String low) { this.lowValue = low; }
	void setHigh(String high) { this.highValue = high; }
	
	/**
	 * Reasonable extension to toString() method.
	 */
	public String toString () {
		return super.toString() + "<" + lowValue + ":" + highValue + ">";
	}
	
}
