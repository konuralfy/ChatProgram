/**
 * This is the main class of clients.
 * More than 1 client can connect to preset Server
 * 
 * @author  Konuralp
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
	
	static String nickname;
	static Scanner s = new Scanner(System.in);
	static String host = "localhost";
	static int port = 2221;
	
	public static void main(String[] args) {
		try {
			System.out.println("Please choose a nickname: ");
			nickname = s.nextLine();
			System.out.println("Connecting to the server");
			Socket s =new Socket(host,port);		
			ClientThread ct = new ClientThread(s,nickname);
			System.out.println("Connected to Server: " + host + " Port: "+ port);
			new Thread(ct.Send).start();
			new Thread(ct.Get).start();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}