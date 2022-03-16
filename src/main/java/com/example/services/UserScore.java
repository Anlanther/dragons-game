package com.example.services;

import com.example.entities.User;

public class UserScore {

	public void updateScore(User user) {
		int currentScore = user.getScore();
		user.setScore(currentScore + 10);
	}

}
