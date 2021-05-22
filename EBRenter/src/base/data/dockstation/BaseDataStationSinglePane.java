package base.data.dockstation;

import javax.swing.JLabel;

import com.ebr.bean.DockStation;

import base.data.BaseDataSinglePane;

public class BaseDataStationSinglePane extends BaseDataSinglePane {
	private JLabel labelAddress;
	private JLabel labelName;
	private JLabel labelNumOfNBike;
	private JLabel labelNumOfEBike;
	private JLabel labelNumOfTwinBike;
	private JLabel labelNumOfFreeDock;

	public BaseDataStationSinglePane() {
		super();
	}

	public BaseDataStationSinglePane(DockStation ds) {
		this();
		this.t = ds;
		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		int row;
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelName = new JLabel();
		add(labelName, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelAddress = new JLabel();
		add(labelAddress, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfNBike = new JLabel();
		add(labelNumOfNBike, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfEBike = new JLabel();
		add(labelNumOfEBike, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfTwinBike = new JLabel();
		add(labelNumOfTwinBike, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfFreeDock = new JLabel();
		add(labelNumOfFreeDock, c);

	}

	@Override
	public void displayData() {
		super.displayData();
		if (t instanceof DockStation) {
			DockStation ds = (DockStation) t;
			labelAddress.setText("Address: " + ds.getAddress());
			labelName.setText("Name: " + ds.getName());
			labelNumOfNBike.setText("Num of current N-Bike: " + ds.getNumberOfNBike());
			labelNumOfEBike.setText("Num of current E-Bike: " + ds.getNumberOfEBike());
			labelNumOfTwinBike.setText("Num of current Twin-Bike: " + ds.getNumberOfTwinBike());
			int freeDock = ds.getTotalDock() - ds.getNumberOfNBike() - ds.getNumberOfEBike() - ds.getNumberOfTwinBike();
			labelNumOfFreeDock.setText("Num of free dock: " + String.valueOf(freeDock));
		}
	}
}
