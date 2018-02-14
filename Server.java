import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server{
	static Scanner s = new Scanner(System.in);

	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2221);
			ServerThread st = new ServerThread(server);
			new Thread(st.Send).start();
			new Thread(st.Get).start();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
}