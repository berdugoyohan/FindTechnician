package org.example.Example1;

/*this class prepare the project to receive info and data from the local database 
 * by initialize parameters of the database*/

import java.io.Serializable;

import com.google.android.maps.GeoPoint;

public class LSB implements Serializable
{

	private static final long serialVersionUID = 4374317167851508844L;

	public LSB()
	{
	}
	public LSB(String name, String adress, String city, String description,
			String coordonates) 
	{
		this.Name = name;
		this.Address = adress;
		this.City = city;
		this.Description = description;
		this.setCoordonates(coordonates);

	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getAddress()
	{
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}

	public String getCity()
	{
		return City;
	}

	public void setCity(String city)
	{
		City = city;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public GeoPoint getCoordonates()
	{
		return Coordonates;
	}

	public GeoPoint setCoordonates(GeoPoint coordonates)
	{
		return Coordonates = coordonates;
	}

	public GeoPoint setCoordonates(String coordonates) 
	{
		try
		{
			String[] s = coordonates.replace("\"", "").split(",");
			return Coordonates = new GeoPoint((int) (Double.parseDouble(s[0]) * 1E6),
					(int) (Double.parseDouble(s[1]) * 1E6));

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	private String Name;
	private String Address;
	private String City;
	private String Description;
	private GeoPoint Coordonates;

}
