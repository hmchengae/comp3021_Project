package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable
{
	
	private Socket clientSocket = null;
	private int visitorPosition;
	
	public ThreadHandler(int pos, Socket cSocket)
	{
		clientSocket = cSocket;
		visitorPosition = pos;
	}
	
	@Override
	public void run() 
	{
		try 
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
			
			String inputLine;
		
			while(true)
			{
				inputLine = in.readLine();
				
				if(inputLine == null)
				{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(inputLine.equals("visitor"))
				{
					out.println("You're the " + visitorPosition + " visitor today.");
				}
				else if(inputLine.equals("quit"))
				{
					clientSocket.close();
					break;
				}
				else
				{
					out.println("echo: " + inputLine);
				}
				
				out.flush();
				
			}
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}