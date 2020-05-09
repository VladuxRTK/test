package MainApp;
import javax.swing.*;

import AbstractTypes.GymUser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;




import AbstractTypes.Administrator;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
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
		ArrayList<String> userNameList = new ArrayList<String>();
		ArrayList<String> passwordList = new ArrayList<String>();
		ArrayList<String> roleList = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		try (Reader reader = new FileReader("src/main/java/Resources/users.json")) {
		JSONArray jsonArray = (JSONArray) parser.parse(reader);
		System.out.println(jsonArray);
		Iterator<JSONObject> it = jsonArray.iterator();
		while (it.hasNext()) {
		JSONObject obj = it.next();
		String userName = obj.get("userName").toString();
		String password = obj.get("password").toString();
		String role = obj.get("role").toString();
		/*userNameList.add(obj.get("userName").toString());
		passwordList.add(obj.get("password").toString());*/
		
		if(userName.equals(usernameField) && password.equals(passwordField)  && radioButton1.isSelected() && role.equals("admin"))
		{
			Administrator admin = new Administrator("admin");
			System.out.println("admin");
			JOptionPane.showMessageDialog(this,"Logged in as admin");
			new AdminPage(admin);
			dispose();
		}
		if(userName.equals(usernameField) && password.equals(passwordField)  && radioButton2.isSelected() && role.equals("trainer"))
		{
			
			JOptionPane.showMessageDialog(this,"Logged in as trainer");
			
		}
		if(userName.equals(usernameField) && password.equals(passwordField)  && radioButton3.isSelected() && role.equals("gymUser"))
		{
			
			/*GymUser user=new GymUser(usernameField);
			System.out.println(obj.get("membershipType").toString());
			JOptionPane.showMessageDialog(this,"Logged in as user");
			new GymUserPage(user);
			dispose();*/
		}
		
		//roleList.add(obj.get("role").toString());
		
		}
		} catch (IOException h) {
		h.printStackTrace();
		} catch (ParseException h) {
		h.printStackTrace();
		}
		for(int i=0;i<userNameList.size();i++)
		{
			System.out.println("Username : " + userNameList.get(i) + "\n" + "Password :" + passwordList.get(i));
		}
		/*if(usernameField.equals ("admin") && passwordField .equals("admin") && radioButton1.isSelected())
		{
			Administrator admin = new Administrator("admin");
			System.out.println("admin");
			JOptionPane.showMessageDialog(this,"Logged in as admin");
			new AdminPage(admin);
			dispose();
			
		}
		
		if(userNameList.contains(usernameField) && passwordList.contains(passwordField) && roleList.contains("trainer") && radioButton3.isSelected())
		{
			GymUser user=new GymUser(usernameField);
			JOptionPane.showMessageDialog(this,"Logged in as user");
			new GymUserPage(user);
			dispose();
		}
		if( userNameList.contains(usernameField) && passwordList.contains(passwordField) && roleList.contains("gymUser") && radioButton2.isSelected())
		{
			JOptionPane.showMessageDialog(this,"Logged in as trainer");
		}*/
		
		
	}
    
    
	

}
