package LoginPage;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage 
{
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel(); 
	
	WelcomePage(String userID)
	{
		
		welcomeLabel.setFont(new Font(null,Font.PLAIN,35));
		welcomeLabel.setText("Welcome "+userID+"!!");
		
		frame.add(welcomeLabel);
		frame.setTitle("Window");        
		frame.setSize(420,420);
		frame.setLocation(500,150);           
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
}
