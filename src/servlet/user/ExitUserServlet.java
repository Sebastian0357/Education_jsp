package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/ExitUserServlet", "/exitUserServlet" })
public class ExitUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExitUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//操作1：清空session中的数据
		HttpSession session = request.getSession();
		session.invalidate();
		
		//操作2：3秒后跳转至登录页面login.jsp
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("退出登录，3秒后跳转到登录页面！！~");
		response.setHeader("refresh", "3;URL=login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
