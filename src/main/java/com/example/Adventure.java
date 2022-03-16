package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.services.ScriptManager;
import com.example.services.StatManager;
import com.example.services.UserInterpreter;
import com.example.services.UserScore;
import com.example.entities.Attack;
import com.example.entities.Dragon;
import com.example.entities.User;

public class Adventure {
	private ScriptManager script = new ScriptManager();
	private UserInterpreter interpreter = new UserInterpreter();
	private StatManager stat = new StatManager();
	private UserScore score = new UserScore();
	private List<Dragon> dragonsList = new ArrayList<Dragon>();

	public void startAdventure() {
		script.printWelcome();
		List<Dragon> dragons = createDefaults(dragonsList);
		String chosenDragon = interpreter.getDragonSelection();
		User user = createUser(chosenDragon, dragons);
		script.printWelcomeEnd(user.getDragon());
		goToMain(user);
	}

	public void goToMain(User user) {
		script.printMainMenu(user.getScore());
		String menuSelection = interpreter.getMenuSelection();

		if (menuSelection.equals("Stats")) {
			script.printStats(user.getDragon());
			promptBackToMain(user);
		} else if (menuSelection.equals("Adventure")) {
			handleAdventure(user);
		} else if (menuSelection.equals("Heal")) {
			stat.healHp(user.getDragon());
			script.printHeal(user.getDragon().getDragonName());
			promptBackToMain(user);
		} else {
			script.printEnd(user.getScore());
		}
	}

	private void handleAdventure(User user) {
		List<Dragon> leftoverDragons = new ArrayList<Dragon>();
		leftoverDragons = createDefaults(dragonsList);
		int usersDragonIndex = -1;
		for (Dragon dragon : leftoverDragons) {
			if (dragon.getDragonName().equals(user.getDragon().getDragonName())) {
				usersDragonIndex = leftoverDragons.indexOf(dragon);
			}
		}
		if (usersDragonIndex >= 0) {
			leftoverDragons.remove(usersDragonIndex);
		}

		Random dragonIndex = new Random();
		int enemyIndex = dragonIndex.nextInt(leftoverDragons.size() - 1);
		Dragon enemyDragon = leftoverDragons.get(enemyIndex);

		script.printAdventure(user.getDragon().getDragonName());

		String adventureSelection = interpreter.getAdventureSelection();
		if (adventureSelection.equals("Attack")) {
			boolean didRun = startAttackLoop(user, enemyDragon);
			if (didRun) {
				script.printRun();
				promptBackToMain(user);
			}
			if (user.getDragon().getDragonHp() <= 0) {
				script.printlose();
				script.printEnd(user.getScore());
			}
			if (enemyDragon.getDragonHp() <= 0) {
				score.updateScore(user);
				script.printWin();
				promptBackToMain(user);
			}
		} else {
			script.printRun();
			promptBackToMain(user);
		}
	}

	private void promptBackToMain(User user) {
		script.printMainPrompt();
		int userSelection = interpreter.getMenuPrompt();
		if (userSelection == 0) {
			goToMain(user);
		} else {
			script.printEndPrompt();
			int endSelection = interpreter.getMenuPrompt();
			if (endSelection == 0) {
				script.printEnd(user.getScore());
			} else {
				promptBackToMain(user);
			}
		}
	}

	private boolean startAttackLoop(User user, Dragon enemyDragon) {
		Attack userAttack = new Attack("", "", 0, false);
		// TODO Change to do while loop instead
		while (userAttack != null || user.getDragon().getDragonHp() > 0 || enemyDragon.getDragonHp() > 0) {
			script.printAttackSelection(user.getDragon(), enemyDragon);
			userAttack = interpreter.getAction(user.getDragon()); // run should be one of the options still
			if (userAttack == null) {
				break;
			}
			Attack enemyAttack = stat.captureAttacks(userAttack, user.getDragon(), enemyDragon);
			if (user.getDragon().getDragonHp() <= 0 || enemyDragon.getDragonHp() <= 0) {
				break;
			}
			script.printAttack(user.getDragon(), userAttack, enemyAttack);
		}
		if (userAttack == null) {
			return true;
		}
		return false;
	}

	private List<Dragon> createDefaults(List<Dragon> dragons) {
		List<Dragon> defaultDragons = new ArrayList<>();
		Attack mainFire = new Attack("Fire Breath", "Fire", 34, true);
		Attack mainEarth = new Attack("Ground Pound", "Earth", 34, true);
		Attack mainWater = new Attack("Water jet", "Water", 34, true);
		Attack mainNormal = new Attack("Tail Whip", "Normal", 30, false);
		Attack otherNormal = new Attack("Claw Slash", "Normal", 20, false);

		Dragon ruby = new Dragon("Ruby", "Fire", 100, mainFire, mainNormal);
		Dragon jade = new Dragon("Jade", "Earth", 100, mainEarth, mainNormal);
		Dragon aqua = new Dragon("Aqua", "Water", 100, mainWater, mainNormal);
		Dragon garnet = new Dragon("Garnet", "Fire", 90, mainFire, otherNormal);
		Dragon emerald = new Dragon("Emerald", "Earth", 120, mainEarth, otherNormal);
		Dragon sapphire = new Dragon("Saphire", "Water", 100, mainWater, otherNormal);

		defaultDragons.add(ruby);
		defaultDragons.add(jade);
		defaultDragons.add(aqua);
		defaultDragons.add(garnet);
		defaultDragons.add(emerald);
		defaultDragons.add(sapphire);

		return defaultDragons;
	}

	private User createUser(String chosenDragon, List<Dragon> dragons) {
		Dragon userDragon = null;
		for (Dragon dragon : dragons) {
			if (dragon.getDragonName().equals(chosenDragon)) {
				userDragon = dragon;
			}
		}
		User user = new User(0, userDragon);
		return user;
	}

}
