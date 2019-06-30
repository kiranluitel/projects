//improved version using an enum
package lesson3.labelwithenums;


public class Label  {

    String text;
    Alignment alignment;
   
    public Label(String text, Alignment alignment)  {
			this.text = text;
			setAlignment(alignment);
    }

    public Alignment getAlignment() {
			return alignment;
    }

    public synchronized void setAlignment(Alignment alignment) {
    	this.alignment = alignment;

    }
    public String getText() {
			return text;
    }
    public void setText(String text) {
	  		synchronized (this) {
	    	if (text != this.text && (this.text == null ||
				      !this.text.equals(text))) {

	        		this.text = text;
	    }
	  }
    }  
    public static void main(String[] args)  {
    	
    	//Label label = new Label("Hi there!", 5);
    	
    	Label label = new Label("Hi there!", Alignment.LEFT);
    	
    	label.setAlignment(Alignment.RIGHT);
    	//Can access instance variables that 
    	//are visible with "dot" notation
    	System.out.println("Alignment: " + label.alignment);
    	//Better to access data using getters
    	System.out.println("Alignment: " + label.getAlignment());
    	System.out.println("Text: " + label.getText());
    }
}
