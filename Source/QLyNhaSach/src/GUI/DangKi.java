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
import java.awt.Color;

public class DangKi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;
	private JTextField txtNhapLaiMK;
	private JTextField txtHoten;
	private JTextField txtCmnd;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;

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
		setBounds(100, 100, 404, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngK = new JLabel("\u0110\u0102NG K\u00DD");
		lblngK.setForeground(Color.BLUE);
		lblngK.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblngK.setBounds(143, 29, 139, 26);
		contentPane.add(lblngK);
		
		JLabel lblUsername = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblUsername.setBounds(33, 78, 78, 26);
		contentPane.add(lblUsername);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setBounds(33, 118, 46, 14);
		contentPane.add(lblMtKhu);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNhpLiMt.setBounds(33, 143, 112, 14);
		contentPane.add(lblNhpLiMt);
		
		JButton btnngK = new JButton("\u0110\u0103ng K\u00FD");
		btnngK.setBackground(Color.GREEN);
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnngK.setBounds(223, 354, 89, 23);
		contentPane.add(btnngK);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(142, 81, 169, 20);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(142, 112, 170, 20);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		txtNhapLaiMK = new JTextField();
		txtNhapLaiMK.setBounds(142, 140, 170, 20);
		contentPane.add(txtNhapLaiMK);
		txtNhapLaiMK.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD T\u00EAn");
		lblNewLabel.setBounds(33, 174, 69, 14);
		contentPane.add(lblNewLabel);
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBounds(142, 171, 170, 20);
		contentPane.add(txtHoten);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(33, 205, 69, 14);
		contentPane.add(lblCmnd);
		
		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(142, 202, 170, 20);
		contentPane.add(txtCmnd);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setBounds(33, 236, 69, 14);
		contentPane.add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(142, 233, 170, 20);
		contentPane.add(txtDiaChi);
		
		JLabel lblSt = new JLabel("S\u0110T");
		lblSt.setBounds(33, 267, 69, 14);
		contentPane.add(lblSt);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(142, 264, 170, 20);
		contentPane.add(txtSDT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(33, 298, 69, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 295, 170, 20);
		contentPane.add(txtEmail);
	}
}
