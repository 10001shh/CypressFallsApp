package com.example.sriramhariharan.cypressfallsapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

	private String subject;
	private Teacher teacher;
	private String id;
	private double average;
	private ArrayList<Assignment> assignments;

	public Course(String subject, String teacher, String id, String average) {
		setSubject(subject);
		setTeacher(new Teacher(teacher));
		setId(id);
		try {
			setAverage(Double.parseDouble(average));
		} catch(NumberFormatException e) {
			setAverage(Double.NaN);
		}
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void setAssignments(String assignments) {
		this.assignments = new ArrayList<Assignment>();
		Scanner input = new Scanner(assignments);
		while(input.hasNext()) {
			String name = input.nextLine();
			String catagory = input.nextLine();
			try {
				this.assignments.add(new Assignment(name, catagory, Double.parseDouble(input.nextLine())));
			} catch(NumberFormatException e) {
				this.assignments.add(new Assignment(name, catagory, Double.NaN));
			}
		}
	}

	public String getSubject() {
		return subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public String getId() {
		return id;
	}

	public double getAverage() {
		return average;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public String toString() {
		return String.format("%s %s %s %.2f %s", getSubject(), getTeacher(), getId(), getAverage(), getAssignments());
	}

}
