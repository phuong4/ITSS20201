package com.ebr.bean;

public class DockStation extends Base {

	private String name;
	private String address;
	private int totalDock;
	private int numberOfNBike;
	private int numberOfEBike;
	private int numberOfTwinBike;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DockStation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DockStation(int id,String name,String address, int totalDock, int numberOfNBike, int numberOfEBike, int numberOfTwinBike) {
		super(id);
		this.name = name;
		this.address = address;
		this.totalDock = totalDock;
		this.numberOfNBike = numberOfNBike;
		this.numberOfEBike = numberOfEBike;
		this.numberOfTwinBike = numberOfTwinBike;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalDock() {
		return totalDock;
	}

	public void setTotalDock(int totalDock) {
		this.totalDock = totalDock;
	}

	public int getNumberOfNBike() {
		return numberOfNBike;
	}

	public void setNumberOfNBike(int numberOfNBike) {
		this.numberOfNBike = numberOfNBike;
	}

	public int getNumberOfEBike() {
		return numberOfEBike;
	}

	public void setNumberOfEBike(int numberOfEBike) {
		this.numberOfEBike = numberOfEBike;
	}

	public int getNumberOfTwinBike() {
		return numberOfTwinBike;
	}

	public void setNumberOfTwinBike(int numberOfTwinBike) {
		this.numberOfTwinBike = numberOfTwinBike;
	}

	@Override
	public String toString(){

		return "id : " + this.getId() + ", name: " + this.getName()+ ", address: " + this.address + ", totalDock: " + String.valueOf(this.totalDock) +  ", numOfBike: "
				+ String.valueOf(this.numberOfNBike) + ", numOfEbike: " + String.valueOf(this.numberOfEBike) + ", numOfTwinBike: "+ String.valueOf(this.numberOfTwinBike);
	}
}
