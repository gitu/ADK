package algs.model.tests.search;

import org.junit.Test;

import algs.model.search.AssociativeHashTable;
import algs.model.search.StandardHash;
import junit.framework.TestCase;

/**
 * Test our Associate Hash Table implementation that stores lists of <K,V> 
 * entries.
 */
public class AssociativeHashTableTest extends TestCase {
	
	@Test
	public void testSimple() {
		AssociativeHashTable<String,Integer> ht = new AssociativeHashTable<String,Integer>(16, new StandardHash<String>(16));
		
		assertEquals (0, ht.size());
		ht.add("January", 99);
		assertEquals (1, ht.size());
		
		assertTrue (ht.search("January"));
		assertFalse (ht.search("February"));
		ht.add("February", 43);
		assertEquals (2, ht.size());
		assertTrue (ht.search("February"));
		
		ht.remove("February");
		assertFalse (ht.search("February"));	
		assertEquals (1, ht.size());
	}

}
