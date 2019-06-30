package lab13_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import junit.framework.TestCase;

public class Test extends TestCase {						//// Please test only in mac with this code
	static File insert;
	private String expectedText = "This is the file you are seeking!";
	private String setupDirectory = "/users/macbookpro/eclipse-workspace/testCode";
	private String targetFile = "seek.txt";
	@Override
	public void setUp() {
		File f = new File("/users/macbookpro/eclipse-workspace/testCode/level1/level2/finalLevel");
		System.out.println(f.mkdirs());
		f = new File("/users/macbookpro/eclipse-workspace/testCode/level1/level2a/thirdLevel");
		System.out.println(f.mkdirs());
		f = new File("/users/macbookpro/eclipse-workspace/testCode/level1/level2b/thirdLevelb");
		System.out.println(f.mkdirs());
		f = new File("/users/macbookpro/eclipse-workspace/testCode/level1/level2b/thirdLevelc/fourthLevel");
		System.out.println(f.mkdirs());
		insert = new File(f.getAbsolutePath() + "/seek.txt");
		System.out.println("writing to " + insert.getAbsolutePath());
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(insert)));
			pw.write(expectedText);
			pw.flush();
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testSearchForFile() {
		
		boolean result = FileSearch.searchForFile(new File(targetFile), new File(setupDirectory));
		assertEquals(true,result);
		
		//assertTrue(expectedText.equals(FileSearch.discoveredText.trim()));
		
		
		
	}
}
