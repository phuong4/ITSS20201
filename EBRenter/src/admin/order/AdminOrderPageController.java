package admin.order;
import java.util.ArrayList;
import java.util.List;

import com.ebr.bean.Base;
import com.ebr.bean.Order;

import abstractdata.ADataListPane;
import abstractdata.AHandlePane;
import admin.base.AdminBasePageController;
import base.data.BaseDataSearchPane;
import base.data.BaseDataSinglePane;


public class AdminOrderPageController extends AdminBasePageController{
	public AdminOrderPageController() {
		super();
	}
	
	@Override
	public List<? extends Base> search(String searchParams) {
		ArrayList<Order> res = dataApi.getOrders(searchParams);
		return res;
	}
	@Override
	public BaseDataSinglePane createSinglePane() {
		return new OrderSinglePane();
	}
	@Override
	public BaseDataSearchPane createSearchPane() {
		return new OrderSearchPane();
	}
	@Override
	public ADataListPane createListPane() {
		return new AdminOrderListPane(this);
	}

	@Override
	public AHandlePane createHandlePane() {
		return new OrderHandelPane();
	}

}
