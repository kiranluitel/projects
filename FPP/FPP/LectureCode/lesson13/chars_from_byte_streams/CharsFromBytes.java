package lesson13.chars_from_byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CharsFromBytes {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\lesson13\\chars_from_byte_streams";
	static StringBuilder sbText = new StringBuilder();
	static StringBuilder sbChin = new StringBuilder();
	public static void main(String[] args) {
		System.out.println("Bytes from ABfile");
		
		//outputs each byte and changes each byte to char and inserts in sbText
		outputBytes(OUTPUT_DIR+"\\ABfile", sbText);
		System.out.println("\nTrying to interpret bytes as characters...");
		System.out.println(sbText);
		System.out.println("======================");
		System.out.println("Bytes from ChineseFile");
		
		//outputs each byte and changes each byte to char and inserts in sbChin
		outputBytes(OUTPUT_DIR+"\\ChineseFile", sbChin);
		System.out.println("\nTrying to interpret bytes as characters...");
		System.out.println(sbChin.toString());
		System.out.println("======================");


	}

	public static void outputBytes(String s, StringBuilder sb) {
		File file = new File(s);
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
	
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				sb.append((char) content);
				System.out.print(content + "  ");
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
	}
	
	

}
