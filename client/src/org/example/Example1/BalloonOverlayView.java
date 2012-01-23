package org.example.Example1;

import android.content.Context;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.maps.OverlayItem;
import android.content.Intent;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.util.Log;

/**
 * A view representing a MapView marker information balloon.
 * <p>
 * This class has a number of Android resource dependencies:
 * <ul>
 * <li>drawable/balloon_overlay_bg_selector.xml</li>
 * <li>drawable/balloon_overlay_close.png</li>
 * <li>drawable/balloon_overlay_focused.9.png</li>
 * <li>drawable/balloon_overlay_unfocused.9.png</li>
 * <li>layout/balloon_map_overlay.xml</li>
 * </ul>
 * </p>
 */
public class BalloonOverlayView<Item extends OverlayItem> extends FrameLayout
{
	private LinearLayout layout;
	private TextView title;
	private TextView snippet;
	/**
	 * Create a new BalloonOverlayView.
	 * 
	 * @param context - The activity context.
	 * @param balloonBottomOffset - The bottom padding (in pixels) to be applied
	 * when rendering this view.
	 */
	public BalloonOverlayView(Context context, int balloonBottomOffset) 
	{
		super(context);
		setPadding(10, 0, 10, balloonBottomOffset);
		layout = new LinearLayout(context);
		layout.setVisibility(VISIBLE);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.balloon_overlay, layout);
		title = (TextView) v.findViewById(R.id.balloon_item_title);
		snippet = (TextView) v.findViewById(R.id.balloon_item_snippet);

		
		
		
		ImageView close = (ImageView) v.findViewById(R.id.close_img_button);
		close.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				layout.setVisibility(GONE);
			}
		});

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.NO_GRAVITY;

		addView(layout, params);

		}
	/**
	 * Sets the view data from a given overlay item.
	 * 
	 * @param item - The overlay item containing the relevant view data 
	 * (title and snippet). 
	 */

	public void setData(Item item) 
	{
		layout.setVisibility(VISIBLE);
		if (item.getTitle() != null) 
		{
			title.setVisibility(VISIBLE);
			title.setText(item.getTitle());
		} else 
		{
			title.setVisibility(GONE);
		}
		if (item.getSnippet() != null) 
		{
			snippet.setVisibility(VISIBLE);
			snippet.setText(item.getSnippet());
		} else 
		{
			snippet.setVisibility(GONE);
		}
	}
	
	public class phonecalls extends Activity {
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        call();
	    }

	private void call() {
	    try {
	        Intent callIntent = new Intent(Intent.ACTION_CALL);
	        callIntent.setData(Uri.parse("tel:123456789"));
	        startActivity(callIntent);
	    } catch (ActivityNotFoundException activityException) {
	        Log.e("dialing-example", "Call failed", activityException);
	    }
	}

	}
	      
	
	
	
}



