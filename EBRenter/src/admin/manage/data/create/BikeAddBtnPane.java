package admin.manage.data.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ebr.bean.Bike;

import admin.manage.data.controller.AdminManageBikeController;

public class BikeAddBtnPane extends AddBtnHandlePane{
	public BikeAddBtnPane() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	public void decorateHandlePane(JPanel panel) {
		// TODO Auto-generated method stub
		addBtn = new JButton("Add new Bike");
		//super.decorateHandlePane(panel);
		panel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminManageBikeController addBtnController = new AdminManageBikeController();
				System.out.println("hu");
				BikeCreateDialog newBike = new BikeCreateDialog(new Bike(),addBtnController);
			}
		});
		
	}
}
