package com.ebr.bean;

public class Order extends Base {

	private int idBike;
	private String startOrder;
	private String endOrder;
	private String codePayment;
	private int status;
	private float depositMoney;

	
	public Order(int idBike, String startOrder, String codePayment, int status, float depositMoney) {
		this.idBike = idBike;
		this.startOrder = startOrder;
		this.codePayment = codePayment;
		this.status = status;
		this.depositMoney = depositMoney;
	}

	public Order(int idBike, String startOrder, String endOrder, String codePayment, int status,float depositMoney) {
		this.idBike = idBike;
		this.startOrder = startOrder;
		this.endOrder = endOrder;
		this.codePayment = codePayment;
		this.status = status;
		this.depositMoney = depositMoney;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public String getStartOrder() {
		return startOrder;
	}

	public void setStartOrder(String startOrder) {
		this.startOrder = startOrder;
	}

	public String getEndOrder() {
		return endOrder;
	}

	public void setEndOrder(String endOrder) {
		this.endOrder = endOrder;
	}

	public String getCodePayment() {
		return codePayment;
	}

	public void setCodePayment(String codePayment) {
		this.codePayment = codePayment;
	}
	public float getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(float depositMoney) {
		this.depositMoney = depositMoney;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (endOrder != null)
			return "id: " + this.getId() + ", idBike: " + String.valueOf(idBike) + ", startOrder: "
					+ startOrder.toString() + ", endOrder: " + endOrder.toString() + ", codePayment: " + codePayment
					+ ", status: " + String.valueOf(status);
		else
			return "id: " + this.getId() + ", idBike: " + String.valueOf(idBike) + ", startOrder: "
					+ startOrder.toString() + ", codePayment: " + codePayment + ", status: " + String.valueOf(status);
	}

}
