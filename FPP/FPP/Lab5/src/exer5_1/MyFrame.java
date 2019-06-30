package exer5_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyFrame extends JFrame {
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	
	private JPanel namePanel;
	private JTextField nameField;
	private JLabel nameLabel;
	
	private JPanel streetPanel;
	private JTextField streetField;
	private JLabel streetLabel;
	
	private JPanel cityPanel;
	private JTextField cityField;
	private JLabel cityLabel;
	
	private JPanel statePanel;
	private JTextField stateField;
	private JLabel stateLabel;
	
	private JPanel zipPanel;
	private JTextField zipField;
	private JLabel zipLabel;
	
	private JButton button;
	public MyFrame() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	private void defineTopPanel() {
		topPanel = new JPanel();
		defineNamePanel();
		
		
		
		defineStreetPanel();
	
		
		
		defineCityPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(namePanel);
		topPanel.add(streetPanel);
		topPanel.add(cityPanel);
		
		
	}
	private void defineMiddlePanel() {
		middlePanel = new JPanel();
		defineStatePanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(statePanel);
		
		defineZipPanel();
	
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(zipPanel);
		
		
		
	}
	private void defineBottomPanel(){
		bottomPanel=new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("Submit");
		button.addActionListener(new MyButtonListener());
		bottomPanel.add(button);
	}

	/*private void defineBottomPanel() {
		bottomPanel = new JPanel();
		defineTextPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottomPanel.add(textPanel);

	}*/
	private void defineNamePanel() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		nameField = new JTextField(10);
		nameLabel = new JLabel("Name");
		nameLabel.setFont(makeSmallFont(nameLabel.getFont()));
		topText.add(nameLabel);
		bottomText.add(nameField);
		
		namePanel = new JPanel();
		namePanel.setLayout(new BorderLayout());
		namePanel.add(topText,BorderLayout.NORTH);
		namePanel.add(bottomText,BorderLayout.CENTER);
	}
	private void defineStreetPanel() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		streetField = new JTextField(10);
		streetLabel = new JLabel("Street");
		streetLabel.setFont(makeSmallFont(streetLabel.getFont()));
		topText.add(streetLabel);
		bottomText.add(streetField);
		
		streetPanel = new JPanel();
		streetPanel.setLayout(new BorderLayout());
		streetPanel.add(topText,BorderLayout.NORTH);
		streetPanel.add(bottomText,BorderLayout.CENTER);
	}
private void defineCityPanel() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		cityField = new JTextField(10);
		cityLabel = new JLabel("City");
		cityLabel.setFont(makeSmallFont(cityLabel.getFont()));
		topText.add(cityLabel);
		bottomText.add(cityField);
		
		cityPanel = new JPanel();
		cityPanel.setLayout(new BorderLayout());
		cityPanel.add(topText,BorderLayout.NORTH);
		cityPanel.add(bottomText,BorderLayout.CENTER);
	}

private void defineStatePanel() {
	
	JPanel topText = new JPanel();
	JPanel bottomText = new JPanel();
	topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
	bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
	
	stateField = new JTextField(10);
	stateLabel = new JLabel("State");
	stateLabel.setFont(makeSmallFont(stateLabel.getFont()));
	topText.add(stateLabel);
	bottomText.add(stateField);
	
	statePanel = new JPanel();
	statePanel.setLayout(new BorderLayout());
	statePanel.add(topText,BorderLayout.NORTH);
	statePanel.add(bottomText,BorderLayout.CENTER);
}
private void defineZipPanel() {
	
	JPanel topText = new JPanel();
	JPanel bottomText = new JPanel();
	topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
	bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
	
	zipField = new JTextField(10);
	zipLabel = new JLabel("ZIP");
	zipLabel.setFont(makeSmallFont(zipLabel.getFont()));
	topText.add(zipLabel);
	bottomText.add(zipField);
	
	zipPanel = new JPanel();
	zipPanel.setLayout(new BorderLayout());
	zipPanel.add(topText,BorderLayout.NORTH);
	zipPanel.add(bottomText,BorderLayout.CENTER);
}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Address Form");	
		centerFrameOnDesktop(this);
		setSize(475,320); 
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	
	public static void centerFrameOnDesktop(Component f) {
	        final int SHIFT_AMOUNT = 0;
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        int height = toolkit.getScreenSize().height;
	        int width  = toolkit.getScreenSize().width;
	        int frameHeight = f.getSize().height;
	        int frameWidth  = f.getSize().width;
	        f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MyFrame mf = new MyFrame();
				mf.setVisible(true);
			}
		});
	}
	
	
	
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String[] textVal = {nameField.getText(),
					streetField.getText(),
					cityField.getText()
					,stateField.getText(),
					zipField.getText()
					};
			final String prompt = "Empty: please type";
			final String youWrote = "You wrote: ";
			boolean check=true;
			for(int i=0;i<textVal.length;i++) {
			if(textVal[i].equals("") || 
					textVal[i].equals(prompt)){
				check=false;
			}
			}
			if (check==false) {	
				nameField.setText(prompt);streetField.setText(prompt);cityField.setText(prompt)
				;stateField.setText(prompt);zipField.setText(prompt);
			}
			
			else {
				System.out.println(nameField.getText()+"\n"
						+ streetField.getText()+"\n"+cityField.getText()+", "+stateField.getText()+
						" "+zipField.getText());
			}
		
			
			
		}
		
	}
	private void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	private static final long serialVersionUID = 3618976789175941431L;
}
	