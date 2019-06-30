package lab3.prog3_4;

public final class Rectangle {
	private double width;
	private double length;
	public double computeArea() {
		return width*length;
	}
	public Rectangle(double width, double length) {
		this.width=width;
		this.length=length;
	}
}
