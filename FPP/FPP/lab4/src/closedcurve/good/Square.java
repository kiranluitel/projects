package closedcurve.good;

public final class Square extends ClosedCurve {
	private final double side;

	
	public Square(double side){
		this.side = side;
		setName("Square");
		
	}
	public double computeArea() {
		return side * side;
	}


}
