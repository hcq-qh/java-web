package util;

import java.util.Properties;

//多种数据库的帮助工具类
public class PropertiesUtil {
	static Properties prop;
	// 静态块
	static {
		prop = new Properties();
		// 加载
		try {
			// 方式1.使用类加载ClassLoader加载src的资源（固定写法）
			prop.load(PropertiesUtil.class
					.getResourceAsStream("/database.properties"));
			// ??prop.load(new FileInputStream("database.properties"));
			// 方式2 加载当前类同包下的资源，如果需要从src开始必须填写 ‘’/‘’
			// InputStream is2 =
			// PropertiesUtil.class.getResourceAsStream("jdbc2.properties");
			// prop.load(is2)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("加载文件失败");
			e.printStackTrace();
		}
	}

	// 根据数据库名获取驱动
	public static String getDriverByProp(String key) {
		return prop.getProperty(key);
	}
	// 根据数据库名获取
	// 根据数据库名获取
	// 根据数据库名获取
}
