package prog7_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchTest2 {
	@Test
	public void searchTest() {
	BinarySearch bs = new BinarySearch();
	
	
	boolean expResult1 = false;
	boolean result1 =bs.search("abcdefghijklmnop", 'z');
	System.out.println(result1);
	assertEquals("Test Failed",expResult1,result1);
	}
}
