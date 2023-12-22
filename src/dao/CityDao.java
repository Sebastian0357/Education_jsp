package dao;
import java.sql.*;
import java.util.ArrayList;

import bean.City;

public class CityDao extends BaseDao
{
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
//	
//	//删除操作：删除ids数组中每一个id（主键）对应的朋友记录	
//	//ids类型是数组的原因：删除操作对应的是复选框（需一次删除多条记录）
//	public boolean deleteByID(String[] ids)
//	{
//		int count = 0;
//		Connection conn = getConn();
//		
//		//SQL删除语句
//		String sql = "delete from friendinfo where id = ?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			//循环删除id数组中每一个元素对应的记录
//			for (int i = 0; i < ids.length; i++) {
//				ps.setString(1, ids[i]);
//				
//				//count记录实际删除的数据记录数量
//				count += ps.executeUpdate();
//			}
//			closeConn(null, ps, conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		
//		
//		//如果实际删除的数据记录，和用户想删除的记录数量相同。
//		if(count==ids.length)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//	}
//	
//	//插入userName的朋友信息f
//	public boolean insertFriend(Friend f, String userName)
//	{
//		Connection conn = getConn();
//		//在friendinfo表中插入一条记录（包含9条属性）
//		//注：MySQL数据库中的函数str_to_date，可以将数据从字符串转化为日期类型
//		String sql = "insert into friendinfo values(?,?,str_to_date(?,'%Y-%m-%d'),?,?,?,?,?,?)";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, f.getId());
//			ps.setString(2, f.getName());
//			ps.setString(3, f.getBirthday());
//			ps.setString(4, f.getTelephone());
//			ps.setString(5, f.getEmail());
//			ps.setString(6, f.getAddress());
//			ps.setString(7, f.getPicture());
//			ps.setString(8, f.getRelation());
//			ps.setString(9, userName);
//			
//			//插入成功
//			if(ps.executeUpdate()>0)
//			{
//				return true;
//			}
//			closeConn(null, ps, conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//插入失败
//		return false;		
//	}
//	
//	//更新数据库表friendinfo
//	public boolean updateFriend(Friend f)
//	{
//		Connection conn = getConn();
//		
//		//SQL更新语句
//		String sql = "update friendinfo set name=?,birthday=str_to_date(?,'%Y-%m-%d'),"
//				+ "telephone=?,email=?,address=?,relation=?";
//		
//		//当f的picture属性不为空时，表明用户此次操作上传了新的头像文件
//		if(f.getPicture()!=null && f.getPicture().length()>0)
//		{
//			sql = sql + ",picture=?";
//		}
//		sql += " where id = ?";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, f.getName());
//			ps.setString(2, f.getBirthday());
//			ps.setString(3, f.getTelephone());
//			ps.setString(4, f.getEmail());
//			ps.setString(5, f.getAddress());
//			ps.setString(6, f.getRelation());
//			
//			//当需要修改图片信息时，SQL语句共有8个问号
//			if(f.getPicture()!=null && f.getPicture().length()>0)
//			{
//				ps.setString(7, f.getPicture());
//				ps.setString(8, f.getId());
//			}
//			else//当不需要修改图片信息时，SQL语句共有7个问号
//			{
//				ps.setString(7, f.getId());
//			}
//			
//			//判定是否更新成功
//			if(ps.executeUpdate()>0)
//			{
//				return true;
//			}
//			closeConn(null, ps, conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;		
//	}
//	
//	/*******测试程序不在考察范围内**********/
//	//测试程序：Java application模式运行测试
//	public static void main(String[] args) {
//		CityDao fb = new CityDao();
////		System.out.println(fb.findByID("1"));		
////		Friend f = fb.findByID("1");
////		f.setId("3");
////		fb.insertFriend(f, "Jack");
////		f.setName("333");
////		f.setPicture(null);
////		fb.updateFriend(f);
//		
//		String[] ids = {"1","2"};
//		System.out.println(fb.deleteByID(ids));
//		
//		ArrayList<Friend> fList = fb.findFriendList("Jack");
//		for (Friend friend : fList) {
//			System.out.println(friend);
//		}
//		
//	}
}
