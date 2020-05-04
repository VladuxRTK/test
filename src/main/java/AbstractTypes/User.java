package AbstractTypes;

public abstract class User {
	protected String username;
	protected String password;
	
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getUsername()
	{
		return this.username;
	}
}
