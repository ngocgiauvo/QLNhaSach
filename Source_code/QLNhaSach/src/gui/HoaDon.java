package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.*;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HoaDon extends JPanel {
	private JTextField txtTenKhachHang;
	private JTable tblHoaDon;

	/**
	 * Create the panel.
	 */
	public HoaDon() {
		setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 865, 87);
		add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn kh\u00E1ch h\u00E0ng:");
		lblNewLabel.setBounds(124, 62, 119, 14);
		panelHead.add(lblNewLabel);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(253, 59, 216, 20);
		panelHead.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		
		JLabel lblNgyLpHa = new JLabel("Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n:");
		lblNgyLpHa.setBounds(479, 62, 119, 14);
		panelHead.add(lblNgyLpHa);
		
		JLabel lblHanBn = new JLabel("HÓA ĐƠN BÁN SÁCH");
		lblHanBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHanBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHanBn.setBounds(87, 11, 673, 40);
		panelHead.add(lblHanBn);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 109, 725, 420);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblHoaDon = new JTable();
		panelMain.add(new JScrollPane(tblHoaDon), BorderLayout.CENTER);
		DefaultTableModel model = setDataForTable(null);
		tblHoaDon.setModel(model);
		
		tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(30);
		tblHoaDon.getColumnModel().getColumn(1).setMaxWidth(310);
		tblHoaDon.getColumnModel().getColumn(2).setMaxWidth(150);
		tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(85);
		tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(150);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(745, 109, 130, 420);
		add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel curModel = (DefaultTableModel) tblHoaDon.getModel();
				
				Object rowData[] = new Object[1];
				curModel.addRow(rowData);
				
				tblHoaDon.setModel(curModel);
			}
		});
		btnThem.setBounds(10, 11, 110, 28);
		panelBtn.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel curModel = (DefaultTableModel) tblHoaDon.getModel();
				
				int select = tblHoaDon.getSelectedRow();
				
				curModel.removeRow(select);
				
				tblHoaDon.setModel(curModel);
			}
		});
		btnXoa.setBounds(10, 50, 110, 28);
		panelBtn.add(btnXoa);
		
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBounds(10, 89, 110, 28);
		panelBtn.add(btnLapHoaDon);

	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Hoadon> data) {
		String[] columnName = {"STT", "Sách", "Thể loại", "Số lượng", "Đơn giá"};

	    DefaultTableModel model = new DefaultTableModel(columnName, 0);
	    
	    if(data == null) {
//	    	Object rowData[] = new Object[1];
//		    model.addRow(rowData);
	    }
	    
//	    for(int i = 0; i < data.size(); i++) {
//	    	Object rowData[] = new Object[5];
//	    	rowData[0] = data.get(i).getMssv();
//            rowData[1] = data.get(i).getHoten();
//            rowData[2] = data.get(i).getNamsinh();
//            rowData[3] = data.get(i).getGioitinh();
//            rowData[4] = data.get(i).getDiachi();
//            model.addRow(rowData);
//	    }
	    
	    return model;
	}
}
