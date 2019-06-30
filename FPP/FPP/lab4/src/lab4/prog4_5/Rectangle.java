package lab4.prog4_5;

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
	public double[] getArrayOfSides() {
		double[] sides = { width, width, length, length};
		return sides;
	}
	
	private String name;
	public String getName() {
		return name;
	}
		
		public void setName (String name) {
			this.name=name;
		}
}
