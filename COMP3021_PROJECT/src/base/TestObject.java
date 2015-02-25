package base;

import java.util.Date;

public class TestObject 
{

	public static void main(String [] args)
	{
		
		User user = new User(1, "Comp3021", "Comp3021@ust.hk");
		Date date = new Date();
		
				
		String content = "This is my first post";
		FriendsPost fpost = new FriendsPost(date, content, user);
		
		System.out.println(fpost);
		
		System.out.println(fpost.contains("first"));
		System.out.println(fpost.contains("HKUST"));
	}
	
}
