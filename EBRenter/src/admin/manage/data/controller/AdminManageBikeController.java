package admin.manage.data.controller;

import com.ebr.bean.Bike;
import abstractdata.IDataManageController;
import api.IDataAccess;
import api.ServerJsonApi;

public class AdminManageBikeController implements IDataManageController<Bike>{
	public IDataAccess apiManage = ServerJsonApi.getInstance();
	public AdminManageBikeController(){
		
	}
	@Override
	public void create(Bike t) {
		// TODO Auto-generated method stub
		apiManage.createBike(t);
		apiManage.updateDockStationAfterCreateBike(t);
	}

	@Override
	public void read(Bike t) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void delete(Bike t) {
		// TODO Auto-generated method stub
		apiManage.deleteBike(((Bike) t).getId());
		apiManage.updateDockAfterDeleteBike(t.getType(),t.getDockStationCode());
		
	}

	@Override
	public void update(Bike t) {
		// TODO Auto-generated method stub
		apiManage.updateBike(t);
	}
	
}
