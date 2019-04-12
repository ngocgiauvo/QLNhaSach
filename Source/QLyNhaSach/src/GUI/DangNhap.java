package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TAIKHOANDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(10, 11, 61, 14);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(96, 8, 86, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 82, 46, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(96, 79, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(62, 131, 89, 23);
		contentPane.add(btnLogin);
		addControll();
		//Xu ly dang nhap
		
	}

	private void addControll() {
		// TODO Auto-generated method stub
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				XuLyDangNhap̣();
			}
		});
	}

	private void XuLyDangNhap̣() {
		// TODO Auto-generated method stub
		String UserName= txtUserName.getText().toString().trim(); //Xoa khoang trang hai dau
		String PassWord= txtPassword.getText().toString().trim();
		TAIKHOANDAO TK= new TAIKHOANDAO();
		boolean kt=TK.KiemTraDangNhap(UserName,PassWord);
		if( kt==true)
		{
			System.out.println("DANG NHAP THANH CONG");
		}else{
			System.out.println("DANG nhap that bai");
		}
		
	}
}
