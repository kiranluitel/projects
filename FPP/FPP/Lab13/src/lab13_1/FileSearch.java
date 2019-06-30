package lab13_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
//PSEUDO-CODE
boolean searchForFile(Object file, Object startDir) {
	Object[] fileSystemObjects =
						startDir.getContents();
	for(Object o: fileSystemObjects) {
		//base case
		if(isFile(o) && isSameFile(o,f)) {
			return true;
		}

		if(isDirectory(o)) {
			searchForFile(file, o);
		}
	}
	//file not found in startDir
	return false;
}
*/
public class FileSearch {
	static boolean found = false;
	// Store the text that is found in the
	// file that is found in this String variable
	static String discoveredText = null;

	public static boolean searchForFile(File filename, File f) {
		// implement
		//File f= new File(startDir);
		//File fileBeingSearched = new File(filename);
		
		File[] fileSystemObjects = f.listFiles();
		for (File i : fileSystemObjects) {
			//for(File j:fileSystemObjects) System.out.println(i.getName());
//base case
			if (i.isFile() && isSameFile(i,filename)) {
				return true;
			}

			if (i.isDirectory()) {
			//	System.out.println(filename.getName()+" "+i.getName());
				searchForFile(new File(filename.getAbsolutePath()), new File(i.getAbsolutePath()));
			}
		}
//file not found in startDir
		return true;
	}	
	private static boolean isSameFile(File a, File b) {
		if(a.isFile() && b.isFile() && a.getName().equals(b.getName())) return true;
		return false;
	}
	

}
