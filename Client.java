import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
	
	static String nickname;
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Socket s =new Socket("localhost",2221);		
			ClientThread ct = new ClientThread(s);
			new Thread(ct.Send).start();
			new Thread(ct.Get).start();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}