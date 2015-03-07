package unit;

public class User implements Comparable<User>
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
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userEmail=" + userEmail + "]";
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userID;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null) {
				return false;
			}
		} else if (!userEmail.equals(other.userEmail)) {
			return false;
		}
		if (userID != other.userID) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(User o) 
	{
		if(this.getUserID() > o.getUserID())
		{
			return 1;
		}
		else if(this.getUserID() < o.getUserID())
		{
			return -1;
		}

		//mean equals
		return 0;
	}



}
