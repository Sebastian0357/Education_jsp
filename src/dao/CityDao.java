package dao;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.City;

public class CityDao extends BaseDao
{
	//查找所有城市信息
	public ArrayList<City> findCityList()
	{
		ArrayList<City> cList = new ArrayList<City>();
		Connection conn = getConn();
		String sql = "select * from citytable";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				City c = new City();
				c.setCityname(rs.getString(1));
				c.setPicture(rs.getString(2));
				
				String pic = rs.getString(2);
				if(pic==null || pic.length()==0) c.setPicture("default.jpg");
				else c.setPicture(rs.getString(2));
				
				c.setBase(rs.getString(3));
				
				cList.add(c);
			}
			closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}

	//条件查询：基于城市名查找并返回对应的城市基地信息
	public City findByName(String cityname)
	{
		City c = null;
		Connection conn = getConn();
		
		//SQL条件查询语句
		String sql = "select * from citytable where cityname = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cityname);
			ResultSet rs = ps.executeQuery();
			if(rs.next())//基于主键id查询，最多迭代一次
			{
				//阿拉伯数字1-8，对应数据库friendinfo表中的1-8列属性
				//建议：如果不写数字，改写属性名，会提高程序的可读性。
				c = new City();
				c.setCityname(rs.getString(1));
				c.setBase(rs.getString(3));
				
				//获取头像图片的uri
				String pic = rs.getString(2);
				//如用户未选择图片，则上传默认头像default.jpg
				if(pic==null || pic.length()==0)
				{
					c.setPicture("default.jpg");
				} else
				{
					c.setPicture(rs.getString(2));
				}							
			}
			closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return c;
	}
	
	public boolean updateCity(City c, String oldCityName)
	{
		Connection conn = getConn();
		//SQL更新语句
		String sql = "update citytable set cityname=?";
		
		//当f的picture属性不为空时，表明用户此次操作上传了新的头像文件
		if(c.getPicture()!=null && c.getPicture().length()>0)
		{
			sql = sql + ",image=?";
		}
		sql += ",base=? where cityname = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCityname());
			
			//当需要修改图片信息时，SQL语句共有8个问号
			if(c.getPicture()!=null && c.getPicture().length()>0)
			{
				ps.setString(2, c.getPicture());
				ps.setString(3, c.getBase());
				ps.setString(4, oldCityName);
			}
			else//当不需要修改图片信息时，SQL语句共有7个问号
			{
				ps.setString(2, c.getBase());
				ps.setString(3, oldCityName);
			}
			
			//判定是否更新成功
			if(ps.executeUpdate()>0)
			{
				return true;
			}
			closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
}
