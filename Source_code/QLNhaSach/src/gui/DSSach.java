package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.SachDAO;
import dao.TheLoaiDAO;
import entities.Sach;
import entities.Theloai;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DSSach extends JPanel {
	private JTable tblDSSach;
	private static ArrayList<Theloai> theloai;
	private JTextField txtTenSach;
	private JTextField txtTacGia;

	/**
	 * Create the panel.
	 */
	public DSSach() {
		setLayout(null);
		
		TheLoaiDAO tlDAO = new TheLoaiDAO();
		theloai = tlDAO.layTheLoai();
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 865, 40);
		add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblDanhSchSch = new JLabel("DANH S\u00C1CH S\u00C1CH");
		lblDanhSchSch.setBounds(98, 0, 673, 40);
		lblDanhSchSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhSchSch.setHorizontalAlignment(SwingConstants.CENTER);
		panelHead.add(lblDanhSchSch);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 113, 865, 416);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblDSSach = new JTable();
		panelMain.add(new JScrollPane(tblDSSach), BorderLayout.CENTER);
		
		ArrayList<Sach> ds = layDSSach();
		DefaultTableModel model = setDataForTable(ds);
		tblDSSach.setModel(model);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(10, 62, 865, 40);
		add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lblTnSch = new JLabel("Tên sách:");
		lblTnSch.setBounds(10, 11, 58, 14);
		panelSearch.add(lblTnSch);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(78, 8, 211, 20);
		panelSearch.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblThLoi = new JLabel("Thể loại:");
		lblThLoi.setBounds(313, 11, 58, 14);
		panelSearch.add(lblThLoi);
		
		JComboBox cbTheLoai = new JComboBox();
		cbTheLoai.setBounds(381, 8, 121, 20);
		
		DefaultComboBoxModel cbModel = setDataForCombobox();
		cbTheLoai.setModel(cbModel);
		cbTheLoai.setSelectedItem(null);
		
		panelSearch.add(cbTheLoai);
		
		JLabel lblTcGi = new JLabel("Tác giả:");
		lblTcGi.setBounds(522, 11, 47, 14);
		panelSearch.add(lblTcGi);
		
		txtTacGia = new JTextField();
		txtTacGia.setBounds(579, 8, 154, 20);
		panelSearch.add(txtTacGia);
		txtTacGia.setColumns(10);
		
		JButton btnTimSach = new JButton("Tìm");
		btnTimSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tensach = txtTenSach.getText();
				String tacgia = txtTacGia.getText();
				int loaiId = 0;
				
				if(cbTheLoai.getSelectedItem() != null) {
					String loai = cbTheLoai.getSelectedItem().toString();
					for(int j = 0; j < theloai.size(); j++) {
						String temp = theloai.get(j).getTenTheLoai();
						
						if(loai.equals(temp)) {
							loaiId = theloai.get(j).getId();
						}
					}
				}
				
				//tim sach theo 3 tieu chi
				SachDAO sDAO = new SachDAO();
				ArrayList<Sach> dsSach = sDAO.timKiemSach(tensach, tacgia, loaiId);
				
				DefaultTableModel model = setDataForTable(dsSach);
				tblDSSach.setModel(model);
				
				tblDSSach.getColumnModel().getColumn(0).setMaxWidth(40);
				tblDSSach.getColumnModel().getColumn(1).setMaxWidth(350);
				tblDSSach.getColumnModel().getColumn(2).setMaxWidth(200);
				tblDSSach.getColumnModel().getColumn(3).setMaxWidth(200);
				tblDSSach.getColumnModel().getColumn(4).setMaxWidth(95);
			}
		});
		btnTimSach.setBounds(766, 7, 89, 23);
		panelSearch.add(btnTimSach);
		
		tblDSSach.getColumnModel().getColumn(0).setMaxWidth(40);
		tblDSSach.getColumnModel().getColumn(1).setMaxWidth(350);
		tblDSSach.getColumnModel().getColumn(2).setMaxWidth(200);
		tblDSSach.getColumnModel().getColumn(3).setMaxWidth(200);
		tblDSSach.getColumnModel().getColumn(4).setMaxWidth(95);
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Sach> data) {
		String[] columnName = {"STT", "Tên Sách", "Thể Loại", "Tác Giả", "Số Lượng"};

	    DefaultTableModel model = new DefaultTableModel(columnName, 0);
	    
	    if(data != null) {
	    	for(int i = 0; i < data.size(); i++) {
	    		Object rowData[] = new Object[5];
	    		rowData[0] = i + 1;
	    		rowData[1] = data.get(i).getTenSach();
	    		rowData[2] = layTenTheLoai(data.get(i).getTheLoai());
	    		rowData[3] = data.get(i).getTacGia();
	    		rowData[4] = data.get(i).getSoLuong();
	    		model.addRow(rowData);
	    	}
	    }
	    
	    return model;
	}
	
	public static ArrayList<Sach> layDSSach() {
		SachDAO sDAO = new SachDAO();
		ArrayList<Sach> dsSach = sDAO.layDSSach();
		return dsSach;
	}
	
	public static String layTenTheLoai(int id) {
		for(int i = 0; i < theloai.size(); i++) {
			if(theloai.get(i).getId() == id) {
				return theloai.get(i).getTenTheLoai();
			}
		}
		return null;
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
