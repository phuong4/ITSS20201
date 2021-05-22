package base.data;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;

public class BaseDataListPane extends ADataListPane {
	public BaseDataListPane(ADataPageController controller) {
		this.controller = controller;
	}

	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
		// TODO Auto-generated method stub
		
	}
	
	

}
