package org.example.Example1;

//=========================================================================================

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

//=========================================================================================

public class Example1Activity extends Activity implements OnClickListener 
{
			//static MediaPlayer ourSong;
		    @Override
		    public void onCreate(Bundle savedInstanceState)
		    {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main);
		        //ourSong=MediaPlayer.create(Example1Activity.this,R.raw.asfur);
		        //ourSong.start();
		        
		        // Set up click listeners for all the buttons
		        
		        View findButton = findViewById(R.id.find_button);
		        findButton.setOnClickListener(this);
		        View newButton = findViewById(R.id.seekBar1);
		        newButton.setOnClickListener(this);
		        View helpButton = findViewById(R.id.help_button);
		        helpButton.setOnClickListener(this);
		        View exitButton = findViewById(R.id.exit_button);
		        exitButton.setOnClickListener(this);
		       
		     
		    }
//==========================================================================================
		    
		    @Override
		    public boolean onCreateOptionsMenu(Menu menu)
		    {
			    super.onCreateOptionsMenu(menu);
			    MenuInflater inflater = getMenuInflater();
			    inflater.inflate(R.menu.menu, menu);
			    return true;
		    }
		    
//==========================================================================================
		    
		    @Override
		    public boolean onOptionsItemSelected(MenuItem item)
		    {
			    switch (item.getItemId())
			    {
				    case R.id.settings:
				    startActivity(new Intent(this, Prefs.class));
				    return true;
				    // More items go here (if any) ...
			    }
		    return false;
		    }
		    
		    
		    public void onClick(View v)
		    {
			    switch (v.getId())
			    {
			      //============================
				    case R.id.help_button:
				    Intent i = new Intent(this, Help.class);
				    startActivity(i);
				    break;
				  //============================
				    case R.id.exit_button:
				    //ourSong.release();
				    finish();
				    break;
				  //============================
				    case R.id.find_button:
				    Intent g = new Intent(this, LBSActivity.class);
				    startActivity(g);
				    break;
				  //============================
				    // More buttons go here (if any) ...
			    }
		    }
//==========================================================================================
		    public class AndroidColorResources extends Activity 
		    {
		    	/** Called when the activity is first created. */
		    	@Override
		    	public void onCreate(Bundle savedInstanceState)
		    	{
		    		super.onCreate(savedInstanceState);
		    		setContentView(R.layout.main);

		    	
		    	}
		    }
}