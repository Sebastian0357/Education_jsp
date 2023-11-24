package dao;
import java.sql.*;
import bean.User;

public class UserDao extends BaseDao
{
	//返回数据库usertable表中名为uname的用户信息 
	public User findByName(String uname)
	{
		User u = null;
		//调用继承自父类的方法getConn，完成前两个步骤：“加载驱动”和“创建连接”
		Connection conn = getConn();
		//SQL条件查询语句：在usertable表中，获取名为'？'用户的全部信息，注：'？'为占位符
		String sql = "select * from usertable where userName = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//用uname的值，替换SQL语句中的第一个问号占位符
			ps.setString(1, uname);
			//调用预处理对象ps的executeQuery方法执行数据库查询操作，获得ResultSet类型的查询结果
			ResultSet rs = ps.executeQuery();
			if(rs.next())//如果用户输入的uname存在于数据库usertable表中
			{
				//将查询到的结果（用户名+密码）封装在User类的对象u中
				u = new User(uname,rs.getString("password"));
			}
			//调用继承自父类的方法closeConn，完成最后的步骤：“释放连接”
			closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//注：如果用户输入的uname不存在于数据库usertable表中，则返回初始值null
		return u;
	}
	
	//向数据库usertable表中，插入User类对象u中存放的用户信息
	public boolean regUser(User u)
	{
		boolean mark = false;
		Connection conn = getConn();
		//SQL插入操作语句：在usertable表中，插入名为'？'，密码为'？'的用户信息
		String sql = "insert into usertable values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//使用对象u的用户名和密码，依次替换sql中存放的两个问号占位符
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			//预处理对象ps的executeUpdate方法返回值为int类型，意味着更新后数据库中发生变化的记录数量
			if(ps.executeUpdate()>0)
			{
				//ps.executeUpdate()的返回值大于零，意味着成功能插入了数据
				mark = true;
			}
			//更新操作没有ResultSet类型的结果集rs，所以第一个参数为null
			closeConn(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//插入操作成功返回true，反之返回false
		return mark;
	}
	
	//将数据库usertable表中，userName与对象u的用户名相同的对象，password改为对象u的密码
	public boolean updatePwd(User u)
	{
		boolean mark = false;
		Connection conn = getConn();
		String sql = "update usertable set password=? where userName=?";
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
}
