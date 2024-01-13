package bean;


/**  

* <p>Title: City.java</p>  

* <p>Description: </p>  

* @author WuTong

* @date 2024Äê1ÔÂ14ÈÕ  

* @version 1.0  

*/  
public class City
{
	private String cityname;
	private String base;
	private String picture;
	public City()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String cityname, String base, String picture)
	{
		super();
		this.cityname = cityname;
		this.base = base;
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
	public String getBase()
	{
		return base;
	}
	public void setBase(String base)
	{
		this.base = base;
	}
	public String getPicture()
	{
		return picture;
	}
	public void setPicture(String picture)
	{
		this.picture = picture;
	}
	
	
	
	
	
}
