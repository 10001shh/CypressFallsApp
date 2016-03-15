package com.example.sriramhariharan.cypressfallsapp;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ThreadAssign extends Thread {

	private InputStreamReader assign;
	private String username;
	private String password;

	ThreadAssign(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void run() {
		try {
			Socket clientSocket = new Socket("173.227.86.24", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("getassign " + username + " " + password + "\n");
			assign = new InputStreamReader(clientSocket.getInputStream());
		} catch(Exception e) {

		}
	}

	public InputStreamReader getAssign() {
		return assign;
	}

}
