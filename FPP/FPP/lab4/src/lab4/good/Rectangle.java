package lab4.good;

public class Rectangle extends ClosedCurve implements Polygon {
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
	public int getNumberOfSides() {
		return 4;
	}
	
	public double computePerimeter() {
		return 2*(length+width);
	}
	
	private String name;
	public String getName() {
		return name;
	}
		
		public void setName (String name) {
			this.name=name;
		}
}
