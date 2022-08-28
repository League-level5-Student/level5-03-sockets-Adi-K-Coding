package _02_Chat_Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client1 {

	private String ip;
	private int port;

	Socket connection;

	ObjectOutputStream os;
	ObjectInputStream is;
	
	ChatApp ca;

	public Client1(String ip, int port, ChatApp ca) {
			this.ip = ip;
			this.port = port;
			this.ca = ca;
		}

	public void start() {
		try {

			connection = new Socket(ip, port);

			os = new ObjectOutputStream(connection.getOutputStream());
			is = new ObjectInputStream(connection.getInputStream());

			os.flush();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (connection.isConnected()) {
			try {
//				JOptionPane.showMessageDialog(null, is.readObject());
				System.out.println(is.readObject());
				ca.label.setText(is.readObject()+"");
				ca.pack();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendClick(String input) {
		try {
			if (os != null) {
				os.writeObject(input);
				os.flush();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
