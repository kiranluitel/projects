package prog7_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class SearchTest {
	@Test
	public void searchTest() {
	BinarySearch bs = new BinarySearch();
	boolean expResult = true;
	boolean result =bs.search("abcdefghijklmnop", 'a');
	System.out.println(result);
	assertEquals("Test Failed",expResult,result);

	}
}
