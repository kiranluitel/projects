package lab3.prog3_4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub56
			Triangle t1= new Triangle(10,10);
			Triangle t2= new Triangle(5,4,3);
			Circle c1= new Circle(5);
			Rectangle r1=new Rectangle(10,5);
			System.out.println("Area of the triangle = "+t1.computeArea()+" side 1: " +t1.getSide1()+" side2: "+t1.getSide2()+" side3: "+ t1.getSide3()+" height: "+t1.getHeight()+" base: "+t1.getBase());
			System.out.println("Area of the triangle = "+t2.computeArea()+" side 1: " +t2.getSide1()+" side2: "+t2.getSide2()+" side3: "+ t2.getSide3()+" height: "+t2.getHeight()+" base: "+t2.getBase());
			System.out.println("Area of the Rectangle = "+r1.computeArea());
			System.out.println("Area of the Circle = "+c1.computeArea());
	}

}
