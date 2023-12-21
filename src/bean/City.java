package bean;

import java.util.Arrays;

public class City
{
	private String cityname;
	private String[] basearr;
	private String picture;
	
	
	public City()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public City(String cityname, String[] basearr, String picture)
	{
		super();
		this.cityname = cityname;
		this.basearr = basearr;
		this.picture = picture;
	}


	public String getCityname()
	{
		return cityname;
	}


	public void setCityname(String cityname)
	{
		this.cityname = cityname;
	}


	public String[] getBasearr()
	{
		return basearr;
	}


	public void setBasearr(String[] basearr)
	{
		this.basearr = basearr;
	}


	public String getPicture()
	{
		return picture;
	}


	public void setPicture(String picture)
	{
		this.picture = picture;
	}


	@Override
	public String toString()
	{
		return "City [cityname=" + cityname + ", basearr=" + Arrays.toString(basearr) + ", picture=" + picture + "]";
	}
	
	
}
