package lab4.prog4_5;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;

	
	public Square(double side){
		this.side = side;
		setName("Square");
		
	}
	
	public double computeArea() {
		return side * side;
	}
	
	
	public double[] getArrayOfSides() {
		double[] sides = { side, side, side, side};
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
