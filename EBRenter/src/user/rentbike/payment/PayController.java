package user.rentbike.payment;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ebr.bean.BankAccount;
import com.ebr.bean.Bike;
import com.ebr.bean.Order;

import abstractdata.AHandlePane;
import base.detail.BaseDetailController;
import factory.GetBikeFactory;

public class PayController extends BaseDetailController {
	public static final int SUCCESS = 0;
	public static final int NOT_ENOUGH_MONEY = 1;
	public static final int INVALID_CODE = 2;
	public static final int IS_USED = 3;

	public PayController() {
		super();
	}

	public PayController(Object t) {
		super(t);
	}

	@Override
	public JLabel createLabel() {
		// TODO Auto-generated method stub
		return new JLabel("Enter your payment code: ");
	}

	@Override
	public AHandlePane createHandlePane() {
		// TODO Auto-generated method stub
		return new PayHandlePane(this);
	}

	@Override
	public JPanel decorateMainPanel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int payDepositBike(String codePayment) {
		if(codePayment.equals("")) {
			return INVALID_CODE;
		}
		BankAccount account = dataApi.getBankAccount("id="+codePayment);
		if(account == null)
			return INVALID_CODE;
		//kiem tra xem paymentcode co dang duoc su dung hay khong
		if(dataApi.getUnpayOrder(codePayment) != null) {
			return IS_USED;
		}
		
		Bike bike = (Bike)t;
		GetBikeFactory getBikeFactory = new GetBikeFactory();

		if(account.getMoney() < getBikeFactory.getDepositMoney(bike.getType()))
			return NOT_ENOUGH_MONEY;
		//thuc hien tru tien, chuyen status cua bike sang 1, update lai giao dien xe dap, luu lai order, 
		dataApi.payMoney(account, getBikeFactory.getDepositMoney(bike.getType()));

		dataApi.changeBikeStatus(bike, 1);
		Order order = new Order(bike.getId(), new Date().toString(), codePayment,0,getBikeFactory.getDepositMoney(bike.getType()));
		dataApi.createOrder(order);
		
		return SUCCESS;
	}

}
