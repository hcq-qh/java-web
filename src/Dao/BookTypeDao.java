package Dao;

import java.sql.PreparedStatement;

import util.BaseDao;
import model.BookType;

public class BookTypeDao {
	//Ôö¼Ó
	public static int Add(BookType bookType) throws Exception {
		String sql = "INSERT INTO booktype_tb(bname,bdese) VALUES(?,?)";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setString(1, bookType.getBname());
		prep.setString(2, bookType.getBdese());
		return prep.executeUpdate();
	}
	//ÐÞ¸Ä
	public static int Update(BookType bookType) throws Exception {
		String sql = "UPDATE booktype_tb SET bname = ?,bdese=? where bid = ?";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setString(1, bookType.getBname());
		prep.setString(2, bookType.getBdese());
		prep.setInt(3, bookType.getBid());
		return prep.executeUpdate();
	}
	//É¾³ý
	public static int delete(BookType bookType) throws Exception {
		String sql = "DELETE  FROM booktype_tb WHERE bid =?";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setInt(1, bookType.getBid());
		return prep.executeUpdate();
	}
	
}
