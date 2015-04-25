package net;

import java.io.PrintWriter;
import java.net.Socket;

public class BlogClient 
{

	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String [] args)
	{
		
		try
		{
			Socket cSocket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(cSocket.getOutputStream(), true);
			
			/*
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextLine()) System.out.println(sc.nextLine());
			*/
			
			String message = new String("I am sending message to the server!!");
			
			//System.out.println("You are sending \"" + message + "\" to server");
			out.println(message);
			//System.out.println("Finish sent");
			
			//not close so fast
			
			cSocket.close();
			System.exit(0);
			
		}
		catch (Exception e)
		{
			System.out.print("THERE ARE SOME PROBLEMs");
			e.printStackTrace();
		}
		
	}
	
}
