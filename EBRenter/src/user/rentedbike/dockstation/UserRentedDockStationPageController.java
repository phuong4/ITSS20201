package user.rentedbike.dockstation;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.ebr.bean.Base;
import com.ebr.bean.DockStation;

import abstractdata.ADataListPane;
import abstractdata.ADataSearchPane;
import abstractdata.ADataSinglePane;
import abstractdata.AHandlePane;
import base.data.BaseDataPageController;



public class UserRentedDockStationPageController extends BaseDataPageController{

	public UserRentedDockStationPageController() {
		super();
	}
	public UserRentedDockStationPageController(Object bike) {
		super(bike);
	}
	
	@Override
	public List<? extends Base> search(String searchParams) {
		ArrayList<DockStation> res = dataApi.getDockStation(searchParams);
		return res;
	}
	@Override
	public ADataSinglePane createSinglePane() {
		return new UserRentedDockStationSinglePane();
	}
	@Override
	public ADataSearchPane createSearchPane() {
		return new UserRentedDockStationSearchPane();
	}
	@Override
	public ADataListPane createListPane() {
		return new UserRentedUserDockStationListPane(this);
	}

	@Override
	public AHandlePane createHandlePane() {
		return new UserRentedDockStationHandlePane(t);
	}
	
	@Override
	public JLabel createLabel() {
		JLabel tittleLabel = new JLabel("Choose Dock To Return Bike");
		tittleLabel.setForeground(Color.red);
		tittleLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		return tittleLabel;
	}
}
