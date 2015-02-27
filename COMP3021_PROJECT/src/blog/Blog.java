package blog;

import java.util.ArrayList;

import unit.*;

public class Blog 
{
	private User user;
	private ArrayList<Post> postList;
	
	public Blog(User user)
	{
		this.user = user;
		postList = new ArrayList<Post> ();
	}
	
	public void setUser (User input)
	{
		user = input;
	}
	
	public User getUser ()
	{
		return user;
	}
	
	public void post(Post p)
	{
		if(p == null)
			return;
		
		if (postList.contains(p) == true)
		{
			return;
		}
		else
		{
			postList.add(p);
			System.out.println("A new Post:");
			System.out.println(p);
		}
	}
	
	public void list()
	{
		if(postList == null || postList.isEmpty() == true)
		{
			System.out.println("No post.");
			return;
		}
		
		System.out.println("Current Post(s):");
		
		int count = 1;
		for(Post p: postList)
		{
			System.out.print("Post[" + count + "]:");
			System.out.println(p);
			++count;
		}
		
	}
	
	public void delete (int index)
	{
		if(postList == null || postList.isEmpty() == true)
		{
			System.out.println("No post so can't delete!");
		}
		else if(index <= 0 || index > postList.size())
		{
			System.out.println("Illegeal deletetion.");
		}
		else
		{
			//successful deleted
			postList.remove(index-1);
		}
	}
	
	@Override
	public String toString()
	{
		return null;
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
			//the equal condition can be change
			if(o.getClass().getName().equals(this.getClass().getName()) == true)
			{
				Blog temp = (Blog) o;
				if (temp.getUser().equals(user) == true)
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
		hashCode = hashCode + user.hashCode();
		return hashCode;
	
	}
	
}
