package user.rentedbike.detail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import com.ebr.bean.BankAccount;
import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;
import com.ebr.bean.Order;

import api.IDataAccess;
import api.ServerJsonApi;
import factory.GetBikeFactory;
import main.EBRUser;
import user.rentbike.dockstation.UserRentStationPageController;
import user.rentedbike.bike.UserRentedBikePageController;

public class UserRentedPayment{
	public static final int SUCCESS = 0;
	public static final int NOT_ENOUGH_MONEY = 1;
	public static final int INVALID_CODE = 2;
	public static final int IS_USED = 3;
	public static final int FULL_DOCK = 4;
	Long totalTime;
	float moneyPay;
	Bike bike;

	public UserRentedPayment(Bike bike) {
		this.bike = bike;
		totalTime = getDiffTime(bike);
		moneyPay = new GetBikeFactory().getPayMoney(bike.getType(),totalTime);
		System.out.println(moneyPay);
	}


	public String getTotalTime() {
		return String.valueOf(totalTime);
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = Long.valueOf(totalTime);
	}

	public String getMoneyPay() {
		return String.valueOf(moneyPay);
	}

	public void setMoneyPay(String moneyPay) {
		this.moneyPay = Float.valueOf(moneyPay);
	}

	public long getDiffTime(Bike bike) {
		Date startDate = null;
		Date returnDate = new Date();
		Order order = this.getDataApi().getOrderByIdBike(String.valueOf(bike.getId()));
		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss ZZZ yyyy");
		
		try {
			startDate = formatter.parse(order.getStartOrder());
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(startDate.toString());
		System.out.println(returnDate.toString());
		long diffTime = (returnDate.getTime() - startDate.getTime())/(60*1000);
		return diffTime;
	}
	
	public int ReturnBike() {
		Order order = this.getDataApi().getOrderByIdBike(String.valueOf(this.bike.getId()));
		//get bankAccount follow ID;
		BankAccount account = getDataApi().getBankAccount("id="+order.getCodePayment());
		//check remain money
		if (account.getMoney() + new GetBikeFactory().getDepositMoney(bike.getType()) - new GetBikeFactory().getPayMoney(bike.getType(), getDiffTime(this.bike)) < 0) {
			JOptionPane.showMessageDialog(EBRUser.dialog, "Not enough Money! Return Failed", "",
					JOptionPane.ERROR_MESSAGE);
			UserRentedBikePageController bikeController  = new UserRentedBikePageController();
			EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
			return NOT_ENOUGH_MONEY;
		}
		//check full dockStation
		else if (checkFullDock(bike.getDockStationCode())) {
			JOptionPane.showMessageDialog(EBRUser.dialog, "DockStation is Full! Return Failed", "",
					JOptionPane.ERROR_MESSAGE);
			UserRentedBikePageController bikeController  = new UserRentedBikePageController();
			EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
			return FULL_DOCK;
		}
		else {
			try {
				getDataApi().payMoney(account, new GetBikeFactory().getPayMoney(bike.getType(), getDiffTime(this.bike)) - order.getDepositMoney());
				getDataApi().changeBikeStatus(this.bike, 0);
				System.out.println(this.bike.getDockStationCode());
				getDataApi().changeOrderStatus(order, 1);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(EBRUser.dialog, "Return Failed", "",
						JOptionPane.ERROR_MESSAGE);
				UserRentedBikePageController bikeController  = new UserRentedBikePageController();
				EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
				return NOT_ENOUGH_MONEY;
			}
			JOptionPane.showMessageDialog(EBRUser.dialog, "Success !!");
			UserRentedBikePageController bikeController  = new UserRentedBikePageController();
			EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
			
			UserRentStationPageController dSController = new UserRentStationPageController();
			EBRUser.tabbedPane.setComponentAt(0, dSController.getPagePane());
			return SUCCESS;
		}
	}
	
	public IDataAccess getDataApi() {
		return ServerJsonApi.getInstance();
	}
	
	public boolean checkFullDock(int dockCode) {
		DockStation dockStation = getDataApi().getDockStation("id="+dockCode).get(0);
		int numFreeDock = dockStation.getTotalDock() - dockStation.getNumberOfNBike()
				- dockStation.getNumberOfEBike() -dockStation.getNumberOfTwinBike();
		if (numFreeDock < 1) return true;
		else return false;
		
	}
}
