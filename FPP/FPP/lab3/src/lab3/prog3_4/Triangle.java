package lab3.prog3_4;

public final class Triangle {
	
		private double base;
		private double height;
		private double side1;
		private double side2;
		private double side3;
		public double getBase() {
			return base;
		}
		
		
		public double getHeight() {
			return height;
		}
	
		
		public double getSide1() {
			return side1;
		}
		
		
		public double getSide2() {
			return side2;
		}
		
		
		public double getSide3() {
			return side3;
		}
		
		
		public double computeArea() {
			double area;
			area = this.base * this.height * 0.5;
			return area;
		}
		public Triangle(double base, double height) {
			this.base=base;
			this.height=height;
			//calculating 3 sides
			this.side2=base;
			this.side3=height;
			this.side1=Math.sqrt(side2*side2+side3*side3);
			
		}
		public Triangle(double x, double y, double z) {
			double temp;
			if (y>z) {
				temp=z;
				z=y;
				y=temp;
			}
			if (x>z) {
				temp=z;
				z=x;
				x=temp;
			}
			base=z;
			height= Math.sqrt(x*x-Math.pow((x*x+z*z-y*y), 2)/(4.0*z*z));
			side1=x;
			side2=y;
			side3=z;
		}
	
}
