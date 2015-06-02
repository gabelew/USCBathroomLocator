package itp341.lew.gabriel.finalproject.app.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Building implements Serializable{
	//JSON keys
	private static final String JSON_NAME = "name";
	private static final String JSON_ADDRESS = "address";
	private static final String JSON_CODE = "code";
	private static final String JSON_DESC = "description";
	private static final String JSON_NUMREST = "restrooms";
	
	private String name;
	private String address;
	private String code;
	private String description;
	private int numRestrooms;
	
	public Building() {
		this.name = "Blank Note";
		this.address = "";
		this.code = "";
	}
	
	public Building(String title, String content, String code, String description, int restrooms) {
		this.name = title;
		this.address = content;
		this.code = code;
		this.description = description;
		this.numRestrooms = restrooms;
	}
	
	/**Constructor to create Note object from JSON object
	* @param JSONObject
	* @throws JSONException
	*/
	public Building(JSONObject json) throws JSONException {
		this.name = json.getString(JSON_NAME);
		this.address = json.getString(JSON_ADDRESS);
		this.code = json.getString(JSON_CODE);
		this.description = json.getString(JSON_DESC);
		this.numRestrooms = json.getInt(JSON_NUMREST);
	}
	
	/**Constructor to convert Note object into JSON object
	* @param JSONObject
	* @throws JSONException
	*/
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_NAME, name);
		json.put(JSON_ADDRESS, address);
		json.put(JSON_CODE, code);
		json.put(JSON_DESC, description);
		json.put(JSON_NUMREST, numRestrooms);
		return json;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return address;
	}

	public void setAddres(String addres) {
		address = addres;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumRestroom() {
		return numRestrooms;
	}

	public void setNumRestroom(int numRestroom) {
		numRestrooms = numRestroom;
	}

	
}
