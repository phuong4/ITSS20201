package admin.manage.data.create;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.bean.DockStation;

import abstractdata.IDataManageController;

public class DockStationCreateDialog extends ADataCreateDialog<DockStation>{
	private JTextField nameField;
	private JTextField addressField;
	private JTextField totalDockField;
	private JTextField numberOfNBikeField;
	private JTextField numberOfEBikeField;
	private JTextField numberOfTwinBikeField;

	public DockStationCreateDialog(DockStation t, IDataManageController<DockStation> controller) {
		super(t, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildControls() {
		// TODO Auto-generated method stub
		//super.buildControls();
		
		if (t instanceof DockStation) {
			DockStation dockStation = (DockStation) t;
			
			int row = getLastRowIndex();
			JLabel nameLabel = new JLabel("Name");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(nameLabel, c);
			nameField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(nameField, c);
			
			
			row = getLastRowIndex();
			JLabel addressLabel = new JLabel("Address");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(addressLabel, c);
			addressField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(addressField, c);
			
			row = getLastRowIndex();
			JLabel totalDockLabel = new JLabel("TotalDock");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(totalDockLabel, c);
			totalDockField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(totalDockField, c);
			
			row = getLastRowIndex();
			JLabel numberOfBikeLabel = new JLabel("NumberOfBike");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(numberOfBikeLabel, c);
			numberOfNBikeField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(numberOfNBikeField, c);
			
			row = getLastRowIndex();
			JLabel numberOfEBikeLabel = new JLabel("NumberOfEBike");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(numberOfEBikeLabel, c);
			numberOfEBikeField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(numberOfEBikeField, c);
			
			row = getLastRowIndex();
			JLabel numberOfTwinBikeLabel = new JLabel("NumberOfTwinBike");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(numberOfTwinBikeLabel, c);
			numberOfTwinBikeField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(numberOfTwinBikeField, c);
			
			
		}
	}
	@Override
	public DockStation getNewData() {
		// TODO Auto-generated method stub
		//super.getNewData();
		if (t instanceof DockStation) {
			DockStation dockStation = (DockStation) t;
			dockStation.setName(nameField.getText());
			dockStation.setAddress(addressField.getText());
			dockStation.setTotalDock((Integer.parseInt(totalDockField.getText())));
			dockStation.setNumberOfNBike(Integer.parseInt(numberOfNBikeField.getText()));
			dockStation.setNumberOfEBike(Integer.parseInt(numberOfEBikeField.getText()));
			dockStation.setNumberOfTwinBike(Integer.parseInt(numberOfTwinBikeField.getText()));
		
			return dockStation;
		}
		return null;
	}

}
