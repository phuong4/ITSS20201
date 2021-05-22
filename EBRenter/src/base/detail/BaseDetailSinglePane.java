package base.detail;

import javax.swing.JLabel;

import com.ebr.bean.Base;

import abstractdata.ADataSinglePane;

public class BaseDetailSinglePane extends ADataSinglePane{

	private JLabel labelCode;
	private JLabel labelName;
	
	public BaseDetailSinglePane() {
		super();
	}
	
	public BaseDetailSinglePane(Base base) {
		this();
		this.t = base;
		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();

		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelCode = new JLabel();
		add(labelCode, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelName = new JLabel();
		add(labelName, c);
		
	}
	
	
	@Override
	public void displayData() {
		Base base = (Base) t;
		labelCode.setText("Code: " + String.valueOf(base.getId()));
	}

}
