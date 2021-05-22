package base.data.dockstation;

import javax.swing.JLabel;
import javax.swing.JTextField;

import base.data.BaseDataSearchPane;

public class BaseDataStationSearchPane extends BaseDataSearchPane{
	private JTextField nameField;
	private JTextField addressField;

	public BaseDataStationSearchPane() {
		super();
	}

	@Override
	public void buildControls() {
		JLabel nameLabel = new JLabel("Name of dock station: ");
		nameField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(nameField, c);

		JLabel addressLabel = new JLabel("Address of dock station: ");
		addressField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(addressLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(addressField, c);
	}

	@Override
	public String getQueryParams() {
		String res = super.getQueryParams();
		if (!nameField.getText().trim().equals("")) {
			res = res + "name=" + nameField.getText().trim();
		}
		if (!addressField.getText().trim().equals("")) {
			res = res+ "&" + "address=" + addressField.getText();
		}
		res = res.replace(" ", "%20");
		System.out.println(res);
		return res;
	}
}
