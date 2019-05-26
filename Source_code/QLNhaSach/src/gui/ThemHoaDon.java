package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import dao.QuyDinhDAO;
import dao.SachDAO;
import dao.TheLoaiDAO;
import entities.Quydinh;
import entities.Sach;
import gui.ThemNhapSach.BookListCellRenderer;

public class ThemHoaDon extends JFrame {

	private JPanel contentPane;
	public ArrayList<Sach> dsSach;
	public ArrayList<Quydinh> dsQuyDinh;
	public ArrayList<Object[]> dsBanTemp = new ArrayList<Object[]>();
	int tonToiThieuBan = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHoaDon frame = new ThemHoaDon();
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
	public ThemHoaDon() {
		QuyDinhDAO qdDAO = new QuyDinhDAO();
		dsQuyDinh = qdDAO.layDSQuyDinh();
		
		for(int i = 0; i < dsQuyDinh.size(); i++) {
			if(dsQuyDinh.get(i).getTenQuyDinh().equals("ton_toi_thieu_ban")) {
				tonToiThieuBan = dsQuyDinh.get(i).getNoiDung();
			}
		}
		
		setResizable(false);
		setTitle("Chọn sách");
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
		
		JLabel lblChonSach = new JLabel("CHỌN SÁCH");
		lblChonSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChonSach.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChonSach);
		
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
				
				if(s.getSoLuong() - soluong < tonToiThieuBan) {
					JOptionPane.showMessageDialog(null, "Chỉ bán các đầu sách có lượng tồn sau khi bán ít nhất là " + tonToiThieuBan);
				} else {
					//luu ds tam
					Object[] temp = new Object[6];
					temp[0] = s.getId();
					temp[1] = s.getTenSach();
					temp[2] = tlDAO.layTenTheLoai(s.getTheLoai());
					temp[3] = soluong; //so luong mua
					temp[4] = s.getDonGia();
					temp[5] = s.getSoLuong(); //so luong ton
					dsBanTemp.add(temp);
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
