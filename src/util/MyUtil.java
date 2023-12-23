package util;

import java.util.Date;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;

import javax.servlet.http.Part;

public class MyUtil {
	// 主键产生器(根据当前的系统时间，精确到毫秒)
	public static String getStringID() {
		//当前的系统时间
		Date date = new Date();
		
		//创建将系统时间格式化为字符串的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		//格式化操作：系统时间——>字符串
		String id = sdf.format(date);
		return id;
	}

	// 从Part中获得原始文件名
	public static String getFileName(Part part) {
		if (part == null)
			return null;
		
		// fileName形式为：form-data; name="resPath"; filename="20140920_110531.jpg"
		String partHead = part.getHeader("content-disposition");
		
		// 如果没有选择文件，filename等于""
		if (partHead.lastIndexOf("=") + 2 == partHead.length() - 1)
			return null;
		
		//返回partHead中的filename的值
		return partHead.substring(partHead.lastIndexOf("=") + 2,
				partHead.length() - 1);
	}
	
	/*******************本项目暂未使用下面的程序模块**********************/
	// 本模块可用于将用户密码加密后，存入数据库(防止管理员盗取密码)
	// 利用Java自带的MessageDigest类实现的最简单的MD5加密方法。最终加密生成32位md5码
	// MD5本质上是一个哈希算法，不可逆！
	public static String getMD5String(String str)
	{
		try
		{
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");

			// 计算md5函数
			md.update(str.getBytes());

			// digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			// 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
			return new BigInteger(1, md.digest()).toString(16);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("MD5算法加密出现错误！");
			return null;
		}
	}	
}