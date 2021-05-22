package base.detail;


import javax.swing.JLabel;
import javax.swing.JPanel;

import abstractdata.ADetailPageController;
import abstractdata.AHandlePane;

public class BaseDetailController extends ADetailPageController{
	public BaseDetailController() {
		super();
	}
	public BaseDetailController(Object t) {
		super(t);
	}

	@Override
	public JLabel createLabel() {
		// TODO Auto-generated method stub
		return new JLabel();
	}

	@Override
	public AHandlePane createHandlePane() {
		// TODO Auto-generated method stub
		return new BaseDetailHandlePane();
	}

	@Override
	public JPanel decorateMainPanel() {
		// TODO Auto-generated method stub
		return new BaseDetailPagePane();
	}

}
