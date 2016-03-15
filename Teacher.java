package com.example.sriramhariharan.cypressfallsapp;

public class Teacher implements Comparable<Teacher> {
	private String name;
	private String website;
	private String email;

	public Teacher(String name) {
		setName(name);
	}

	public Teacher(String name, String website, String email) {
		setName(name);
		setWebsite(website);
		setEmail(email);
	}

	public void setName(String name) {
		String[] n = name.split("\\W+");
		this.name = n[0] + ", " + n[1];
	}

	public void setWebsite(String website) {
		if(!website.equals("none"))
			this.website = website;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getWebsite() {
		return website;
	}

	public String getEmail() {
		return email;
	}

	public int compareTo(Teacher teacher) {
		String teacher1 = getName().toLowerCase();
		String teacher2 = teacher.getName().toLowerCase();
		if(teacher1.contains(teacher2) || teacher2.contains(teacher1))
			return 0;
		return teacher1.compareTo(teacher2);
	}

	public String toString() {
		return String.format("%s %s %s", getName(), getWebsite(), getEmail());
	}

}
