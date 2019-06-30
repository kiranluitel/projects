package lesson6_innerexamples;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  This version of MyFrame uses lambda notation to add a listener 
 *  Requires jse8 or later.
 *
 */
public class MyFrameLambda extends JFrame {
	JLabel label;
	JTextField text;
	public MyFrameLambda(){
		initializeWindow();
		JPanel mainPanel = new JPanel();
		
		text = new JTextField(10);
		label = new JLabel("My Text");
		JButton button = new JButton("My Button");
		
		//Registering an ActionListener with button using lambda notation - requires jse8.
		//Java figures out the type of evt using "target typing"
		button.addActionListener (
			evt -> {
				System.out.println("Button height = " + button.getSize().height);
				text.setText("button press");
			}
		);
		
		mainPanel.add(text);
		mainPanel.add(label);
		mainPanel.add(button);		
		getContentPane().add(mainPanel);
	}
	
	public void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");
		setSize(320, 240); // see NOTE below
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MyFrameLambda mf = new MyFrameLambda();
				mf.setVisible(true);
			}
		});
	}
	private static final long serialVersionUID = -5565229515686514125L;
}
