package MainApp;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import AbstractTypes.Administrator;


public class OrderEquipmentPage extends JFrame implements ActionListener {

	private JButton orderButton;
	private JButton checkTrainerSuggestion;
	private JButton placeOrder;
	private JTable suggestionTable;
	private JScrollPane jp;
	private Scanner s;
	private File file;
	private JFrame orderFrame;
	private JFrame checkSuggestionFrame;
	private JTextArea orderArea;
	private ArrayList<String> suggestionList = new ArrayList<String>();
	private Administrator admin;
	
	public OrderEquipmentPage(String name,Administrator admin)
	{
		this.admin = admin;
		this.setTitle("Order Equipment Page");
		orderArea = new JTextArea();
		placeOrder = new JButton("Place order");
		orderButton = new JButton("Order equipment");
		orderArea = new JTextArea();
		checkTrainerSuggestion = new JButton("Check trainer suggestion");
		orderButton.setBounds(50,200,200,100);
		orderButton.addActionListener(this);
		placeOrder.setBounds(175,400,200,100);
		createTable();
		orderFrame = new JFrame("Order equipment");
		orderArea.setBounds(124,150,300,200);
		orderFrame.add(orderArea);
		orderFrame.setSize(600,600);
		orderFrame.setLayout(null);
		orderFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		orderFrame.add(placeOrder);
		placeOrder.addActionListener(this);
		checkTrainerSuggestion.addActionListener(this);
		checkTrainerSuggestion.setBounds(325,200,200,100);
		this.add(orderButton);
		this.add(checkTrainerSuggestion);
		this.setSize(600,600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	
	
	public void readSuggestionFile()
	{
		file = new File("src/main/java/suggestions");
		try {
			s = new Scanner(file);
			
			while (s.hasNextLine()){
			    suggestionList.add(s.nextLine());
			}
			s.close();
		
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable()
	{
		readSuggestionFile();
		int counter=0;
		for(int i=0;i<suggestionList.size();i++)
		{
			if(i%2==1)
			{
				counter++;
			}
		}
		String column[]={"NAME","SUGGESTION"};
		String[][] stuff  = new String[counter][2];
		int k=0;
		for(int i=0;i<counter;i++)
		{
			for(int j=0;j<2;j++)
			{
				stuff[i][j] = suggestionList.get(k);
				k++;
			}
		}
		suggestionTable = new JTable(stuff,column);
		suggestionTable.setBounds(400,400,200,300);
		jp =new JScrollPane(suggestionTable);   
		checkSuggestionFrame = new JFrame("Suggestions from trainers");
		
		checkSuggestionFrame.setSize(800,800);
		checkSuggestionFrame.add(jp);
		checkSuggestionFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    
	  
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		String data = orderArea.getText().trim();
		if(clicked == checkTrainerSuggestion)
		{
			checkSuggestionFrame.setVisible(true);
		}
		if(clicked == orderButton)
		{
			orderFrame.setVisible(true);
		}
		if(clicked == placeOrder && data.length()>0)
		{
			
		    admin.orderEquipment();
		}
	}
}
