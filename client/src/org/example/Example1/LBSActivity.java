package org.example.Example1;

/*this class is the class that create the points on the map and 
 * implement some functions of the point show.
 * we need this class to be a kind of "linker" for the map point
 * */

import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MyLocationOverlay;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.graphics.drawable.Drawable;
import org.example.Example1.itimizedOverlay;
import com.google.android.maps.Overlay;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.util.List;

public class LBSActivity extends MapActivity implements LocationListener
{
	private double lat = 0;
	private double lng = 0;
	List<Overlay> mapOverlays;
	Drawable drawable;
	itimizedOverlay itemizedOverlay;
	MapController mc;
	private Context context;
	private LocationManager lm = null;
	MapView mapView;
	GeoPoint p;
	private MyLocationOverlay myLocation = null;
	//==================================================================================================================================================
	//==================================================================================================================================================
	/** Called when the activity is first created. */
	@Override
	//==================================================================================================================================================
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		context = getApplicationContext();
		setContentView(R.layout.show_the_map);


		lm = (LocationManager)this. getSystemService(LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0,this);
		
		mapView = (MapView) findViewById(R.id.mapView);
		//LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);
		mapOverlays = mapView.getOverlays();
		drawable = getResources().getDrawable(R.drawable.marker_green);
		itemizedOverlay = new itimizedOverlay(drawable, mapView);

		mc = mapView.getController();
		String coordinates[] = {"31.769104","35.193812"};
		double lat = Double.parseDouble(coordinates[0]);
		double lng = Double.parseDouble(coordinates[1]);
		p = new GeoPoint((int) (lat * 1E6),(int) (lng * 1E6));
		mc.animateTo(p);
		mc.setZoom(10);
		//---Add a location marker---
		Button locateme =(Button)findViewById(R.id.locateme);
		locateme.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				locateme();
			}
		});
		setpointonmap();			
	}
	//==================================================================================================================================================
	@Override
	protected boolean isRouteDisplayed()
	{
		// TODO Auto-generated method stub
		return false;
	}
	public void locateme()
	{
		myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
		myLocation.runOnFirstFix(new Runnable()
		{
			public void run() 
			{
				mc.animateTo(myLocation.getMyLocation());
				mc.setZoom(17);
				mc = mapView.getController();
				lat = myLocation.getMyLocation().getLatitudeE6();
				lng = myLocation.getMyLocation().getLongitudeE6();
			}
		});
		mapView.getOverlays().add(myLocation);
	}
	@Override
	public void onLocationChanged(Location arg0) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void onProviderDisabled(String provider)
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void onProviderEnabled(String provider) 
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) 
	{
		// TODO Auto-generated method stub
	}
	private void setpointonmap() 
	{
		mapOverlays.add(itemizedOverlay);
		LSBCollection lsbCollection = LSBCollection.GetCurrent(getApplicationContext());
		for (int i = 0; i < lsbCollection.size(); i++) 
		{
			// Add point to the map
			LSB lsb= lsbCollection.get(i);
			GeoPoint gp = lsb.getCoordonates();
			if (gp != null) 
			{
				OverlayDataItem overlayItem = new OverlayDataItem(gp,lsb.getName(),lsb.getDescription());
				overlayItem.setDataID(i);
				itemizedOverlay.addOverlay(overlayItem);
			}
		}
	}
}