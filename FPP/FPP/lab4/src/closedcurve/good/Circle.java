package closedcurve.good;

public final class Circle extends ClosedCurve {
	private final double radius;
	
	public Circle(double radius) {
		this.radius = radius;
		setName("Circle");
	}
	public double computeArea() {
		return (Math.PI * radius * radius);
	}
}
