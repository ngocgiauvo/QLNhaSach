package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entities.Khachhang;

import javax.swing.JTextField;
import java.awt.BorderLayout;

public class BaoCaoCongNo extends JPanel {
	private JTextField txtMonth;
	private JTable tblBCCongNo;
	public ArrayList<Khachhang> dsKH;
	public List<Object[]> tongTienTra;
	public List<Object[]> tongNoThem;
	public String thang;

	/**
	 * Create the panel.
	 */
	public BaoCaoCongNo() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 865, 40);
		add(panel);
		
		JLabel lblBoCoCng = new JLabel("BÁO CÁO CÔNG NỢ");
		lblBoCoCng.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoCoCng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoCoCng.setBounds(10, 0, 845, 40);
		panel.add(lblBoCoCng);
		
		JPanel panelDate = new JPanel();
		panelDate.setLayout(null);
		panelDate.setBounds(10, 62, 865, 40);
		add(panelDate);
		
		JLabel label = new JLabel("Tháng:");
		label.setBounds(303, 11, 51, 18);
		panelDate.add(label);
		
		txtMonth = new JTextField();
		txtMonth.setEditable(false);
		txtMonth.setColumns(10);
		txtMonth.setBounds(364, 10, 155, 20);
		panelDate.add(txtMonth);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 113, 865, 416);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblBCCongNo = new JTable();
		panelMain.add(new JScrollPane(tblBCCongNo));
		DefaultTableModel model = setDataForTable(null);
		tblBCCongNo.setModel(model);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date = new Date();
		thang = sdf.format(date);
		
		//hien thi thang
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM");
		txtMonth.setText(sdf2.format(date));
		
		KhachHangDAO khDAO = new KhachHangDAO();
		dsKH = khDAO.layDSKhachHang();
		
		tongTienTra = khDAO.layTongTienTra(thang);
		
		tongNoThem = khDAO.layTongNoThem(thang);
		
		ArrayList<Object[]> dataForTable = taoData();
		DefaultTableModel model2 = setDataForTable(dataForTable);
		tblBCCongNo.setModel(model2);
		
		tblBCCongNo.getColumnModel().getColumn(0).setMaxWidth(30);
		tblBCCongNo.getColumnModel().getColumn(1).setMaxWidth(385);
		tblBCCongNo.getColumnModel().getColumn(2).setMaxWidth(150);
		tblBCCongNo.getColumnModel().getColumn(3).setMaxWidth(150);
		tblBCCongNo.getColumnModel().getColumn(4).setMaxWidth(150);
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Object[]> data) {
		String[] columnName = {"STT", "Khách hàng", "Nợ Đầu", "Phát Sinh", "Nợ Cuối"};

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
		for(int i = 0; i < dsKH.size(); i++) {
			Object[] s = new Object[4];
			s[0] = dsKH.get(i).getHoTen();
			
			int tienTra = 0;
			for(int j = 0; j < tongTienTra.size(); j++) {
				if(tongTienTra.get(j)[0] == dsKH.get(i).getId()) {
					Long temp = (Long) tongTienTra.get(j)[1];
					tienTra = temp.intValue();
				}
			}
			
			int noThem = 0;
			for(int j = 0; j < tongNoThem.size(); j++) {
				if(tongNoThem.get(j)[0] == dsKH.get(i).getId()) {
					Long temp = (Long) tongNoThem.get(j)[1];
					noThem = temp.intValue();
				}
			}
			
			s[1] = dsKH.get(i).getTienNo() - noThem + tienTra; //no dau
			s[2] = tienTra - noThem;
			s[3] = dsKH.get(i).getTienNo(); //no cuoi
			
			data.add(s);
		}
		
		return data;
	}
}
