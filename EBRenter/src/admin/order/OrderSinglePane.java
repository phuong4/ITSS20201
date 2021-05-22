package admin.order;

import javax.swing.JLabel;

import com.ebr.bean.Order;

import base.data.BaseDataSinglePane;

public class OrderSinglePane extends BaseDataSinglePane {

	private JLabel labelIdBike;
	private JLabel labelStartOrder;
	private JLabel labelCodePayment;
	private JLabel labelStatus;
	
	public OrderSinglePane() {
		super();
	}

	public OrderSinglePane(Order ds) {
		this();
		this.t = ds;

		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelIdBike = new JLabel();
		add(labelIdBike, c);

		 row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStartOrder = new JLabel();
		add(labelStartOrder, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelCodePayment = new JLabel();
		add(labelCodePayment, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStatus = new JLabel();
		add(labelStatus, c);


	}

	@Override
	public void displayData() {
		super.displayData();

		if (t instanceof Order) {
			Order order = (Order) t;
			labelIdBike.setText("IdBike: " + order.getIdBike());
			labelStartOrder.setText("Start Order: " + order.getStartOrder());
			labelCodePayment.setText("Code Payment: " + order.getCodePayment());
			labelStatus.setText("Status: " + order.getStatus());
		}
	}

}
