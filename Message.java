/**
 * This class controls messages like sending and getting.
 * Censorship can be set here
 * 
 * @author  Konuralp
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Message {

	String SendMessage;
	String GetMessage;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	
	public void SendMessage(DataOutputStream dos,String nickname) throws IOException {
		while(true) {
			SendMessage=br.readLine();
			if(SendMessage.equals("get me out")) {
				System.exit(0);
			}
			dos.writeUTF(nickname+": "+SendMessage);
			System.out.print("");
		}

	}
	
	public void GetMessage(DataInputStream dis){

		try {
			while(true) {
				GetMessage = dis.readUTF();
				System.out.println(GetMessage);
			}
		}catch(IOException e) {
			System.out.print("Connection Lost...");
		}
	}


	
}
