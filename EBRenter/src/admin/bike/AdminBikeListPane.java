package admin.bike;

import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import admin.base.AdminDataBaseListPane;

public class AdminBikeListPane extends AdminDataBaseListPane{

	public AdminBikeListPane(ADataPageController controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void decorateSinglePane(ADataSinglePane singlePane) {
			// TODO Auto-generated method stub
			super.decorateSinglePane(singlePane);
		
//			singlePane.setBackground(Color.yellow);
		
	}
}
