package user.rentbike.rentdetail;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import com.ebr.bean.Bike;

import base.data.bike.BaseDataBikeSinglePane;
import factory.GetBikeFactory;

public class UserRentBikeDetailSinglePane extends BaseDataBikeSinglePane{
	private JLabel labelDeposit;
	public UserRentBikeDetailSinglePane(Object t) {
		super(t);
		displayData();
	}

	@Override
	public void buildControls() {
		// TODO Auto-generated method stub
		super.buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelDeposit = new JLabel();
		add(labelDeposit, c);
	}

	@Override
	public void displayData() {
		super.displayData();
		GetBikeFactory getBikeFactory = new GetBikeFactory();
		if (t instanceof Bike) {
			Bike bike = (Bike) t;
			labelDeposit.setText("Deposit amount: " + getBikeFactory.getDepositMoney(bike.getType()));
			labelDeposit.setForeground(Color.red);
			labelDeposit.setFont(new Font("Verdana", Font.BOLD, 16));
		}
	}
}
