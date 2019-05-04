package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdatepicker.DateModel;
import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import dao.TheLoaiDAO;
import entities.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

import java.awt.CardLayout;

public class PhieuNhapSach extends JPanel {
	private JTable tblNhapsach;
	private static ArrayList<Theloai> theloai;
	private static DatePicker picker = new JDatePicker();

	/**
	 * Create the panel.
	 */
	public PhieuNhapSach() {
		setLayout(null);
		TheLoaiDAO tlDAO = new TheLoaiDAO();
		theloai = tlDAO.layTheLoai();
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 865, 40);
		add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblPhiuNhpSch = new JLabel("PHIẾU NHẬP SÁCH");
		lblPhiuNhpSch.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiuNhpSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhiuNhpSch.setBounds(96, 0, 673, 40);
		panelHead.add(lblPhiuNhpSch);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 109, 725, 420);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblNhapsach = new JTable();
		panelMain.add(new JScrollPane(tblNhapsach), BorderLayout.CENTER);
		
		DefaultTableModel model = setDataForTable(null);
		tblNhapsach.setModel(model);
		
		tblNhapsach.getColumnModel().getColumn(0).setMaxWidth(30);
		tblNhapsach.getColumnModel().getColumn(1).setMaxWidth(320);
		tblNhapsach.getColumnModel().getColumn(2).setMaxWidth(150);
		tblNhapsach.getColumnModel().getColumn(3).setMaxWidth(150);
		tblNhapsach.getColumnModel().getColumn(4).setMaxWidth(75);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(745, 109, 130, 255);
		add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel curModel = (DefaultTableModel) tblNhapsach.getModel();
				
				Object rowData[] = new Object[1];
				curModel.addRow(rowData);
				
				tblNhapsach.setModel(curModel);
				
				TableColumn theLoaiColumn = tblNhapsach.getColumnModel().getColumn(2);
				JComboBox cbTheLoai = new JComboBox();
				
				DefaultComboBoxModel cbModel = setDataForCombobox();
				cbTheLoai.setModel(cbModel);
				cbTheLoai.setSelectedItem(null);
				
				theLoaiColumn.setCellEditor(new DefaultCellEditor(cbTheLoai));
			}
		});
		btnThem.setBounds(10, 11, 110, 28);
		panelBtn.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel curModel = (DefaultTableModel) tblNhapsach.getModel();
				
				int select = tblNhapsach.getSelectedRow();
				
				curModel.removeRow(select);
				
				tblNhapsach.setModel(curModel);
			}
		});
		btnXoa.setBounds(10, 50, 110, 28);
		panelBtn.add(btnXoa);
		
		JButton btnNhapSach = new JButton("Nhập sách");
		btnNhapSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sodong = tblNhapsach.getModel().getRowCount();
				
			}
		});
		btnNhapSach.setBounds(10, 89, 110, 28);
		panelBtn.add(btnNhapSach);
		
		JPanel panelLabel = new JPanel();
		panelLabel.setBounds(10, 58, 371, 40);
		add(panelLabel);
		panelLabel.setLayout(null);
		
		JLabel lblNgyNhp = new JLabel("Ngày nhập:");
		lblNgyNhp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgyNhp.setBounds(275, 11, 86, 14);
		panelLabel.add(lblNgyNhp);
		
		JPanel panelDate = new JPanel();
		panelDate.setBounds(391, 62, 213, 36);
		add(panelDate);
		panelDate.setLayout(new BorderLayout(0, 0));
		
		picker.setTextEditable(false);
		picker.setShowYearButtons(true);
		panelDate.add((JComponent) picker);
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
	
	public static DefaultComboBoxModel setDataForCombobox() {
		String[] data = new String[theloai.size()];
		for(int i = 0; i < theloai.size(); i++) {
			data[i] = theloai.get(i).getTenTheLoai();
		}
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		
		return model;
	}
}
