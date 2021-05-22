package user.rentbike.rentdetail;

import javax.swing.JLabel;
import javax.swing.JPanel;

import abstractdata.AHandlePane;
import base.detail.BaseDetailController;

public class UserRentBikeDetailController extends BaseDetailController{

	public UserRentBikeDetailController(Object t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public JLabel createLabel() {
		// TODO Auto-generated method stub
		return new JLabel();
	}

	@Override
	public AHandlePane createHandlePane() {
		// TODO Auto-generated method stub
		return new UserRentBikeDetailHandlePane(t);
	}

	@Override
	public JPanel decorateMainPanel() {
		return new UserRentBikeDetailSinglePane(t);
	}
}
