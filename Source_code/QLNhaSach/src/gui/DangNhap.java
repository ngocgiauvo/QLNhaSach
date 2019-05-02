package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.*;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngNhp = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblngNhp.setBounds(158, 11, 105, 36);
		contentPane.add(lblngNhp);
		
		JLabel lblTnngNhp = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblTnngNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnngNhp.setBounds(33, 70, 85, 23);
		contentPane.add(lblTnngNhp);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 71, 259, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setBounds(33, 114, 85, 23);
		contentPane.add(lblMtKhu);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(128, 115, 259, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanDAO tkDAO = new TaiKhoanDAO();
				tkDAO.getAll();
			}
		});
		btnLogin.setBounds(174, 164, 105, 36);
		contentPane.add(btnLogin);
	}
}
