package lesson13.readersandwriters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
//		m.useInputStreamReader();
//		m.readNoInputStream();
//		m.useOutputStreamWriter();
		m.writeNoOutputStream();
	}

	public void useInputStreamReader() {
		try {
			InputStream stream1 = System.in;
			InputStream stream2 = new FileInputStream("text.txt");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream1));
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(stream2, "UTF-8"));
			System.out.println(reader2.readLine());
			System.out.print("Type something: ");
			System.out.println(reader1.readLine());
			reader1.close();
			reader2.close();
			stream1.close();
			stream2.close();
		}

		catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	public void readNoInputStream() {
		// uses a FileReader
		try {
			FileReader reader = new FileReader("text.txt");
			BufferedReader bufreader = new BufferedReader(reader);
			String line = null;
			while ((line = bufreader.readLine()) != null) {
				System.out.println(line);
			}
			bufreader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Example:
		// uses a Scanner
		try {
			Scanner sc = new Scanner(new File("text.txt"));
			String line = null;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void useOutputStreamWriter() {
		try {
			OutputStream stream1 = System.out;
			OutputStream stream2 = 
				new FileOutputStream("text2.txt");
			PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(stream1));
			PrintWriter writer2 = new PrintWriter(
					new OutputStreamWriter(stream2, StandardCharsets.UTF_8));
			writer1.println("output to console with chinese: 你");
			writer2.println("output to file with chinese: 你");
			writer1.close();
			writer2.close();
			stream1.close();
			stream2.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void writeNoOutputStream() {
		try{
			PrintWriter writer = 
					new PrintWriter("text3.txt", "UTF-8");	
			writer.printf("Output this character %c to %s", '你', "file");		
			writer.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}	

	}

}
