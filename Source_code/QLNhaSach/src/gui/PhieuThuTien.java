package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import dao.KhachHangDAO;
import dao.ThuTienDAO;
import entities.Khachhang;
import entities.Thutien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PhieuThuTien extends JFrame {

	private JPanel contentPane;
	private static DatePicker picker = new JDatePicker();
	private JTextField txtDienThoai;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuThuTien frame = new PhieuThuTien(null);
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
	public PhieuThuTien(Khachhang kh) {
		setResizable(false);
		setTitle("Phiếu thu tiền");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(10, 11, 685, 34);
		contentPane.add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblPhiuThuTin = new JLabel("PHIẾU THU TIỀN");
		lblPhiuThuTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiuThuTin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhiuThuTin.setBounds(67, 0, 548, 34);
		panelHead.add(lblPhiuThuTin);
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(10, 56, 685, 212);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblHTnKhch = new JLabel("Họ tên khách hàng:");
		lblHTnKhch.setHorizontalAlignment(SwingConstants.LEFT);
		lblHTnKhch.setBounds(10, 25, 117, 14);
		panelMain.add(lblHTnKhch);
		
		JLabel lblinThoi = new JLabel("Điện thoại:");
		lblinThoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblinThoi.setBounds(10, 66, 117, 14);
		panelMain.add(lblinThoi);
		
		JLabel lblNgyThuTin = new JLabel("Ngày thu tiền:");
		lblNgyThuTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgyThuTin.setBounds(10, 109, 117, 14);
		panelMain.add(lblNgyThuTin);
		
		JPanel panelDate = new JPanel();
		panelDate.setBounds(137, 97, 212, 30);
		panelMain.add(panelDate);
		
		picker.setTextEditable(false);
		picker.setShowYearButtons(true);
		panelDate.add((JComponent) picker);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setEditable(false);
		txtDienThoai.setBounds(142, 62, 200, 22);
		panelMain.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		txtDienThoai.setText(kh.getSoDienThoai().toString());
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(142, 22, 200, 22);
		panelMain.add(txtTenKH);
		txtTenKH.setColumns(10);
		txtTenKH.setText(kh.getHoTen());
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(385, 25, 80, 14);
		panelMain.add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(475, 21, 200, 22);
		panelMain.add(txtDiaChi);
		txtDiaChi.setText(kh.getDiaChi());
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(385, 66, 80, 14);
		panelMain.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(475, 63, 200, 22);
		panelMain.add(txtEmail);
		txtEmail.setText(kh.getEmail());
		
		JLabel lblSTinThu = new JLabel("Số tiền thu:");
		lblSTinThu.setBounds(385, 109, 80, 14);
		panelMain.add(lblSTinThu);
		
		JSpinner spinnerTienThu = new JSpinner();
		spinnerTienThu.setBounds(474, 105, 106, 22);
		spinnerTienThu.setModel(new SpinnerNumberModel(1, 1, 10000000, 1));
		spinnerTienThu.setEditor(new JSpinner.NumberEditor(spinnerTienThu,"##.#"));
		JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerTienThu.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		panelMain.add(spinnerTienThu);
		
		JButton btnThuTien = new JButton("THU TIỀN");
		btnThuTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kiem tra so tien thu co vuot so tien dang no khong
				int tienthu = (Integer) spinnerTienThu.getValue();
				
				if(tienthu > kh.getTienNo()) {
					JOptionPane.showMessageDialog(null, "Số tiền thu không vượt quá số tiền khách đang nợ.");
				} else {
					//cap nhat lai so tien no cua khach hang
					KhachHangDAO khDAO = new KhachHangDAO();
					khDAO.capNhatTienNo(kh.getId(), kh.getTienNo() - tienthu);
					
					//lay ngay tu datepicker
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					Calendar c2 = (Calendar) picker.getModel().getValue();
					
					String ngaythu = "";
					
					if(c2 != null) {
						ngaythu = sdf.format(c2.getTime());
					} else {
						//lay ngay hien tai
						Date date = new Date();
						ngaythu = sdf.format(date);
					}
					
					//insert vao bang thu tien
					Thutien tt = new Thutien();
					tt.setMaKh(kh.getId());
					tt.setTienThu((long) tienthu);
					tt.setNgayThu(ngaythu);
					
					ThuTienDAO ttDAO = new ThuTienDAO();
					ttDAO.thuTien(tt);
					
					JOptionPane.showMessageDialog(null, "Thu tiền thành công.");
					
					dispose();
				}
			}
		});
		btnThuTien.setBounds(286, 163, 117, 38);
		panelMain.add(btnThuTien);
	}
}
