package admin.base;

import java.util.List;
import com.ebr.bean.Base;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSearchPane;
import abstractdata.ADataSinglePane;
import abstractdata.AHandlePane;
import admin.manage.data.create.AddBtnHandlePane;

public class AdminBasePageController  extends ADataPageController{
	public AdminBasePageController() {
		super();
	}

	@Override
	public ADataSearchPane createSearchPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Base> search(String searchParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AHandlePane createHandlePane() {
		// TODO Auto-generated method stub
		return new AddBtnHandlePane();
	}

	@Override
	public ADataSinglePane createSinglePane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ADataListPane createListPane() {
		// TODO Auto-generated method stub
		return null;
	}
}
