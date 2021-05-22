package com.ebr.bean;

public class NormalBike extends Bike{

	@Override
	public float getDepositMoney() {
		// TODO Auto-generated method stub
		return 400000;
	}

	@Override
	public float getPaymentMoney(long time) {
		float PaymentMoney = 0;
		if(time < 10) return 0;
		else {
			PaymentMoney += 10000;
			time -= 30;
			while (time >0) {
				PaymentMoney += 3000;
				time -= 15;
			}
		}
		return PaymentMoney;
	}
}
