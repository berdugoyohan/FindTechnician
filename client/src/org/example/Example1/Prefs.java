package org.example.Example1;

/*this class represent the preferences settings of
 * the on tap menu settings*/

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Prefs extends PreferenceActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}

}