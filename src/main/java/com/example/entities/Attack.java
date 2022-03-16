package com.example.entities;

public class Attack {
	// attributes
	private String attackName;
	private String attackType;
	private int attackDamage;
	private boolean isTypeAttack;

	public Attack(String attackName, String attackType, int attackDamage, boolean isTypeAttack) {
		this.attackName = attackName;
		this.attackType = attackType;
		this.attackDamage = attackDamage;
		this.isTypeAttack = isTypeAttack;
	}

	public String getAttackName() {
		return attackName;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	public String getAttackType() {
		return attackType;
	}

	public void setAttackType(String attackType) {
		this.attackType = attackType;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public boolean isTypeAttack() {
		return isTypeAttack;
	}

	public void setTypeAttack(boolean isTypeAttack) {
		this.isTypeAttack = isTypeAttack;
	}

}
