package de.codingmonk.hackady.core;

import java.awt.Color;

public class Player {
	
	private String name;
	private int points;
	private Color color;
	private String buzzerCode;
	
	
	public String getBuzzerCode() {
		return buzzerCode;
	}
	public void setBuzzerCode(String buzzerCode) {
		this.buzzerCode = buzzerCode;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void addPoints(int points) {
		this.points += points;
	}
	public void removePoints(int points) {
		this.points -= points;
	}
	
	public String toString() {
		return "Playername: " + this.name + ", Points: " + this.points + ", BuzzerCode: " + this.buzzerCode;
	}

}
