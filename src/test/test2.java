package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.BaseDao;

public class test2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BaseDao bd = new BaseDao();
        String sql = "SELECT * from user_tb";
        PreparedStatement ps= bd.getConn(sql);
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {
			System.out.println("11");
		}
        bd.close(rs, ps);
	}

}
