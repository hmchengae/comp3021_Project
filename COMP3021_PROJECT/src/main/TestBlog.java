package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import blog.Blog;
import unit.Post;
import unit.User;

public class TestBlog 
{

	public static void main(String [] args)
	{
		
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "Comp3021", "Comp3021@ust.hk");
		Blog myBlog = new Blog(user);			
		String prompt = "";
		
		while(!(prompt = testBlog.getInput()).equals("exit"))
		{
			
			if(prompt.equals("list"))
			{
				myBlog.list();
			}
			else if(prompt.startsWith("post"))
			{
				
				if(prompt.length() <= "post".length())
				{
					continue;
				}
				
				Date date = new Date();
				String content = new String(prompt.substring("post".length()+1));
				Post post = new Post(date, content);
				myBlog.post(post);
			}
			else if(prompt.startsWith("delete"))
			{
				String number = prompt.substring("delete".length()+1);
				try
				{
					int index = Integer.parseInt(number);
					myBlog.delete(index);
				}
				catch (Exception e)
				{
					System.out.println("Please enter a valid number.");
				}
			}
		}
		
	}
	
	public String getInput()
	{
		String line = "";
		System.out.print("Enter your prompt: ");
		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return line;
	}
	
}
