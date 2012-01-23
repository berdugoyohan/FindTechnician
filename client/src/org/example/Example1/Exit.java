package org.example.Example1;

/*this class make an OnCreate for the Exit button that will exit the application*/

import android.app.Activity;
import android.os.Bundle;

public class Exit extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit);
		
	}

}
