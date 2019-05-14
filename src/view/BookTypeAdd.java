package view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.BookTypeDao;
import model.BookType;
import util.NotNull;
import javax.swing.ImageIcon;

public class BookTypeAdd extends JInternalFrame {
	private JTextField bookTypetxt;
	private JTextArea bookTypedesetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAdd frame = new BookTypeAdd();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeAdd() {
		setClosable(true);
		setNormalBounds(new Rectangle(-50, -50, 0, 0));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 544, 369);

		JLabel lblNewLabel = new JLabel(
				"\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

		JLabel lblNewLabel_1 = new JLabel(
				"\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");

		bookTypetxt = new JTextField();
		bookTypetxt.setColumns(10);

		bookTypedesetxt = new JTextArea();

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/add_media_social_17.233734939759px_1211638_easyicon.net.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddbookType(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAdd.class.getResource("/images/Button_Load_16px_1097507_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetBook(evt);
			}
		});
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
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(92)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								lblNewLabel_1))
																		.addGap(60)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								bookTypedesetxt)
																						.addComponent(
																								bookTypetxt,
																								GroupLayout.DEFAULT_SIZE,
																								239,
																								Short.MAX_VALUE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(158)
																		.addComponent(
																				btnNewButton)
																		.addGap(109)
																		.addComponent(
																				btnNewButton_1)))
										.addContainerGap(83, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(94)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel)
														.addComponent(
																bookTypetxt,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(58)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																bookTypedesetxt,
																GroupLayout.PREFERRED_SIZE,
																75,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 38,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton_1)
														.addComponent(
																btnNewButton))
										.addGap(31)));
		getContentPane().setLayout(groupLayout);

	}

	protected void AddbookType(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String bookTypet = bookTypetxt.getText();
		String bookTypedeset = bookTypedesetxt.getText();
		BookType bookType = new BookType(bookTypet, bookTypedeset);
		if (NotNull.isempty(bookTypet)) {
			JOptionPane.showMessageDialog(null, "图书类别不能为空");
		}
		if (NotNull.isempty(bookTypedeset)) {
			JOptionPane.showMessageDialog(null, "图书类别描述不能为空");
		}
		int n = BookTypeDao.Add(bookType);
		if (1 == n) {
			JOptionPane.showMessageDialog(null, "添加成功");
			reset();
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
	}

	protected void resetBook(ActionEvent evt) {
		// TODO Auto-generated method stub
		reset();
	}

	public void reset() {
		this.bookTypetxt.setText("");
		this.bookTypedesetxt.setText("");
	}

}
