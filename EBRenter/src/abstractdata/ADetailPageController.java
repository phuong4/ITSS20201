package abstractdata;

import api.IDataAccess;
import api.ServerJsonApi;

public abstract class ADetailPageController extends APageController{
	public ADetailPageController() {
		super();
	}
	
	
	public ADetailPageController(Object t) {
		super(t);
	}
	
	@Override
	public IDataAccess getDataApi() {
		return ServerJsonApi.getInstance();
	}
	
}
