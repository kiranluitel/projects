
public class StringTest {

	public static void main(String[] args) {
		String str = new String("test");
		String str3 = "test";
		String str2 = new String("test");
		System.out.println(str.intern() == str2.intern());
	}

}
