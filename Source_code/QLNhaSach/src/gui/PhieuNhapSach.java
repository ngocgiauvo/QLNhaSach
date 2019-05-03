package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class PhieuNhapSach extends JPanel {
	private JTable tblNhapsach;

	/**
	 * Create the panel.
	 */
	public PhieuNhapSach() {
		setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 680, 39);
		panelHead.setLayout(null);
		add(panelHead);
		
		JLabel lblNgyNhp = new JLabel("Ngày nhập:");
		lblNgyNhp.setBounds(59, 11, 81, 17);
		panelHead.add(lblNgyNhp);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 61, 535, 253);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblNhapsach = new JTable();
		panelMain.add(new JScrollPane(tblNhapsach), BorderLayout.CENTER);
		
		DefaultTableModel model = setDataForTable(null);
		tblNhapsach.setModel(model);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(560, 62, 130, 252);
		add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 110, 28);
		panelBtn.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(10, 50, 110, 28);
		panelBtn.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 89, 110, 28);
		panelBtn.add(btnXoa);
		
		JButton btnNhapSach = new JButton("Nhập sách");
		btnNhapSach.setBounds(10, 128, 110, 28);
		panelBtn.add(btnNhapSach);
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Nhapsach> data) {
		String[] columnName = {"STT", "Sách", "Thể loại", "Tác giả", "Số lượng"};

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
