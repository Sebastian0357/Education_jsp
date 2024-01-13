package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
/**  

* <p>Title: AdminFilter.java</p>  

* <p>Description: </p>  

* @author WuTong

* @date 2024年1月14日  

* @version 1.0  

*/  
@WebFilter(
		urlPatterns = { "/AdminFilter" }, 
		servletNames = { 
				"RegServlet", 
				"addCityInfoServlet", 
				"deleteCityServlet", 
				"updateCityInfoServlet", 
				"updateIndexInfoServlet"
		})
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (null != session.getAttribute("title"))
		{
			// 如果是合法登录的用户，则直接放行
			chain.doFilter(request, response);
		}
		// 不是合法登陆的用户
		else
		{
			// 将response从ServletResponse强制转化为子类HttpServletResponse类型，进而能调用更多的方法（比如：setContentType）
			HttpServletResponse resp = (HttpServletResponse) response;

			// 设置之后页面的内容类型和编码方式
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");

			// 创建用于在web页面中输出的对象out
			PrintWriter out = resp.getWriter();

			// 通过out输出提示信息
			// 通过输出javascript脚本，在警告框中显示信息
			out.print("<script language='javascript'>alert('访问失败！~1');</script>");
			// 通过输出HTML代码，在浏览器中显示信息。
			out.print("<h1>对不起，您还未登录，无权访问本页面</h1>");
			out.print("<h1>3秒后将自动跳回登录页面！~</h1>");

			// 3秒后自动跳转回login.jsp页面
			resp.setHeader("refresh", "3;url=login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("验证管理员身份");
	}

}
