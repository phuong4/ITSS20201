package main;
import javax.swing.JPanel;
import admin.bike.AdminBikePageController;
import admin.dockstation.AdminDockStationPageController;
import admin.order.AdminOrderPageController;


public class EBRAdminController {
		public EBRAdminController(){
		
		}
//		public EBRAdminController();
		public JPanel getDockStationTab() {
			AdminDockStationPageController dockStationController  = new AdminDockStationPageController();
			return  dockStationController.getPagePane();			
		}
		public JPanel getBikeTab() {
			AdminBikePageController bikeController  = new AdminBikePageController();
			return bikeController.getPagePane();
			}
		public JPanel getOrderTab() {
			AdminOrderPageController orderController  = new AdminOrderPageController();
			return orderController.getPagePane();
		}
	}
	
