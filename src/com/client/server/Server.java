/**
 * The code has been referenced from 
 * https://stackoverflow.com/questions/2165006/simple-java-client-server-program
 * https://stackoverflow.com/questions/15247752/gui-client-server-in-java
 * https://github.com/sumanthl158/Thesaurus
 * https://stackoverflow.com/questions/5113614/about-jdbc-beginner-tutorial
 * Several other references from Google.
 * 
 * 
 * 
 * Class: Server (Socket & GUI)
 * It is made to receives request from client and generate response. 
**/
package com.client.server;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server 
{
	private int port = 1235;
	private ServerSocket server = null;
	private Socket clientSocket;
	private JTextArea serverMonitorLog;
	private JFrame serverMonitorwindow;

		/* Creation of Server GUI
	 */
	synchronized void createServer()
	{
		try
		{
			serverMonitorwindow = new JFrame("Server");
			serverMonitorwindow.setSize(450,280);
			serverMonitorwindow.getContentPane().setLayout(null);
			serverMonitorwindow.getContentPane().setBackground(new Color(105,202,191));
			serverMonitorwindow.getContentPane().setForeground(Color.white);
			serverMonitorwindow.setResizable(false);
			serverMonitorwindow.setLocationRelativeTo(null);

			serverMonitorLog = new JTextArea(30,30);
			serverMonitorLog.setEditable(false);
			JScrollPane scrollserverMonitorWindow = new JScrollPane(serverMonitorLog);
			scrollserverMonitorWindow.setBounds(10, 10, 400, 200);
			serverMonitorwindow.add(scrollserverMonitorWindow);
			serverMonitorwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			serverMonitorwindow.setVisible(true);
			startServer();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(serverMonitorwindow,"A problem occured with server, please try again later!","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} 
	}
	
	 /* It starts socket server and listens for input from client 
	 */
	private void startServer()
	{
		try
		{
			serverMonitorLog.append("Connecting to port " + port + " ....\n");
			server = new ServerSocket(port);
			serverMonitorLog.append("Server is now up and running\n");
			
			while(true)
			{
				clientSocket = server.accept();
				SocketHandler c = new SocketHandler(clientSocket);
				c.start();
			}
			
		}
		catch (SocketException se)
		{
			JOptionPane.showMessageDialog(serverMonitorwindow,"Server is already running!","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(serverMonitorwindow,"Unable to connect to the specified port, please try again!","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		finally
		{
			if(server!=null)
				try
			{
					server.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(serverMonitorwindow,"A Problem occured while running server, please try again!","Error",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}       
	}
	
	/* It reads data from client end and searches in Database for the word synonym,
	   it sends back the synonym for selected word. 
	 */
	private class SocketHandler extends Thread
	{
		private Socket clientSocket;

		public SocketHandler(Socket clientSocket)
		{            
			super("socketHandler");
			this.clientSocket = clientSocket;
		}

		public synchronized void run()
		{
			try
			{
				BufferedReader streamIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintStream streamOut = new PrintStream(clientSocket.getOutputStream(), true);
				while(true){
					String selectedWord = streamIn.readLine();
					StringBuilder synonmys=null;
					StringBuilder userGUIOutput;
					/*
					 * If no word is selected on client interface or 
					 * if the word is not found in the database,
					 * append null to the string sent to client. 
					 */
					if(selectedWord.equalsIgnoreCase("null"))
					{
						userGUIOutput=new StringBuilder("0");
					}
					else
					{
						synonmys= new ThesaurusDao().getSynonyms(selectedWord.trim());
						if (synonmys!=null)
						{
							userGUIOutput=new StringBuilder(synonmys);
						}
						else
						{
							userGUIOutput=new StringBuilder("");
						}
					}	
					streamOut.println(userGUIOutput);
					//To display the selected word on server GUI
					if(selectedWord.equalsIgnoreCase("null"))
					{
						 serverMonitorLog.append("\nSelected word : No word selected");
					}
					else
					{
					    serverMonitorLog.append("\nSelected word : "+selectedWord);
					}
					
				}
			}
			catch(Exception e)
			{
				serverMonitorLog.append("\n"+e.getMessage());
			}
			finally
			{
				try
				{
					clientSocket.close();
				}
				catch(IOException e){
					serverMonitorLog.append("\n"+e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		new Server().createServer();
	}
}