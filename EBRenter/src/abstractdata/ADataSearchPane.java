package abstractdata;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class ADataSearchPane extends JPanel{
	protected GridBagLayout layout;
	protected GridBagConstraints c;
	private IDataSearchController controller;
	
	public ADataSearchPane() {
		layout = new GridBagLayout();
		this.setLayout(layout);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 2;
		c.gridy = row - 1;
		JButton searchButton = new JButton("Search");
		add(searchButton, c);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.search(getQueryParams());
			}
		});
		

		// Empty label for resizing
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = row - 1;
		add(new JLabel(), c);
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
	
	public void setController(IDataSearchController controller) {
		this.controller = controller;
	}
	
	public String getQueryParams() {
		return new String();
	}
	
	public abstract void buildControls();
	
	public void fireSearchEvent() {
		controller.search(getQueryParams());
	}
}
