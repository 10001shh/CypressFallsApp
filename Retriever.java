package com.example.sriramhariharan.cypressfallsapp;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Retriever {
	public static ArrayList<Course> getCourses(String username, String password) {
		ThreadGrades tg = new ThreadGrades(username, password);
		ThreadAssign ta = new ThreadAssign(username, password);
		ThreadFaculty tf = new ThreadFaculty();

		tg.start();
		ta.start();
		tf.start();
		try {
			tg.join();
			ta.join();
			tf.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		Scanner inFromServer = new Scanner(tg.getGrades());
		ArrayList<Course> courses = new ArrayList<Course>();
		inFromServer.nextLine();
		String response = inFromServer.nextLine();
		while(!response.equals("close")) {
			courses.add(
					new Course(response, inFromServer.nextLine(), inFromServer.nextLine(), inFromServer.nextLine()));
			response = inFromServer.nextLine();
		}

		inFromServer = new Scanner(ta.getAssign());

		response = inFromServer.nextLine();
		while(!response.equals("close")) {
			String id = response;
			String assignments = "";
			inFromServer.nextLine();
			response = inFromServer.nextLine();
			while(!response.equals("NC")) {
				assignments += response + "\n";
				response = inFromServer.nextLine();
			}
			for(Course c : courses)
				if(id.equals(c.getId())) {
					c.setAssignments(assignments);
					break;
				}
			response = inFromServer.nextLine();
		}

		ArrayList<Teacher> faculty = tf.getFacutly();
		for(Course c : courses) {
			int t = Collections.binarySearch(faculty, c.getTeacher());
			if(t >= 0)
				c.setTeacher(faculty.get(t));
		}

		return courses;
	}

	public static String getName(String username, String password) {
		try {
			Socket clientSocket = new Socket("173.227.86.24", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("getname " + username + " " + password + "\n");
			Scanner inFromServer = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
			return inFromServer.nextLine();
		} catch(Exception e) {
			return null;
		}
	}

	public static boolean logInTest(String username, String password) {
		try {
			Socket clientSocket = new Socket("173.227.86.24", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("logintest " + username + " " + password + "\n");
			Scanner inFromServer = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
			return inFromServer.nextLine().equals("success");
		} catch(Exception e) {
			return false;
		}
	}

	public static ArrayList<Teacher> getFaculty() {
		try {
			Socket clientSocket = new Socket("173.227.86.24", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("getfaculty\n");
			Scanner inFromServer = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
			ArrayList<Teacher> teachers = new ArrayList<Teacher>();
			String response = inFromServer.nextLine();
			while(!response.equals("close")) {
				teachers.add(new Teacher(response, inFromServer.nextLine(), inFromServer.nextLine()));
				response = inFromServer.nextLine();
			}
			return teachers;
		} catch(Exception e) {
			return null;
		}
	}

	public static ArrayList<Sport> getSports() {
		try {
			Socket clientSocket = new Socket("173.227.86.24", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("getsports\n");
			Scanner inFromServer = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
			ArrayList<Sport> sports = new ArrayList<Sport>();
			String response = inFromServer.nextLine();
			while(!response.equals("close")) {
				sports.add(new Sport(response, inFromServer.nextLine(), inFromServer.nextLine(),
						inFromServer.nextLine(), inFromServer.nextLine(), inFromServer.nextLine(),
						inFromServer.nextLine(), inFromServer.nextLine()));
				response = inFromServer.nextLine();
			}
			Collections.sort(sports);
			return sports;
		} catch(Exception e) {
			return null;
		}
	}

}
