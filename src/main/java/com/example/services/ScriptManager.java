package com.example.services;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.example.entities.Attack;
import com.example.entities.Dragon;

public class ScriptManager {
	private Random randoAttack = new Random();
	private int attack = randoAttack.nextInt(4);

	public void printWelcome() {
		System.out.println("Welcome! Are you ready to start your adventure with a dragon of your very own?\n");
		addWait(3);
		System.out.println("During your adventure, you will work with your dragon partner to battle other dragons and "
				+ "\nboost your score as you go. The aim is to get as high of a score you can without having "
				+ "\nyour dragon faint or you will have to begin again.\n");
		addWait(3);
		System.out.println("To start, pick your dragon partner for this adventure!");
		addWait(3);
		System.out.println("1)\n" + "Name: Ruby\n" + "Type: Fire\n" + "HP: 100\n" + "Attacks: \n" + "\tFire Breath: \n"
				+ "\t\tDmg: 34\n" + "\t\tType: Fire\n" + "\tTail wham:\n" + "\t\tDmg 30\n" + "\t\tType: Normal\n"
				+ "2)\n" + "Name: Jade\n" + "Type: Earth\n" + "HP: 100\n" + "Attacks: \n" + "\tGround pound: \n"
				+ "\t\tDmg: 34\n" + "\t\tType: Earth\n" + "\tTail wham:\n" + "\t\tDmg: 30\n" + "\t\tType: Normal\n"
				+ "3)\n" + "Name: Aqua\n" + "Type: Water\n" + "HP: 100\n" + "Attacks: \n" + "\tWater jet: \n"
				+ "\t\tDmg: 34\n" + "\t\tType: Water\n" + "\tTail wham:\n" + "\t\tDmg: 30\n" + "\t\tType Normal");
		System.out.println("Input 1, 2, or 3 to make your selection in the next line: ");
	}

	public void printWelcomeEnd(Dragon dragon) {
		System.out
				.println("\nCongratulations! You have selected your quest companion, " + dragon.getDragonName() + "!");
		addWait(3);
	}

	public void printMainMenu(int userScore) {
		System.out.println("\nWhat would you like to do now?" + "\nUser Experience Points: " + userScore);
		System.out.println("\n1) See stats of dragon\n" + "\n" + "2) Go exploring and gain experience points\n" + "\n"
				+ "3) Go to town to heal\n" + "\n" + "4) Stop playing \n");
		addWait(3);
	}

	public void printStats(Dragon userDragon) {
		System.out.println("\nName: " + userDragon.getDragonName() + "\nType: " + userDragon.getDragonType() + "\nHP: "
				+ userDragon.getDragonHp() + "\nAttacks: \n\t" + userDragon.getTypeAttack().getAttackName()
				+ "\n\t\tDmg: " + userDragon.getTypeAttack().getAttackDamage() + "\n\t\tType: "
				+ userDragon.getTypeAttack().getAttackType() + "\n\t" + userDragon.getNormalAttack().getAttackName()
				+ "\n\t\tDmg: " + userDragon.getNormalAttack().getAttackDamage() + "\n\t\tType: "
				+ userDragon.getNormalAttack().getAttackType());
		addWait(3);
	}

	public void printEnd(int userScore) {
		System.out.println("\nGame over. \n" + "Final score: " + userScore);
	}

	public void printHeal(String dragonName) {
		if (attack % 2 == 0) {
			System.out.println("\nYou want to make sure you and your dragon are all well taken care of "
					+ "\nand so you go to town to rest and have a healer check over your companion. \n" + dragonName
					+ " is now now fully healed.");
		} else {
			System.out.println("\nYou rush to the town and have a healer check on your dragon while also "
					+ "\ntaking a well deserved break. After a quick nap and some snacks you and your "
					+ "\ndragon are ready to set off again. ");
			System.out.println("\n" + dragonName + " is now now fully healed.");
		}
		addWait(3);
	}

	public void printAdventure(String dragonName) {
		if (attack % 2 == 0) {
			System.out.println("\nAs you travel far and wide across mountains and rivers to see new views, you"
					+ "\naccidentally trip on a rock and fall into a hole. Worried about you, " + dragonName
					+ " lept to "
					+ "\nyour aid, but as you get your bearings, you suddenly find another pair of eyes staring at you.");
		} else {
			System.out.println("\nYou head towards the plains looking forward to the wind and open air. "
					+ "\nAfter walking for a while you give in and decide to take a nap in the soft grass "
					+ "\nas your dragon frolics around you. Suddenly you are awoken to growls and a loud thump. "
					+ "\nYou awaken to " + dragonName
					+ " standing protectively over you as another dragon circles around");
		}
		addWait(3);
		System.out.println("\nWhat will you do?\n");
		addWait(3);
		System.out.println("1) Attack\n" + "2) Run away");
		addWait(3);
	}

	public void printAttackSelection(Dragon dragon, Dragon enemyDragon) {
		System.out.println("\nYour dragon:\n" + "\tName: " + dragon.getDragonName() + "\n\tType: "
				+ dragon.getDragonType() + "\n\tHP: " + dragon.getDragonHp() + "\n\nEnemy dragon:\n" + "\tName: "
				+ enemyDragon.getDragonName() + "\n\tType: " + enemyDragon.getDragonType() + "\n\tHP: "
				+ enemyDragon.getDragonHp());
		addWait(3);
		System.out.println("\nWhat should your dragon do now?\n" + "1) Use " + dragon.getTypeAttack().getAttackName()
				+ "\n2) Use " + dragon.getNormalAttack().getAttackName() + "\n3) Run away");
		addWait(3);
	}

	public void printAttack(Dragon dragon, Attack userAttack, Attack enemyAttack) {
		System.out.println(
				"\n" + dragon.getDragonName() + " used " + userAttack.getAttackName() + " to attack the enemy dragon!\n"
						+ "The enemy dragon used " + enemyAttack.getAttackName() + " to fight back!");
		addWait(3);
	}

	public void printWin() {
		System.out.println("\nThe enemy was defeated! You and your dragon gained 10 experience points from the fight.");
		addWait(3);
	}

	public void printRun() {
		if (attack % 2 == 0) {
			System.out.println(
					"\nYou jump onto your dragon in one fluid moment and fly away before the other dragon even blinks.");
		} else {
			System.out.println(
					"\nYou toss a stone to distract the dragon drawing its attention away from you enough to sneak away quickly.");
		}
		addWait(3);
	}

	public void printlose() {
		System.out.println(
				"\nYour dragon ran out of energy to continue fighting. You have failed to take care of your dragon.");
		addWait(3);
	}

	public void printMainPrompt() {
		System.out.println("\nDo you want to go back to the main menu? (y/n)");
	}

	public void printEndPrompt() {
		System.out.println("\nDo you want to go end the game? (y/n)");
	}

	public void addWait(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
