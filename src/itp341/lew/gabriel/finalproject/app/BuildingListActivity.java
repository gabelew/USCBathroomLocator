package itp341.lew.gabriel.finalproject.app;

import itp341.lew.gabriel.finalproject.app.data.BuildingAdapter;
import itp341.lew.gabriel.finalproject.app.model.Building;
import itp341.lew.gabriel.finalproject.app.model.BuildingDataStore;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class BuildingListActivity extends ListActivity {

	private static final String TAG = BuildingListActivity.class.getSimpleName();

	private static final int INTENT_REQUEST_CODE_MAP = 1;
	private static final int INTENT_REQUEST_CODE_EDIT_BUILDING = 2;

	private ArrayList<Building> buildings;
	private BuildingAdapter adapter; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_list);
		buildings = BuildingDataStore.loadBuildings(getApplicationContext());
		adapter = new BuildingAdapter(this, buildings);

		
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_building_list, menu);
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_item_map:
			Intent i = new Intent(getApplicationContext(), MapActivity.class);
			startActivityForResult(i, INTENT_REQUEST_CODE_MAP);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent i = new Intent(getApplicationContext(), BuildingEditActivity.class);
		i.putExtra(BuildingEditActivity.EXTRA_BUILDING_OBJECT, buildings.get(position));
		i.putExtra(BuildingEditActivity.EXTRA_BUILDING_ARRAY_POSITION, position);
		startActivityForResult(i, INTENT_REQUEST_CODE_EDIT_BUILDING);
	}

	@Override
	protected void onPause() {
		super.onPause();
		BuildingDataStore.saveBuildings(buildings, getApplicationContext());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			// user pressed back and didn't save
			Building note = (Building) data.getSerializableExtra(BuildingEditActivity.EXTRA_BUILDING_OBJECT);
			
			if (requestCode == INTENT_REQUEST_CODE_EDIT_BUILDING) {
				int position = data.getIntExtra(BuildingEditActivity.EXTRA_BUILDING_ARRAY_POSITION, -1);
				if (position != -1)
					buildings.set(position, note);
			} else if (requestCode == INTENT_REQUEST_CODE_MAP) {
				
			}
			adapter.notifyDataSetChanged();
		}
	}    

}
