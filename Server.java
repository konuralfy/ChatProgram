/**
 * Main class of server.
 * Server can accept whenever a client tries to connect.
 * Also server can send message to clients.
 * 
 * @author  Konuralp
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server{
	static Socket s;
	static DataInputStream dis;
	static DataOutputStream dos;

	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2221);
			while(true){
				s = server.accept();
				dos= new DataOutputStream(s.getOutputStream());
				dis= new DataInputStream(s.getInputStream());
				ServerThread st = new ServerThread(dis,dos);
				new Thread(st.Send).start();
				new Thread(st.Get).start();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
}