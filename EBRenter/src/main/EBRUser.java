package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EBRUser extends JFrame {
	public static final int WINDOW_WIDTH = 900;
	public static final int WINDOW_HEIGHT = 600;
	public static JTabbedPane tabbedPane;
	public static JPanel rootPanel;
	public static JFrame thisFrame;
	public static JDialog dialog;

	public EBRUser(EBRUserController controller) {
		this.thisFrame = this;
		rootPanel = new JPanel();
		tabbedPane = new JTabbedPane();
		dialog = new JDialog();
		setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		JPanel rentBikePanel = controller.getRentBikePanel();
		tabbedPane.addTab("Rent Bike", null, rentBikePanel, "Rent Bike");
		JPanel listRentedBikePanel = controller.getListRentedBikePanel();
		tabbedPane.addTab("List Rented Bike", null, listRentedBikePanel, "List Rented Bike");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - WINDOW_WIDTH) / 2, (screenSize.height - WINDOW_HEIGHT) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ecogreen Bike Renter for User");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void showChildDialog(JComponent contentChild, String title, Dimension d) {
		dialog.setTitle(title);
		dialog.setContentPane(contentChild);
		dialog.setSize(d);
		dialog.setLocationRelativeTo(thisFrame);
		dialog.setModal(true);
		dialog.setVisible(true);
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
				new EBRUser(new EBRUserController());
			}
		});
	}

}
