package admin.bike;

import javax.swing.JLabel;

import com.ebr.bean.Bike;

import base.data.bike.BaseDataBikeSinglePane;

public class AdminDataBikeSinglePane extends BaseDataBikeSinglePane{
	private JLabel labelDockStationCode;
	private JLabel labelStatus;
	public AdminDataBikeSinglePane() {
		// TODO Auto-generated constructor stub
		super();
	}
	public AdminDataBikeSinglePane(Object t) { 
		super(t);
		this.t= t;
	}
	
	@Override
	public void buildControls() {
		super.buildControls();
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelDockStationCode = new JLabel();
		add(labelDockStationCode, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStatus = new JLabel();
		add(labelStatus, c);
	}
	@Override
	public void displayData() {
		super.displayData();

		if (t instanceof Bike) {
			Bike bike = (Bike) t;
			labelDockStationCode.setText("DockStationCode:"+  bike.getDockStationCode());
			labelStatus.setText("Status:"+bike.getStatus());
		}
	}

}
