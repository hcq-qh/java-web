package test;

import java.io.IOException;
import java.util.Properties;

import util.PropertiesUtil;

public class test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		Properties pp = new Properties();
		//╪сть
		pp.load(PropertiesUtil.class.getResourceAsStream("/database.properties"));
		String url = pp.getProperty("Url");
		System.out.println(url);
		*/
		String driver = PropertiesUtil.getDriverByProp("Driver");
		String url = PropertiesUtil.getDriverByProp("Url"); 
		String username = PropertiesUtil.getDriverByProp("Username");
		System.out.println(driver+","+url+","+username);
	}

}
