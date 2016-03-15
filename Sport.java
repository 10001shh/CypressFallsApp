package com.example.sriramhariharan.cypressfallsapp;

public class Sport implements Comparable<Sport> {

	private String gender;
	private String sport;
	private String team;
	private Date date;
	private Time time;
	private String opponent;
	private String location;
	private String score;

	public Sport(String gender, String sport, String team, String date, String time, String opponent, String location,
			String score) {
		setGender(gender);
		setSport(sport);
		setTeam(team);
		setDate(date);
		setTime(time);
		setOpponent(opponent);
		setLocation(location);
		setScore(score);
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setTeam(String team) {
		this.team = team.replaceAll(" -.*", "");
	}

	public void setDate(String date) {
		this.date = new Date(date);
	}

	public void setTime(String time) {
		this.time = new Time(time);
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getGender() {
		return gender;
	}

	public String getSport() {
		return sport;
	}

	public String getTeam() {
		return team;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public String getOpponent() {
		return opponent;
	}

	public String getLocation() {
		return location;
	}

	public String getScore() {
		return score;
	}

	public int compareTo(Sport sport) {
		if(getDate().compareTo(sport.getDate()) != 0)
			return getDate().compareTo(sport.getDate());
		return getTime().compareTo(sport.getTime());
	}

	public String toString() {
		return String.format("%s %s %s %s %s %s %s %s", getGender(), getSport(), getTeam(), getTime(), getDate(),
				getOpponent(), getLocation(), getScore());
	}

}
