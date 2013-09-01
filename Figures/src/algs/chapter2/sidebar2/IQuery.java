package algs.chapter2.sidebar2;

/**
 * Standard set of queries over the encodings.
 * 
 * @author George Heineman
 * @version 1.0, 7/17/08
 * @since 1.0
 */
public interface IQuery {
	
	// What is the atomic weight of element number N? If invalid, return -1
	public float weight (int n );
	
	// What is the atomic number of element named X? If invalid, return -1
	public int number (String s);
	
	// What is the name of element number N? If invalid, return null
	public String name (int n);
}
