package Lab2.prog2_6;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.Assert;




public class TestProg6 extends TestCase{
	@Test
	public void testRemoveDups() {
		
		String[] testData = {"horse","dog","cat","horse","dog"};
		String[] expectedResult= {"horse","dog","cat"};
		
		String[] result = Prog6.removeDups(testData);
		
		
		assertArrayEquals(expectedResult,result);
	
		
	}
}
