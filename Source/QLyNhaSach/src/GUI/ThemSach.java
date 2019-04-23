package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemSach extends JPanel {
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public ThemSach() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH S\u00C1CH S\u00C1CH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 11, 256, 36);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(35, 55, 46, 14);
		add(lblNewLabel_1);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(112, 52, 109, 20);
		add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblTnSch = new JLabel("T\u00EAn s\u00E1ch");
		lblTnSch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnSch.setBounds(35, 86, 65, 14);
		add(lblTnSch);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(113, 83, 109, 20);
		add(txtTenSach);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E1c gi\u1EA3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(35, 117, 46, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(112, 114, 109, 20);
		add(textField);
		
		
		JList list = new JList();
		list.setBounds(80, 210, 1, 1);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(69, 210, 1, 1);
		add(list_1);
		
		JButton btnThemSach = new JButton("Th\u00EAm S\u00E1ch");
		btnThemSach.setBounds(268, 51, 89, 23);
		add(btnThemSach);
		
		JButton btnTimKiem = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTimKiem.setBounds(268, 82, 89, 23);
		add(btnTimKiem);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(268, 117, 89, 23);
		add(btnRefresh);
		
		JList list_2 = new JList();
		list_2.setBounds(125, 283, 244, -72);
		add(list_2);

	}
}
