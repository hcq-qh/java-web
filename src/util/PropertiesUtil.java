package util;

import java.util.Properties;

//�������ݿ�İ���������
public class PropertiesUtil {
	static Properties prop;
	// ��̬��
	static {
		prop = new Properties();
		// ����
		try {
			// ��ʽ1.ʹ�������ClassLoader����src����Դ���̶�д����
			prop.load(PropertiesUtil.class
					.getResourceAsStream("/database.properties"));
			// ??prop.load(new FileInputStream("database.properties"));
			// ��ʽ2 ���ص�ǰ��ͬ���µ���Դ�������Ҫ��src��ʼ������д ����/����
			// InputStream is2 =
			// PropertiesUtil.class.getResourceAsStream("jdbc2.properties");
			// prop.load(is2)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�����ļ�ʧ��");
			e.printStackTrace();
		}
	}

	// �������ݿ�����ȡ����
	public static String getDriverByProp(String key) {
		return prop.getProperty(key);
	}
	// �������ݿ�����ȡ
	// �������ݿ�����ȡ
	// �������ݿ�����ȡ
}
