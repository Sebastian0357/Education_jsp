package servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户在表单文本框中输入的验证码code
//		String code = request.getParameter("code");
		//从session中获取系统生成的验证码rand
		HttpSession session = request.getSession();
//		String rand = (String)session.getAttribute("rand");
		//当用户输入了正确的验证码
//		if(rand.equals(code))
//		{
			//获取用户在表单中输入的用户名和密码
			String uname = request.getParameter("username");
			String pwd = request.getParameter("password");
			//通过UserDao对象，查找数据库表usertable中名为uname的用户信息，并存入对象u中
			UserDao uDao = new UserDao();
			User u = uDao.findByName(uname);
			if(u==null)//用户输入的用户名不存在
			{
				request.setAttribute("NameError", "用户名不存在！！！");
			}
			else if(!u.getPwd().equals(pwd))//用户输入的密码，与数据库中同名用户的密码不一致
			{
				request.setAttribute("PwdError", "密码错误！！！");
			}
			else
			{				
				//合法用户：用户名存在，密码也对应一致
				//操作1：在session存入对象u，作为合法登录的标记
				session.setAttribute("user", u);
				//操作2：重定向跳转至主页面main.jsp
				response.sendRedirect("index.jsp");
				return;
			}
//		}
//		else
//		{
//			request.setAttribute("codeError", "验证码错误！！！");			
//		}
		//带着存在request对象中的信息NameError/PwdError/codeError，请求转发跳转至登录页面
		RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
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
