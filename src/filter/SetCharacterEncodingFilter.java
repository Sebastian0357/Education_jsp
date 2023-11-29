package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//问题：LoginFilter和SetCharacterEncodingFilter调用的先后顺序是什么？依据是什么？
//问题：urlPatterns = { "/*" }中的“*”含义是什么？
//问题：name = "encoding"中的encoding如改为ec，项目中哪个位置的代码需要同步修改？
import javax.servlet.annotation.WebInitParam;

//过滤器设置字符编码为UTF-8
@WebFilter(
		filterName = "setCharacterEncodingFilter", 
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class SetCharacterEncodingFilter implements Filter {
	private static String encoding;

	public void destroy() {
		System.out.println("销毁过滤器SetCharacterEncodingFilter的对象，本方法仅执行一次");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//在每次通过request对象调用getParameter方法读取表单之前，通过本过滤器设置字符编码，避免中文乱码出现
		request.setCharacterEncoding(encoding);
		
		//过滤器放行，继续访问原目标
		chain.doFilter(request, response);
	}
	
	//问题：init方法和doFilter方法的执行顺序是什么？分别在什么时间被调用？
	public void init(FilterConfig fConfig) throws ServletException {		
		//通过fConfig参数的getInitParameter方法获取注解中（@WebInitParam(name = "encoding", value = "utf-8")）encoding参数的值utf-8
		System.out.println("初始化过滤器SetCharacterEncodingFilter的对象，本方法仅执行一次");
		encoding = fConfig.getInitParameter("encoding");
		System.out.println("将字符编码设置成："+encoding);
	}
}
