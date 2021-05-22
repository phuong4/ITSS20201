package user.rentedbike.detail;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.ebr.bean.Bike;

import factory.GetBikeFactory;
import user.rentbike.bike.UserRentBikeSinglePane;

public class UserRentedDetailSinglePane extends UserRentBikeSinglePane{
	JLabel totalTime;
	JLabel moneyPay;
	JButton returnBike;
	UserRentedPayment noticePayment;
	
	public UserRentedDetailSinglePane(Object t) {
		super(t);
		Bike bike = (Bike)t;
		noticePayment = new UserRentedPayment(bike);
		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		totalTime = new JLabel();
		add(totalTime, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		moneyPay = new JLabel();
		add(moneyPay, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		returnBike = new JButton();
		add(returnBike, c);
		
		c.gridx = 1;
		c.gridy = row;;
		c.weightx = 100;
		add(new JLabel(""), c);
		
	}

	@Override
	public void displayData() {
		super.displayData();
		GetBikeFactory getBikeFactory = new GetBikeFactory();
		if (t instanceof Bike) {
			Bike bike = (Bike) t;
			totalTime.setText("Total Time Rent Bike: " + noticePayment.getTotalTime()+" (min)");
			totalTime.setForeground(Color.red);
			totalTime.setFont(new Font("Verdana", Font.BOLD, 16));
			moneyPay.setText("The Money Payment: " + noticePayment.getMoneyPay() + " (vnd)");
			moneyPay.setForeground(Color.red);
			moneyPay.setFont(new Font("Verdana", Font.BOLD, 16));
			returnBike.setText("Return Bike");
			returnBike.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					noticePayment.ReturnBike();
				}
			});
		}
	}
}
