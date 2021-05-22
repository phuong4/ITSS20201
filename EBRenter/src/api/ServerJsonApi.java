package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ebr.bean.BankAccount;
import com.ebr.bean.Bike;
import com.ebr.bean.DockStation;
import com.ebr.bean.Order;
import com.google.gson.Gson;


public class ServerJsonApi implements IDataAccess {
	public static int SERVER_PORT = 3000;
	public static String serverURL = "http://localhost:" + SERVER_PORT + "/";
	private static ServerJsonApi svJsonApi;

	private ServerJsonApi() {

	}

	public static ServerJsonApi getInstance() {
		if (svJsonApi == null) {
			svJsonApi = new ServerJsonApi();
		}
		return svJsonApi;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	///////BIKE API
	
	@Override
	public ArrayList<Bike> getBike(String query) {
		String queryBike = serverURL + "bike?" + query;
		ArrayList<Bike> res = new ArrayList<Bike>();
		try {
			JSONArray json = readJsonFromUrl(queryBike);
			Gson gson = new Gson();
			Bike[] bikeArray = gson.fromJson(json.toString(), Bike[].class);
			for (Bike bike : bikeArray) {
				System.out.println(bike);
				res.add(bike);
			}
			System.out.println("Da vao day");
			return res;
		} catch (Exception e) {
			return null;
		}

	}
	@Override
	public boolean createBike(Bike bike) {
		try {
			HttpPost request = new HttpPost(serverURL + "bike");
			HttpClient httpClient = new DefaultHttpClient();
			JSONObject jsonObj = new JSONObject();
			Gson gson = new Gson();
//			jsonObj.put("id", bike.getIdBike());
			jsonObj.put("name", bike.getName());
			jsonObj.put("type", bike.getType());
			jsonObj.put("weight", bike.getWeight());
			jsonObj.put("licensePlate", bike.getLicensePlate());
			jsonObj.put("manuafacturingDate", bike.getManuafacturingDate());
			jsonObj.put("producer", bike.getProducer());
			jsonObj.put("cost", bike.getCost());
			jsonObj.put("dockStationCode", bike.getDockStationCode());
			jsonObj.put("status", bike.getStatus());
		

			StringEntity postingString = new StringEntity(jsonObj.toString());
			postingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			request.setEntity(postingString);
			HttpResponse response = httpClient.execute(request);
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			// @Deprecated httpClient.getConnectionManager().shutdown();
		}
	}
	
	@Override
	public boolean updateBike(Bike bike) {
		try {
			HttpClient httpClient2 = new DefaultHttpClient();
			HttpPatch requestPatch = new HttpPatch("http://localhost:3000/bike/" + String.valueOf(bike.getId()));
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", bike.getName());
			jsonObj.put("type", bike.getType());
			jsonObj.put("weight", bike.getWeight());
			jsonObj.put("licensePlate", bike.getLicensePlate());
			jsonObj.put("manuafacturingDate", bike.getManuafacturingDate());
			jsonObj.put("producer", bike.getProducer());
			jsonObj.put("cost", bike.getCost());
			jsonObj.put("dockStationCode", bike.getDockStationCode());
			jsonObj.put("status", bike.getStatus());

			StringEntity putingString = new StringEntity(jsonObj.toString());
			putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			requestPatch.setEntity(putingString);
			HttpResponse response = httpClient2.execute(requestPatch);

		} catch (Exception e) {
		} finally {
		}
		return false;
	}

	
	@Override
	public boolean deleteBike(int id) {
		try {
			String queryDelete = serverURL + "bike/" + id;
			HttpClient httpClient2 = new DefaultHttpClient();
			HttpDelete requestDelete = new HttpDelete(queryDelete);
			HttpResponse response = httpClient2.execute(requestDelete);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
		    // @Deprecated httpClient.getConnectionManager().shutdown(); 
		}
		
	}
	@Override
	public boolean deleteBikeInDock(int dockId) {
		try {
			String getList = serverURL + "bike?" + "dockStationCode="+dockId;
			ArrayList<Bike> listBikeDelete = new ArrayList<Bike>();
			JSONArray json = readJsonFromUrl(getList);
			System.out.println("Vao delete roi");
			System.out.println(json);
			Gson gson = new Gson();
			Bike[] bikeArray = gson.fromJson(json.toString(), Bike[].class);
			for (Bike bike : bikeArray) {
				deleteBike(bike.getId());
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
		    // @Deprecated httpClient.getConnectionManager().shutdown(); 
		}
		
	}
	@Override
	public boolean updateDockStationAfterCreateBike(Bike newBike){
		try {
				
				String getQueryDockStation = "id=" + newBike.getDockStationCode();
				System.out.println(getQueryDockStation);
				ArrayList<DockStation> getDockStationArr = getDockStation(getQueryDockStation);
				DockStation getDockStation = new DockStation();
				getDockStation = getDockStationArr.get(0);
				System.out.println(getDockStation.toString());
			
				String typeField = new String("numberOf"+newBike.getType());
		
				if(getDockStation.getTotalDock()-getDockStation.getNumberOfEBike()-getDockStation.getNumberOfNBike()-getDockStation.getNumberOfTwinBike()>=1) {
					if(typeField.equalsIgnoreCase("numberOfNBike")) {
						getDockStation.setNumberOfNBike(getDockStation.getNumberOfNBike()+1);
					}
					if(typeField.equalsIgnoreCase("numberOfTwinBike")) {
						getDockStation.setNumberOfTwinBike(getDockStation.getNumberOfTwinBike()+1);
					}
					if(typeField.equalsIgnoreCase("numberOfEBike")) {
						getDockStation.setNumberOfEBike(getDockStation.getNumberOfEBike()+1);
					}

					System.out.println("vao update dock after create xe dap");
					System.out.println(getDockStation.toString());
					updateDockStation(getDockStation);	
				}else {
					System.out.println("Dock Station is full");
				}
				
				
				} catch (Exception e) {
					// TODO: handle exception
					return false;
				}
		return false;
		
		
	}
	
	@Override
	public ArrayList<DockStation> getDockStation(String query) {
		String queryDockStation = serverURL + "dockstation?" + query;
		ArrayList<DockStation> res = new ArrayList<DockStation>();
		try {
			JSONArray json = readJsonFromUrl(queryDockStation);
			Gson gson = new Gson();
			DockStation[] dockStationArray = gson.fromJson(json.toString(), DockStation[].class);
			for (DockStation dockStation : dockStationArray) {
				System.out.println(dockStation);
				res.add(dockStation);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	  
	  @Override
		public boolean createDockStation(DockStation dock) {
			try {
				HttpPost request = new HttpPost(serverURL + "dockstation");
				HttpClient httpClient = new DefaultHttpClient();
				JSONObject jsonObj = new JSONObject();
				Gson gson = new Gson();
//				jsonObj.put("id", bike.getIdBike());
				jsonObj.put("name", dock.getName());
				jsonObj.put("address", dock.getAddress());
				jsonObj.put("totalDock", dock.getTotalDock());
				jsonObj.put("numberOfNBike", dock.getNumberOfNBike());
				jsonObj.put("numberOfEBike", dock.getNumberOfEBike());
				jsonObj.put("numberOfTwinBike", dock.getNumberOfTwinBike());


				StringEntity postingString = new StringEntity(jsonObj.toString());
				postingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				request.setEntity(postingString);
				HttpResponse response = httpClient.execute(request);
				return true;
			} catch (Exception ex) {
				return false;
			} finally {
				// @Deprecated httpClient.getConnectionManager().shutdown();
			}
		}
		@Override
		public boolean updateDockStation(DockStation dock) {
			try {
				HttpClient httpClient2 = new DefaultHttpClient();
				HttpPatch requestPatch = new HttpPatch("http://localhost:3000/dockstation/" + String.valueOf(dock.getId()));
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("name", dock.getName());
				jsonObj.put("address", dock.getAddress());
				jsonObj.put("totalDock", dock.getTotalDock());
				jsonObj.put("numberOfNBike", dock.getNumberOfNBike());
				jsonObj.put("numberOfEBike", dock.getNumberOfEBike());
				jsonObj.put("numberOfTwinBike", dock.getNumberOfTwinBike());
				StringEntity putingString = new StringEntity(jsonObj.toString());
				putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				requestPatch.setEntity(putingString);
				HttpResponse response = httpClient2.execute(requestPatch);

			} catch (Exception e) {
			} finally {
			}
			return false;
		}
		@Override
		public boolean updateDockAfterDeleteBike(String type,int dockId) {
			//String queryDockStation = serverURL + "dockstation/" + dockId;;
		try {
			//Get DockStaion Obj
			
			String getQueryDockStation = serverURL + "dockstation/" + dockId;
			ArrayList<DockStation> getDockStationArr = getDockStation(getQueryDockStation);
			DockStation getDockStation = new DockStation();
			getDockStation = getDockStationArr.get(0);
			System.out.println(getDockStation.getId());
			
			HttpClient httpClient2 = new DefaultHttpClient();
			HttpPatch requestPatch = new HttpPatch("http://localhost:3000/dockstation/" + dockId);	
			System.out.println(requestPatch);			
			String typeField = new String("numberOf"+type);
			if(typeField.equalsIgnoreCase("numberOfNBike")) {
				getDockStation.setNumberOfNBike(getDockStation.getNumberOfNBike()-1);
			}
			if(typeField.equalsIgnoreCase("numberOfTwinBike")) {
				getDockStation.setNumberOfTwinBike(getDockStation.getNumberOfTwinBike()-1);
			}
			if(typeField.equalsIgnoreCase("numberOfEBike")) {
				getDockStation.setNumberOfEBike(getDockStation.getNumberOfEBike()-1);
			}
			
			System.out.println("Da vao update Dock");
			updateDockStation(getDockStation);
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			return true;
		
		
		}
	 
	  @Override
		public boolean deleteDockStation(int id) {
			try {
				System.out.println("delete day");
				String queryDelete = serverURL + "dockstation/" + id;
				System.out.println(queryDelete);
				HttpClient httpClient2 = new DefaultHttpClient();
				HttpDelete requestDelete = new HttpDelete(queryDelete);
				HttpResponse response = httpClient2.execute(requestDelete);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			} finally {
			    // @Deprecated httpClient.getConnectionManager().shutdown(); 
			}
			
		}
		  

	@Override
	public boolean payMoney(BankAccount account, float money) {
		try {
			HttpClient httpClient2 = new DefaultHttpClient();
			HttpPatch requestPatch = new HttpPatch(serverURL + "bankaccount/" + String.valueOf(account.getId()));
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("money", account.getMoney() - money);
			StringEntity putingString = new StringEntity(jsonObj.toString());
			putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			requestPatch.setEntity(putingString);
			HttpResponse response = httpClient2.execute(requestPatch);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// @Deprecated httpClient.getConnectionManager().shutdown();
		}
		return false;
	}
	

	@Override
	public boolean changeBikeStatus(Bike bike, int status) {
		try {
			HttpClient httpClient2 = new DefaultHttpClient();

			HttpPatch requestPatch = new HttpPatch(serverURL + "/bike/" + String.valueOf(bike.getId()));

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("status", status);
			jsonObj.put("dockStationCode", bike.getDockStationCode());
			StringEntity putingString = new StringEntity(jsonObj.toString());
			putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			requestPatch.setEntity(putingString);
			HttpResponse response = httpClient2.execute(requestPatch);
			requestPatch = new HttpPatch(serverURL + "/dockstation/" + bike.getDockStationCode());
			ArrayList<DockStation> res = getDockStation("id=" + bike.getDockStationCode());
			String keyNumBike = null;
			int valueNumBike = 0;

			if (bike.getType().equals("nbike")) {
				keyNumBike = "numberOfNBike";
				valueNumBike = res.get(0).getNumberOfNBike();
			} else if (bike.getType().equals("ebike")) {
				keyNumBike = "numberOfEBike";
				valueNumBike = res.get(0).getNumberOfEBike();
			} else if (bike.getType().equals("twinbike")) {
				keyNumBike = "numberOfTwinBike";
				valueNumBike = res.get(0).getNumberOfTwinBike();
			}
			jsonObj = new JSONObject();
			if (status == 0)
				jsonObj.put(keyNumBike, valueNumBike + 1);
			else if (status == 1)
				jsonObj.put(keyNumBike, valueNumBike - 1);
			System.out.println(jsonObj.toString());
			putingString = new StringEntity(jsonObj.toString());
			putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			requestPatch.setEntity(putingString);
			httpClient2 = new DefaultHttpClient();
			response = httpClient2.execute(requestPatch);
			return true;
		} catch (Exception e) {
		} finally {
		}
		return false;
	}

	@Override
	public boolean changeOrderStatus(Order order, int status) {
		try {
			HttpClient httpClient2 = new DefaultHttpClient();
			HttpPatch requestPatch = new HttpPatch(serverURL + "/order/" + String.valueOf(order.getId()));

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("status", status);
			StringEntity putingString = new StringEntity(jsonObj.toString());
			putingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			requestPatch.setEntity(putingString);
			HttpResponse response = httpClient2.execute(requestPatch);
			return true;
		} catch (Exception e) {
		} finally {
		}
		return false;
	}

	@Override
	public BankAccount getBankAccount(String query) {
		String queryBankAccount = serverURL + "bankaccount?" + query;
		System.out.println(queryBankAccount);
		BankAccount[] bankAccountArray = new BankAccount[2];
		try {
			JSONArray json = readJsonFromUrl(queryBankAccount);
			Gson gson = new Gson();
			bankAccountArray = gson.fromJson(json.toString(), BankAccount[].class);
			return bankAccountArray[0];
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Order getUnpayOrder(String codePayment) {
		String query = serverURL + "order?status=0&codePayment=" + codePayment;
		System.out.println(query);
		Order[] orderArray = new Order[2];
		try {
			JSONArray json = readJsonFromUrl(query);
			Gson gson = new Gson();
			System.out.println(json.toString());
			orderArray = gson.fromJson(json.toString(), Order[].class);
			System.out.println(orderArray[0].toString());
			return orderArray[0];
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Order getOrderByIdBike(String IdBike) {
		String query = serverURL + "order?status=0&idBike=" + IdBike;
		System.out.println(query);
		Order[] orderArray = new Order[2];
		try {
			System.out.println("EXCEPTION");
			JSONArray json = readJsonFromUrl(query);
			Gson gson = new Gson();
			System.out.println(json.toString());
			orderArray = gson.fromJson(json.toString(), Order[].class);
			System.out.println("EXCEPTION");
			System.out.println(orderArray[0].toString());
			System.out.println("EXCEPTION");
			return orderArray[0];
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public boolean createOrder(Order order) {
		try {
			HttpPost request = new HttpPost(serverURL + "order");
			HttpClient httpClient = new DefaultHttpClient();
			JSONObject jsonObj = new JSONObject();
			Gson gson = new Gson();
			jsonObj.put("idBike", order.getIdBike());
			jsonObj.put("startOrder", order.getStartOrder());
			jsonObj.put("endOrder", order.getEndOrder());
			jsonObj.put("codePayment", order.getCodePayment());
			jsonObj.put("status", order.getStatus());
			jsonObj.put("depositMoney", order.getDepositMoney());

			StringEntity postingString = new StringEntity(jsonObj.toString());
			postingString.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			request.setEntity(postingString);
			HttpResponse response = httpClient.execute(request);
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			// @Deprecated httpClient.getConnectionManager().shutdown();
		}
	}
	@Override
	public ArrayList<Order> getOrders(String query) {
			 //TODO Auto-generated method stub
			String queryOrder = serverURL + "order?" + query;
			ArrayList<Order> res = new ArrayList<Order>();
			System.out.println(queryOrder);
			try {
				JSONArray json = readJsonFromUrl(queryOrder);
				Gson gson = new Gson();
				Order[] orderArray = gson.fromJson(json.toString(), Order[].class);
				for (Order order : orderArray) {
					System.out.println(order);
					res.add(order);
				}
				return res;
			} catch (Exception e) {
				return null;
			}
		
	}


}
