package user.rentbike.bike;

import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.Bike;

import abstractdata.ADataListPane;
import abstractdata.ADataSearchPane;
import abstractdata.ADataSinglePane;
import abstractdata.AHandlePane;
import base.data.BaseDataPageController;

public class UserRentBikePageController extends BaseDataPageController{
	String dockStationCode;
	
	public UserRentBikePageController(String dockStationCode) {
		super();
		this.dockStationCode = dockStationCode;
		listPane.updateData(this.search(dockStationCode));
	}
	
	@Override
	public List<? extends Base> search(String searchParams) {
		searchParams = dockStationCode + "&status=0&" + searchParams;
		ArrayList<Bike> res = dataApi.getBike(searchParams);
		return res;
	}

	@Override
	public ADataSinglePane createSinglePane() {
		return new UserRentBikeSinglePane();
	}
	
	@Override
	public ADataSearchPane createSearchPane() {
		return new UserRentBikeSearchPane();
	}
	
	@Override
	public ADataListPane createListPane() {
		return new UserRentBikeListPane(this);
	}
	
	@Override
	public  AHandlePane createHandlePane() {
		return new UserRentBikeHandlePane(this);
	}
	
//	public void updateList() {
//		
//	}
	
}
