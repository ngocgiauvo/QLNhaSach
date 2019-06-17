package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SachDAO;
import dao.TheLoaiDAO;
import entities.Sach;
import entities.Theloai;
import gui.ThemNhapSach.BookListCellRenderer;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ThemSach extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTextField txtTacGia;
	private static ArrayList<Theloai> theloai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSach frame = new ThemSach(0, null);
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
	public ThemSach(int action, Sach s) {
		TheLoaiDAO tlDAO = new TheLoaiDAO();
		theloai = tlDAO.layTheLoai();
		
		String title = null, btnName = null;
		if(action == 1) {
			setTitle("Thêm sách");
			title = "THÊM SÁCH";
			btnName = "Thêm";
		}
		if(action == 2) {
			setTitle("Xóa sách");
			title = "XÓA SÁCH";
			btnName = "Xóa";
		}
		if(action == 3) {
			setTitle("Sửa sách");
			title = "SỬA SÁCH";
			btnName = "Sửa";
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(10, 11, 427, 35);
		contentPane.add(lblTitle);
		
		JLabel lblTnSch = new JLabel("Tên sách:");
		lblTnSch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnSch.setBounds(10, 73, 92, 14);
		contentPane.add(lblTnSch);
		
		JLabel lblThLoi = new JLabel("Thể loại:");
		lblThLoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThLoi.setBounds(10, 115, 92, 14);
		contentPane.add(lblThLoi);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(112, 70, 269, 20);
		if(action == 2) {
			txtTenSach.setEditable(false);
			txtTenSach.setText(s.getTenSach());
		}
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JComboBox cbTheLoai = new JComboBox();
		cbTheLoai.setBounds(112, 112, 269, 20);
		
		for(Theloai tl : theloai) {
			cbTheLoai.addItem(tl);
		}
		cbTheLoai.setRenderer(new BookListCellRenderer());
		
		if(action == 2) {
			cbTheLoai.setSelectedItem(tlDAO.layTenTheLoai(s.getTheLoai()));
			cbTheLoai.setEditable(false);
		}
		
		contentPane.add(cbTheLoai);
		
		JLabel lblTcGi = new JLabel("Tác giả:");
		lblTcGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTcGi.setBounds(10, 157, 92, 14);
		contentPane.add(lblTcGi);
		
		txtTacGia = new JTextField();
		txtTacGia.setBounds(112, 154, 269, 20);
		if(action == 2) {
			txtTacGia.setEditable(false);
			txtTacGia.setText(s.getTacGia());
		}
		contentPane.add(txtTacGia);
		txtTacGia.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnGi.setBounds(10, 203, 92, 14);
		contentPane.add(lblnGi);
		
		JSpinner spinnerGia = new JSpinner();
		spinnerGia.setBounds(112, 200, 269, 20);
		
		if(action == 2) {
			spinnerGia.setValue(s.getDonGia());
			((DefaultEditor) spinnerGia.getEditor()).getTextField().setEditable(false);
		}
		
		contentPane.add(spinnerGia);
		
		JButton btnAction = new JButton(btnName);
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sach ss = new Sach();
				ss.setTenSach(txtTenSach.getText());
				ss.setTacGia(txtTacGia.getText());
				Theloai tl = (Theloai) cbTheLoai.getSelectedItem();
				ss.setTheLoai(tl.getId());
				ss.setDonGia((Integer) spinnerGia.getValue());
				ss.setSoLuong(0);
				
				if(action == 1) {
					try {
						SachDAO sDAO = new SachDAO();
						sDAO.themSach(ss);
						
						JOptionPane.showMessageDialog(null, "Thêm sách thành công.");
						
						dispose();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				if(action == 2) {
					try {
						ss.setId(s.getId());
						ss.setSoLuong(s.getSoLuong());
						SachDAO sDAO = new SachDAO();
						sDAO.xoaSach(ss);
						
						JOptionPane.showMessageDialog(null, "Xóa sách thành công.");
						
						dispose();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
		btnAction.setBounds(185, 244, 89, 35);
		contentPane.add(btnAction);
	}
	
	public class BookListCellRenderer extends DefaultListCellRenderer {

	    @Override
	    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

	        if (value instanceof Theloai) {
	            value = ((Theloai)value).getTenTheLoai();
	        }

	        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

	    }

	}
}
