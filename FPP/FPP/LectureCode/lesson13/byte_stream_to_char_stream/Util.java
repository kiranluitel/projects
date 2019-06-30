package lesson13.byte_stream_to_char_stream;

public class Util {
	public static byte[] integerAsBytes(int num) {
		int eightFinalOnes = (1 << 8) - 1;
		int eightSecondToLastOnes = (1 << 16)-1 - eightFinalOnes;
		int eightThirdToLastOnes = (1 << 24) -1 - eightSecondToLastOnes - eightFinalOnes;
		int eightInitialOnes = -1 -eightThirdToLastOnes- eightSecondToLastOnes - eightFinalOnes;
		//System.out.println(Integer.toBinaryString(eightInitialOnes));
		//System.out.println(Integer.toBinaryString(eightThirdToLastOnes));
		//System.out.println(Integer.toBinaryString(eightSecondToLastOnes));
		//System.out.println(Integer.toBinaryString(eightFinalOnes));
		return new byte[] {(byte)((eightInitialOnes & num) >> 24),
				(byte)((eightThirdToLastOnes & num) >> 16),
				(byte)((eightSecondToLastOnes & num) >> 8),
				(byte)(eightFinalOnes & num)};

	}
}
