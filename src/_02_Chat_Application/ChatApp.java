package _02_Chat_Application;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import _02_Chat_Application.Client1;
import _02_Chat_Application.Server1;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame {

	JButton button = new JButton("CLICK");

	Server1 server1;
	Client1 client1;

	public static void main(String[] args) {
		new ChatApp();
	}

	public ChatApp() {

		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "Buttons!",
				JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			server1 = new Server1(8080);
			setTitle("SERVER");
			JOptionPane.showMessageDialog(null,
					"Server started at: " + server1.getIPAddress() + "\nPort: " + server1.getPort());
			button.addActionListener((e) -> {
				server1.sendClick();
			});
			add(button);
			setVisible(true);
			setSize(400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			server1.start();

		} else {
			setTitle("CLIENT");
			String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
			String prtStr = JOptionPane.showInputDialog("Enter the port number");
			int port = Integer.parseInt(prtStr);
			client1 = new Client1(ipStr, port);
			button.addActionListener((e) -> {
				client1.sendClick();
			});
			add(button);
			setVisible(true);
			setSize(400, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			client1.start();
		}
	}

}
