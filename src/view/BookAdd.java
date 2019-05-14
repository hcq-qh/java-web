package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.BookDao;
import model.BookType;
import model.book;
import util.BaseDao;
import util.NotNull;
import javax.swing.ImageIcon;

public class BookAdd extends JInternalFrame {
	private JTextField booknameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox bookTypejrb;
    private JTextArea bookDeacTxt;
    private JRadioButton manjrb;
    JRadioButton femalejrb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAdd frame = new BookAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public BookAdd() throws Exception {
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setClosable(true);
		setBounds(100, 100, 450, 311);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		booknameTxt = new JTextField();
		booknameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manjrb = new JRadioButton("\u7537");
		buttonGroup.add(manjrb);
		manjrb.setSelected(true);
		
		femalejrb = new JRadioButton("\u5973");
		buttonGroup.add(femalejrb);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypejrb = new JComboBox();
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDeacTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setIcon(new ImageIcon(BookAdd.class.getResource("/images/add_media_social_17.233734939759px_1211638_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bookAddAction();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(BookAdd.class.getResource("/images/Button_Load_16px_1097507_easyicon.net.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookDeacTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(authorTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypejrb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(manjrb)
								.addGap(39)
								.addComponent(femalejrb)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(button)
							.addGap(98)
							.addComponent(button_1)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(manjrb)
						.addComponent(femalejrb))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookTypejrb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookDeacTxt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	protected void bookAddAction() throws Exception {
		// TODO Auto-generated method stub
		String bookname = this.booknameTxt.getText();
		String author = this.authorTxt.getText();
		String bookDeac = this.bookDeacTxt.getText();
		if (NotNull.isempty(bookname)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if (NotNull.isempty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if (NotNull.isempty(bookDeac)) {
			JOptionPane.showMessageDialog(null, "图书描述不能为空");
			return;
		}
		String sex = "";
		if (manjrb.isSelected()) {
			sex= "男";
		}else if (femalejrb.isSelected()) {
			sex = "女";
		}
		BookType bookType = (BookType) bookTypejrb.getSelectedItem();
		int bookTypeId = bookType.getBid();
		book Book =new book(bookname, author, sex, bookTypeId, bookDeac);
		int num= BookDao.Add(Book);
		if (1==num) {
			JOptionPane.showMessageDialog(null, "图书添加成功");
			reset();
		}else {
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}
		
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.booknameTxt.setText("");
		this.authorTxt.setText("");
		this.manjrb.setSelected(true);
		this.bookDeacTxt.setText("");
		if (bookTypejrb.getItemCount()>0) {
			bookTypejrb.setSelectedIndex(0);
		}
	}

	public void fillBookType() throws Exception {
		BaseDao bd = new BaseDao();
		BookType bookType = null;
		String sql = "select * from booktype_tb";
		PreparedStatement ps = bd.getConn(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bookType = new BookType();
			bookType.setBid(rs.getInt(1));
			bookType.setBname(rs.getString(2));
			this.bookTypejrb.addItem(bookType);
		}
	}
}
