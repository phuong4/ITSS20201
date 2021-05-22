package abstractdata;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;


public abstract class AHandlePane extends JPanel{
	private LayoutManager layout;
	protected Object t;
	
	public void init() {
		layout = new FlowLayout();
		this.setLayout(layout);
		decorateHandlePane(this);
	}
	public AHandlePane()
	{
		this.init();
	}
	
	public AHandlePane(Object t) {
		this.t = t;
		this.init();
	}
	public abstract void decorateHandlePane(JPanel pane);
}
