package closedcurve.good;

abstract public class ClosedCurve {
	abstract double computeArea();
	private String name;
	
	protected String getName() {
		return name;
	}
		
		protected void setName (String name) {
			this.name=name;
		}


}
