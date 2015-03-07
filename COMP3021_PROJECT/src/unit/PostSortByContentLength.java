package unit;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post> 
{

	@Override
	public int compare(Post o1, Post o2) 
	{

		if(o1.getContent().length() > o2.getContent().length())
		{
			return 1;
		}
		else if(o1.getContent().length() < o2.getContent().length())
		{
			return -1;
		}
		
		//means equal
		return 0;
	}

}
