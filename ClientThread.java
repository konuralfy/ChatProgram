/**
 * Multithreading class for Clients
 * 
 * @author  Konuralp
 */

import java.io.*;
import java.net.*;

public class ClientThread extends Message{
	DataInputStream dis;
	DataOutputStream dos;
	Socket s;
	public final Runnable Send;
	public final Runnable Get;

	public ClientThread(Socket s,String nickname) throws IOException{
		s=s;
		
		dos= new DataOutputStream(s.getOutputStream());
		dis= new DataInputStream(s.getInputStream());
		
		Send= new Runnable() {
			public void run() {
				try {
					ClientThread.this.SendMessage(dos,nickname);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		Get= new Runnable() {
			public void run() {
				ClientThread.this.GetMessage(dis);
			}
		};
		
	}
	
	
}
