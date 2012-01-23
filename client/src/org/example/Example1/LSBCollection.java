package org.example.Example1;

/*this class is make the "Parse " of the database data.
 * it do it by implement the Plist objects*/

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.content.res.AssetManager;
import com.longevitysoft.android.xml.plist.PListXMLHandler;
import com.longevitysoft.android.xml.plist.PListXMLParser;
import com.longevitysoft.android.xml.plist.domain.Dict;
import com.longevitysoft.android.xml.plist.domain.PList;
import com.longevitysoft.android.xml.plist.domain.PListObject;

enum Language
{
	hebrew, english
};

@SuppressWarnings("serial")
public class LSBCollection extends ArrayList<LSB>
{

	Language pListLanguage;
	Context context;
	private LSBCollection(Context context)
	{
		this.context = context;
	}
	private static LSBCollection current;
	public static LSBCollection GetCurrent(Context context)
	{
		if (current == null)
		{
			current = new LSBCollection( context);
		}
		return current;
	}
	// parse the Plist and create a list of agencies
	public void loadAgences(Context context)
	{
		InputStream is = null;
		try 
		{
			// create parser base objects
			PListXMLParser parser = new PListXMLParser();
			PListXMLHandler handler = new PListXMLHandler();
			parser.setHandler(handler);

			// get the correct plist file according to the current language
			// the plist file is located in the Assets folder
			String file = context.getResources().getString(R.string.technicien)+ ".plist";
			AssetManager am = context.getAssets();
			is = am.open(file);

			// read the plist file and parse it into a PLIST object
			byte[] data = com.longevitysoft.android.util.convertStreamToByteArray(is);
			parser.parse(new String(data));
			PList actualPList = ((PListXMLHandler) parser.getHandler())
					.getPlist();

			// Array array = (Array) actualPList.getRootElement();
			Map<String, PListObject> dic = ((Dict) actualPList.getRootElement())
					.getConfigMap();

			// fill our Agencies list
			for (Map.Entry< String, PListObject> entry : dic.entrySet())
			{
				Dict dict = (Dict) entry.getValue();
				String name = ((com.parser.android.xml.plist.domain.String) (dict
						.getConfigMap().get("Name"))).getValue();
				String adress = ((com.parser.android.xml.plist.domain.String) (dict
						.getConfigMap().get("Address"))).getValue();
				String city = ((com.parser.android.xml.plist.domain.String) (dict
						.getConfigMap().get("City"))).getValue();
				String description = ((com.parser.android.xml.plist.domain.String) (dict
						.getConfigMap().get("Description"))).getValue();
				String coordonates = ((com.parser.android.xml.plist.domain.String) (dict
						.getConfigMap().get("Coordonates"))).getValue();

				this.add(new LSB(name, adress, city, description,
						coordonates));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (Exception e2) 
				{

				}
		}
	}
}
