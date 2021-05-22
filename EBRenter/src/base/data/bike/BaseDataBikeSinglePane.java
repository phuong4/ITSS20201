package base.data.bike;

import javax.swing.JLabel;

import com.ebr.bean.Bike;

import base.data.BaseDataSinglePane;

public class BaseDataBikeSinglePane extends BaseDataSinglePane{
	private JLabel labelName;
	private JLabel labelType;
	private JLabel labelWeight;
	private JLabel labelLicensePlate;
	private JLabel labelManuafacturingDate;
	private JLabel labelProducer;
	private JLabel labelCost;

	public BaseDataBikeSinglePane() {
		super();
		System.out.println("This is Bike single pane");
	}

	public BaseDataBikeSinglePane(Object t) {
		super(t);
		this.t = t;
	}

	@Override
	public void buildControls() {
		super.buildControls();

		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelName = new JLabel();
		add(labelName, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelType = new JLabel();
		add(labelType, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelWeight = new JLabel();
		add(labelWeight, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelLicensePlate = new JLabel();
		add(labelLicensePlate, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelManuafacturingDate = new JLabel();
		add(labelManuafacturingDate, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelProducer = new JLabel();
		add(labelProducer, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelCost = new JLabel();
		add(labelCost, c);
		
	}

	@Override
	public void displayData() {
		super.displayData();

		if (t instanceof Bike) {
			Bike bike = (Bike) t;
			labelName.setText("Name: " + bike.getName());
			labelType.setText("Type: " + bike.getType());
			labelWeight.setText("Weight: " + bike.getWeight());
			labelLicensePlate.setText("License plate: " + bike.getLicensePlate());
			labelManuafacturingDate.setText("Manuafacturing Date: " + bike.getManuafacturingDate());
			labelProducer.setText("Producer: " + bike.getProducer());
			labelCost.setText("Cost: " + String.valueOf(bike.getCost()));

		}
	}
}
