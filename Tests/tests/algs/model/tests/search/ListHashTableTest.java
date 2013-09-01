package algs.model.tests.search;

import org.junit.Test;

import algs.model.search.ListHashTable;
import algs.model.search.StandardHash;
import junit.framework.TestCase;

/**
 * Test our Hash Table implementation
 */
public class ListHashTableTest extends TestCase {
	
	@Test
	public void testSimple() {
		ListHashTable<String> ht = new ListHashTable<String>(16, new StandardHash<String>(16));
		
		assertEquals (0, ht.size());
		ht.add("4");
		assertEquals (1, ht.size());
		
		assertTrue (ht.search("4"));
		assertFalse (ht.search("43"));
		ht.add("43");
		assertTrue (ht.search("43"));
		
		ht.remove("43");
		assertFalse (ht.search("43"));		
	}

}
