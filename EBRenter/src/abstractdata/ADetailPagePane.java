package abstractdata;

import javax.swing.JComponent;
import javax.swing.SpringLayout;

public class ADetailPagePane extends APagePane{
	public ADetailPagePane() {
		super();
	}
	
	public ADetailPagePane(JComponent panel) {
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(panel);
		
		layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, panel, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, this);
		
	}
	
	public ADetailPagePane(JComponent panel1, JComponent panel2) {
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(panel1);
		this.add(panel2);
		
		layout.putConstraint(SpringLayout.WEST, panel1, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, panel1, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, panel1, -5, SpringLayout.EAST, this);
		
		
		layout.putConstraint(SpringLayout.WEST, panel2, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, panel2, 5, SpringLayout.SOUTH, panel1);
		layout.putConstraint(SpringLayout.EAST, panel2, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, panel2, 0, SpringLayout.SOUTH, this);
		
	}
}
