package util;

import java.util.Date;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;

import javax.servlet.http.Part;

public class MyUtil
{
	// 主键产生器(根据当前的系统时间，精确到毫秒)
	public static String getStringID()
	{
		// 当前的系统时间
		Date date = new Date();

		// 创建将系统时间格式化为字符串的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		// 格式化操作：系统时间——>字符串
		String id = sdf.format(date);
		return id;
	}

	// 从Part中获得原始文件名
	public static String getFileName(Part part)
	{
		if (part == null)
			return null;

		// fileName形式为：form-data; name="resPath"; filename="20140920_110531.jpg"
		String partHead = part.getHeader("content-disposition");

		// 如果没有选择文件，filename等于""
		if (partHead.lastIndexOf("=") + 2 == partHead.length() - 1)
			return null;

		// 返回partHead中的filename的值
		return partHead.substring(partHead.lastIndexOf("=") + 2, partHead.length() - 1);
	}

}