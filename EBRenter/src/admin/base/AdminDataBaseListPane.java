package admin.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ebr.bean.Base;
import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import admin.manage.data.controller.AdminManageBikeController;
import admin.manage.data.controller.AdminManageDockStationController;
import admin.manage.data.edit.BikeEditDialog;
import admin.manage.data.edit.DockStationEditDialog;
import main.EBRAdmin;
@SuppressWarnings("serial")
public class AdminDataBaseListPane extends ADataListPane{
	// manageController; 

	public AdminDataBaseListPane(ADataPageController controller) {
		this.controller = controller;
		
	}
	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		// TODO Auto-generated method stub
		JButton btnEdit = new JButton("Edit");
		JButton btnDelete = new JButton("Delete");
		singlePane.addDataHandlingComponent(btnEdit);
		singlePane.addDataHandlingComponent(btnDelete);
		//manageController = new AdminManageDataController();
		
		
		btnEdit.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(singlePane.getData() instanceof DockStation) {
					AdminManageDockStationController manageController1 = new AdminManageDockStationController();
					System.out.println(singlePane.getData());
					DockStationEditDialog dockEditPane =new DockStationEditDialog((DockStation)singlePane.getData(),manageController1);
					(manageController1).update(dockEditPane.getNewData());
					singlePane.updateData(dockEditPane.getNewData());
					System.out.println("Edit Clicked");
				}
				if(singlePane.getData() instanceof Bike) {
					AdminManageBikeController manageController1 = new AdminManageBikeController();
					BikeEditDialog bikeEditPane =new BikeEditDialog((Bike)singlePane.getData(),manageController1);
					((AdminManageBikeController)manageController1).update(bikeEditPane.getNewData());
					singlePane.updateData(bikeEditPane.getNewData());
				}
				EBRAdmin.updateData();
			
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("Delete Clicked");
				 int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (EBRAdmin.thisFrame, "Do you really want to delete this Object","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					System.out.println(((Base)singlePane.getData()).getId());
					if(singlePane.getData() instanceof DockStation) {
						AdminManageDockStationController manageController1 = new AdminManageDockStationController();
						(manageController1).delete((DockStation)singlePane.getData());
					}
					if(singlePane.getData() instanceof Bike) {
						AdminManageBikeController manageController1 = new AdminManageBikeController();
						(manageController1).delete(((Bike)singlePane.getData()));
					}
					EBRAdmin.updateData();
				}else {
					System.out.println("No");
					
				}
			}
		});
	}	

}
