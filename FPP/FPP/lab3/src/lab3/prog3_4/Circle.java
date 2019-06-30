package lab3.prog3_4;

public final class Circle {
	private final double radius;
	
	public double computeArea() {
		return Math.PI*radius*radius;
	}
	public Circle(double radius) {
		this.radius=radius;
		
	}

}
