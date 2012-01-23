package org.example.Example1;

/*this class take care to initialized the item of the overlay's point on the map*/

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.MapView;
public class itimizedOverlay extends BalloonItemizedOverlay<OverlayDataItem>
{
	
	private  ArrayList<OverlayDataItem> m_overlays = new ArrayList<OverlayDataItem>();
	private Context c;
	
	public itimizedOverlay(Drawable defaultMarker, MapView mapView)
	{
		super(boundCenter(defaultMarker), mapView);
		setC(mapView.getContext());
	}
	public void addOverlay(OverlayDataItem overlay) 
	{
	    m_overlays.add(overlay);
	    populate();
	}
	@Override
	protected OverlayDataItem createItem(int i) 
	{
		return m_overlays.get(i);
	}
	@Override
	public int size() 
	{
		return m_overlays.size();
	}
	public void setC(Context c) 
	{
		this.c = c;
	}
	public Context getC()
	{
		return c;
	}
	@Override
	protected boolean onBalloonTap(int index, OverlayDataItem item)
	{
		return true;
	}
}


