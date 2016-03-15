package com.example.sriramhariharan.cypressfallsapp;

public class Time implements Comparable<Time> {

	private int min;

	public Time(String time) {
		if(time.equals("TBA")) {
			setMin(-1);
		} else {
			String[] t = time.split("\\W");
			setMin(60 * (Integer.parseInt(t[0]) + (t[2].equals("PM") ? 12 : 0)) + Integer.parseInt(t[1]));
		}
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMin() {
		return min;
	}

	public int compareTo(Time time) {
		return getMin() - time.getMin();
	}

	public String toString() {
		if(getMin() == -1)
			return "TBA";
		return String.format("%d:%02d %s", getMin() / 60 % 12 > 0 ? getMin() / 60 % 12 : 12, getMin() % 60,
				getMin() / 60 < 12 ? "AM" : "PM");
	}

}
