package com.ebr.bean;

public class ElectricBike extends Bike{

	@Override
	public float getDepositMoney() {
		// TODO Auto-generated method stub
		return 700000;
	}
	
	@Override
	public float getPaymentMoney(long time) {
		float PaymentMoney = 0;
		if(time < 10) return 0;
		else {
			PaymentMoney += 15000;
			time -= 30;
			while (time >0) {
				PaymentMoney += 4500;
				time -= 15;
			}
		}
		return PaymentMoney;
	}

}
