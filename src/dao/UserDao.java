package dao;
import java.sql.*;

import bean.Admin;
import bean.User;

public class UserDao extends BaseDao
{
	public User findByName(String uname)
	{
		User u = null;
		Connection conn = getConn();
		String sql = "select * from usertable where uname = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				u = new User();
				u.setUname(uname);
				u.setPwd(rs.getString(2));
				u.setGender(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setIntroduce(rs.getString(5));
				u.setBirthday(rs.getString(6));
				u.setOrganization(rs.getString(7));
				u.setPhone(rs.getString(8));
				u.setPicture(rs.getString(9));
			}
			closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	public Admin findByAdminName(String uname)
	{
		Admin u = null;
		Connection conn = getConn();
		String sql = "select * from admintable where uname = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				u = new Admin();
				u.setUname(uname);
				u.setPwd(rs.getString(2));
				
			}
			closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	public boolean regUser(User u)
	{
		boolean mark = false;
		Connection conn = getConn();
		String sql = "insert into usertable values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			if(ps.executeUpdate()>0)
			{
				mark = true;
			}
			closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mark;
	}
	
	public boolean updatePwd(User u)
	{
		boolean mark = false;
		Connection conn = getConn();
		String sql = "update usertable set pwd=? where uname=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPwd());
			ps.setString(2, u.getUname());			
			if(ps.executeUpdate()>0)
			{
				mark = true;
			}
			closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return mark;
	}
	
	public User updateUserInfo(User u)
	{
		Connection conn = getConn();
		
		//SQL更新语句
		String sql = "update usertable set uname=?,gender=?,email=?,introduce=?,brithday=str_to_date(?,'%Y-%m-%d'),"
				+ "organization=?,phone=?";
		
		//当f的picture属性不为空时，表明用户此次操作上传了新的头像文件
		if(u.getPicture()!=null && u.getPicture().length()>0)
		{
			sql = sql + ",picture=?";
		}
		sql += " where uname = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getGender());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getIntroduce());
			ps.setString(5, u.getBirthday());
			ps.setString(6, u.getOrganization());
			ps.setString(7, u.getPhone());
			
			//当需要修改图片信息时，SQL语句共有8个问号
			if(u.getPicture()!=null && u.getPicture().length()>0)
			{
				ps.setString(8, u.getPicture());
				ps.setString(9, u.getUname());
			}
			else//当不需要修改图片信息时，SQL语句共有7个问号
			{
				ps.setString(8, u.getUname());
			}
			
			//判定是否更新成功
			if(ps.executeUpdate()>0)
			{	
				return findByName(u.getUname());
			}
			closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
