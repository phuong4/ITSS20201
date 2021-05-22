package base.data.bike;

import javax.swing.JLabel;
import javax.swing.JTextField;

import base.data.BaseDataSearchPane;

public class BaseDataBikeSearchPane  extends BaseDataSearchPane{
	private JTextField codeField;


	@Override
	public void buildControls() {
		JLabel codeLabel = new JLabel("Code of bike: ");
		codeField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(codeLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(codeField, c);
		
	}

	@Override
	public String getQueryParams() {
		String res = super.getQueryParams();
		if (!codeField.getText().trim().equals("")) {
			res = res + "id=" + codeField.getText().trim();
		}
		return res;
	}
}
