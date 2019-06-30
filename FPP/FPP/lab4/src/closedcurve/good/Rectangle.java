package closedcurve.good;

public class Rectangle extends ClosedCurve{
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length=length;
		this.width=width;
		setName("Rectangle");
	}
	
	double computeArea() {
		return length*width;
	}
	
}
