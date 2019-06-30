package lab4.good;

public class Test2 {
	
	public static void main(String[] args) {
		Triangle t = new Triangle(4,5,6);
		Square s = new Square(3);
		Rectangle r = new Rectangle(7,3);
		Polygon[] objects = {t, s, r};
		//compute areas
		for(Polygon cc : objects) {
			System.out.println("For this "+cc.getName()+"\nPerimeter is: "+cc.computePerimeter()+
					"\nNo. of Sides: "+cc.getNumberOfSides() );
			
		}
    
	}

}