package MainApp;
import AbstractTypes.GymUser;
import javax.swing.*;
public class GymUserPage extends JFrame{
	public GymUserPage(GymUser user)
	{
		JLabel text = new JLabel("Welcome " + user.getUsername());
		text.setBounds(150,200,125,30);
		
		this.setSize(600,600);
		this.add(text);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
