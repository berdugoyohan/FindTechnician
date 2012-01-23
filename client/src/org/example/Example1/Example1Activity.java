package org.example.Example1;

/* this class is one of the most important in this project.
 * this class is the first that are called when the application is launched
 * and she manage the way that the application will response  
 * */
 //=========================================================================================
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
//=========================================================================================
//=========================================================================================
public class Example1Activity extends Activity implements OnClickListener 
{
			private ProgressDialog progressDialog;
			Context context;
			//==========================================================================================
			//==========================================================================================
		    @Override
		    public void onCreate(Bundle savedInstanceState)
		    {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.main);
		         // Set up click listeners for all the buttons
		        View findButton = findViewById(R.id.find_button);
		        findButton.setOnClickListener(this);
		        View helpButton = findViewById(R.id.help_button);
		        helpButton.setOnClickListener(this);
		        View exitButton = findViewById(R.id.exit_button);
		        exitButton.setOnClickListener(this);
		        progressDialog = new ProgressDialog(this);
				context = getApplicationContext();
		      }
//==========================================================================================
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
//==========================================================================================		    
//==========================================================================================		    
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
				    	LoadData();
				    	break;
				  //============================
				  // More buttons go here (if any) ...
			    }
		    }
//==========================================================================================
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
//==========================================================================================
//==========================================================================================
		    private void LoadData()
		    {
		    	progressDialog.setMessage("Loading...");
		    	progressDialog.show();
		    	(new AsyncTask<Void, Void, Void>() 
				{
		    		//==========================================================================================
		    		@Override
					protected Void doInBackground(Void... params) 
					{
						// verify if we need to load again
						LSBCollection lsbCollection = LSBCollection.GetCurrent(context);
						if (lsbCollection.size() == 0)
						{ 
							Log.e("", " reading p list");
							lsbCollection.loadAgences(getApplicationContext());
						}
						return null;
					};
					//==========================================================================================
					protected void onPostExecute(Void result)
					{
						Intent i = new Intent(Example1Activity.this,
						LBSActivity.class);
						startActivity(i);
						progressDialog.dismiss();
					}
					//==========================================================================================
				}).execute();
			}
//==========================================================================================
//==========================================================================================
}