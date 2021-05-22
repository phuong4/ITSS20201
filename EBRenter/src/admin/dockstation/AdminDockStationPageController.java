package admin.dockstation;

import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.DockStation;

import abstractdata.ADataListPane;
import abstractdata.AHandlePane;
import admin.base.AdminBasePageController;
import admin.manage.data.create.DockAddBtnPane;
import base.data.BaseDataSearchPane;
import base.data.BaseDataSinglePane;


public class AdminDockStationPageController extends AdminBasePageController{
	public AdminDockStationPageController() {
		super();
	}
	@Override
	public List<? extends Base> search(String searchParams) {
		ArrayList<DockStation> res = dataApi.getDockStation(searchParams);
		return res;
	}
	@Override
	public BaseDataSinglePane createSinglePane() {
		return new AdminDockStationSinglePane();
	}
	@Override
	public BaseDataSearchPane createSearchPane() {
		return new AdminDockStationSearchPane();
	}
	@Override
	public ADataListPane createListPane() {
		return new AdminDockStationListPane(this);
	}

	@Override
	public AHandlePane createHandlePane() {
		return new DockAddBtnPane();
	}

}
