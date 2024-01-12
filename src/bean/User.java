package bean;

/**  

* <p>Title: User.java</p>  

* <p>Description: </p>  

* @author WuTong

* @date 2024年1月10日  

* @version 1.0  

*/  
public class User 
{
	private String uname;
	private String pwd;
	private String gender;
	private String email;
	private String introduce;
	private String birthday;
	private String organization;
	private String phone;
	private String picture;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(String uname, String pwd)
	{
		super();
		this.uname = uname;
		this.pwd = pwd;
	}


	public User(
			String uname, String pwd, String gender, String email, String introduce, String birthday,
			String organization, String phone, String picture
	)
	{
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.gender = gender;
		this.email = email;
		this.introduce = introduce;
		this.birthday = birthday;
		this.organization = organization;
		this.phone = phone;
		this.picture = picture;
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


	public String getGender()
	{
		return gender;
	}


	public void setGender(String gender)
	{
		this.gender = gender;
	}


	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email)
	{
		this.email = email;
	}


	public String getIntroduce()
	{
		return introduce;
	}


	public void setIntroduce(String introduce)
	{
		this.introduce = introduce;
	}


	public String getBirthday()
	{
		return birthday;
	}


	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}


	public String getOrganization()
	{
		return organization;
	}


	public void setOrganization(String organization)
	{
		this.organization = organization;
	}


	public String getPhone()
	{
		return phone;
	}


	public void setPhone(String phone)
	{
		this.phone = phone;
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
