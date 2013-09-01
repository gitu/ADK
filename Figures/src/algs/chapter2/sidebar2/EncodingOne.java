package algs.chapter2.sidebar2;

import java.io.*;
import java.util.Scanner;

/**
 * Represents the periodic table of elements.
 * 
 * @author George Heineman
 * @version 1.0, 7/17/08
 * @since 1.0
 */
public class EncodingOne implements IQuery {
	
	/** Max Number of Elements + 1. */
	static int numElements = 119;

	/** Array of elements. */
	static String[] elementName;
	
	static float[] elementWeight;
	
	public EncodingOne() {
		try {
			// locate in resources
			String loc = "resources" + java.io.File.separatorChar +  
						 "algs" + java.io.File.separatorChar +
						 "chapter2" + java.io.File.separatorChar +
			                         "sidebar2" + java.io.File.separatorChar;
			initialize (new File (loc, "elements.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Load up elements from the identified text file. 
	 * 
	 * Each line must be of the form:
	 * 
	 * 1 H Hydrogen 1.00794
	 * 
	 * Note that the 117th element does not exist and is skipped!
	 * 
	 * @param f
	 * @throws FileNotFoundException
	 */
	public static void initialize(File f) throws FileNotFoundException {
		elementName = new String[numElements];
		elementWeight = new float[numElements];
		Scanner sc = new Scanner (f);
		for (int i = 0; i < 117; i++) {
			// load up a line.
			int num = sc.nextInt();
			/* String symbol */ sc.next();
			String name = sc.next();
			
			float mass;
			if (sc.hasNextFloat()) {
				mass = sc.nextFloat();
			} else {
				// input is of form "[290]"
				String input = sc.next();
				String isotopeMass = input.substring(1,input.length()-1);
				
				mass = Integer.parseInt(isotopeMass);
			}
			
			sc.nextLine();   // to clean out the line.
			
			elementName[num] = name;
			elementWeight[num] = mass;
		}
	}
	
	
	public String name(int n) {
		if (n >= elementName.length) { return null; }
		if (n < 1) { return null; }
		return elementName[n];
	}

	public int number(String s) {
		for (int i = 0; i < elementName.length; i++) {
			if (elementName[i] == null) continue; 
			
			if (elementName[i].equals(s)) {
				return i;
			}
		}
		
		return -1;
	}

	public float weight(int n) {
		if (n >= elementWeight.length) { return -1.0f; }
		if (n < 1) { return -1.0f; }
		if (elementName[n] == null) { return -1.0f; }
		return elementWeight[n];
	}
	
	public String toString () { return " Encoding One "; }
}
