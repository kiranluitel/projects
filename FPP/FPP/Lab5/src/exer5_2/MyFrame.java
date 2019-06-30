package exer5_2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class MyFrame extends JFrame {

	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;

	private JPanel leftPanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	private JPanel rightPanel;
	
	private JPanel inputPanel;
	private JTextField inputField;
	private JLabel inputLabel;
	
	private JPanel outputPanel;
	private JTextField outputField;
	private JLabel outputLabel;
	

	
	
	public MyFrame() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		
		
		defineLeftPanel();
		defineRightPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(leftPanel);
		middlePanel.add(rightPanel);
		
		mainPanel.setLayout(new BorderLayout(0,30));
		mainPanel.add(topPanel,BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
	}
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");	
		centerFrameOnDesktop(this);
		setSize(340,200); 
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
	
	private void defineLeftPanel() {
		leftPanel = new JPanel();
		
		leftPanel.setLayout(new BorderLayout());
		button1 = new JButton("Count Letters");
		button1.addActionListener(new MyButtonListener1());
		leftPanel.add(button1,BorderLayout.NORTH);
		button2 = new JButton("Reverse Letters");
		button2.addActionListener(new MyButtonListener2());
		leftPanel.add(button2,BorderLayout.CENTER);
		button3 = new JButton("Remove Duplicates");
		button3.addActionListener(new MyButtonListener3());
		leftPanel.add(button3,BorderLayout.SOUTH);
		
	}
	private void defineRightPanel() {
		rightPanel = new JPanel();
		defineInputPanel();
		defineOutputPanel();
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(inputPanel, BorderLayout.NORTH);
		rightPanel.add(outputPanel,BorderLayout.SOUTH);
		
	}
	private void defineInputPanel() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new BorderLayout());
		bottomText.setLayout(new BorderLayout());		
		
		inputField = new JTextField(10);
		inputLabel = new JLabel("Input");
		inputLabel.setFont(makeSmallFont(inputLabel.getFont()));
		topText.add(inputLabel);
		bottomText.add(inputField);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(topText,BorderLayout.NORTH);
		inputPanel.add(bottomText,BorderLayout.CENTER);
	}
	private void defineOutputPanel() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new BorderLayout());
		bottomText.setLayout(new BorderLayout());		
		
		outputField = new JTextField(10);
		outputLabel = new JLabel("Output");
		outputLabel.setFont(makeSmallFont(inputLabel.getFont()));
		topText.add(outputLabel);
		bottomText.add(outputField);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add(topText,BorderLayout.NORTH);
		outputPanel.add(bottomText,BorderLayout.CENTER);
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
	class MyButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String textVal = inputField.getText();
					
			final String prompt = "Empty: please type";
			
			
		
			if(textVal.equals("")) {
				outputField.setText("0");
			}
			else {
				
				outputField.setText(""+textVal.length());
			}
			
				
			
			
			
		
			
			
		}
		
	}
	class MyButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String textVal = inputField.getText();
					
			final String prompt = "Please give input";
			
			
		
			if(textVal.equals("")) {
				outputField.setText(prompt);
			}
			else {
				String output="";
				for(int i=textVal.length()-1;i>=0;i--) {
					output += textVal.charAt(i);
				}
				outputField.setText(output);
			}
			
				
			
			
			
		
			
			
		}
		
	}
	class MyButtonListener3 implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String textVal = inputField.getText();
					
			final String prompt = "Please give input";
			
			
		
			if(textVal.equals("")) {
				outputField.setText(prompt);
			}
			else {
				String output="";
				
				for ( int i=0;i<textVal.length();i++) {
					boolean check = true;
					for ( int j=0;j<output.length();j++) {
						if(output.charAt(j)==textVal.charAt(i)) check=false;
					}
					if (check) output +=textVal.charAt(i);

				}
				outputField.setText(output);
				
			}
			
				
			
			
			
		
			
			
		}
		
	}
}
