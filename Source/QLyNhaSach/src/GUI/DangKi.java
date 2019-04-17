package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DangKi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;
	private JTextField txtNhapLaiMK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKi frame = new DangKi();
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
	public DangKi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngK = new JLabel("\u0110\u0102NG K\u00DD");
		lblngK.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblngK.setBounds(142, 11, 139, 26);
		contentPane.add(lblngK);
		
		JLabel lblUsername = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblUsername.setBounds(33, 66, 78, 14);
		contentPane.add(lblUsername);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setBounds(33, 91, 46, 14);
		contentPane.add(lblMtKhu);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNhpLiMt.setBounds(33, 116, 112, 14);
		contentPane.add(lblNhpLiMt);
		
		JButton btnngK = new JButton("\u0110\u0103ng K\u00FD");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnngK.setBounds(223, 171, 89, 23);
		contentPane.add(btnngK);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(143, 63, 169, 20);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(142, 88, 170, 20);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		txtNhapLaiMK = new JTextField();
		txtNhapLaiMK.setBounds(142, 113, 170, 20);
		contentPane.add(txtNhapLaiMK);
		txtNhapLaiMK.setColumns(10);
	}
}
