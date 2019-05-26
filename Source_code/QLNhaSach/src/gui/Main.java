package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setTitle("Quản lý nhà sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHethong = new JMenu("Hệ thống");
		menuBar.add(mnHethong);
		
		JMenuItem mnDangnhap = new JMenuItem("Đăng nhập");
		mnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				contentPane.removeAll();
				contentPane.add(dn);
				revalidate();
			}
		});
		mnHethong.add(mnDangnhap);
		
		JMenuItem mntmngXut = new JMenuItem("Đăng xuất");
		mnHethong.add(mntmngXut);
		
		JMenu mnDanhmuc = new JMenu("Danh mục");
		menuBar.add(mnDanhmuc);
		
		JMenuItem mnDSSach = new JMenuItem("Danh sách sách");
		mnDSSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DSSach ds = new DSSach();
				contentPane.removeAll();
				contentPane.add(ds);
				revalidate();
			}
		});
		mnDanhmuc.add(mnDSSach);
		
		JMenuItem mnTheloaisach = new JMenuItem("Thể loại sách");
		mnDanhmuc.add(mnTheloaisach);
		
		JMenuItem mnTacgia = new JMenuItem("Tác giả");
		mnDanhmuc.add(mnTacgia);
		
		JMenuItem mnKhachhang = new JMenuItem("Khách hàng");
		mnDanhmuc.add(mnKhachhang);
		
		JMenuItem mnNhaxuatban = new JMenuItem("Nhà xuất bản");
		mnDanhmuc.add(mnNhaxuatban);
		
		JMenu mnNghiepvu = new JMenu("Nghiệp vụ");
		menuBar.add(mnNghiepvu);
		
		JMenuItem mnPhieunhapsach = new JMenuItem("Lập phiếu nhập sách");
		mnPhieunhapsach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PhieuNhapSach ns = new PhieuNhapSach();
				contentPane.removeAll();
				contentPane.add(ns);
				revalidate();
			}
		});
		mnNghiepvu.add(mnPhieunhapsach);
		
		JMenuItem mnHoadon = new JMenuItem("Lập hóa đơn");
		mnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoaDon hd = new HoaDon();
				contentPane.removeAll();
				contentPane.add(hd);
				revalidate();
			}
		});
		mnNghiepvu.add(mnHoadon);
		
		JMenuItem mnThuTien = new JMenuItem("Lập phiếu thu tiền");
		mnThuTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DSKhachNo thutien = new DSKhachNo();
				contentPane.removeAll();
				contentPane.add(thutien);
				revalidate();
			}
		});
		mnNghiepvu.add(mnThuTien);
		
		JMenu mnBaocao = new JMenu("Báo cáo");
		menuBar.add(mnBaocao);
		
		JMenuItem mnBaocaoton = new JMenuItem("Báo cáo tồn");
		mnBaocaoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaoCaoTon bcTon = new BaoCaoTon();
				contentPane.removeAll();
				contentPane.add(bcTon);
				revalidate();
			}
		});
		mnBaocao.add(mnBaocaoton);
		
		JMenuItem mnBaocaocongno = new JMenuItem("Báo cáo công nợ");
		mnBaocaocongno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaoCaoCongNo bcCongNo = new BaoCaoCongNo();
				contentPane.removeAll();
				contentPane.add(bcCongNo);
				revalidate();
			}
		});
		mnBaocao.add(mnBaocaocongno);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelGioiThieu = new JPanel();
		contentPane.add(panelGioiThieu, BorderLayout.CENTER);
		panelGioiThieu.setLayout(null);
		
		JLabel lbln = new JLabel("ĐỒ ÁN");
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbln.setBounds(366, 129, 152, 31);
		panelGioiThieu.add(lbln);
		
		JLabel lblLpTrnhng = new JLabel("LẬP TRÌNH ỨNG DỤNG JAVA");
		lblLpTrnhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblLpTrnhng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLpTrnhng.setBounds(314, 160, 263, 31);
		panelGioiThieu.add(lblLpTrnhng);
		
		JLabel lblGvhdHTun = new JLabel("GVHD: Hồ Tuấn Thanh");
		lblGvhdHTun.setHorizontalAlignment(SwingConstants.LEFT);
		lblGvhdHTun.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGvhdHTun.setBounds(348, 256, 263, 31);
		panelGioiThieu.add(lblGvhdHTun);
		
		JLabel lblSvthVTh = new JLabel("SVTH: Võ Thị Ngọc Giàu - 1742019");
		lblSvthVTh.setHorizontalAlignment(SwingConstants.LEFT);
		lblSvthVTh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSvthVTh.setBounds(348, 286, 263, 31);
		panelGioiThieu.add(lblSvthVTh);
		
		JLabel lblTiQun = new JLabel("Đề tài: Quản lý nhà sách");
		lblTiQun.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiQun.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiQun.setBounds(314, 202, 263, 31);
		panelGioiThieu.add(lblTiQun);
		
		JLabel lblNguynThKiu = new JLabel("Nguyễn Thị Kiều Oanh - 1742044");
		lblNguynThKiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNguynThKiu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNguynThKiu.setBounds(389, 308, 263, 31);
		panelGioiThieu.add(lblNguynThKiu);
	}
}
