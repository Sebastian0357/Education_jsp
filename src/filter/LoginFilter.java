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

@WebFilter(filterName = "loginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
	//问题：为什么将如下5个uri放入白名单OK_URL中？
	//白名单uriList，无需登录验证，用户可以直接请求访问的资源uri
	private static final String [] OK_URL= {"/login.jsp","/register.jsp",
			"/LoginServlet","/RegServlet"};
	public void destroy() {
		System.out.println("销毁过滤器LoginFilter的对象，本方法仅执行一次");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//问题：ServletRequest和HttpServletRequest之间的关系是什么？下面代码为何要执行强制类型转化的操作？
		//将ServletRequest类型的request，转成子类HttpServletRequest类型，进而能够调用更多方法（比如getRequestURI）
		HttpServletRequest req = (HttpServletRequest) request;		
		
		//获取用户请求的完整uri（项目名+资源名，例如：/2023JSP/main.jsp）
		//问题：getRequestURI方法和getContextPath方法的返回值分别是什么？两者有何关系？
		String request_uri = req.getRequestURI();

		//获取web应用程序的上下文路径（项目名，例如：/2023JSP）
		String ctxPath = req.getContextPath();
		
		//问题：函数substring的作用是什么？其形式参数是什么类型的，作用又是什么？
		//基于项目名的长度ctxPath.length()，通过计算子串的方式，获取请求的资源名称（例如：/main.jsp）	
		String uri = request_uri.substring(ctxPath.length());
		
		//判定当前请求资源的uri是否在白名单OK_URL中,或在/css/和/js/路径下，如果在就直接放行
		if(uri.startsWith("/css/") || uri.startsWith("/js/"))
		{
			//直接放行（继续传递用户的请求）
			chain.doFilter(request, response);
			return;
		}		
		for (int i = 0; i < OK_URL.length; i++) {
			if(OK_URL[i].equals(uri))
			{
				//直接放行（继续传递用户的请求）
				chain.doFilter(request, response);
				return;
			}
		}
			
		//通过req的getSession方法，获得session对象
		HttpSession session = req.getSession();
		
		//问题：判断session.getAttribute("user")!=null的目的是什么？
		//问题：session中的user对象如果不为空，那又是在什么时候被存入的？
		//通过查看session中是否存在user对象，来判定当前用户是否曾经成功登录
		Object u = session.getAttribute("user");
		if (null != session.getAttribute("user")) {
			//如果是合法登录的用户，则直接放行
			chain.doFilter(request, response);
		} else {//不是合法登陆的用户
			//问题：方法out.print和System.out.print有何区别？为便于用户（非开发者）查看结果，应在Web程序中使用哪一个？
			
			//将response从ServletResponse强制转化为子类HttpServletResponse类型，进而能调用更多的方法（比如：setContentType）
			HttpServletResponse resp = (HttpServletResponse)response;			
			
			//设置之后页面的内容类型和编码方式
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			
			//创建用于在web页面中输出的对象out
			PrintWriter out = resp.getWriter();
			
			//通过out输出提示信息			
			//通过输出javascript脚本，在警告框中显示信息
			out.print("<script language='javascript'>alert('访问失败！~1');</script>");
			//通过输出HTML代码，在浏览器中显示信息。
			out.print("<h1>对不起，您还未登录，无权访问本页面</h1>");
			out.print("<h1>3秒后将自动跳回登录页面！~</h1>");
			
			//3秒后自动跳转回login.jsp页面
			resp.setHeader("refresh", "3;url=login.jsp");
		}
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("初始化过滤器LoginFilter的对象，本方法仅执行一次");
	}
}
