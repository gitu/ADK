package algs.example.model.network.mincostmaxflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.StringTokenizer;

import algs.model.network.DisjointPairs;
import algs.model.network.BipartiteMatchingMinCost;
import algs.model.network.FordFulkerson;
import algs.model.network.ShortestPathArray;

/**
 * Show a larger example.
 *  
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class TestMatchingLargeExample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String directory = "resources" + java.io.File.separator +
						   "algs" + java.io.File.separator +
						   "model" +  java.io.File.separator +
						   "network"  + java.io.File.separator +
						   "mincostmaxflow"  + java.io.File.separator;
		
		File f = new File (directory, "r422.geom");
		BufferedReader br = new BufferedReader (new FileReader(f));
		String s;
		DisjointPairs<String,String> dp = new DisjointPairs<String,String>();
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			String v1 = st.nextToken();
			String v2 = st.nextToken();
			dp.add(v1,v2);
		}
		
		BipartiteMatchingMinCost mm = new BipartiteMatchingMinCost(dp);
		FordFulkerson ff = new FordFulkerson (mm, new ShortestPathArray(mm));
		ff.compute();
		
		System.out.println ("cost:" + mm.getCost());
		mm.output();
	}

}
