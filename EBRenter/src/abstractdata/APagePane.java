package abstractdata;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class APagePane extends JPanel {
	public APagePane() {
	}

	public APagePane(JLabel label, JComponent mainPane, JComponent handlePane) {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		if (label != null) {
			this.add(label);
			layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, label, -5, SpringLayout.EAST, this);
		}

		if (mainPane != null) {
			this.add(mainPane);
			layout.putConstraint(SpringLayout.WEST, mainPane, 5, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, mainPane, 5, SpringLayout.SOUTH, label);
			layout.putConstraint(SpringLayout.EAST, mainPane, -5, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.SOUTH, mainPane, -50, SpringLayout.SOUTH, this);

			layout.putConstraint(SpringLayout.NORTH, handlePane, 0, SpringLayout.SOUTH, mainPane);
		}

		if (handlePane != null) {
			this.add(handlePane);
			layout.putConstraint(SpringLayout.WEST, handlePane, 5, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.EAST, handlePane, -5, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.SOUTH, handlePane, -5, SpringLayout.SOUTH, this);
		}

	}
	
	public APagePane(JLabel label, JComponent mainPane) {
		
	}
	
	
}
