package test;

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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StringUtil extends JFrame{
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel inputTextPanel;
	private JTextField inputText;
	private JLabel inputLabel;
	private JButton btnCountLetter;
	private JButton btnReverseLetters;
	private JButton btnRemoveDuplicates;
	private JTextField outputText;
	private JLabel outputLabel;
	private JPanel outTextPanel;
	public StringUtil() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineLeftPanel();
		defineRightPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(leftPanel, BorderLayout.CENTER);
		mainPanel.add(rightPanel, BorderLayout.WEST);
		getContentPane().add(mainPanel);
	}
	private void defineLeftPanel() {
		leftPanel = new JPanel();
		defineTextPanel1();
		defineTextPanel2();
		BoxLayout boxlayout1 = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
		leftPanel.setLayout(boxlayout1);
		leftPanel.add(inputTextPanel);
		leftPanel.add(outTextPanel);
		
	}
	private void defineRightPanel(){
		rightPanel=new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);
		rightPanel.setLayout(boxlayout2);
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		btnCountLetter = new JButton("Count Letters");
		//btnCountLetter.addActionListener(new CountLettersListener());
		btnCountLetter.addActionListener( evt -> {
			if(!inputText.getText().equals("")) {
				String letters = inputText.getText();
				outputText.setText(String.valueOf(letters.length()));
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Type a word");
				inputText.grabFocus();
			}
		});
		p1.add(btnCountLetter);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		btnRemoveDuplicates = new JButton("Remove Duplicates");
		//btnRemoveDuplicates.addActionListener(new RemoveDuplicatesListener());
		btnRemoveDuplicates.addActionListener(evt -> {
			String letters = inputText.getText().trim();
			String noDups = removeDuplicatesFromString(letters);
			outputText.setText(noDups);
		});
		p2.add(btnRemoveDuplicates);
		btnReverseLetters = new JButton("Reverse Letters");
		//btnReverseLetters.addActionListener(new ReverseLettersListener());
		btnReverseLetters.addActionListener( evt -> {
			String letters = inputText.getText().trim();
			String reverse = reverse(letters);
			outputText.setText(reverse);
		});
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		p3.add(btnReverseLetters);
		//btnReverseLetters.addActionListener(new Button2ActionListener());
		rightPanel.add(p1);
		rightPanel.add(p2);
		rightPanel.add(p3);
	}
	private void defineTextPanel1() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		inputText = new JTextField(10);
		inputLabel = new JLabel("Input");
		inputLabel.setFont(makeSmallFont(inputLabel.getFont()));
		topText.add(inputText);
		bottomText.add(inputLabel);
		
		inputTextPanel = new JPanel();
		inputTextPanel.setLayout(new BorderLayout());
		inputTextPanel.add(topText,BorderLayout.NORTH);
		inputTextPanel.add(bottomText,BorderLayout.CENTER);
	}
	
private void defineTextPanel2() {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		outputText = new JTextField(10);
		outputLabel = new JLabel("Output");
		outputLabel.setFont(makeSmallFont(outputLabel.getFont()));
		topText.add(outputText);
		bottomText.add(outputLabel);
		
		outTextPanel = new JPanel();
		outTextPanel.setLayout(new BorderLayout());
		outTextPanel.add(topText,BorderLayout.NORTH);
		outTextPanel.add(bottomText,BorderLayout.CENTER);
	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");		
		setSize(320,200);
		handleWindowClosing();
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	private void handleWindowClosing() {
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                dispose();
				//other clean-up
                System.exit(0);
           }
        }); 				
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
				StringUtil su = new StringUtil();
				su.setVisible(true);
			}
		});
	}
	
	void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	class CountLettersListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!inputText.getText().equals("")) {
				String letters = inputText.getText();
				outputText.setText(String.valueOf(letters.length()));
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Type a word");
				inputText.grabFocus();
			}
		}

	}
	public String reverse(String s) {
		String reverse = "";
		for(int i = s.length()-1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		return reverse;
		
	}
	public String removeDuplicatesFromString(String s) {
		String noDups = "";
		for(int i = 0; i < s.length(); i++) {
			if(!noDups.contains(String.valueOf(s.charAt(i)))) {
				noDups += s.charAt(i);
			}
		}
		return noDups;
	}
	
}
