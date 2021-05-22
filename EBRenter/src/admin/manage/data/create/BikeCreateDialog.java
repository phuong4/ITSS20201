package admin.manage.data.create;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.bean.Bike;
import abstractdata.IDataManageController;

public class BikeCreateDialog extends ADataCreateDialog<Bike>{
	private JTextField nameField;
	private JTextField typeField;
	private JTextField weightField;
	private JTextField licensePlateField;
	private JTextField manuafacturingDateField;
	private JTextField producerField;
	private JTextField costField;
	private JTextField dockStationCodeField;
	private JTextField statusField;
	public BikeCreateDialog(Bike t, IDataManageController<Bike> controller) {
		super(t, controller);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void buildControls() {
		// TODO Auto-generated method stub
		//super.buildControls();
		
		if (t instanceof Bike) {
			Bike bike = (Bike) t;
			
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
			JLabel typeLabel = new JLabel("Type");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(typeLabel, c);
			typeField = new JTextField(15);
	
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(typeField, c);
			
			
			row = getLastRowIndex();
			JLabel manuafacturingDateLabel = new JLabel("ManuafacturingDate");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(manuafacturingDateLabel, c);
			manuafacturingDateField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(manuafacturingDateField, c);
			row = getLastRowIndex();
			JLabel licensePlateLabel = new JLabel("LicensePlate");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(licensePlateLabel, c);
			licensePlateField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(licensePlateField, c);
			row = getLastRowIndex();
			JLabel weightLabel = new JLabel("Weight");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(weightLabel, c);
			weightField = new JTextField(15);
			
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(weightField, c);
			row = getLastRowIndex();
			JLabel producerLabel = new JLabel("Producer");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(producerLabel, c);
			producerField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(producerField, c);
			
			row = getLastRowIndex();
			JLabel costLabel = new JLabel("Cost");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(costLabel, c);
			costField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(costField, c);
			
			row = getLastRowIndex();
			JLabel dockStationCodeLabel = new JLabel("DockStationCode");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(dockStationCodeLabel, c);
			dockStationCodeField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(dockStationCodeField, c);
			
			row = getLastRowIndex();
			JLabel statusLabel = new JLabel("Status");
			c.gridx = 0;
			c.gridy = row;
			getContentPane().add(statusLabel, c);
			statusField = new JTextField(15);
			c.gridx = 1;
			c.gridy = row;
			getContentPane().add(statusField, c);
			}		
	}
	
	@Override
	public Bike getNewData() {
		// TODO Auto-generated method stub
		//super.getNewData();
		if (t instanceof Bike) {
		Bike bike = (Bike) t;
			bike.setName(nameField.getText());
			bike.setType(typeField.getText());
			bike.setWeight(weightField.getText());
			bike.setManuafacturingDate(manuafacturingDateField.getText());
			bike.setLicensePlate(licensePlateField.getText());
			bike.setProducer(producerField.getText());
			bike.setCost(Float.parseFloat(costField.getText()));
			bike.setDockStationCode(Integer.parseInt(dockStationCodeField.getText()));
			bike.setStatus(Integer.parseInt(statusField.getText()));
	
	
			return bike;
		}
		return null;

	}

}
