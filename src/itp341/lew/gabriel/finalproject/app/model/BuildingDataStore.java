package itp341.lew.gabriel.finalproject.app.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;

public class BuildingDataStore {
	private static final String TAG = BuildingDataStore.class.getSimpleName();
	private static final String FILENAME = "buildings.json";
	
	/**
	 * saveBuildings
	 * @param ArrayList<Building> buildings
	 * @param Context context
	 */
	public static void saveBuildings(ArrayList<Building> buildings, Context context) {
		Log.d(TAG, "saveBuildings");
		// build an array in JSON
		JSONArray array = new JSONArray();
		for (Building b : buildings) {
			try {
				array.put(b.toJSON());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		// write the file to disk
		Writer writer = null;
		OutputStream out;
		try {
			out = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			writer = new OutputStreamWriter(out);
			writer.write(array.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * loadBuildings
	 * @param context
	 * @return
	 */
	public static ArrayList<Building> loadBuildings(Context context) {
		Log.d(TAG, "loadBuildings");
		ArrayList<Building> buildings = new ArrayList<Building>(); 
		BufferedReader reader = null;
		try {
			// open and read the file into a StringBuilder
			//get JSON file from assets
			InputStream in = context.getAssets().open(FILENAME);
			if (in != null) {
				reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder jsonString = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					// line breaks are omitted and irrelevant
					jsonString.append(line);
				}
				// parse the JSON using JSONTokener
				JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
				// build the array of buildings from JSONObjects
				for (int i = 0; i < array.length(); i++) {
					buildings.add(new Building(array.getJSONObject(i)));
				}
			}
			if (reader != null)
				reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return buildings;
	}

}
