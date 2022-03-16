package com.example.entities;

public class User {
	// attributes
	private int score;
	private Dragon dragon;

	// constructor
	public User(int score, Dragon dragon) {
		this.score = score;
		this.dragon = dragon;
	}

	// Getter and setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

}
