package abstractdata;

import javax.swing.JComponent;
import javax.swing.SpringLayout;

public class ADataPagePane extends APagePane{
	public ADataPagePane(JComponent searchPane, JComponent listPane) {
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(searchPane);
		this.add(listPane);
		
		layout.putConstraint(SpringLayout.WEST, searchPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, searchPane, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, searchPane, -5, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.WEST, listPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, listPane, 5, SpringLayout.SOUTH, searchPane);
		layout.putConstraint(SpringLayout.EAST, listPane, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, listPane, 0, SpringLayout.SOUTH, this);
		
	}
}
