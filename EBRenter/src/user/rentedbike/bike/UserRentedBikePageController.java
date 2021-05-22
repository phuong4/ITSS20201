package user.rentedbike.bike;


import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.Bike;

import abstractdata.ADataListPane;
import abstractdata.ADataSearchPane;
import abstractdata.ADataSinglePane;
import abstractdata.AHandlePane;
import base.data.BaseDataPageController;

public class UserRentedBikePageController extends BaseDataPageController{
	public UserRentedBikePageController() {
		super();
		listPane.updateData(this.search("status=1"));
	}
	
	@Override
	public List<? extends Base> search(String searchParams) {
		searchParams = searchParams;
		ArrayList<Bike> res = dataApi.getBike(searchParams);
		return res;
	}

	@Override
	public ADataSinglePane createSinglePane() {
		return new UserRentedBikeSinglePane();
	}
	
	@Override
	public ADataSearchPane createSearchPane() {
		return new UserRentedBikeSearchPane();
	}
	
	@Override
	public ADataListPane createListPane() {
		return new UserRentedBikeListPane(this);
	}
	
	@Override
	public  AHandlePane createHandlePane() {
		return new UserRentedBikeHandlePane();
	}
	
}
