package user.rentedbike.bike;

import base.data.bike.BaseDataBikeSearchPane;

public class UserRentedBikeSearchPane extends BaseDataBikeSearchPane{

	@Override
	public String getQueryParams() {
		String res = super.getQueryParams();
		res = res + "&status=1";
		return res;
	}	
}
