package user.rentbike.rentdetail;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ebr.bean.Bike;

import base.detail.BaseDetailHandlePane;
import main.EBRUser;
import user.rentbike.payment.PayController;

public class UserRentBikeDetailHandlePane extends BaseDetailHandlePane{
	public UserRentBikeDetailHandlePane(Object t) {
		super(t);
		Bike bike = (Bike)t;
	}
	@Override
	public void decorateHandlePane(JPanel pane) {
		super.decorateHandlePane(pane);
		JButton rentBtn = new JButton("Rent bike");
		rentBtn.setPreferredSize(new Dimension(100,40));
		rentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PayController payController = new PayController(t);
				EBRUser.showChildDialog(payController.getPagePane(), "Payment", new Dimension(450,110));
				
			}
		});
		pane.add(rentBtn);
	}
	
}
