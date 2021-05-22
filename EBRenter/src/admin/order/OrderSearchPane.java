package admin.order;
import javax.swing.JLabel;
import javax.swing.JTextField;

import base.data.BaseDataSearchPane;

public class OrderSearchPane extends BaseDataSearchPane{
	private JTextField codeField;

	public OrderSearchPane() {
//		super();
	}
	

	@Override
	public void buildControls() {
		JLabel codeLabel = new JLabel("Id of oder: ");
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

