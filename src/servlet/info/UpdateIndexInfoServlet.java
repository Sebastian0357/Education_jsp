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
import dao.CityDao;

/**
 * Servlet implementation class UpdateIndexInfoServlet
 */
@WebServlet(name = "updateIndexInfoServlet", urlPatterns = { "/updateIndexInfoServlet" })
public class UpdateIndexInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIndexInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("进入修改界面");
		HttpSession session = request.getSession();
		CityDao cDao = new CityDao();
		
		ArrayList<City> cList = cDao.findCityList();
		session.setAttribute("cList", cList);
		
		String url;
		
		//flag存放着对朋友信息的操作类型：修改？删除？查询？
		String flag = request.getParameter("flag");
		String cityName = request.getParameter("cityname");
		if("detail".equals(flag))
		{
			City c = cDao.findByName(cityName);
			session.setAttribute("city", c);
			//修改朋友的页面
//			System.out.println("城市信息");
			url = "cityDetail.jsp";
		}
		else if("delete".equals(flag))
		{
			//删除朋友的页面
			url = "deleteCity.jsp";
		}
		else
		{
			//查询朋友的页面
			url = "queryCity.jsp";
		}
		
		//请求转发方式跳转至URL对应的JSP页面上
		RequestDispatcher disp = request.getRequestDispatcher(url);
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
