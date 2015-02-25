package base;

public class User
{

	private int userID;
	private String userName;
	private String userEmail;
	
	public User(int id, String name, String email)
	{
		userID = id;
		userName = name;
		userEmail = email;
	}

	public int getUserID()
	{
		return userID;
	}
	
	
	public String getUserName()
	{
		return userName;
	}
	
	
	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserID(int id)
	{
		userID = id;
	}
	
	public void setUserName(String name)
	{
		userName = name;	
	}
	
	
	public void setUserEmail(String email)
	{
		userEmail = email;
	}
	
	@Override
	public String toString()
	{
		String temp = "";

		temp = "User[userID=" + userID +", userName=" + userName + 
				", userEmail=" + userEmail + "]";

		return temp;
		
	}
	
}
