package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class EBRAdmin extends JFrame{
	
	public static final int WINDOW_WIDTH = 900;
	public static final int WINDOW_HEIGHT = 600;
	public static JFrame thisFrame;
	public static JPanel rootPanel;
	public static JTabbedPane tabbedPane;
	public static EBRAdminController controller1;
	
	public EBRAdmin(EBRAdminController controller) {
		this.controller1 = controller;
		this.thisFrame= this;
		rootPanel = new JPanel();
		tabbedPane = new JTabbedPane();
		setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		rootPanel.add(tabbedPane, BorderLayout.CENTER);

		JPanel dockStationPanel = controller.getDockStationTab();
		tabbedPane.addTab("DockStation", null,dockStationPanel, "DockStation");
		// Tab Bike
		JPanel bikePanel = controller.getBikeTab();		
		tabbedPane.addTab("Bike", null, bikePanel, "Bike");

		JPanel orderPanel = controller.getOrderTab();
		tabbedPane.addTab("Order", null,orderPanel, "Order");

	    tabbedPane.addChangeListener(new ChangeListener() {
	    	@Override
	    	public void stateChanged(ChangeEvent e) {
	            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
	            System.out.println("Tab: " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
	        }
	    });
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ecogreen Bike Renter for Admin");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EBRAdmin(new EBRAdminController());
			}
		});
	}
	public static void updateData() {
		
		System.out.println("Vao add du lieu");
		tabbedPane.setComponentAt(0, controller1.getDockStationTab()); 		
		tabbedPane.setComponentAt(1, controller1.getBikeTab()); 
		tabbedPane.setComponentAt(2, controller1.getOrderTab()); 
	}
}
