package abstractdata;

import javax.swing.JLabel;
import javax.swing.JPanel;

import api.IDataAccess;

public abstract class APageController {
	protected APagePane pagePane;
	protected JLabel label;
	protected JPanel mainPanel;
	protected AHandlePane handlePane;
	protected IDataAccess dataApi;
	protected Object t;
	
	public APageController() {
		this.init();
	}

	public APageController(Object t) {
		this.t = t;
		this.init();
	}

	public void init() {
		// TODO Auto-generated constructor stub
		dataApi = getDataApi();
		
		label = createLabel();
		
		mainPanel = decorateMainPanel();
		handlePane = createHandlePane();
		
		pagePane = new APagePane(label, mainPanel, handlePane);
	}

	public APagePane getPagePane() {
		return this.pagePane;
	}
	public abstract IDataAccess getDataApi();
	public abstract JLabel createLabel();
	public abstract AHandlePane createHandlePane();
	public abstract JPanel decorateMainPanel();

	public Object getT() {
		return t;
	}

	public void setT(Object t) {
		this.t = t;
	}

}
