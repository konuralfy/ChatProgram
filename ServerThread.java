/**
 * Multithreading class for Server
 * 
 * @author  Konuralp
 */

import java.io.*;
import java.net.*;

public class ServerThread extends Message{
	final DataInputStream dis;
	final DataOutputStream dos;
	ServerSocket server;
	Socket s;
	public final Runnable Send;
	public final Runnable Get;

	public ServerThread(DataInputStream dis, DataOutputStream dos) throws IOException {
		this.dis=dis;
		this.dos=dos;
		
		Send= new Runnable() {
			public void run() {
				try {
					ServerThread.this.SendMessage(dos,"Server");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		Get= new Runnable() {
			public void run() {
				ServerThread.this.GetMessage(dis);
			}
		};
		

	}
	
}
