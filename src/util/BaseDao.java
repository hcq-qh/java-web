package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.PropertiesUtil;

public class BaseDao {
	private String Driver = PropertiesUtil.getDriverByProp("Driver");
	private String url = PropertiesUtil.getDriverByProp("Url");
	private String username = PropertiesUtil.getDriverByProp("Username");
	private String password = PropertiesUtil.getDriverByProp("Password");
	Connection con =null;
	public PreparedStatement getConn(String sql) throws Exception {
		Class.forName(Driver);
		con= DriverManager.getConnection(url, username, password);
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}
	public void close(ResultSet rs,PreparedStatement ps) throws Exception{
		if (rs!=null) {
			rs.close();
		}
		if (ps!=null) {
			ps.close();
		}
		if (con!=null) {
			con.close();
		}
	}
}
