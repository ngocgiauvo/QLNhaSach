package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.SachDAO;
import entities.Khachhang;
import entities.Sach;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class BaoCaoTon extends JPanel {

	public ArrayList<Sach> dsSach;
	public List<Object[]> tongNhap;
	public List<Object[]> tongBan;
	private JTable tblBCTon;
	public String thang;
	private JTextField txtMonth;
	/**
	 * Create the panel.
	 */
	public BaoCaoTon() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 865, 40);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBoCoTn = new JLabel("BÁO CÁO TỒN");
		lblBoCoTn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoCoTn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoCoTn.setBounds(10, 0, 845, 40);
		panel.add(lblBoCoTn);
		
		JPanel panelDate = new JPanel();
		panelDate.setBounds(10, 62, 865, 40);
		add(panelDate);
		panelDate.setLayout(null);
		
		JLabel lblThng = new JLabel("Tháng:");
		lblThng.setBounds(303, 11, 51, 18);
		panelDate.add(lblThng);
		
		txtMonth = new JTextField();
		txtMonth.setEditable(false);
		txtMonth.setBounds(364, 10, 155, 20);
		panelDate.add(txtMonth);
		txtMonth.setColumns(10);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 113, 865, 416);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblBCTon = new JTable();
		panelMain.add(new JScrollPane(tblBCTon));
		DefaultTableModel model = setDataForTable(null);
		tblBCTon.setModel(model);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date = new Date();
		thang = sdf.format(date);
		
		SachDAO sDAO = new SachDAO();
		//lay danh sach sach
		dsSach = sDAO.layDSSach();
		
		//lay tong luong nhap
		tongNhap = sDAO.layTongNhap(thang);
		
		//lay tong ban
		tongBan = sDAO.layTongBan(thang);
		
		//hien thi thang
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM");
		txtMonth.setText(sdf2.format(date));
		
		//hien thi table
		ArrayList<Object[]> dataForTable = taoData();
		DefaultTableModel model2 = setDataForTable(dataForTable);
		tblBCTon.setModel(model2);
		
		tblBCTon.getColumnModel().getColumn(0).setMaxWidth(30);
		tblBCTon.getColumnModel().getColumn(1).setMaxWidth(385);
		tblBCTon.getColumnModel().getColumn(2).setMaxWidth(150);
		tblBCTon.getColumnModel().getColumn(3).setMaxWidth(150);
		tblBCTon.getColumnModel().getColumn(4).setMaxWidth(150);
	}
	
	public static DefaultComboBoxModel setDataForCombobox() {
		String[] data = new String[6];
		
		for(int i = 0; i < 6; i++) {
			data[i] = "Tháng " + (i + 1);
		}
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(data);
		
		return model;
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Object[]> data) {
		String[] columnName = {"STT", "Sách", "Tồn Đầu", "Phát Sinh", "Tồn Cuối"};

	    DefaultTableModel model = new DefaultTableModel(columnName, 0) {
	    	@Override
	        public boolean isCellEditable(int row, int column)
	        {
	            // make read only fields except column 1, 2, 3, 4
	            return false;
	        }
	    };
	    
	    if(data != null) {
	    	for(int i = 0; i < data.size(); i++) {
		    	Object rowData[] = new Object[5];
		    	rowData[0] = i + 1;
	            rowData[1] = data.get(i)[0];
	            rowData[2] = data.get(i)[1];
	            rowData[3] = data.get(i)[2];
	            rowData[4] = data.get(i)[3];
	            model.addRow(rowData);
	    	}
	    }
	    
	    return model;
	}
	
	public ArrayList<Object[]> taoData() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for(int i = 0; i < dsSach.size(); i++) {
			Object[] s = new Object[4];
			s[0] = dsSach.get(i).getTenSach();
			
			int nhap = 0;
			for(int j = 0; j < tongNhap.size(); j++) {
				if(tongNhap.get(j)[0] == dsSach.get(i).getId()) {
					Long temp = (Long) tongNhap.get(j)[1];
					nhap = temp.intValue();
				}
			}
			
			int xuat = 0;
			for(int j = 0; j < tongBan.size(); j++) {
				if(tongBan.get(j)[0] == dsSach.get(i).getId()) {
					Long temp = (Long) tongBan.get(j)[1];
					xuat = temp.intValue();
				}
			}
			
			s[1] = xuat + dsSach.get(i).getSoLuong() - nhap;
			s[2] = nhap;
			s[3] = dsSach.get(i).getSoLuong();
			
			data.add(s);
		}
		
		return data;
	}
}
