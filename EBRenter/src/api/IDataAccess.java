package api;

import java.util.ArrayList;

import com.ebr.bean.BankAccount;
import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;
import com.ebr.bean.Order;

public interface IDataAccess {
	public ArrayList<Bike> getBike(String query);
	public boolean createBike(Bike bike);
	public boolean updateBike(Bike bike);
	public boolean deleteBike(int id);
	public boolean deleteBikeInDock(int dockId);
	public boolean changeBikeStatus(Bike bike, int status);
	public boolean updateDockStationAfterCreateBike(Bike newBike);
	
	public ArrayList<DockStation> getDockStation(String query);
	public boolean createDockStation(DockStation dock);
	public boolean updateDockStation(DockStation dockStation);
	public boolean updateDockAfterDeleteBike(String type,int dockId);
	public boolean deleteDockStation(int id);
	
	
	public BankAccount getBankAccount(String query);
	public boolean payMoney(BankAccount account, float money);
	public Order getUnpayOrder(String codePayment);

	
	public ArrayList<Order> getOrders(String query);

	public Order getOrderByIdBike(String IdBike);

	public boolean createOrder(Order order);
	public boolean changeOrderStatus(Order order, int status);
}
