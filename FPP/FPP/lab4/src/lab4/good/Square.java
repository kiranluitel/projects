package lab4.good;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;

	
	public Square(double side){
		this.side = side;
		setName("Square");
		
	}
	
	public double computeArea() {
		return side * side;
	}
	
	
	public int getNumberOfSides() {
		return 4;
	}
	
	
	public double computePerimeter() {
		return 4*side;
	}
	
	private String name;
	public String getName() {
		return name;
	}
		
		public void setName (String name) {
			this.name=name;
		}


}
