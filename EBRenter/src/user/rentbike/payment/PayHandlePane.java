package user.rentbike.payment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ebr.bean.Bike;

import base.detail.BaseDetailHandlePane;
import main.EBRUser;
import user.rentbike.bike.UserRentBikePageController;

public class PayHandlePane extends BaseDetailHandlePane {
	private JTextField payField;
	PayController controller;

	public PayHandlePane(PayController controller) {
		this.controller = controller;
	}

	@Override
	public void decorateHandlePane(JPanel pane) {

		payField = new JTextField(20);
		JButton payBtn = new JButton("Pay");

		payBtn.setPreferredSize(new Dimension(100, 40));
		payBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int status = controller.payDepositBike(payField.getText());
				if (status == controller.SUCCESS) {
					JOptionPane.showMessageDialog(EBRUser.dialog, "Success !!");
					Bike bike = (Bike) controller.getT();
					EBRUser.tabbedPane.setComponentAt(0,
							new UserRentBikePageController("dockStationCode=" + bike.getDockStationCode()).getPagePane());
					EBRUser.dialog.setVisible(false);
					user.rentedbike.bike.UserRentedBikePageController bikeController  = new user.rentedbike.bike.UserRentedBikePageController();
					EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
				} else if (status == controller.INVALID_CODE) {
					JOptionPane.showMessageDialog(EBRUser.dialog, "Your code payment is invalid !!", "",
							JOptionPane.ERROR_MESSAGE);
				} else if (status == controller.NOT_ENOUGH_MONEY) {
					JOptionPane.showMessageDialog(EBRUser.dialog, "Your code payment doesnot have enough money !!", "",
							JOptionPane.ERROR_MESSAGE);
				} else if (status == controller.IS_USED) {
					JOptionPane.showMessageDialog(EBRUser.dialog, "Your code payment is using !!", "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pane.add(payField);
		pane.add(payBtn);

	}

}
