package com.ebr.bean;

public class Bike extends Base{
	private String name;
	private String type;
	private String weight;
	private String licensePlate;
	private String manuafacturingDate;
	private String producer;
	private float cost;
	private int dockStationCode;
	private int status;
	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bike(String name, String type, String weight, String licensePlate, String manuafacturingDate,
			String producer, float cost, int dockStationCode, int status) {
		super();
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.licensePlate = licensePlate;
		this.manuafacturingDate = manuafacturingDate;
		this.producer = producer;
		this.cost = cost;
		this.dockStationCode = dockStationCode;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getManuafacturingDate() {
		return manuafacturingDate;
	}
	public void setManuafacturingDate(String manuafacturingDate) {
		this.manuafacturingDate = manuafacturingDate;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	

	public int getDockStationCode() {
		return dockStationCode;
	}

	public void setDockStationCode(int dockStationCode) {
		this.dockStationCode = dockStationCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getDepositMoney() {
		return 0;
	}
	
	public float getPaymentMoney(long time) {
		return 0;
	}

	@Override
	public String toString() {
		return "id: " + this.getId() 
			 + ", name: " + this.getName()
			 + ", type: "+ this.type
			 + ", weight: "+ this.weight
			 + ", licensePlate: "+ this.licensePlate
			 + ", manuafacturingDate: "+ this.manuafacturingDate
			 + ", producer: " + this.producer
			 + ", cost: " + String.valueOf(this.cost)
			 + ", dockStationCode: " + String.valueOf(this.dockStationCode)
			 + ", status: " + String.valueOf(this.status);
	}

	
	
}