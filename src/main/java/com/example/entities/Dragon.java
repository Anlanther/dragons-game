package com.java.entities;

public class Dragon {
	// attributes
	private String dragonName;
	private String dragonType;
	private int dragonHp;
	private Attack typeAttack;
	private Attack normalAttack;

	public Dragon(String dragonName, String dragonType, int dragonHp, Attack typeAttack, Attack normalAttack) {
		super();
		this.dragonName = dragonName;
		this.dragonType = dragonType;
		this.dragonHp = dragonHp;
		this.typeAttack = typeAttack;
		this.normalAttack = normalAttack;
	}

	public String getDragonName() {
		return dragonName;
	}

	public void setDragonName(String dragonName) {
		this.dragonName = dragonName;
	}

	public String getDragonType() {
		return dragonType;
	}

	public void setDragonType(String dragonType) {
		this.dragonType = dragonType;
	}

	public int getDragonHp() {
		return dragonHp;
	}

	public void setDragonHp(int dragonHp) {
		this.dragonHp = dragonHp;
	}

	public Attack getTypeAttack() {
		return typeAttack;
	}

	public void setTypeAttack(Attack typeAttack) {
		this.typeAttack = typeAttack;
	}

	public Attack getNormalAttack() {
		return normalAttack;
	}

	public void setNormalAttack(Attack normalAttack) {
		this.normalAttack = normalAttack;
	}

}
