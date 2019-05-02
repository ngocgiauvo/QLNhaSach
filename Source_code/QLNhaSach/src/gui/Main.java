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
		setBounds(100, 100, 1100, 700);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
