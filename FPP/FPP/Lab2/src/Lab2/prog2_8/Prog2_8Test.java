package Lab2.prog2_8;

import junit.framework.TestCase;

public class Prog2_8Test extends TestCase {
	public void testMin() {
		int[] test1= {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		int expResult=-22;
		int result= Prog8.min(test1);
		assertEquals("The function is not correct",expResult,result);
	}
}
