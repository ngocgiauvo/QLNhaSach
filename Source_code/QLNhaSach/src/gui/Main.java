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
		setTitle("Qu\u1EA3n l\u00FD nh\u00E0 s\u00E1ch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHethong = new JMenu("H\u1EC7 th\u1ED1ng");
		menuBar.add(mnHethong);
		
		JMenuItem mnDangnhap = new JMenuItem("\u0110\u0103ng nh\u1EADp");
		mnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				contentPane.add(dn);
				revalidate();
			}
		});
		mnHethong.add(mnDangnhap);
		
		JMenuItem mntmngXut = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mnHethong.add(mntmngXut);
		
		JMenu mnDanhmuc = new JMenu("Danh m\u1EE5c");
		menuBar.add(mnDanhmuc);
		
		JMenuItem mnDSSach = new JMenuItem("Danh s\u00E1ch s\u00E1ch");
		mnDanhmuc.add(mnDSSach);
		
		JMenuItem mnTheloaisach = new JMenuItem("Th\u1EC3 lo\u1EA1i s\u00E1ch");
		mnDanhmuc.add(mnTheloaisach);
		
		JMenuItem mnTacgia = new JMenuItem("T\u00E1c gi\u1EA3");
		mnDanhmuc.add(mnTacgia);
		
		JMenuItem mnKhachhang = new JMenuItem("Kh\u00E1ch h\u00E0ng");
		mnDanhmuc.add(mnKhachhang);
		
		JMenuItem mnNhaxuatban = new JMenuItem("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		mnDanhmuc.add(mnNhaxuatban);
		
		JMenu mnNghiepvu = new JMenu("Nghi\u1EC7p v\u1EE5");
		menuBar.add(mnNghiepvu);
		
		JMenuItem mnPhieunhapsach = new JMenuItem("L\u1EADp phi\u1EBFu nh\u1EADp s\u00E1ch");
		mnPhieunhapsach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PhieuNhapSach ns = new PhieuNhapSach();
				contentPane.removeAll();
				contentPane.add(ns);
				revalidate();
			}
		});
		mnNghiepvu.add(mnPhieunhapsach);
		
		JMenuItem mnHoadon = new JMenuItem("L\u1EADp h\u00F3a \u0111\u01A1n");
		mnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoaDon hd = new HoaDon();
				contentPane.removeAll();
				contentPane.add(hd);
				revalidate();
			}
		});
		mnNghiepvu.add(mnHoadon);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
