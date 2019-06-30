package lab4.prog4_5;

public interface Polygon {
	public double[] getArrayOfSides();
	public String getName();
	
	 static double sum(double[] arr) {
		 double sum=0.0;
		for (int i = 0; i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	 default double computePerimeter() {
		 double perimeter=0;
		 double[] sides = this.getArrayOfSides();
		 for(int i = 0; i<sides.length;i++) {
			 perimeter += sides[i];
		 }
		 return perimeter;
	 }
}
