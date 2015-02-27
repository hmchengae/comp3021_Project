package unit;

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
	
	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		else
		{
			
			if(o.getClass().getName().equals(this.getClass().getName()) == true)
			{
				User temp = (User) o;
				
				if(temp.getUserID() == userID && temp.getUserEmail().equals(userEmail)
					&& temp.getUserName().equals(userName))
				{
					return true;
				}
			}
			
		}
		
		//reach here = not same class
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		
		hashCode = hashCode + userName.hashCode();
		hashCode = hashCode + userEmail.hashCode();
		hashCode = hashCode + userID;
		
		return hashCode;
	
	}
	
}
