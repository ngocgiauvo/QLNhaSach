package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MuonSach extends JPanel {
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtTenTacGia;
	private JTextField txtNguoiMuon;
	private JTextField txtNgayMuon;
	private JTextField txtNguoiChoMuon;

	/**
	 * Create the panel.
	 */
	public MuonSach() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u01AF\u1EE2N S\u00C1CH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(152, 25, 224, 33);
		add(lblNewLabel);
		
		JLabel lblMSch = new JLabel("M\u00E3 s\u00E1ch ");
		lblMSch.setBounds(43, 73, 46, 14);
		add(lblMSch);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(137, 70, 196, 20);
		add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblTnSch = new JLabel("T\u00EAn s\u00E1ch ");
		lblTnSch.setBounds(43, 107, 46, 14);
		add(lblTnSch);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(137, 104, 196, 20);
		add(txtTenSach);
		
		JLabel lblTnTcGi = new JLabel("T\u00EAn t\u00E1c gi\u1EA3");
		lblTnTcGi.setBounds(43, 143, 83, 14);
		add(lblTnTcGi);
		
		JLabel lblNgiMn = new JLabel("Ng\u01B0\u1EDDi M\u01B0\u1EE3n");
		lblNgiMn.setBounds(43, 168, 83, 14);
		add(lblNgiMn);
		
		txtTenTacGia = new JTextField();
		txtTenTacGia.setColumns(10);
		txtTenTacGia.setBounds(137, 135, 196, 20);
		add(txtTenTacGia);
		
		txtNguoiMuon = new JTextField();
		txtNguoiMuon.setColumns(10);
		txtNguoiMuon.setBounds(137, 165, 196, 20);
		add(txtNguoiMuon);
		
		JLabel lblNgyMn = new JLabel("Ng\u00E0y m\u01B0\u1EE3n");
		lblNgyMn.setBounds(43, 199, 83, 14);
		add(lblNgyMn);
		
		txtNgayMuon = new JTextField();
		txtNgayMuon.setColumns(10);
		txtNgayMuon.setBounds(137, 196, 196, 20);
		add(txtNgayMuon);
		
		JLabel lblNgiChoMn = new JLabel("Ng\u01B0\u1EDDi cho m\u01B0\u1EE3n");
		lblNgiChoMn.setBounds(43, 230, 83, 14);
		add(lblNgiChoMn);
		
		txtNguoiChoMuon = new JTextField();
		txtNguoiChoMuon.setColumns(10);
		txtNguoiChoMuon.setBounds(137, 227, 196, 20);
		add(txtNguoiChoMuon);
		
		JButton btnMuonSach = new JButton("M\u01B0\u1EE3n S\u00E1ch");
		btnMuonSach.setBounds(137, 266, 103, 23);
		add(btnMuonSach);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(250, 266, 83, 23);
		add(btnRefresh);

	}
}
