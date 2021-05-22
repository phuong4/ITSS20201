package main;

import javax.swing.JPanel;
import user.rentbike.dockstation.UserRentStationPageController;
import user.rentedbike.bike.UserRentedBikePageController;


public class EBRUserController {
	public JPanel getRentBikePanel() {
		UserRentStationPageController dockStationController  = new UserRentStationPageController();
		return dockStationController.getPagePane();			
	}
	
	public JPanel getListRentedBikePanel() {
		UserRentedBikePageController bikeController  = new UserRentedBikePageController();
		return bikeController.getPagePane();
	}
	
}
