package abstractdata;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import api.IDataAccess;
import api.ServerJsonApi;


public abstract class ADataPageController extends APageController{
	protected ADataListPane listPane;
	protected ADataSearchPane searchPane;
	//protected AHandlePane handlePane;
	
	public ADataPageController() {
		super();
	}
	
	public ADataPageController(Object t) {
		super(t);
	}
	
	
	@Override
	public IDataAccess getDataApi() {
		System.out.println("Van vui ve");
		System.out.println(ServerJsonApi.getInstance());
		return ServerJsonApi.getInstance();
		
	}
	
	@Override
	public JLabel createLabel() {
		return new JLabel();
	}
	
	@Override
	public JPanel decorateMainPanel() {
		listPane = createListPane();
		searchPane = createSearchPane();
		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(String searchParams) {
				List<? extends Object> list = ADataPageController.this.search(searchParams);
				listPane.updateData(list);
			}
		});
		searchPane.fireSearchEvent();
		
		pagePane = new ADataPagePane(searchPane, listPane);
		return pagePane;
	}

	
	public abstract ADataSearchPane createSearchPane();

	public abstract List<? extends Object> search(String searchParams);
	
	public abstract ADataSinglePane createSinglePane();
	
	public abstract ADataListPane createListPane();
}
