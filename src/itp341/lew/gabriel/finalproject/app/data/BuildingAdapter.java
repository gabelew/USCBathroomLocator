package itp341.lew.gabriel.finalproject.app.data;

import itp341.lew.gabriel.finalproject.app.R;
import itp341.lew.gabriel.finalproject.app.model.Building;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BuildingAdapter extends BaseAdapter {
	private static LayoutInflater inflater = null;
	private final Activity context;
	private final ArrayList<Building> buildings;
	
	public BuildingAdapter(Activity context, ArrayList<Building> buildings) {
		this.context = context;
		this.buildings = buildings;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return buildings.size();
	}

	@Override
	public Object getItem(int position) {
		return buildings.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		if (view == null)
			view = inflater.inflate(R.layout.list_item_building, null);
		TextView textTitle = (TextView) view.findViewById(R.id.text_title);
		textTitle.setText(buildings.get(position).getName());
		TextView textDate = (TextView) view.findViewById(R.id.text_date);
		textDate.setText(Integer.toString(buildings.get(position).getNumRestroom()));
		return view;
	}

}
