package algs.example.gui.problems.rangeQuery.model;

import java.awt.*;

import algs.example.gui.problems.rangeQuery.ISelectable;
import algs.model.IMultiPoint;
import algs.model.IPoint;

/**
 * A bridge class that extends the standard java.awt.Point but
 * also implements IPoint.
 * 
 * In other words, it behaves as needed for the Java AWT, yet it 
 * also can be dropped into the algs.model data structures.
 * 
 * The primary extension for the rangeQuery problem is that a
 * point can be selected (needed to highlight on screen those
 * points that are indeed selected).
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class SelectablePoint extends Point implements IPoint, IMultiPoint, ISelectable {

	/**
	 * Generated Serializable ID
	 */
	private static final long serialVersionUID = -4189985580004417605L;
	
	/** Selected. */
	boolean isSelected;
	
	/** Is this a drained node. */
	int mark;
	
	/** Build a point from the details. */
	public SelectablePoint (int x, int y) {
		super (x,y);
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public String toString () {
		String sel = "";
		if (isSelected) sel = "*";
		return "(" + x + "," + y + ")" + sel;
	}

	/** Determine selectable status. */
	public void select(boolean flag) {
		isSelected = flag;
		if (!isSelected) { mark = 0; }
	}

	public int dimensionality() {
		return 2;
	}
	
	@Override
	public double[] raw() {
		return new double[] { x, y };
	}
	
	public double distance(IMultiPoint imp) {
		if (imp.dimensionality() != 2) {
			throw new IllegalArgumentException ("distance computation can only be performed between two-dimensional points");
		}
		
		double ox = imp.getCoordinate(1);
		double oy = imp.getCoordinate(2);
		
		return Math.sqrt((ox-x)*(ox-x) + (oy-y)*(oy-y));
	}

	public double getCoordinate(int dx) {
		if (dx == 1) { return x; } else { return y; }
	}
	
	@Override
	public void select(int mark) throws IllegalArgumentException {
		this.mark = mark;
	}	
	
	@Override
	public int getMark() {
		return mark;
	}
}
