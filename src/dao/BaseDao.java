package dao;
import java.sql.*;
import java.util.ArrayList;

/**  

* <p>Title: BaseDao.java</p>  

* <p>Description: </p>  

* @author WuTong

* @date 2024年1月14日  

* @version 1.0  

*/  
public class BaseDao {
	/**存放Connection对象的列表作为连接池 */
	static ArrayList<Connection> list = new ArrayList<Connection>();
	/**数据库连接池中连接数量的上限 */
	private static final int MAX_LEN = 20;
	
	//getConn完成数据库连接的前两个步骤：“加载驱动”和“创建连接”
	/**synchronized 是 Java 中的关键字，利用锁的机制来实现同步，具有互斥性 */
	public synchronized static Connection getConn() {
		// 如果连接池中没有连接对象，创建连接放到连接池中
		if(list.size() == 0)
		{
			try {
				//1.加载驱动程序
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2.创建数据库连接对象，url中存放对应数据库的连接地址
				String url = "jdbc:mysql://localhost:3306/education"
						+ "?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
				//循环十次，每次向连接池list中添加一个数据库连接对象conn
				for(int i = 1; i <= 10; i ++ )
				{
					Connection conn = DriverManager.getConnection(url,"root","123456");
					list.add(conn);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list.remove(0);
	}

	/**方法closeConn，完成数据库连接的最后的步骤：“释放连接”*/
	public synchronized static void closeConn(ResultSet rs, 
			PreparedStatement ps, Connection conn) {
		try {
			if(rs != null)
			{
				rs.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			
			if(conn != null)
			{
				//连接数量如超过上限，则直接关闭
				if(list.size() > MAX_LEN)	
				{
					conn.close();
				}
				//连接数量如未超过上限，则归还至数据库连接池list中
				else					
				{
					list.add(conn);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
