package user.rentedbike.dockstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;

import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import base.data.BaseDataListPane;
import main.EBRUser;
import user.rentedbike.detail.UserRentedBikeDetailController;

public class UserRentedUserDockStationListPane extends BaseDataListPane {
	Bike bike;
	public UserRentedUserDockStationListPane(ADataPageController controller) {
		super(controller);
		bike = (Bike)controller.getT();
	}

	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		JButton button = new JButton("Select");
		singlePane.addDataHandlingComponent(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DockStation dockStation= (DockStation) singlePane.getData();
				bike.setDockStationCode(dockStation.getId());
				UserRentedBikeDetailController detailController = new UserRentedBikeDetailController(bike);
				EBRUser.tabbedPane.setComponentAt(1, detailController.getPagePane());
			}
		});
	}
}
