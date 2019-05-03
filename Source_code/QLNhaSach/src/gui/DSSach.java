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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DSSach extends JPanel {
	private JTable tblDSSach;
	private static ArrayList<Theloai> theloai;

	/**
	 * Create the panel.
	 */
	public DSSach() {
		setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 865, 40);
		add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblDanhSchSch = new JLabel("DANH S\u00C1CH S\u00C1CH");
		lblDanhSchSch.setBounds(98, 0, 673, 40);
		lblDanhSchSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhSchSch.setHorizontalAlignment(SwingConstants.CENTER);
		panelHead.add(lblDanhSchSch);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Sach> ds = layDSSach();
				DefaultTableModel model = setDataForTable(ds);
				tblDSSach.setModel(model);
				
				tblDSSach.getColumnModel().getColumn(0).setMaxWidth(40);
				tblDSSach.getColumnModel().getColumn(1).setMaxWidth(350);
				tblDSSach.getColumnModel().getColumn(2).setMaxWidth(200);
				tblDSSach.getColumnModel().getColumn(3).setMaxWidth(200);
				tblDSSach.getColumnModel().getColumn(4).setMaxWidth(95);
			}
		});
		btnLamMoi.setBounds(776, 11, 89, 23);
		panelHead.add(btnLamMoi);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 62, 865, 467);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblDSSach = new JTable();
		panelMain.add(new JScrollPane(tblDSSach), BorderLayout.CENTER);
		
		TheLoaiDAO tlDAO = new TheLoaiDAO();
		theloai = tlDAO.layTheLoai();
		
		ArrayList<Sach> ds = layDSSach();
		DefaultTableModel model = setDataForTable(ds);
		tblDSSach.setModel(model);
		
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
}
