package AbstractTypes;
import java.awt.*;
import java.net.*;

public class Administrator extends User {

	public Administrator(String username)
	{
		this.username = username;
	}
	public void orderEquipment() {
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI("http://www.google.com");
			  desktop.browse(oURL);
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}

}
