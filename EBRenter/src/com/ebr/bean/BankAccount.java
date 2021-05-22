package com.ebr.bean;

public class BankAccount extends Base {
	private float money;

	public BankAccount(int id, float money) {
		super(id);
		this.money = money;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}
