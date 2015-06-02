package itp341.lew.gabriel.finalproject.app;

import java.io.IOException;
import java.io.InputStream;

import itp341.lew.gabriel.finalproject.app.model.Building;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingEditActivity extends Activity {
	public static final String TAG = BuildingEditActivity.class.getSimpleName();
	public static final String EXTRA_BUILDING_OBJECT = "itp341.lew.gabriel.finalproject.extra_building_object";
	public static final String EXTRA_BUILDING_ARRAY_POSITION = "itp341.lew.gabriel.finalproject.extra_building_array_position";
	
	private TextView textName;
	private TextView textDescription;
	private TextView textCode;
	private TextView textAddress;
	private TextView textRestrooms;
	private ImageView imageBuilding;
	
	//private Button buttonSave;
	private Building building;
	int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_edit);
		
		textName = (TextView) findViewById(R.id.edit_title);
		textDescription = (TextView) findViewById(R.id.edit_content);
		textCode = (TextView) findViewById(R.id.text_code);
		textAddress = (TextView) findViewById(R.id.text_address);
		textRestrooms = (TextView) findViewById(R.id.textRestrooms);
		imageBuilding = (ImageView)findViewById(R.id.imageBuilding); 
		
//		buttonSave = (Button) findViewById(R.id.button_save);
//		
//		buttonSave.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Log.d(TAG, "onClick");
//				saveAndClose();
//			}
//		});
		
		Intent i = getIntent();
		building = (Building) i.getSerializableExtra(EXTRA_BUILDING_OBJECT);
		position = i.getIntExtra(EXTRA_BUILDING_ARRAY_POSITION, -1);
		
		if (building != null) {
			// load building data
			textName.setText(building.getName());
			textDescription.setText(building.getDescription());
			textCode.setText(building.getCode());
			textRestrooms.setText(Integer.toString(building.getNumRestroom()));
			textAddress.setText(building.getAddres());
			String imageName = building.getCode() + ".jpg";
			// loads appropriate building image from assets
			try {
				InputStream ims = getAssets().open(imageName);
				Drawable d = Drawable.createFromStream(ims, null);
				imageBuilding.setImageDrawable(d);
			} catch(IOException ex) {
				return;
			}
		}	
	}
	
//	private void saveAndClose() {
//		if (building == null)
//			building = new Building();
//		
//		building.setName(textName.getText().toString());
//		building.setDescription(textDescription.getText().toString());
//		//building.setDate();
//		
//		Intent i = new Intent();
//		i.putExtra(EXTRA_BUILDING_OBJECT, building);
//		i.putExtra(EXTRA_BUILDING_ARRAY_POSITION, position);
//		setResult(RESULT_OK, i);
//		finish();
//	}
}
