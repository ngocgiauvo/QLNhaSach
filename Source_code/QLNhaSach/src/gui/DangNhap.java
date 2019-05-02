package gui;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entities.Taikhoan;
import dao.TaiKhoanDAO;

public class DangNhap extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public DangNhap() {
		setLayout(null);
		
		JLabel lblngNhp = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblngNhp.setBounds(148, 11, 118, 40);
		add(lblngNhp);
		
		JLabel lblTnngNhp = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblTnngNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnngNhp.setBounds(10, 84, 118, 24);
		add(lblTnngNhp);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setBounds(10, 130, 118, 24);
		add(lblMtKhu);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(138, 86, 243, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(138, 132, 243, 20);
		add(txtPassword);
		
		JButton btnngNhp = new JButton("\u0110\u0103ng nh\u1EADp");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				String password = String.valueOf(txtPassword.getPassword());
				
				TaiKhoanDAO tkDAO = new TaiKhoanDAO();
				int kt = tkDAO.KiemTraDangNhap(username, password);
				
				if(kt == 1) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
				}
			}
		});
		btnngNhp.setBounds(171, 181, 107, 31);
		add(btnngNhp);

	}
}
