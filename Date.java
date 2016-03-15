package com.example.sriramhariharan.cypressfallsapp;


public class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;

	public Date(String date) {
		String[] s = date.split("\\W");
		setDay(Integer.parseInt(s[1]));
		setMonth(Integer.parseInt(s[0]));
		setYear(Integer.parseInt(s[2]));
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int compareTo(Date date) {
		if(getYear() != date.getYear())
			return getYear() - date.getYear();
		if(getMonth() != date.getMonth())
			return getMonth() - date.getMonth();
		if(getDay() != date.getDay())
			return getDay() - date.getDay();
		return 0;
	}

	public String toString() {
		return String.format("%d/%d/%d", getMonth(), getDay(), getYear() % 100);
	}
}
