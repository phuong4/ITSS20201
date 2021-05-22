package user.rentedbike.bike;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.Bike;

import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import base.data.BaseDataListPane;
import main.EBRUser;
import user.rentedbike.dockstation.UserRentedDockStationPageController;

public class UserRentedBikeListPane extends BaseDataListPane{

	public UserRentedBikeListPane(ADataPageController controller) {
		super(controller);
	}
	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		JButton button = new JButton("Return");
		singlePane.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bike bike = (Bike)singlePane.getData();
				
				UserRentedDockStationPageController dockStationController  = new UserRentedDockStationPageController(bike);
				EBRUser.tabbedPane.setComponentAt(1, dockStationController.getPagePane());
			}
		});
	}
}
