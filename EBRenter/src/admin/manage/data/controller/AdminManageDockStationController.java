package admin.manage.data.controller;

import com.ebr.bean.DockStation;

import abstractdata.IDataManageController;
import api.IDataAccess;
import api.ServerJsonApi;

public class AdminManageDockStationController implements IDataManageController<DockStation>{
	public IDataAccess apiManage = ServerJsonApi.getInstance();
	@Override
	public void create(DockStation t) {
		// TODO Auto-generated method stub
		apiManage.createDockStation((DockStation)t);
	}

	@Override
	public void read(DockStation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DockStation t) {
		// TODO Auto-generated method stub
		int temp = t.getId();
		apiManage.deleteBikeInDock(temp);
		apiManage.deleteDockStation(t.getId());
	}

	@Override
	public void update(DockStation t) {
		// TODO Auto-generated method stub
		apiManage.updateDockStation(t);
	}

}
