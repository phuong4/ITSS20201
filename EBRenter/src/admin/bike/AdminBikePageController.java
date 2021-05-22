package admin.bike;

import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.Bike;

import abstractdata.ADataListPane;
import abstractdata.AHandlePane;
import admin.base.AdminBasePageController;
import admin.manage.data.create.BikeAddBtnPane;
import base.data.BaseDataSearchPane;
import base.data.BaseDataSinglePane;


public class AdminBikePageController extends AdminBasePageController{
	String dockStationCode;
	public AdminBikePageController() {
		super();
	}
	@Override
	public List<? extends Base> search(String searchParams) {
		ArrayList<Bike> res = dataApi.getBike(searchParams);
		return res;
	}
	@Override
	public BaseDataSinglePane createSinglePane() {
//		return new DockStationSinglePane();
		return new AdminDataBikeSinglePane();
	}
	@Override
	public BaseDataSearchPane createSearchPane() {
		return new AdminBikeSearchPane();
	}
	@Override
	public ADataListPane createListPane() {
		return new AdminBikeListPane(this);
	}

	@Override
	public AHandlePane createHandlePane() {
		return new BikeAddBtnPane();
	}

}



