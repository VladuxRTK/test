package MainApp;
import javax.swing.*;

import AbstractTypes.GymUser;

import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
	//private JPanel panel;
	private JPasswordField password;
	private JTextField username;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton button;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    
    public Login()
    {
    	super("Login Page");
    	this.setSize(600,400);
    	username = new JTextField();
    	password = new JPasswordField();
    	
    	usernameLabel = new JLabel("Username: ");
    	passwordLabel = new JLabel("Password: ");
    	
    	button = new JButton("Login");//action listener to be added
    	
    	radioButton1 = new JRadioButton("admin");
    	radioButton2 = new JRadioButton("trainer");
    	radioButton3 = new JRadioButton("gym user");
    		
    	usernameLabel.setBounds(175,100,150,25);
    	passwordLabel.setBounds(175,150,150,25);
    	
    	username.setBounds(250,100,150,25);
    	password.setBounds(250,150,150,25);
    	
    	button.setBounds(250,250,75,25);
    	
    	radioButton1.setBounds(175,200,100,30);
    	radioButton2.setBounds(275,200,100,30);
    	radioButton3.setBounds(375,200,100,30);
    	
    	button.addActionListener(this);
    		
    	
    	
    	ButtonGroup bg = new ButtonGroup();
    	bg.add(radioButton1);
    	bg.add(radioButton2);
    	bg.add(radioButton3);
    	
    	/*radioButton1.addActionListener(this);
    	radioButton2.addActionListener(this);
    	radioButton3.addActionListener(this);*/
    	
    	this.add(username);
    	this.add(password);
    	this.add(passwordLabel);
    	this.add(button);
    	this.add(usernameLabel);
    	this.add(radioButton1);
    	this.add(radioButton2);
    	this.add(radioButton3);
    	
    	this.setLayout(null);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String passwordField = password.getText();
		String usernameField = username.getText();
		//JButton clicked = (JButton)e.getSource();
		
		if(usernameField.equals ("admin") && passwordField .equals("admin") && radioButton1.isSelected())
		{
			System.out.println("admin");
			JOptionPane.showMessageDialog(this,"Logged in as admin");
			
		}
		
		if(usernameField.equals("user") && passwordField .equals("1234") && radioButton3.isSelected())
		{
			GymUser user=new GymUser("abc");
			JOptionPane.showMessageDialog(this,"Logged in as user");
			new GymUserPage(user);
			dispose();
		}
		if(usernameField.equals( "trainer") && passwordField.equals("1234")  && radioButton2.isSelected())
		{
			JOptionPane.showMessageDialog(this,"Logged in as trainer");
		}
		
		
	}
    
    
	

}
