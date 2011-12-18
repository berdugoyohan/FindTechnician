package org.example.Example1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class Example1Activity extends Activity implements OnClickListener 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
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
    	// ...
    	public void onClick(View v)
    	{
	    	switch (v.getId())
	    	{
		    	case R.id.help_button:
		    	Intent i = new Intent(this, Help.class);
		    	startActivity(i);
		    	break;
		    	case R.id.exit_button:
		    	/*Intent j=new Intent(this, Exit.class);	//don't need it anymore...if we active it it will give a 
		    	startActivity(j);*/							//text like the help button
		    	finish();
		    	System.exit(0);
		    	break;
		    	/*case R.id.find_button:
		    	Intent g = new Intent(this, Find.class);
		    	startActivity(g);
		    	break;*/
		    	
		    	// More buttons go here (if any) ...
	    	}
    	}
    
  }