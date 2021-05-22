package admin.manage.data.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.ebr.bean.DockStation;

import admin.manage.data.controller.AdminManageDockStationController;

public class DockAddBtnPane extends AddBtnHandlePane{
	public DockAddBtnPane() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	public void decorateHandlePane(JPanel panel) {
		// TODO Auto-generated method stub
		addBtn = new JButton("Add new DocStation");
		panel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminManageDockStationController addBtnController = new AdminManageDockStationController();
				System.out.println("hu");
				DockStationCreateDialog newDock = new DockStationCreateDialog(new DockStation(),addBtnController);
			}
		});
		
	}
}
