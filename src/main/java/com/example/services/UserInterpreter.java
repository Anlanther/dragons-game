package com.example.services;

import java.util.Scanner;

import com.example.entities.Attack;
import com.example.entities.Dragon;

public class UserInterpreter {
	private Scanner input = new Scanner(System.in);

	public String getDragonSelection() {
		int i = input.nextInt();
		if (i == 1) {
			return "Ruby";
		} else if (i == 2) {
			return "Jade";
		} else if (i == 3) {
			return "Aqua";
		} else
			return null;
	}

	public String getMenuSelection() {
		int i = input.nextInt();
		if (i == 1) {
			return "Stats";
		} else if (i == 2) {
			return "Adventure";
		} else if (i == 3) {
			return "Heal";
		} else if (i == 4) {
			return "Run away";
		} else
			return null;
	}

	public String getAdventureSelection() {
		int i = input.nextInt();
		if (i == 1) {
			return "Attack";
		} else if (i == 2) {
			return "Run Away";
		} else
			return null;
	}

	public Attack getAction(Dragon dragon) {
		int i = input.nextInt();
		if (i == 1) {
			return dragon.getTypeAttack();
		} else if (i == 2) {
			return dragon.getNormalAttack();
		} else if (i == 3) {
			return null;
		} else {
			return null;// return attack entity
		}
	}

	public int getMenuPrompt() {
		String i = input.next();
		if (i.equals("y")) {
			return 0;
		} else {
			return 1;
		}
	}

}
