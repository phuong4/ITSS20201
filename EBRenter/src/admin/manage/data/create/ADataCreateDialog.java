package admin.manage.data.create;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;

import abstractdata.IDataManageController;
import main.EBRAdmin;

@SuppressWarnings("serial")
public abstract class ADataCreateDialog<T> extends JDialog  {
	protected T t;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();

	public ADataCreateDialog(T t, IDataManageController<T> controller) {
		super((Frame) null, "Add", true);
		setLocationRelativeTo(EBRAdmin.thisFrame);
		this.t = t;
		
		setContentPane(new JPanel());
		layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		this.buildControls();
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(t instanceof Bike){
					Bike xBike = new Bike();
					xBike = (Bike)getNewData();
					controller.create((T)xBike);
				}
				if(t instanceof DockStation){
					System.err.println("Nhanh dpc");
					DockStation xDock = new DockStation();
					xDock = (DockStation)getNewData();
					controller.create((T)xDock);
				}
				ADataCreateDialog.this.dispose();
				EBRAdmin.updateData();
				System.out.println("Submited");
			}
		});
		c.gridx = 1;
		c.gridy = getLastRowIndex();
		getContentPane().add(submitBtn, c);
		
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(getContentPane());
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
	
	public abstract void buildControls();
	
	public abstract T getNewData();

}
