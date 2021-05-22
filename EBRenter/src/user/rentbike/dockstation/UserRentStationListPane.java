package user.rentbike.dockstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.DockStation;

import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import base.data.BaseDataListPane;
import main.EBRUser;
import user.rentbike.bike.UserRentBikePageController;

public class UserRentStationListPane extends BaseDataListPane {

	public UserRentStationListPane(ADataPageController controller) {
		super(controller);
	}

	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		JButton button = new JButton("Select");
		singlePane.addDataHandlingComponent(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DockStation dock = (DockStation) singlePane.getData();
				UserRentBikePageController bikeController = new UserRentBikePageController("dockStationCode="+String.valueOf(dock.getId()));
				EBRUser.tabbedPane.setComponentAt(0, bikeController.getPagePane());
//				EBRUser.rootPanel.add(bikeController.createHandlePane(), BorderLayout.SOUTH);
				
			}
		});
	}

}
