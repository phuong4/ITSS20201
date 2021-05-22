package user.rentedbike.detail;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ebr.bean.Bike;

import abstractdata.AHandlePane;
import base.detail.BaseDetailController;
import user.rentedbike.bike.UserRentedBikeSinglePane;

public class UserRentedBikeDetailController extends BaseDetailController{
	public UserRentedBikeDetailController(Object t) {
		super(t);
	}

	@Override
	public JLabel createLabel() {
		JLabel tittleLabel = new JLabel("Detail Information Rented Bike");
		tittleLabel.setForeground(Color.red);
		tittleLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		return tittleLabel;		
	}

	@Override
	public AHandlePane createHandlePane() {
		// TODO Auto-generated method stub
		return new UserRentedDetailHandlePane(t);
	}

	@Override
	public JPanel decorateMainPanel() {
		Bike bike = (Bike) t;
		return new UserRentedDetailPane(new UserRentedBikeSinglePane(t),new UserRentedDetailSinglePane(t));
	}

}
