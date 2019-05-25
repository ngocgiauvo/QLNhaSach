package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import dao.NhapSachDAO;
import dao.QuyDinhDAO;
import dao.SachDAO;
import dao.TheLoaiDAO;
import entities.Nhapsach;
import entities.Quydinh;
import entities.Sach;
import entities.Theloai;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ThemNhapSach extends JFrame {

	private JPanel contentPane;
	public ArrayList<Sach> dsSach;
	public ArrayList<Quydinh> dsQuyDinh;
	public ArrayList<Object[]> dsNhapTemp = new ArrayList<Object[]>();
	int nhapToiThieu = 0, tonToiThieuNhap = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhapSach frame = new ThemNhapSach(null);
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
	public ThemNhapSach(String ngaynhap) {
		QuyDinhDAO qdDAO = new QuyDinhDAO();
		dsQuyDinh = qdDAO.layDSQuyDinh();
		
		for(int i = 0; i < dsQuyDinh.size(); i++) {
			if(dsQuyDinh.get(i).getTenQuyDinh().equals("nhap_toi_thieu")) {
				nhapToiThieu = dsQuyDinh.get(i).getNoiDung();
				System.out.println("nhap toi thieu la: " + nhapToiThieu);
			}
			
			if(dsQuyDinh.get(i).getTenQuyDinh().equals("ton_toi_thieu_nhap")) {
				tonToiThieuNhap = dsQuyDinh.get(i).getNoiDung();
				System.out.println("ton toi thieu nhap la: " + tonToiThieuNhap);
			}
		}
		
		setResizable(false);
		setTitle("Thêm sách");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 395, 40);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThmSch = new JLabel("THÊM SÁCH");
		lblThmSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThmSch.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblThmSch);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 62, 395, 166);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblChnSch = new JLabel("Chọn sách:");
		lblChnSch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChnSch.setBounds(10, 22, 81, 22);
		mainPanel.add(lblChnSch);
		
		JComboBox cbChonSach = new JComboBox();
		cbChonSach.setBounds(101, 23, 249, 25);
		SachDAO sDAO = new SachDAO();
		dsSach = sDAO.layDSSach();
		for(Sach s : dsSach) {
		    cbChonSach.addItem(s);
		}
		cbChonSach.setRenderer(new BookListCellRenderer());
		mainPanel.add(cbChonSach);
		
		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLng.setBounds(10, 71, 81, 22);
		mainPanel.add(lblSLng);
		
		JSpinner spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setBounds(101, 70, 97, 25);
		spinnerSoLuong.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spinnerSoLuong.setEditor(new JSpinner.NumberEditor(spinnerSoLuong,"##.#"));
		JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerSoLuong.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		mainPanel.add(spinnerSoLuong);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TheLoaiDAO tlDAO = new TheLoaiDAO();
				//lay id sach va so luong
				Sach s = (Sach) cbChonSach.getSelectedItem();
				int soluong = (Integer) spinnerSoLuong.getValue();
				
				if(soluong < nhapToiThieu || s.getSoLuong() >= tonToiThieuNhap) {
					JOptionPane.showMessageDialog(null, "Số lượng nhập ít nhất là 150. Chỉ nhập các đầu sách có lượng tồn ít hơn 300.");
				} else {
					//luu ds tam
					Object[] temp = new Object[7];
					temp[0] = ngaynhap;
					temp[1] = s.getId();;
					temp[2] = s.getTenSach();
					temp[3] = tlDAO.layTenTheLoai(s.getTheLoai());
					temp[4] = s.getTacGia();
					temp[5] = soluong; //so luong nhap
					temp[6] = s.getSoLuong(); //so luong ton
					dsNhapTemp.add(temp);
				}
			}
		});
		btnThem.setBounds(101, 115, 97, 34);
		mainPanel.add(btnThem);
		
		JButton btnHuy = new JButton("Xóa");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbChonSach.setSelectedIndex(0);
				spinnerSoLuong.setValue(150);
			}
		});
		btnHuy.setBounds(253, 115, 97, 34);
		mainPanel.add(btnHuy);
	}
	
	public class BookListCellRenderer extends DefaultListCellRenderer {

	    @Override
	    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

	        if (value instanceof Sach) {
	            value = ((Sach)value).getTenSach();
	        }

	        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

	    }

	}
}
