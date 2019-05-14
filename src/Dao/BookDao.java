package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookType;
import model.book;
import util.BaseDao;
import util.NotNull;

public class BookDao {
	// 增加
	public static int Add(book Book) throws Exception {
		String sql = "INSERT INTO book_tb(bookname,author,sex,bookTypeId,bookDeac) VALUES(?,?,?,?,?)";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setString(1, Book.getBookname());
		prep.setString(2, Book.getAuthor());
		prep.setString(3, Book.getSex());
		prep.setInt(4, Book.getBookTypeId());
		prep.setString(5, Book.getBookDeac());
		return prep.executeUpdate();
	}

	// 查询
	public static ResultSet list(book Book) throws Exception {
		StringBuffer sb = new StringBuffer(
				"SELECT * FROM book_tb b JOIN booktype_tb bt ON b.bookTypeId=bt.bid");
		if (!NotNull.isempty(Book.getBookname())) {
			sb.append(" AND b.bookname like '%" + Book.getBookname() + "%'");
		}
		if (!NotNull.isempty(Book.getAuthor())) {
			sb.append(" AND b.author like '%" + Book.getAuthor() + "%'");
		}
		BaseDao bd = new BaseDao();
		PreparedStatement ps = bd.getConn(sb.toString().replaceFirst("AND",
				"where"));
		return ps.executeQuery();
	}

	// 删除
	public static int delete(book Book) throws Exception {
		String sql = "DELETE  FROM book_tb WHERE id =?";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setInt(1, Book.getId());
		return prep.executeUpdate();
	}

	// 修改
	public static int Update(book Book) throws Exception {
		String sql = "UPDATE book_tb SET bookname=?,author=?,sex=?,bookTypeId=?,bookDeac=? WHERE id=?";
		BaseDao bd = new BaseDao();
		PreparedStatement prep = bd.getConn(sql);
		prep.setString(1, Book.getBookname());
		prep.setString(2, Book.getAuthor());
		prep.setString(3, Book.getSex());
		prep.setInt(4, Book.getBookTypeId());
		prep.setString(5, Book.getBookDeac());
		prep.setInt(6, Book.getId());
		return prep.executeUpdate();
	}
}
