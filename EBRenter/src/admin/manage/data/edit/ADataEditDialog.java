package admin.manage.data.edit;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import abstractdata.IDataManageController;
import main.EBRAdmin;

@SuppressWarnings("serial")
public abstract class ADataEditDialog <T> extends JDialog  {
	protected T t;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();
	public ADataEditDialog(T t, IDataManageController<T> controller) {
		super((Frame) null, "Edit", true);
		this.setLocationRelativeTo(EBRAdmin.thisFrame);
		this.t = t;
		
		setContentPane(new JPanel());
		layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		this.buildControls();
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Da vao save button");
				T newT = getNewData();
				controller.update(newT);	
				ADataEditDialog.this.dispose();
				EBRAdmin.updateData();
			}
		});
		
		
		c.gridx = 1;
		c.gridy = getLastRowIndex();
		getContentPane().add(saveButton, c);
		
		
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
