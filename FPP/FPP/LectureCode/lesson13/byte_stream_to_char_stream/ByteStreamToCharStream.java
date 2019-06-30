package lesson13.byte_stream_to_char_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class ByteStreamToCharStream {
	public static void main(String[] args) {
		try {
		   chineseCharTest();
		} catch(Exception e) {}
		
	}
	static void chineseCharTest() throws Exception {
		char ch = '好';
		int chInt = (int)ch;
		System.out.println("Unicode for character " + ch + " as base 10 integer: " + chInt);
		byte[] asBytes = Util.integerAsBytes(chInt);
		System.out.println("View of " + chInt + " as byte array: " + Arrays.toString(asBytes));
		
		//read it one byte at a time -- not possible
		//to reconstruct the original character:
		byte byte1 = (byte)asBytes[2];
		byte byte2 = (byte)asBytes[3];
		System.out.println("Can't rebuild character by looking at each byte individually as a character:\n" 
		  +(char)byte1 + " " + (char)byte2);
		
		//can't reconstruct it from the byte sequence 
		String construct = new String(asBytes); //same as   String construct = new String(asBytes, "UTF-8");
		System.out.println("Reconstructing by interpreting byte array " + Arrays.toString(asBytes)
		   + "as a Java String doesn't work either because Java constructs the String using utf8 encoding: ");
		System.out.println(construct);
		
		//grouping the last two bytes and viewing them as a single character
		//lets us reconstruct the original character 
		int combined = byte2 + ((int)byte1 << 8);
		System.out.println("Putting last two bytes together, viewed as a character, lets Java reconstruct the character:" +
		 "\n    " + (char)combined);
		System.out.println("This is same as simply casting 22909 as a char:");
		System.out.println((char)22909);
		
	}
}
