package com.example.sriramhariharan.cypressfallsapp;

import java.util.ArrayList;

public class ThreadFaculty extends Thread {

	private ArrayList<Teacher> faculty;

	public void run() {
		faculty = Retriever.getFaculty();
	}

	public ArrayList<Teacher> getFacutly() {
		return faculty;
	}

}
