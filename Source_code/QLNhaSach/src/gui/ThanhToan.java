package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

import dao.KhachHangDAO;
import dao.ThanhToanDAO;
import entities.Khachhang;
import entities.Thanhtoan;

import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThanhToan extends JFrame {

	private JPanel contentPane;
	private JTextField txtTotal;
	private JTextField txtTienThoi;
	private JTextField txtTienNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan("", null, 0);
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
	public ThanhToan(String maHoaDon, Khachhang kh, int tongTien) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Thanh toán");
		setResizable(false);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThanhTon = new JLabel("THANH TOÁN");
		lblThanhTon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThanhTon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhTon.setBounds(10, 11, 424, 25);
		contentPane.add(lblThanhTon);
		
		JLabel lblTnKhchHng = new JLabel("Tổng tiền phải trả:");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKhchHng.setBounds(10, 74, 112, 14);
		contentPane.add(lblTnKhchHng);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setBounds(132, 71, 233, 20);
		txtTotal.setText(String.valueOf(tongTien));
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTinKhcha = new JLabel("Tiền khách trả:");
		lblTinKhcha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinKhcha.setBounds(10, 120, 112, 14);
		contentPane.add(lblTinKhcha);
		
		JSpinner spinnerCus = new JSpinner();
		JComponent comp = spinnerCus.getEditor();
	    JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
	    DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
	    formatter.setCommitsOnValidEdit(true);
	    spinnerCus.addChangeListener(new ChangeListener() {

	        @Override
	        public void stateChanged(ChangeEvent e) {
	            int tienthoi = (Integer) spinnerCus.getValue() - tongTien;
	            txtTienThoi.setText(String.valueOf(tienthoi));
	            
	            int tienno = tongTien - (Integer) spinnerCus.getValue();
	            if(tienno > 0) {
	            	txtTienNo.setText(String.valueOf(tienno));
	            }
	        }
	    });
		spinnerCus.setBounds(132, 117, 233, 20);
		contentPane.add(spinnerCus);
		
		JLabel lblTinThi = new JLabel("Tiền thối:");
		lblTinThi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinThi.setBounds(10, 164, 112, 14);
		contentPane.add(lblTinThi);
		
		txtTienThoi = new JTextField();
		txtTienThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienThoi.setEditable(false);
		txtTienThoi.setBounds(132, 161, 233, 20);
		contentPane.add(txtTienThoi);
		txtTienThoi.setColumns(10);
		
		JLabel lblTinKhchN = new JLabel("Tiền khách nợ:");
		lblTinKhchN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinKhchN.setBounds(10, 210, 112, 14);
		contentPane.add(lblTinKhchN);
		
		txtTienNo = new JTextField();
		txtTienNo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienNo.setEditable(false);
		txtTienNo.setBounds(132, 207, 233, 20);
		contentPane.add(txtTienNo);
		txtTienNo.setColumns(10);
		
		JLabel lblng = new JLabel("đồng");
		lblng.setBounds(375, 74, 46, 14);
		contentPane.add(lblng);
		
		JLabel label = new JLabel("đồng");
		label.setBounds(375, 164, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("đồng");
		label_1.setBounds(375, 210, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("đồng");
		label_2.setBounds(375, 120, 46, 14);
		contentPane.add(label_2);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thanhtoan tt = new Thanhtoan();
				tt.setMaHoaDon(maHoaDon);
				tt.setMaKhachHang(kh.getId());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
				Date date = new Date();
				tt.setNgayThanhToan(sdf2.format(date));
				tt.setTienTra((Integer) spinnerCus.getValue());
				int tienno = tongTien - (Integer) spinnerCus.getValue();
				tt.setTienNo(tienno);
				
				ThanhToanDAO ttDAO = new ThanhToanDAO();
				ttDAO.thanhToan(tt);
				
				//cap nhat tien no neu khach hang co no
				if(tienno > 0) {
					KhachHangDAO khDAO = new KhachHangDAO();
					khDAO.capNhatTienNo(kh.getId(), kh.getTienNo() + tienno);
				}
				
				JOptionPane.showMessageDialog(null, "Thanh toán thành công");
				dispose();
			}
		});
		btnThanhToan.setBounds(174, 250, 102, 32);
		contentPane.add(btnThanhToan);
	}
}
