package model;

public class BookType {
	private int bid;
	private String bname;
	private String bdese;
	
	
	public BookType(int bid) {
		super();
		this.bid = bid;
	}
	public BookType(int bid, String bname, String bdese) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bdese = bdese;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdese() {
		return bdese;
	}
	public void setBdese(String bdese) {
		this.bdese = bdese;
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookType(String bname, String bdese) {
		super();
		this.bname = bname;
		this.bdese = bdese;
	}
   //÷ÿ–¥toString
	@Override
	public String toString() {
		return bname;
	}
	
}
