package factory;

import com.ebr.bean.ElectricBike;
import com.ebr.bean.NormalBike;
import com.ebr.bean.TwinBike;

public class GetBikeFactory {
	public float getDepositMoney(String type) {
		if (type.equals("ebike")) {
			return new ElectricBike().getDepositMoney();
		} else if (type.equals("nbike")) {
			return new NormalBike().getDepositMoney();
		} else if (type.equals("twinbike")) {
			return new TwinBike().getDepositMoney();
		} else
			return 0;
	}

	public float getPayMoney(String type,long time) {
		if(type.equals("ebike")) {
			return new ElectricBike().getPaymentMoney(time);
		} else if(type.equals("nbike")) {
			return new NormalBike().getPaymentMoney(time);
		} else if(type.equals("twinbike")) {
			return new TwinBike().getPaymentMoney(time);
		} else
			return 0;
	}
}
