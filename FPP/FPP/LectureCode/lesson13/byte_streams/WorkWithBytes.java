package lesson13.byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkWithBytes {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\lesson13\\byte_streams";
	public static void main(String[] args) {
		//String s = "9876543210";
		//System.out.println(lastEight(s));
		System.out.println("Bytes from ABfile");
		outputBytes(OUTPUT_DIR + "\\ABfile");
		System.out.println("\n\nBytes from executable ToastDll64.dll");
		outputBytes(OUTPUT_DIR + "\\ToastDll64.dll");
	}
	public static void outputBytes(String s) {
		File file = new File(s);
		FileInputStream fis = null;
		List<Byte> bytes = new ArrayList<>();
		
		try {
			fis = new FileInputStream(file);
	
			byte nextByte;
			while ((nextByte = (byte)fis.read()) != -1) {
				bytes.add(nextByte);
				
			}
			System.out.print("  In binary (padded): ");
			for(int i = 0; i < bytes.size(); ++i) {
				 System.out.print(toBinary(Integer.toBinaryString(bytes.get(i))) + "  ");
				 
			}
			System.out.print("\n  ...notice how binary padding works...\n  In binary (unpadded): ");
			for(int i = 0; i < bytes.size(); ++i) {
				 System.out.print(Integer.toBinaryString(bytes.get(i)) + "  ");
				 
			}
			System.out.println();
			System.out.print("  As hexadecimals: ");
			for(int i = 0; i < bytes.size(); ++i) {
				System.out.print(trimHex(Integer.toHexString(bytes.get(i))) + "  ");
			}
			System.out.println();
			System.out.print("  As decimal nums: ");
			for(int i = 0; i < bytes.size(); ++i) {
				 System.out.print(bytes.get(i) + "  ");
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
	/* Returns a length-8 string of 0's and 1's. If input
	 * has length < 8, it is padded with 0's in front. If
	 * input has length > 8, front bits are removed
	 */
	private static String toBinary(String zeroesAndOnes) {
		int len = zeroesAndOnes.length();
		if(len > 8) return lastEight(zeroesAndOnes);
		return padInFront(zeroesAndOnes, '0', 8-len);
		
	}
	
	//Place num copies of char c at front of  input string s
	private static String padInFront(String s, char c, int num) {
		for(int i = 0; i < num; ++i) {
			s = ("" + c) + s;
		}
		return s;
	}
	//Extracts last 8 bits and returns 
	private static String lastEight(String s) {
		return last(s, 8);
	}
	
	private static String trimHex(String s) {
		return last(s, 2);
	}
	
	private static String last(String s, int num) {
		if(s == null || s.length() <= num || num < 1) return s;
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		String t = sb.toString().substring(0, num);
		sb = new StringBuilder(t);
		return sb.reverse().toString();
	}
	

}
