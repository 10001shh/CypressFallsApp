package com.example.sriramhariharan.cypressfallsapp;

public class Assignment {
	private String name;
	private String category;
	private double score;

	public Assignment(String name, String category, double score) {
		setName(name);
		setCategory(category);
		setScore(score);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getScore() {
		return score;
	}

	public String toString() {
		return String.format("%s %s %.2f", getName(), getCategory(), getScore());
	}

}
