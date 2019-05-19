package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import dao.SachDAO;
import entities.Sach;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemNhapSach extends JFrame {

	private JPanel contentPane;
	public ArrayList<Sach> dsSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhapSach frame = new ThemNhapSach();
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
	public ThemNhapSach() {
		setResizable(false);
		setTitle("Th\u00EAm s\u00E1ch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 395, 40);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThmSch = new JLabel("TH\u00CAM S\u00C1CH");
		lblThmSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThmSch.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblThmSch);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 62, 395, 166);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblChnSch = new JLabel("Ch\u1ECDn s\u00E1ch:");
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
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblSLng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLng.setBounds(10, 71, 81, 22);
		mainPanel.add(lblSLng);
		
		JSpinner spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setBounds(101, 70, 97, 25);
		spinnerSoLuong.setModel(new SpinnerNumberModel(1,1,300,1));
		spinnerSoLuong.setEditor(new JSpinner.NumberEditor(spinnerSoLuong,"##.#"));
		JFormattedTextField txt = ((JSpinner.NumberEditor) spinnerSoLuong.getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
		mainPanel.add(spinnerSoLuong);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lay id sach va so luong
				Sach s = (Sach) cbChonSach.getSelectedItem();
				int id = s.getId();
				
				int soluong = (Integer) spinnerSoLuong.getValue();
				
				System.out.println("Id: " + id + " so luong: " + soluong);
			}
		});
		btnThem.setBounds(101, 115, 97, 34);
		mainPanel.add(btnThem);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
