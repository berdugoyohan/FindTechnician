package org.example.Example1;

//import android.app.Activity;
import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;  
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import android.view.View;
import android.widget.LinearLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import com.google.android.maps.Overlay;
import java.util.List;

public class LBSActivity extends MapActivity
{
	
	MapView mapView;
	MapController mc;
	GeoPoint p;
	
	class MapOverlay extends com.google.android.maps.Overlay
	{
		@Override
		public boolean draw(Canvas canvas, MapView mapView,
				boolean shadow, long when)
		{
			super.draw(canvas, mapView, shadow);
			//---translate the GeoPoint to screen pixels---
			Point screenPts = new Point();
			mapView.getProjection().toPixels(p, screenPts);
			//---add the marker---
			Bitmap bmp = BitmapFactory.decodeResource(
					getResources(), R.drawable.pushpin);
			canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);
			return true;
		}
	}
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_the_map);
        
        mapView = (MapView) findViewById(R.id.mapView);
        LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(false);
        
        
        mc = mapView.getController();
        String coordinates[] = {"31.769104","35.193812"};
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
        p = new GeoPoint(
        (int) (lat * 1E6),
        (int) (lng * 1E6));
        mc.animateTo(p);
        mc.setZoom(19);
      //---Add a location marker---
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);
        
        mapView.invalidate();
        

    }
    @Override
    protected boolean isRouteDisplayed()
    {
    // TODO Auto-generated method stub
    return false;
    }
}