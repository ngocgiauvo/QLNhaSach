package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.SachDAO;
import entities.Sach;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTable;

public class DSSach extends JPanel {
	private JTable tblDSSach;

	/**
	 * Create the panel.
	 */
	public DSSach() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 865, 40);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDanhSchSch = new JLabel("DANH S\u00C1CH S\u00C1CH");
		lblDanhSchSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhSchSch.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDanhSchSch, BorderLayout.CENTER);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 62, 865, 467);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblDSSach = new JTable();
		panelMain.add(new JScrollPane(tblDSSach), BorderLayout.CENTER);
		ArrayList<Sach> ds = layDSSach();
		DefaultTableModel model = setDataForTable(ds);
		tblDSSach.setModel(model);

	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Sach> data) {
		String[] columnName = {"STT", "Tên Sách", "Thể Loại", "Tác Giả", "Số Lượng"};

	    DefaultTableModel model = new DefaultTableModel(columnName, 0);
	    
	    if(data == null) {
//	    	Object rowData[] = new Object[1];
//		    model.addRow(rowData);
	    } else {
	    	for(int i = 0; i < data.size(); i++) {
	    		Object rowData[] = new Object[5];
	    		rowData[0] = i + 1;
	    		rowData[1] = data.get(i).getTenSach();
	    		rowData[2] = data.get(i).getTheLoai();
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
}
