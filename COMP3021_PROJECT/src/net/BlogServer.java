package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer 
{
	public static final int PORT = 3021;
	
	public static void main(String [] args)
	{
		
		try
		{
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			Socket clientSocket = serverSocket.accept();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String inputLine;
			while((inputLine = in.readLine()) != null)
			{
				System.out.println(inputLine);
			}
			
				
			serverSocket.close();
			System.exit(0);
			
		}
		catch (Exception e)
		{
			System.out.print("THERE ARE SOME PROBLEMs");
			e.printStackTrace();
		}
	}
	
}
