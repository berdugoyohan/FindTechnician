package org.example.Example1;

/*this class is getting and setting data from the database*/

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class OverlayDataItem extends OverlayItem
{
	private int DataID;
	public int getDataID() 
	{
		return DataID;
	}
	public void setDataID(int data) 
	{
		DataID = data;
	}
	public OverlayDataItem(GeoPoint point, String title, String snippet)
	{
		super(point, title, snippet); 
	}
}
