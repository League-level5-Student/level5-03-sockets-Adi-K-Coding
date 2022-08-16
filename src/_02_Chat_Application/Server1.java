package _02_Chat_Application;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class Server1 extends Thread {
	ServerSocket sg;

	public Server1() throws IOException {

		sg = new ServerSocket(8080);
	}

	public void run() {
		Boolean b = true;
		while (b) {

			try {

				System.out.println("server is waiting for client to connect");

				Socket sock = sg.accept();
				System.out.println("The client has connected");
				DataInputStream dInput1 = new DataInputStream(sock.getInputStream());
				System.out.println(dInput1.readUTF());
				DataOutputStream dOutput1 = new DataOutputStream(sock.getOutputStream());
				String uInput = JOptionPane.showInputDialog("Enter an input to send to the server");
				dOutput1.writeUTF(uInput);

			} catch (SocketTimeoutException e) {

				System.out.println("Socket timeout");
				b = false;

			} catch (IOException e1) {
				System.out.println("caught IOException");
				b = false;
			}
		}

	}

	public static void main(String[] args) {

		Thread t;
		try {
			t = new Thread(new Server1());
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
