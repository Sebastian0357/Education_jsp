package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet({ "/RegServlet", "/regServlet" })
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String flag = request.getParameter("flag");
		UserDao uDao = new UserDao();
		if("0".equals(flag))
		{
			User u = uDao.findByName(uname);
			request.setAttribute("user", u);
			request.setAttribute("uname", uname);
			RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
			disp.forward(request, response);
		}
		
		if("1".equals(flag))
		{
			User u = new User(uname, pwd);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			if(uDao.regUser(u))
			{
				out.print("注册成功，3秒后自动跳转到登录页面！");
				response.setHeader("refresh", "3;url=login.jsp");
			}
			else
			{
				out.print("注册失败，3秒后自动跳转到注册页面！");
				response.setHeader("refresh", "3;url=reg.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
