package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.BaseDao;
import model.User;

public class UserDao {
	public User login(User user) throws Exception {
		BaseDao bd = new BaseDao();
		User user2 = null;
		String sql = "SELECT * from user_tb where uname = ? and upassword = ?";
        PreparedStatement ps= bd.getConn(sql);
        ps.setString(1,user.getUname());
        ps.setString(2,user.getUpassword());
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {
			user2 = new User();
			user2.setUid(rs.getInt(1));
			user2.setUname(rs.getString(2));
			user2.setUpassword(rs.getString(3));
		}
        bd.close(rs, ps);
		return user2;
	}
}
