package api;

import org.json.simple.JSONObject;

public class SingleUserSuccessResponse {

	public JSONObject data;
	public JSONObject support;
	public JSONObject ad;
	
	public SingleUserSuccessResponse(JSONObject data, JSONObject support, JSONObject ad)
	{
		this.data = data;
		this.support = support;
		this.ad = ad;
		
	}
	
	public String toString() {
		return "Data: " + this.data + "\nSupport:" + this.support + "\nAd: " + this.ad;
	}
	
}
