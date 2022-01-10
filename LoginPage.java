package LoginPage;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage implements ActionListener
{
	JFrame frame = new JFrame();	                // creating the frame on which watch will display 
	JButton loginButton = new JButton("LOGIN");    // creating & naming the Buttons 
	JButton resetButton = new JButton("RESET");
	JTextField userIDField = new JTextField();   // Text Field where we can enter user ID   
	JPasswordField userPasswordField = new JPasswordField(); // When we enter something it will be automatically encrypted as ****** 
	JLabel userIDLabel = new JLabel("User:"); 
	JLabel userPasswordLabel = new JLabel("Password:"); 
	JLabel messageLabel = new JLabel();       // it will show are the entered values correct or not
		
	HashMap<String,String> logininfo = new HashMap<String,String>(); // creating a new HashMap where we will store all the details of user  
	
	LoginPage(HashMap<String,String> logininfoOriginal)
	{
		logininfo = logininfoOriginal;  // copying the details from logininfo(of IDandPASSWORD) too logininfo(of LoginPage)
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setTitle("Login Page");          // Frame Title
		frame.setSize(420,420);
		frame.setLocation(500,150);           // Window coordinates
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==resetButton)  // when reset button is clicked we will clear all the entered values from the Fields
		{
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton)  // when login button is clicked we will
		{
			String userID = userIDField.getText();                               // copying the values from Fields to compare it  
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) // if logininfo(HashMap which is storing data of users) contains the value entered in the Text Field
			{
				if(logininfo.get(userID).equals(password))  // when userID is verified, we use the userID<String, ?> to check in the logininfo HashMap for the
				{                                          // password<userID,"String"> value associated with the ID in the map & then compare it with the Password Field value 
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successful");
					frame.dispose();                   // it will simply delete the current frame
					WelcomePage welcomePage = new WelcomePage(userID);  // then we call a new frame & passed the verified userID value 
				}
				else                                       // when the user id is not valid, we wont check further that password is correct or not
				{
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}
			else                                        // when user id is valid, but the password entered is incorrect 
			{
				messageLabel.setForeground(Color.red);
				messageLabel.setText("User Not Found");
			}
		}	
	}
	
}
