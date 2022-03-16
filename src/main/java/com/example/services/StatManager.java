package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.entities.Attack;
import com.example.entities.Dragon;

public class StatManager {

	public void healHp(Dragon dragon) {
		dragon.setDragonHp(100);
	}

	public Attack captureAttacks(Attack userAttack, Dragon userDragon, Dragon enemyDragon) {
		Attack enemyAttack = getEnemyAttack(enemyDragon);
		List<Double> multiplier = getTypeMultipliers(userDragon, enemyDragon);

		int totalUserDamage = 0;
		int totalEnemyDamage = 0;
		if (userAttack.isTypeAttack()) {
			totalEnemyDamage = (int) (userAttack.getAttackDamage() * multiplier.get(0));
		} else {
			totalEnemyDamage = userAttack.getAttackDamage();
		}

		if (enemyAttack.isTypeAttack()) {
			totalUserDamage = (int) (enemyAttack.getAttackDamage() * multiplier.get(1));
		} else {
			totalUserDamage = enemyAttack.getAttackDamage();
		}

		updateHp(userDragon, totalUserDamage);
		updateHp(enemyDragon, totalEnemyDamage);
		return enemyAttack;
	}

	private void updateHp(Dragon dragon, int damage) {
		int originalHp = dragon.getDragonHp();
		dragon.setDragonHp(originalHp - damage);
	}

	private Attack getEnemyAttack(Dragon enemyDragon) {
		Random randoAttack = new Random();
		int attack = randoAttack.nextInt(4);

		if (attack % 2 == 0) {
			return enemyDragon.getTypeAttack();
		} else {
			return enemyDragon.getNormalAttack();
		}
	}

	public List<Double> getTypeMultipliers(Dragon userDragon, Dragon enemyDragon) {
		double typeAdvantage = 1.2;
		double typeDisadvantage = 0.8;
		Double equalType = 1.0;

		List<Double> multiplier = new ArrayList<>();
		if (userDragon.getDragonType().equals(enemyDragon.getDragonType())) {
			multiplier.add(equalType);
			multiplier.add(equalType);
		} else if (userDragon.getDragonType().equals("Fire") && enemyDragon.getDragonType().equals("Earth")
				|| userDragon.getDragonType().equals("Earth") && enemyDragon.getDragonType().equals("Water")
				|| userDragon.getDragonType().equals("Water") && enemyDragon.getDragonType().equals("Fire")) {
			multiplier.add(typeAdvantage);
			multiplier.add(typeDisadvantage);
		} else if (userDragon.getDragonType().equals("Earth") && enemyDragon.getDragonType().equals("Fire")
				|| userDragon.getDragonType().equals("Water") && enemyDragon.getDragonType().equals("Earth")
				|| userDragon.getDragonType().equals("Fire") && enemyDragon.getDragonType().equals("Water")) {
			multiplier.add(typeDisadvantage);
			multiplier.add(typeAdvantage);
		}
		return multiplier;
	}
}
