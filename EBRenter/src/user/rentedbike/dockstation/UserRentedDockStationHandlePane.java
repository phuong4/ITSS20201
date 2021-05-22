package user.rentedbike.dockstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base.data.BaseDataHandlePane;
import main.EBRUser;
import user.rentedbike.bike.UserRentedBikePageController;

public class UserRentedDockStationHandlePane extends BaseDataHandlePane{
	public UserRentedDockStationHandlePane() {
		super();
	}
	public UserRentedDockStationHandlePane(Object t) {
		super(t);
		
	}

	@Override
	public void decorateHandlePane(JPanel pane) {
		// TODO Auto-generated method stub
		super.decorateHandlePane(pane);
		JButton backBtn = new JButton("Back");
		pane.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRentedBikePageController bikeController  = new UserRentedBikePageController();
				EBRUser.tabbedPane.setComponentAt(1, bikeController.getPagePane());
				
			}
		});

	}
}
