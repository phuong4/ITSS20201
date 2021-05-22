package user.rentbike.dockstation;

import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.DockStation;

import abstractdata.ADataListPane;
import abstractdata.AHandlePane;
import base.data.BaseDataSearchPane;
import base.data.BaseDataSinglePane;
import base.data.BaseDataPageController;

public class UserRentStationPageController extends BaseDataPageController{
	
	public UserRentStationPageController() {
		super();
	}
	
	@Override
	public List<? extends Base> search(String searchParams) {
		ArrayList<DockStation> res = dataApi.getDockStation(searchParams);
		return res;
	}
	@Override
	public BaseDataSinglePane createSinglePane() {
		return new UserRentStationSinglePane();
	}
	@Override
	public BaseDataSearchPane createSearchPane() {
		return new UserRentStationSearchPane();
	}
	@Override
	public ADataListPane createListPane() {
		return new UserRentStationListPane(this);
	}

	@Override
	public AHandlePane createHandlePane() {
		return new UserRentStationHandlePane();
	}
}
