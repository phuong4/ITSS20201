package user.rentbike.bike;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base.data.BaseDataHandlePane;
import main.EBRUser;
import user.rentbike.dockstation.UserRentStationPageController;

public class UserRentBikeHandlePane extends BaseDataHandlePane {
	protected UserRentBikePageController controller;
	public UserRentBikeHandlePane() {
		super();
	}
	
	public UserRentBikeHandlePane(UserRentBikePageController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void decorateHandlePane(JPanel pane) {
		JButton backButton = new JButton("Back to Dock Station List");
		pane.add(backButton);
		backButton.setPreferredSize(new Dimension(220, 40));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserRentStationPageController dSController = new UserRentStationPageController();
				EBRUser.tabbedPane.setComponentAt(0, dSController.getPagePane());
				EBRUser.rootPanel.remove(pane);
				//
				
			}
		});
	}
}
