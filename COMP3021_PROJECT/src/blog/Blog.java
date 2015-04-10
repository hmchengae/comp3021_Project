package blog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import unit.*;

public class Blog implements Serializable
{
	
	private static final long serialVersionUID = -716916758200703890L;
	
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
	public String toString() {
		return "Blog [user=" + user + ", postList=" + postList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((postList == null) ? 0 : postList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Blog other = (Blog) obj;
		if (postList == null) {
			if (other.postList != null) {
				return false;
			}
		} else if (!postList.equals(other.postList)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	public void setPosts(ArrayList<Post> allposts) 
	{
		if(allposts != null)
		{
			postList = allposts;
		}
	}
	
	public ArrayList<Post> getPostsList() 
	{
		return postList;
		
	}

	public void search(int i, String string) 
	{

		if(postList == null || postList.size() == 0)
		{
			return;
		}


		Calendar cal = Calendar.getInstance();

		for(Post p: postList)
		{

			cal.setTime(p.getDate());

			int month = cal.get(Calendar.MONTH);
			
			if(month == (i-1))
			{
				if(p.getContent().contains(string) == true)
				{
					System.out.println(p);
				}
			}

		}

	}
	
	public void save(String filepath)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filepath)));
			oos.writeObject(user);
			oos.writeObject(postList);
			oos.flush();
			oos.close();
		}
		catch (Exception e)
		{
			return;
		}

	}
	
	@SuppressWarnings("unchecked")
	public void load(String filepath)
	{
		
		try
		{

			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filepath)));
			//reach here = exists file
			try
			{	
				user = (User) ois.readObject();
				postList = (ArrayList<Post>) ois.readObject();
			}
			catch (Exception e)
			{	
				System.out.println("Casting error!");
			}

			ois.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println("Wait! There is something wrong. I cannot find the file!");
			return;
		}
		catch (Exception e)
		{
			System.out.println("Something Wrong with the file!");
			return;
		}
		
	}


}
