package servlet.info;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.City;
import dao.CityDao;
import util.MyUtil;

/**
 * Servlet implementation class UpdateCityInfoServlet
 */
@WebServlet(name = "updateCityInfoServlet", urlPatterns = { "/updateCityInfoServlet" })
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class UpdateCityInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCityInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获得页面表单中对应朋友的全部信息
		String cityname = request.getParameter("name");
		String base = request.getParameter("base");

		/********上传图片操作开始******/
		String picture = "";		
		
		// 从表单中获得Part类型的照片对象picture
		Part part = request.getPart("picture");
		
		// 获得上传图片的“路径名+原始文件名”
		String oldName = MyUtil.getFileName(part);
		
		// 如果用户选择上传头像照片
		if (oldName != null) {
			// 指定上传的文件保存到服务器的uploadFiles目录中
			File uploadFileDir = new File(getServletContext().getRealPath("/uploadPic"));
			System.out.println("success");
			
			//如果"/uploadPic"路径不存在，就创建该路径
			if (!uploadFileDir.exists()) {				
				uploadFileDir.mkdir();
			}
			
			// 从oldName（“路径名+原始文件名”）中截取出“原始文件名”
			int index = oldName.lastIndexOf(File.separator);
			if (index > 0) {
				oldName = oldName.substring(index + 1, oldName.length());
			}
			
			// 获取文件类型（后缀名）
			String fileType = oldName.substring(oldName.lastIndexOf("."));
			
			// 为了避免客户上传时图片文件重名，使用系统时间重新为其命名
			String newName = MyUtil.getStringID() + fileType;
			picture = newName;
			
			// 将新命名的图片文件，上传到服务器的uploadFiles目录中
			part.write(uploadFileDir + File.separator + newName);
		}
		/********上传图片操作结束******/
		HttpSession session = request.getSession();
		City city = (City) session.getAttribute("city");
		String oldCityName = city.getCityname();
		City c = new City(cityname, base, picture);		
		CityDao cDao = new CityDao();
		String url;
		if(cDao.updateCity(c, oldCityName))
		{
			//修改成功，自动查询修改后的结果
			url = "updateIndexInfoServlet";
		}
		else			
		{
			//修改失败，重新修改
			System.out.println("修改失败");
			url = "cityDetail.jsp";
		}
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
