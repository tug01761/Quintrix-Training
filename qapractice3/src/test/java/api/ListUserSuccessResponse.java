package api;

import java.util.List;

import org.json.simple.JSONObject;

public class ListUserSuccessResponse {

	public String page;
	public String per_page;
	public String total;
	public String total_pages;
	public List<JSONObject> data;
	public JSONObject support;
	public JSONObject ad;
	
	public ListUserSuccessResponse(String page, String per_page, String total, String total_pages, List<JSONObject> data, JSONObject support, JSONObject ad)
	{
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
		this.support = support;
		this.ad = ad;
		
	}
	
	public String toString() {
		return "Data: " + this.data + "\nSupport:" + this.support + "\nAd: " + this.ad;
	}
}
