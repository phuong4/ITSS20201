package base.data;
import java.util.List;

import com.ebr.bean.Base;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSearchPane;
import abstractdata.ADataSinglePane;
import abstractdata.AHandlePane;

public class BaseDataPageController extends ADataPageController{
	public BaseDataPageController() {
		super();
	}
	
	public BaseDataPageController(Object t) {
		super(t);
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
		return null;
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
