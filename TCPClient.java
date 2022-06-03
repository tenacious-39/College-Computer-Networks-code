//Developed by - Kritidipta Ghosh
// Developed on - 13 <Apr> 2022

import java.io.*;
import java.net.*;

public class TCPClient {
	private static Socket socket;

	public static void main(String args[]) {
		try {
			String host = "127.0.0.1";
			int port = 2500;
			socket = new Socket(host, port);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			String sendMessage = s + "\n";
			bw.write(sendMessage);
			bw.flush();
			System.out.println("Sent it to server : " + sendMessage + "\n");

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(socket);
			String message = br.readLine();
			System.out.println("Received from server : " + message + "\n");
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}
}