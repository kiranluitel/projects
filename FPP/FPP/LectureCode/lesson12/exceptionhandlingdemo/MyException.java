package lesson12.exceptionhandlingdemo;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException() {
		super();
	}
	public MyException(Throwable t) {
		super(t);
	}
	public MyException(String msg) {
		super(msg);
	}
}
