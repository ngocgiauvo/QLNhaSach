package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import dao.HoaDonDAO;
import dao.SachDAO;
import entities.*;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class HoaDon extends JPanel {
	private JTable tblHoaDon;
	private JTextField txtTenKH;
	private static DatePicker picker = new JDatePicker();
	Khachhang kh = new Khachhang();

	/**
	 * Create the panel.
	 */
	public HoaDon() {
		setLayout(null);
		
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
		
		tblHoaDon.getColumnModel().getColumn(5).setMinWidth(0);
		tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(0);
		tblHoaDon.getColumnModel().getColumn(5).setWidth(0);
		
		tblHoaDon.getColumnModel().getColumn(6).setMinWidth(0);
		tblHoaDon.getColumnModel().getColumn(6).setMaxWidth(0);
		tblHoaDon.getColumnModel().getColumn(6).setWidth(0);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(745, 109, 130, 420);
		add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemHoaDon themHD = new ThemHoaDon();
				themHD.setVisible(true);
				
				themHD.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
				    	ArrayList<Object[]> dsNhap = themHD.dsBanTemp;
						
						DefaultTableModel curModel = (DefaultTableModel) tblHoaDon.getModel();
						for(int i = 0; i < dsNhap.size(); i++) {
							Object rowData[] = new Object[7];
							rowData[0] = curModel.getRowCount() + 1;
							rowData[1] = dsNhap.get(i)[1]; //ten sach
							rowData[2] = dsNhap.get(i)[2]; //the loai
							rowData[3] = dsNhap.get(i)[3]; //so luong mua
							rowData[4] = dsNhap.get(i)[4]; //don gia
							rowData[5] = dsNhap.get(i)[0]; //ID sach
							rowData[6] = dsNhap.get(i)[5]; //so luong ton
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
				DefaultTableModel curModel = (DefaultTableModel) tblHoaDon.getModel();
				
				int select = tblHoaDon.getSelectedRow();
				
				curModel.removeRow(select);
				
				tblHoaDon.setModel(curModel);
			}
		});
		btnXoa.setBounds(10, 50, 110, 28);
		panelBtn.add(btnXoa);
		
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lay id khach hang
				if(kh.getId() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng!");
				} else {
					int idKH = kh.getId();
					
					//lay ngay tu datepicker
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					Calendar c2 = (Calendar) picker.getModel().getValue();
					
					String ngaylap = "";
					
					if(c2 != null) {
						ngaylap = sdf.format(c2.getTime());
					} else {
						//lay ngay hien tai
						Date date = new Date();
						ngaylap = sdf.format(date);
					}
					
					//lay ngay gio hien tai (dung de tao ma hoa don)
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmss");
					Date date = new Date();
					
					ArrayList<Hoadon> hdList = new ArrayList<Hoadon>();
					int tongtien = 0;
					
					DefaultTableModel curModel = (DefaultTableModel) tblHoaDon.getModel();
					SachDAO sDAO = new SachDAO();
					
					String maHD = "HD" + sdf2.format(date);
					
					for(int i = 0; i < curModel.getRowCount(); i++) {
						int idsach = (Integer) curModel.getValueAt(i, 5);
						int soluongmua = (Integer) curModel.getValueAt(i, 3);
						int soluongton = (Integer) curModel.getValueAt(i, 6);
						int dongia = (int) curModel.getValueAt(i, 4);
						tongtien += soluongmua * dongia;
						
						Hoadon hd = new Hoadon();
						hd.setMaHoaDon(maHD);
						hd.setMakhachHang(idKH);
						hd.setMaSach(idsach);
						hd.setSoLuong(soluongmua);
						hd.setNgayLap(ngaylap);
						hdList.add(hd);
						sDAO.capNhatSoLuong(idsach, soluongton - soluongmua);
					}
					
					HoaDonDAO hdDAO = new HoaDonDAO();
					hdDAO.lapHoaDon(hdList);
					
					System.out.println("So tien phai thanh toan " + tongtien);
					
					curModel.setRowCount(0);
					
					//hien thi man hinh thanh toan
					if(maHD != null && tongtien > 0) {
						ThanhToan tt = new ThanhToan(maHD, kh, tongtien);
						tt.setVisible(true);
					}
				}
			}
		});
		btnLapHoaDon.setBounds(10, 89, 110, 28);
		panelBtn.add(btnLapHoaDon);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 865, 40);
		add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblHanBn = new JLabel("HÓA ĐƠN BÁN SÁCH");
		lblHanBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHanBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHanBn.setBounds(95, 0, 673, 40);
		panelHead.add(lblHanBn);
		
		JPanel panelCustomer = new JPanel();
		panelCustomer.setBounds(10, 62, 430, 40);
		add(panelCustomer);
		panelCustomer.setLayout(null);
		
		JLabel lblHTnKhch = new JLabel("Họ tên khách hàng:");
		lblHTnKhch.setBounds(10, 15, 114, 14);
		panelCustomer.add(lblHTnKhch);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(134, 12, 215, 20);
		panelCustomer.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton btnTimKH = new JButton("Tìm");
		btnTimKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DSKhachHang dsKH = new DSKhachHang();
				dsKH.setVisible(true);
				
				dsKH.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
				        kh = dsKH.khSelected;
				        txtTenKH.setText(kh.getHoTen());
				    }
				});
			}
		});
		btnTimKH.setBounds(359, 11, 61, 20);
		panelCustomer.add(btnTimKH);
		
		JPanel panelDateLabel = new JPanel();
		panelDateLabel.setBounds(472, 62, 121, 40);
		add(panelDateLabel);
		panelDateLabel.setLayout(null);
		
		JLabel lblNgyLpHa = new JLabel("Ngày lập hóa đơn:");
		lblNgyLpHa.setBounds(10, 15, 109, 14);
		panelDateLabel.add(lblNgyLpHa);
		
		JPanel panelDatePicker = new JPanel();
		panelDatePicker.setBounds(603, 71, 213, 31);
		add(panelDatePicker);
		panelDatePicker.setLayout(new BorderLayout(0, 0));

		picker.setTextEditable(false);
		picker.setShowYearButtons(true);
		panelDatePicker.add((JComponent) picker);
	}
	
	public static DefaultTableModel setDataForTable(ArrayList<Hoadon> data) {
		String[] columnName = {"STT", "Sách", "Thể loại", "Số lượng", "Đơn giá", "ID Sách", "Tồn"};

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
