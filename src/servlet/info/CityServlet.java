package servlet.info;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.City;
import bean.User;
import dao.CityDao;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet({"/CityServlet", "/cityServlet"})
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入cityserv");
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		CityDao cDao = new CityDao();
		
		//将当前用户u的所有朋友信息存入fList列表
		ArrayList<City> cList = cDao.findCityList();
		
		//将包含用户u所有朋友信息的列表fList存入request中
		session.setAttribute("cList", cList);
		
		//url存放未来将要跳转的页面地址
		String url;
		
//		//flag存放着对朋友信息的操作类型：修改？删除？查询？
//		String flag = request.getParameter("flag");
//		if("modify".equals(flag))
//		{
//			//修改朋友的页面
//			url = "modifyFriend.jsp";
//		}
//		else if("delete".equals(flag))
//		{
//			//删除朋友的页面
//			url = "deleteFriend.jsp";
//		}
//		else
//		{
//			//查询朋友的页面
//			url = "queryFriend.jsp";
//		}
		
		//请求转发方式跳转至URL对应的JSP页面上
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
