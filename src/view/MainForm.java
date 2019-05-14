package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JButton;

public class MainForm {

	private static JFrame frame;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 710, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6309\u6761\u4EF6\u67E5\u627E\u56FE\u4E66");
		menuBar.add(menu);
		
		JMenuItem menuItem_7 = new JMenuItem("\u67E5\u627E");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSelect bookSelect = null;
				try {
					bookSelect = new BookSelect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bookSelect.setVisible(true);
				table.add(bookSelect);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainForm.class.getResource("/images/blue_query_16px_1075411_easyicon.net.png")));
		menu.add(menuItem_7);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7EF4\u62A4");
		menuBar.add(mnNewMenu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menu_2.setIcon(new ImageIcon(MainForm.class.getResource("/images/library_19.238095238095px_1221550_easyicon.net.png")));
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAdd bookTypeAdd = new BookTypeAdd();
				bookTypeAdd.setVisible(true);
				table.add(bookTypeAdd);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainForm.class.getResource("/images/add_media_social_17.233734939759px_1211638_easyicon.net.png")));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManager bookTypeManager = null;
				try {
					bookTypeManager = new BookTypeManager();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bookTypeManager.setVisible(true);
				table.add(bookTypeManager);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainForm.class.getResource("/images/document_edit_modify_write_16px_1631_easyicon.net.png")));
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7EF4\u62A4");
		menu_3.setIcon(new ImageIcon(MainForm.class.getResource("/images/aldiko_bookReader_15.733333333333px_1118275_easyicon.net.png")));
		mnNewMenu.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd bookAdd = null;
				try {
					bookAdd = new BookAdd();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bookAdd.setVisible(true);
				table.add(bookAdd);		
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainForm.class.getResource("/images/add_media_social_17.233734939759px_1211638_easyicon.net.png")));
		menu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u7EF4\u62A4");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BookManager(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainForm.class.getResource("/images/document_edit_modify_write_16px_1631_easyicon.net.png")));
		menu_3.add(menuItem_5);
		
		JMenu menu_1 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  int num = JOptionPane.showConfirmDialog(null,"是否退出系统");
			  if (0 == num) {
				//frame.setVisible(false);
				  //关闭窗口
				  System.exit(0);
			}
			}
		});
		menuItem.setIcon(new ImageIcon(MainForm.class.getResource("/images/login_exit_16px_516164_easyicon.net.png")));
		menu_1.add(menuItem);
		//最大化
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//居中
		frame.setLocationRelativeTo(null);
	}
  
	protected void BookManager(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		BookManager bookManager = new BookManager();
		bookManager.setVisible(true);
		table.add(bookManager);
	}
}
