package lesson13.char_encodings;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;


public class Test {

	public static void main(String[] args) {
//		Charset utf16 = Charset.forName("UTF-16BE");
//		Charset isolatin = Charset.forName("ISO-8859-1");
//		Charset utf8 = Charset.forName("UTF-8");
//		String abc = "ABC";
//		byte[] asUtf16 = abc.getBytes(utf16);
//		byte[] asUtf8 = abc.getBytes(utf8);
//		byte[] defaultEnc = abc.getBytes();
//		byte[] asIsolatin = abc.getBytes(isolatin);
//				
//		printArray(asUtf16);
//		printArray(defaultEnc);
//		printArray(asIsolatin);
//		
//		String newAbc = new String(asIsolatin);
//		System.out.println(newAbc);
//
//		//going from byte array to string
//		byte letrA = 65;
//		byte[] bytes = {0, letrA};
//		try {
//			String sUtf16 = new String(bytes, "UTF-16BE");
//			String sIso = new String(bytes, "ISO-8859-1");
//			System.out.println(sUtf16);
//			System.out.println(sIso);
//			
//		} catch(UnsupportedEncodingException e) {
//			
//		}
		
		
	}
	
	private static void printArray(byte[] bytes) {
		StringBuilder b = new StringBuilder("[");
		for(int i = 0; i < bytes.length; ++i) {
			if(i < bytes.length-1) b.append(bytes[i] + ", ");
			else b.append(bytes[i]);
		}
		b.append("]");
		System.out.println(b);
		
	}

}
