package lesson13.readWriteEncodings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
	//Shows how the same String is encoded as different
	//byte sequences using different character encodings.
	
	//Encoding a character using one encoding and then
	//reading it back using a different encoding 
	//leads to trouble
	
	public static void main(String[] args) {
//		try {
//			simple();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			justAscii();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			Charset isolatin = Charset.forName("ISO-8859-1");
			String accentO = "Ó"; //extended ASCII character (in range 0-255)
			byte[] accentOisolatin = accentO.getBytes(isolatin);
		    System.out.print(" - Character Ó under " + "ISO-8859-1" + " encoding:  ");
			printArrayAsBytes(accentOisolatin);
			byte[] asUtf8 = accentO.getBytes("UTF-8");
	        System.out.print(" - Character Ó under " + "UTF-8" + " encoding:  ");
			printArrayAsBytes(asUtf8);
			byte[] asUtf16 = accentO.getBytes("UTF-16");
            System.out.print(" - Character Ó under " + "UTF-16" + " encoding:  ");
			printArrayAsBytes(asUtf16);
//			//reading these byte sequences under different encodings
			String accentOAsUtf8 = new String(accentOisolatin);//by default, UTF-8 is the encoding used by new String()
			System.out.println(" - " + accentOAsUtf8 + "\t(ISO-8859-1 encoding of Ó read using UTF-8 encoding)");
			String utf8AsIsolatin = new String(asUtf8, "ISO-8859-1");
			System.out.println(" - " + utf8AsIsolatin+ "\t(UTF-8 encoding of Ó read using ISO-8859-1 encoding)");
			String isolatinAsIsolatin = new String(accentOisolatin, "ISO-8859-1");
			System.out.println(" - " + isolatinAsIsolatin + "\t(ISO-8859-1 encoding of Ó read using ISO-8859-1 encoding)");
			String utf8AsUtf8 = new String(asUtf8, "UTF-8");
			System.out.println(" - " + utf8AsUtf8 + "\t(UTF-8 encoding of Ó read using UTF-8 encoding)" );
		} catch(Exception e) {
			e.printStackTrace();
		}
//		try {
//			other();
//		} catch(Exception e) {
//			
//		}
	}
	public static void simple() {
		//to get the utf-8 bytes (in binary) for 好, use getBytes
		printArrayAsBytes("好".getBytes());
		//to reassemble the bytes to obtain '好', 
		//create new String from the byte array (uses utf-8 by default)
		System.out.println(new String("好".getBytes()));
		//to see the precise unicode value of '好', use codePointAt()
		System.out.println("好".codePointAt(0));
		//if codePoint is same as code unit, can get by casting to int
		System.out.println((int)'好');
		//to assemble '好' from the exact unicode value, cast to a char
		//assuming character requires only one Java code unit (see below)
		System.out.println((char)("好".codePointAt(0)));
		//to get code units from character that is represented using two code units:
		if("𝕫".length() == 2) {
			char char0 = "𝕫".charAt(0);
			char char1 = "𝕫".charAt(1);
			String charNum0 = Integer.toHexString("𝕫".charAt(0));
			String charNum1 = Integer.toHexString("𝕫".charAt(1));
			System.out.print(charNum0 + " " + charNum1);
			//to reassemble from code units
			System.out.println("\n"+new String(new char[] {char0, char1}));
			//codePointAt(0) actually reads charAt(0) and charAt(1) to determine
			//the full unicode value
			System.out.println(Integer.toHexString("𝕫".codePointAt(0)));
			//display character given codepoint by reading codepoint into a string the following
			//does not work
			System.out.println((char)("𝕫".codePointAt(0)));
			//instead do the following
			System.out.println(Character.toChars("𝕫".codePointAt(0)));
		}
		
		
		
	}
	/** 
	 * Shows how under any of the usual encodings, if bytes that are
	 * intended to represent ASCII characters can be read in as bytes
	 * and converted to characters.
	 * 
	 * Setup: Write a few characters in Notepad and save using
	 * different encodings. Read in as bytes
	 */
	static void justAscii() throws Exception {
		String path = System.getProperty("user.dir") + "\\text.txt";
		List<Integer> bytes = readBytes(path);
		System.out.println("\nTranslating bytes to characters: (notice the Chinese character is not printed correctly)");
		System.out.print("  ");
		for(int i = 0; i < bytes.size(); ++i) {
			System.out.print(""+(char)bytes.get(i).intValue());
		}
//		System.out.println("\n");
//		System.out.print("你 as bytes (assumes UTF8 encoding) ");
//		printArrayAsBytes("你".getBytes());
//		//printArrayAsBytes("你".getBytes("UTF-8"));
//		System.out.println("The Chinese character 你 at end of file requires 3 bytes.");
//		System.out.println("The text.txt file was saved using UTF-8 so bytes so we can reassemble these bytes if we use UTF-8");
//		byte[] lastThree = {bytes.get(bytes.size()-3).byteValue(), bytes.get(bytes.size()-2).byteValue(), bytes.get(bytes.size()-1).byteValue()};
//		System.out.println("Output obtained by manually re-assembling bytes: " + new String(lastThree) + "\n\n");
		
	}
	static void printArrayAsBytes(byte[] arr) {
		int[] asInts = new int[arr.length];		
		for(int i = 0; i < arr.length; ++i) {
			String intString = Integer.toBinaryString(arr[i]);
			int len = intString.length();
			String byteString = null;
			if(len < 8) byteString = pad(intString, 8 - len);
			else byteString = intString.substring(len - 8);
			System.out.print(byteString + "  ");
			asInts[i] = Integer.valueOf(byteString, 2);
		}
		
		System.out.println("  As base 10 ints: " + Arrays.toString(asInts));
			
		
		System.out.println();
		//System.out.println(Arrays.toString(arr));
	}
	static String pad(String s, int k) {
		for(int i = 0; i < k; ++i) {
			s = "0" + s;
		}
		return s;
	}
	static void printArray(byte[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			String intString = Integer.toBinaryString(arr[i]);
			//String byteString = intString.substring(24);
			System.out.print(intString + "  ");
		}
		System.out.println();
		//System.out.println(Arrays.toString(arr));
	}
	
	static List<Integer> readBytes(String filename) {
		File file = new File(filename);
		FileInputStream fis = null;
		List<Integer> ints = new ArrayList<>();
		try {
			fis = new FileInputStream(file);
	
			int nextByte;
			while ((nextByte = fis.read()) != -1) {
				ints.add(nextByte);		
			}
			System.out.print("In binary: ");
			for(int i = 0; i < ints.size(); ++i) {
				 System.out.print(toBinary(Integer.toBinaryString(ints.get(i))) + "  ");
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
		return ints;
	}
	private static String toBinary(String zeroesAndOnes) {
		int len = zeroesAndOnes.length();
		if(len > 8) return zeroesAndOnes;
		return padInFront(zeroesAndOnes, '0', 8-len);
		
	}
	
	//Place num copies of char c at front of  input string s
	private static String padInFront(String s, char c, int num) {
		for(int i = 0; i < num; ++i) {
			s = ("" + c) + s;
		}
		return s;
		
	}
	
	private static void other() throws Exception {
		System.out.println("\n other character: \n" + "As bytes, using utf8: ");
		printArrayAsBytes("好".getBytes()); //same as getBytes("UTF-8");
		System.out.println("As a unicode value: " + "好".codePointAt(0));
		System.out.println((char)22909);
	}
}
