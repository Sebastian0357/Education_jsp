package servlet.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import bean.City;
import dao.CityDao;

/**
 * Servlet implementation class DeleteCityServlet
 */
@WebServlet(name = "deleteCityServlet", urlPatterns = { "/deleteCityServlet" })
public class DeleteCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单中复选框delID中的所有选中的id，并将其存入字符串数组ids中
				HttpSession session = request.getSession();
				City c = (City) session.getAttribute("city");
				String cityname = c.getCityname();
				
				//创建FriendDao类的fDao对象，对数据库中的friendinfo表进行删除操作
				CityDao fDao = new CityDao();
				
				//只要id值在数组ids中，就将对应的朋友信息从friendinfo表中删除
				fDao.deleteByCityName(cityname);
				
				//跳转至queryFriendServlet，查看删除之后的结果
				response.sendRedirect("updateIndexInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
