package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import Dao.UserDao;
import model.User;
import util.NotNull;

public class login {

	private JFrame frame;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;
    private static login window = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 15));
		frame.setResizable(false);
		frame.setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		frame.setBounds(100, 100, 761, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel
				.setIcon(new ImageIcon(
						login.class
								.getResource("/images/book_35.706563706564px_1179406_easyicon.net.png")));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1
				.setIcon(new ImageIcon(
						login.class
								.getResource("/images/user_yellow_16px_1174177_easyicon.net.png")));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2
				.setIcon(new ImageIcon(
						login.class
								.getResource("/images/key_locked_password_16px_5093_easyicon.net.png")));

		usernametxt = new JTextField();
		usernametxt.setColumns(10);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adminlogin(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
       
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chongzhi(e);
			}
		});

		passwordtxt = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
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
																										.addGap(275)
																										.addComponent(
																												lblNewLabel,
																												GroupLayout.PREFERRED_SIZE,
																												194,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGap(203)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblNewLabel_1)
																														.addComponent(
																																lblNewLabel_2))
																										.addGap(38)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																passwordtxt,
																																GroupLayout.DEFAULT_SIZE,
																																160,
																																Short.MAX_VALUE)
																														.addComponent(
																																usernametxt,
																																GroupLayout.DEFAULT_SIZE,
																																160,
																																Short.MAX_VALUE))))
																		.addGap(1))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				btnNewButton)
																		.addGap(151)))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(button).addGap(251)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(54)
										.addComponent(lblNewLabel)
										.addGap(77)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																usernametxt,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(40)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																passwordtxt,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 98,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton)
														.addComponent(button))
										.addGap(74)));
		frame.getContentPane().setLayout(groupLayout);
		//居中
		frame.setLocationRelativeTo(null);
	}

	// 登录按钮
	protected void adminlogin(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String uname = this.usernametxt.getText();
	    //String upassword = this.passwordtxt.getText();
		String upassword =new String(this.passwordtxt.getPassword());
		if (NotNull.isempty(uname)) {
			JOptionPane.showMessageDialog(null, "账号不能为空！！！");
		}
		if (NotNull.isempty(upassword)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！！！");
		}
		User user = new User(uname, upassword);
		UserDao userDao = new UserDao();
		//??uname == userDao.login(user).getUname() && upassword == userDao.login(user).getUpassword()
		if (userDao!= null) {
			//进入主程序
			frame.setVisible(false);
			MainForm.main(null);
			
		}
	}
     
	// 重置按钮
	protected void chongzhi(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.usernametxt.setText("");
		this.passwordtxt.setText("");
	}
}
