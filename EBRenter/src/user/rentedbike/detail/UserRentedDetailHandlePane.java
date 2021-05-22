package user.rentedbike.detail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base.data.BaseDataHandlePane;
import main.EBRUser;
import user.rentedbike.dockstation.UserRentedDockStationPageController;

public class UserRentedDetailHandlePane extends BaseDataHandlePane{
	public UserRentedDetailHandlePane() {
		super();
	}
	public UserRentedDetailHandlePane(Object t) {
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
				UserRentedDockStationPageController dockStationController  = new UserRentedDockStationPageController(t);
				EBRUser.tabbedPane.setComponentAt(1, dockStationController.getPagePane());
				
			}
		});
		
	}
}
