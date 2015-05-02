package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
			BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextLine())
			{
				//send to server
				String input = sc.nextLine();
				out.println(input);
				out.flush();
				
				if(input.equals("quit"))
				{
					break;
				}
				
				//should sleep to gain buffer
				Thread.sleep(300);
	
				//Receive server feedback
				String responese = in.readLine();
				System.out.println(responese);
				
				
			}
			
		
			//not close so fast
			sc.close();
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
