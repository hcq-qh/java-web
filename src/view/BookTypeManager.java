package view;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Dao.BookTypeDao;
import util.BaseDao;
import model.BookType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BookTypeManager extends JInternalFrame {
	private static JTable bookTypetable;
	private JTextField typetxt;
	private JLabel desetxt;
	private JTextArea textdese;
	private JTextField idtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManager frame = new BookTypeManager();
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
	public BookTypeManager() throws Exception {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setClosable(true);
		setBounds(100, 100, 450, 300);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setToolTipText("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel,
										GroupLayout.PREFERRED_SIZE, 415,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						Alignment.TRAILING,
						groupLayout
								.createSequentialGroup()
								.addContainerGap(15, Short.MAX_VALUE)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 409,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								119, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		typetxt = new JTextField();
		typetxt.setColumns(10);

		desetxt = new JLabel("\u63CF\u8FF0:");

		textdese = new JTextArea();

		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/highlight_remove_16px_1181938_easyicon.net.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除
               try {
				deletebookType(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManager.class.getResource("/images/document_edit_modify_write_16px_1631_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 修改
				try {
					UpdatebookType();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A\r\n");

		idtxt = new JTextField();
		idtxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(28)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(desetxt)
												.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		btnNewButton)
																.addGap(116)
																.addComponent(
																		btnNewButton_1))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		idtxt,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(46)
																.addComponent(
																		label)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		typetxt))
												.addComponent(
														textdese,
														GroupLayout.PREFERRED_SIZE,
														277,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(58, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNewLabel)
												.addComponent(
														idtxt,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(label)
												.addComponent(
														typetxt,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(desetxt)
												.addComponent(
														textdese,
														GroupLayout.PREFERRED_SIZE,
														41,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnNewButton_1)
												.addComponent(btnNewButton))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		Object[][] obj = new Object[][] { { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, };
		BaseDao bd = new BaseDao();
		String sql = "SELECT * from booktype_tb";
		PreparedStatement prep = bd.getConn(sql);
		ResultSet rs = prep.executeQuery();
		int i = 0;
		while (rs.next()) {
			obj[i][0] = rs.getInt(1);
			obj[i][1] = rs.getString(2);
			obj[i][2] = rs.getString(3);
			i++;
		}
		bd.close(rs, prep);
		bookTypetable = new JTable();
		bookTypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypetablemousepress(e);
			}
		});
		bookTypetable.setModel(new DefaultTableModel(obj, new String[] { "编号",
				"图书类别", "图书类别描述" }));
		scrollPane.setViewportView(bookTypetable);
		getContentPane().setLayout(groupLayout);

	}

	protected void deletebookType(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(idtxt.getText());
		BaseDao bd = new BaseDao();
		BookType bookType = new BookType(id);
		int num = BookTypeDao.delete(bookType);
		if (1 == num) {
			JOptionPane.showMessageDialog(null, "删除成功");
		} else {
			JOptionPane.showMessageDialog(null, "删除失败");
		}
	}

	protected void UpdatebookType() throws Exception {
		// TODO Auto-generated method stub
		String name = typetxt.getText();
		String dese = textdese.getText();
		int id = Integer.parseInt(idtxt.getText());
		BookType bookType = new BookType(id, name, dese);
		int num = BookTypeDao.Update(bookType);
		if (1 == num) {
			JOptionPane.showMessageDialog(null, "修改成功");
            
		} else {
			JOptionPane.showMessageDialog(null, "修改失败");
		}
	}

	protected void bookTypetablemousepress(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = bookTypetable.rowAtPoint(e.getPoint());
		idtxt.setText(String.valueOf(bookTypetable.getValueAt(row, 0)));
		typetxt.setText((String) bookTypetable.getValueAt(row, 1));
		textdese.setText((String) bookTypetable.getValueAt(row, 2));
	}
    
	public void fillTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) bookTypetable.getModel();
		dtm.setRowCount(0);
	}
	
}
