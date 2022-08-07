package _02_Chat_Application;

import java.net.*;
import java.io.*;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {

	public static void main(String[] args) {
		String ip = "localhost";
		int port = 8081;
		try {
			Socket s1 = new Socket(ip, port);
			DataOutputStream dOutput = new DataOutputStream(s1.getOutputStream());
			dOutput.writeUTF("message to server");
			DataInputStream dInput = new DataInputStream(s1.getInputStream());
			System.out.println(dInput.readUTF());
			s1.close();
		} catch (IOException e) {

		}
	}


	
	
}
