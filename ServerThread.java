import java.io.*;
import java.net.*;

public class ServerThread extends Message{
	DataInputStream dis;
	DataOutputStream dos;
	ServerSocket server;
	public final Runnable Send;
	public final Runnable Get;

	public ServerThread(ServerSocket server) throws IOException {
		server=server;
		Socket s;
		s = server.accept();
		dos= new DataOutputStream(s.getOutputStream());
		dis= new DataInputStream(s.getInputStream());
		
		Send= new Runnable() {
			public void run() {
				try {
					ServerThread.this.SendMessage(dos);
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
