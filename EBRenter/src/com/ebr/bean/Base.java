package com.ebr.bean;

public class Base {
	private int id;

	public Base() {
	}

	public Base(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Base) {
			Base base = (Base) obj;
			return this.id == base.id;
		}
		return false;
	}

	@Override
	public String toString() {
		return "id: " + this.id;
	}

}
