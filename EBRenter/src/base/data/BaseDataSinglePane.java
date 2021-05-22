package base.data;

import javax.swing.JLabel;

import com.ebr.bean.Base;

import abstractdata.ADataSinglePane;

public class BaseDataSinglePane extends ADataSinglePane {
	private JLabel labelCode;

	public BaseDataSinglePane() {
		super();
	}

	public BaseDataSinglePane(Object t) {
		super(t);
	}

	public BaseDataSinglePane(Base base) {
		super(base);
		System.out.println("Base Data Single Pane");
		this.t = base;
	}

	@Override
	public void buildControls() {
		super.buildControls();

		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelCode = new JLabel();
		add(labelCode, c);
	}

	@Override
	public void displayData() {
		Base base = (Base) t;
		labelCode.setText("Code: " + String.valueOf(base.getId()));
	}

}
