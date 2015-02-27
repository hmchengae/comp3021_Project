package unit;

import java.util.Date;

public class Post {

	private Date date;
	private String content;

	public Post(Date date, String content)
	{
		this.date = date;
		this.content = content;
	}
	
	
	public Date getDate()
	{
		return date;
	}

	public String getContent()
	{
		return content;
	}
	
	
	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setContent(String content)
	{
		this.content = content;	
	}
	
	@Override
	public String toString()
	{
		String temp = "";
		temp = date.toString() + "\n" + content;
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
				Post temp = (Post) o;
				if (temp.getContent().equals(content) == true && temp.getDate().equals(date))
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
		
		hashCode = hashCode + content.hashCode();
		hashCode = hashCode + date.hashCode();
		
		return hashCode;
	
	}
	
	public boolean contains(String keyword)
	{
		if (keyword == null)
		{
			return false;
		}
		else
		{
			if (content.contains(keyword) == true)
			{
				return true;
			}
		}	
		
		return false;
		
	}
	
}