package itp341.lew.gabriel.finalproject.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity
implements OnMapReadyCallback {
	
	private static final int INTENT_REQUEST_CODE_LIST_BUILDINGS = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		MapFragment mapFragment = (MapFragment) getFragmentManager()
			    .findFragmentById(R.id.map);
			mapFragment.getMapAsync(this);
	}

	@Override
	public void onMapReady(GoogleMap map) {
		BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.toilet);
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.020128, -118.290725))
	        .title("Andrus Gerontology Center (GER)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.020923, -118.289447))
	        .title("Olin Hall (OHE)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.019515, -118.282841))
	        .title("Alumni House (ALM)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.021858, -118.289586))
	        .title("Childs Way Building I (CWO)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.024060, -118.286347))
	        .title("Norris Dental Science Center (DEN)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.020849, -118.287875))
	        .title("Hedco Neurosciences Building (HNB)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.019697, -118.287794))
	        .title("Loker Hydrocarbon Research Institute (LHI)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.020044, -118.286448))
	        .title("Ronald Tutor Campus Center (TCC)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.018860, -118.285741))
	        .title("Bridge Hall (BRI)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.020946, -118.285559))
	        .title("Bovard Auditorium (ADM)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.023159, -118.284297))
	        .title("United University Church (UUC)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.022331, -118.283682))
	        .title("College Academic Services (CAS)")
	        .icon(icon));
		 
		 map.addMarker(new MarkerOptions()
	        .position(new LatLng(34.019903, -118.281639))
	        .title("Figueroa Bldg (FIG)")
	        .icon(icon));
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_map_list, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_item_list:
			Intent i = new Intent(getApplicationContext(), BuildingListActivity.class);
			startActivityForResult(i, INTENT_REQUEST_CODE_LIST_BUILDINGS);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}