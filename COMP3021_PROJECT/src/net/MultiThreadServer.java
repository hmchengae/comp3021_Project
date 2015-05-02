package net;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

	public static final int PORT = 3021;

	private static int vistorCounter = 1;
	
	public int getVistorCounter() {
		return vistorCounter;
	}


	public void setVistorCounter(int vistorCounter) {
		MultiThreadServer.vistorCounter = vistorCounter;
	}


	public static void main(String [] args)
	{

		try
		{
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				
				Runnable runHandler = new ThreadHandler(vistorCounter, clientSocket);
				Thread temp = new Thread(runHandler);
				temp.start();
				
				System.out.println("Get a new connection");
				
				++vistorCounter;
				
			}

		}
		catch (Exception e)
		{
			System.out.print("THERE ARE SOME PROBLEMs");
			e.printStackTrace();
		}
	}
	
	
}
