package view;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.BookType;
import model.book;
import Dao.BookDao;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;






import util.BaseDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BookManager extends JInternalFrame {
	private JTable table;
	private JTextField m_idTxt;
	private JTextField m_bookTxt;
	private JTextField m_authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton m_man;
	private JRadioButton m_famer;
	private JComboBox m_bookTypejpb;
	private JTextArea m_deacTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManager frame = new BookManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public BookManager() throws Exception {
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setClosable(true);
		setBounds(100, 100, 450, 357);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					bookTablemousePressed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0",
				"\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B",
				"\u56FE\u4E66\u7C7B\u522B\u7F16\u53F7",
				"\u56FE\u4E66\u63CF\u8FF0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u7EF4\u62A4",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																432,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																428,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								117, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 193,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));

		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");

		m_idTxt = new JTextField();
		m_idTxt.setEditable(false);
		m_idTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		m_bookTxt = new JTextField();
		m_bookTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		m_authorTxt = new JTextField();
		m_authorTxt.setColumns(10);

		JLabel label_3 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		m_man = new JRadioButton("\u7537");
		buttonGroup.add(m_man);
		m_man.setSelected(true);

		m_famer = new JRadioButton("\u5973");
		buttonGroup.add(m_famer);

		m_bookTypejpb = new JComboBox();

		JLabel label_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		m_deacTxt = new JTextArea();

		JButton button = new JButton("\u4FEE\u6539");
		button.setIcon(new ImageIcon(BookManager.class.getResource("/images/document_edit_modify_write_16px_1631_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Updatebook(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setIcon(new ImageIcon(BookManager.class.getResource("/images/highlight_remove_16px_1181938_easyicon.net.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					delectbook(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(72)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(label)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.LEADING)
																.addComponent(
																		label_2)
																.addComponent(
																		label_1)
																.addComponent(
																		label_3)
																.addComponent(
																		label_4)
																.addComponent(
																		label_5)))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(m_deacTxt)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.LEADING,
																false)
																.addComponent(
																		m_authorTxt)
																.addComponent(
																		m_idTxt)
																.addComponent(
																		m_bookTxt,
																		GroupLayout.DEFAULT_SIZE,
																		162,
																		Short.MAX_VALUE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		m_man)
																.addGap(18)
																.addComponent(
																		m_famer))
												.addComponent(
														m_bookTypejpb,
														GroupLayout.PREFERRED_SIZE,
														123,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED,
										37, Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(button)
												.addComponent(button_1))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														m_idTxt,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(label))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_1)
												.addComponent(
														m_bookTxt,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_2)
												.addComponent(
														m_authorTxt,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_3)
												.addComponent(m_man)
												.addComponent(m_famer))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(label_4)
												.addComponent(
														m_bookTypejpb,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_5)
												.addComponent(
														m_deacTxt,
														GroupLayout.PREFERRED_SIZE,
														40,
														GroupLayout.PREFERRED_SIZE)))
				.addGroup(
						Alignment.TRAILING,
						gl_panel.createSequentialGroup()
								.addContainerGap(34, Short.MAX_VALUE)
								.addComponent(button_1).addGap(32)
								.addComponent(button).addGap(57)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillTable(new book());
		fillBookType();
	}

	protected void Updatebook(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		int id =Integer.valueOf(m_idTxt.getText());
		String bookname = m_bookTxt.getText();
		String author = m_authorTxt.getText();
		String deac=m_deacTxt.getText();
		String sex = "";
		if (m_man.isSelected()) {
			sex="男";
		}else if (m_famer.isSelected()) {
			sex="女";
		}
		BookType bookType = (BookType) m_bookTypejpb.getSelectedItem();
        int bookTypeId = bookType.getBid();
		book Book = new book(id, bookname, author, sex, bookTypeId, deac);
		int num= BookDao.Update(Book);
		if (1 == num) {
			JOptionPane.showMessageDialog(null, "修改成功");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败");
		}
	}

	protected void delectbook(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		int id =Integer.valueOf(m_idTxt.getText());
		book Book = new book(id);
		int num= BookDao.delete(Book);
		if (1 == num) {
			JOptionPane.showMessageDialog(null, "删除成功");
			fillTable(new book());
		} else {
			JOptionPane.showMessageDialog(null, "删除失败");
		}
	}

	protected void bookTablemousePressed(MouseEvent evt) throws Exception {
		// TODO Auto-generated method stub
		int num = this.table.getSelectedRow();
		m_idTxt.setText(String.valueOf(table.getValueAt(num, 0)));
		m_bookTxt.setText(String.valueOf(table.getValueAt(num, 1)));
		m_authorTxt.setText(String.valueOf(table.getValueAt(num, 2)));
		String sex=(String) table.getValueAt(num, 3);
		if ("男".equals(sex)) {
			this.m_man.setSelected(true);
		}else if ("女".equals(sex)) {
			this.m_famer.setSelected(true);
		}

		int bookTypeId=(int) table.getValueAt(num, 4);
		BookType bookType = new BookType();
		BaseDao bd = new BaseDao();
		String sql ="SELECT bname from booktype_tb WHERE bid = ?";
		PreparedStatement ps = bd.getConn(sql);
		ps.setInt(1, bookTypeId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bookType.setBid(bookTypeId);
			bookType.setBname(rs.getString(1));
			int n = m_bookTypejpb.getItemCount();
			for (int j = 0; j < n; j++) {
				BookType item = (BookType) this.m_bookTypejpb.getItemAt(j);
				if (item.getBname().equals(bookType.getBname())) {
					this.m_bookTypejpb.setSelectedIndex(j);
				}
			}
		}		
		m_deacTxt.setText(String.valueOf(table.getValueAt(num, 5)));
	}

	public void fillTable(book Book) throws Exception {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		ResultSet rs = BookDao.list(Book);
		while (rs.next()) {
			Vector v = new Vector();
			v.add(rs.getInt("id"));
			v.add(rs.getString("bookname"));
			v.add(rs.getString("author"));
			v.add(rs.getString("sex"));
			v.add(rs.getInt("bookTypeId"));
			v.add(rs.getString("bookDeac"));
			dtm.addRow(v);
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
			this.m_bookTypejpb.addItem(bookType);
		}
	}
}
