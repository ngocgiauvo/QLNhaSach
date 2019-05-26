package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entities.Khachhang;
import entities.Nhapsach;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class DSKhachHang extends JFrame {

	private JPanel contentPane;
	private JTable tblKhachHang;
	public ArrayList<Khachhang> dsKH;
	public Khachhang khSelected = new Khachhang();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DSKhachHang frame = new DSKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DSKhachHang() {
		KhachHangDAO khDAO = new KhachHangDAO();
		dsKH = khDAO.layDSKhachHang();
		
		setResizable(false);
		setTitle("Danh sách khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 534, 34);
		contentPane.add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblDanhSchKhch = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setBounds(83, 0, 353, 34);
		panelHead.add(lblDanhSchKhch);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(10, 44, 534, 34);
		contentPane.add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnChonKH = new JButton("Chọn");
		btnChonKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int isSelected = tblKhachHang.getSelectedRow();
				
				DefaultTableModel curModel = (DefaultTableModel) tblKhachHang.getModel();
				
				khSelected.setId((Integer) curModel.getValueAt(isSelected, 0));
				khSelected.setHoTen(curModel.getValueAt(isSelected, 1).toString());
				khSelected.setDiaChi(curModel.getValueAt(isSelected, 2).toString());
				khSelected.setSoDienThoai((Integer) curModel.getValueAt(isSelected, 3));
				khSelected.setEmail(curModel.getValueAt(isSelected, 4).toString());
				khSelected.setTienNo((Long) curModel.getValueAt(isSelected, 5));
				
				dispose();
			}
		});
		btnChonKH.setBounds(214, 11, 89, 23);
		panelBtn.add(btnChonKH);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 89, 534, 211);
		contentPane.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		tblKhachHang = new JTable();
		panelMain.add(new JScrollPane(tblKhachHang), BorderLayout.CENTER);
		DefaultTableModel model = setDataForTable(dsKH);
		tblKhachHang.setModel(model);
		
		tblKhachHang.getColumnModel().getColumn(0).setMaxWidth(30);
		tblKhachHang.getColumnModel().getColumn(1).setMaxWidth(320);
		tblKhachHang.getColumnModel().getColumn(2).setMaxWidth(150);
		tblKhachHang.getColumnModel().getColumn(3).setMaxWidth(150);
		tblKhachHang.getColumnModel().getColumn(4).setMaxWidth(150);
		tblKhachHang.getColumnModel().getColumn(5).setMaxWidth(100);
		
		tblKhachHang.setSelectionModel(new ForcedListSelectionModel());
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Khachhang> data) {
		String[] columnName = {"ID", "Họ và tên", "Địa chỉ", "Số điện thoại", "Email", "Tiền nợ"};

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
		    	Object rowData[] = new Object[6];
		    	rowData[0] = data.get(i).getId();
	            rowData[1] = data.get(i).getHoTen();
	            rowData[2] = data.get(i).getDiaChi();
	            rowData[3] = data.get(i).getSoDienThoai();
	            rowData[4] = data.get(i).getEmail();
	            rowData[5] = data.get(i).getTienNo();
	            model.addRow(rowData);
	    	}
	    }
	    
	    return model;
	}
	
	public class ForcedListSelectionModel extends DefaultListSelectionModel {

	    public ForcedListSelectionModel () {
	        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    }

	    @Override
	    public void clearSelection() {
	    }

	    @Override
	    public void removeSelectionInterval(int index0, int index1) {
	    }

	}
}
