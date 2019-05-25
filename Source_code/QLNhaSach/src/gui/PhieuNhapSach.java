package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdatepicker.DateModel;
import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import dao.NhapSachDAO;
import dao.QuyDinhDAO;
import dao.SachDAO;
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
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
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
	private static DatePicker picker = new JDatePicker();

	/**
	 * Create the panel.
	 */
	public PhieuNhapSach() {
		setLayout(null);
		
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
		
		tblNhapsach.getColumnModel().getColumn(5).setMinWidth(0);
		tblNhapsach.getColumnModel().getColumn(5).setMaxWidth(0);
		tblNhapsach.getColumnModel().getColumn(5).setWidth(0);
		
		tblNhapsach.getColumnModel().getColumn(6).setMinWidth(0);
		tblNhapsach.getColumnModel().getColumn(6).setMaxWidth(0);
		tblNhapsach.getColumnModel().getColumn(6).setWidth(0);
		
		tblNhapsach.getColumnModel().getColumn(7).setMinWidth(0);
		tblNhapsach.getColumnModel().getColumn(7).setMaxWidth(0);
		tblNhapsach.getColumnModel().getColumn(7).setWidth(0);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(755, 109, 130, 255);
		add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lay ngay tu datepicker
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Calendar c2 = (Calendar) picker.getModel().getValue();
				
				String ngaynhap = "";
				
				if(c2 != null) {
					ngaynhap = sdf.format(c2.getTime());
				} else {
					//lay ngay hien tai
					Date date = new Date();
					ngaynhap = sdf.format(date);
				}
				
				final String ddd = ngaynhap;
				
				ThemNhapSach themNS = new ThemNhapSach(ngaynhap);
				themNS.setVisible(true);
				
				themNS.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						ArrayList<Object[]> dsNhap = themNS.dsNhapTemp;
						
						DefaultTableModel curModel = (DefaultTableModel) tblNhapsach.getModel();
						for(int i = 0; i < dsNhap.size(); i++) {
							Object rowData[] = new Object[8];
							rowData[0] = curModel.getRowCount() + 1;
							rowData[1] = dsNhap.get(i)[2]; //ten sach
							rowData[2] = dsNhap.get(i)[3]; //the loai
							rowData[3] = dsNhap.get(i)[4]; //tac gia
							rowData[4] = dsNhap.get(i)[5]; //so luong nhap
							rowData[5] = dsNhap.get(i)[1]; //ID sach
							rowData[6] = dsNhap.get(i)[0]; //ngay nhap
							rowData[7] = dsNhap.get(i)[6]; //so luong ton
							curModel.addRow(rowData);
						}
					}
				});
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
				DefaultTableModel curModel = (DefaultTableModel) tblNhapsach.getModel();
				SachDAO sDAO = new SachDAO();
				
				ArrayList<Nhapsach> nsList = new ArrayList<Nhapsach>();
				
				//luu thong tin vao bang nhap sach
				for(int i = 0; i < curModel.getRowCount(); i++) {
					int soluongnhap = (Integer) curModel.getValueAt(i, 4);
					int soluongton = (Integer) curModel.getValueAt(i, 7);
					int idsach = (Integer) curModel.getValueAt(i, 5);
					
					Nhapsach ns = new Nhapsach();
					ns.setNgayNhap(curModel.getValueAt(i, 6).toString());
					ns.setMaSach(idsach);
					ns.setSoLuongNhap(soluongnhap);
					ns.setSoLuongTon(soluongton);
					nsList.add(ns);
					
					sDAO.capNhatSoLuong(idsach, soluongton + soluongnhap);
				}
				
				NhapSachDAO nsDAO = new NhapSachDAO();
				nsDAO.nhapSach(nsList);
				
				curModel.setRowCount(0);
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
		String[] columnName = {"STT", "Sách", "Thể loại", "Tác giả", "Số lượng", "Ngày nhập", "ID Sách", "Tồn"};

	    DefaultTableModel model = new DefaultTableModel(columnName, 0) {
	    	@Override
	        public boolean isCellEditable(int row, int column)
	        {
	            // make read only fields except column 1, 2, 3, 4
	            return false;
	        }
	    };
	    
	    return model;
	}
}
