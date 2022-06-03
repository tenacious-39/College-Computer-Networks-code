//Developed by - Kritidipta Ghosh
// Developed on - 13 <Apr> 2022

import java.io.*;
import java.net.*;

public class TCPServer {
	private static Socket socket;

	public static void main(String args[]) {
		try {
			System.out.println("Server started.");
			int port = 2500;
			ServerSocket serversocket = new ServerSocket(port);
			socket = serversocket.accept();
			System.out.println("Server started and listening to port 2500");
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String number = br.readLine();
			System.out.println("Received from client" + number + "\n");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(s);
			bw.flush();
			System.out.println("Sent (to " + socket + ") client : " + s + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}
}