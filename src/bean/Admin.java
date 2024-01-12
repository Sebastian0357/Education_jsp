package bean;

/**  

* <p>Title: Admin.java</p>  

* <p>Description: </p>  

* @author WuTong

* @date 2024年1月10日  

* @version 1.0  

*/  
public class Admin
{
	private String uname;
	private String pwd;
	public Admin()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String uname, String pwd)
	{
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	
}
