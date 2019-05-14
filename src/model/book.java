package model;

public class book {
	private int id;
	private String bookname;
	private String author;
	private String sex;
	private int bookTypeId;
	private String bookDeac;
	
	
	public book(int id, String bookname, String author, String sex,
			int bookTypeId, String bookDeac) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.bookDeac = bookDeac;
	}
	public book(int id, String bookname, String author, String sex,
			String bookDeac) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.sex = sex;
		this.bookDeac = bookDeac;
	}
	public book(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBookDeac() {
		return bookDeac;
	}
	public void setBookDeac(String bookDeac) {
		this.bookDeac = bookDeac;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(String bookname, String author, String sex, int bookTypeId,
			String bookDeac) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.sex = sex;
		this.bookTypeId = bookTypeId;
		this.bookDeac = bookDeac;
	}
	public book(String bookname, String author) {
		super();
		this.bookname = bookname;
		this.author = author;
	}

}
