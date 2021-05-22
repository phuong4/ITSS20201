package user.rentbike.bike;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.Bike;

import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import base.data.BaseDataListPane;
import main.EBRUser;
import user.rentbike.rentdetail.UserRentBikeDetailController;

public class UserRentBikeListPane extends BaseDataListPane{

	public UserRentBikeListPane(ADataPageController controller) {
		super(controller);
	}
	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		JButton button = new JButton("Select");
		singlePane.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bike bike = (Bike)singlePane.getData();
				UserRentBikeDetailController bikeDetailController = new UserRentBikeDetailController(bike);
				EBRUser.showChildDialog(bikeDetailController.getPagePane(), "Bike detail", new Dimension(450,280));
			}
		});
	}
}
