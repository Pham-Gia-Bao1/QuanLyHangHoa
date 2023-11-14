package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import QuanLyHangHoa.*;

import Database.JDBCConnection;

public class QLHangHoa extends JFrame implements ActionListener,MouseListener{
	
	JScrollPane sp;
	JPanel p ,jpn1;
	JTable tb;
	DefaultTableModel model;
	ArrayList<HangHoa> list;
	JButton bNew,bEdit,bDelete,bThongKe,bThongKeTime,bTimKiem,bSapXep,bLamMoi;
	JLabel lableTK,lableSX,lableTimKiem,lableSapXep,tenSV;
	JComboBox comSX;
	JTextField tfTK,tfSX;
	int getRow;
	public QLHangHoa(String s) {
		
		super(s);
		setLayout(new BorderLayout());
		
		jpn1 = new JPanel();
		jpn1.setLayout(new FlowLayout());
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\no-image (1).png"));
		tenSV = new JLabel("Quản Lý Hàng Hoá Xuất - Nhập Kho");
		tenSV.setForeground(new Color(255, 0, 0));
		tenSV.setFont(new Font("Sitka Text", Font.BOLD, 24));
        
		jpn1.add(img,BorderLayout.WEST);
		jpn1.add(tenSV,BorderLayout.CENTER);
		jpn1.setBackground(new Color(224, 255, 255));
		
		this.add(jpn1,BorderLayout.NORTH);
		
		tb = new JTable();
		tb.addMouseListener(this);
		list = new JDBCConnection().getListHangHoa();
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Ten");
		model.addColumn("Gia");
		model.addColumn("So Luong");
		model.addColumn("Da Nhap");
		model.addColumn("Ngay Nhap");
		model.addColumn("Da Xuat");
		model.addColumn("Ngay Xuat");
		for (HangHoa e : list) {
			model.addRow(new Object[] {e.getId(),e.getTen(),e.getGia(),e.getSoLuong(),
					e.getDaNhap(),e.getNgayNhap(),e.getDaXuat(),e.getNgayXuat()});
		}
		tb.setModel(model);
		sp = new JScrollPane(tb);
		sp.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "DANH SÁCH HÀNG HÓA   ", TitledBorder.CENTER, 
				TitledBorder.TOP, null, Color.MAGENTA));
		this.add(sp,BorderLayout.CENTER);
		sp.setBackground(new Color(204, 255, 204));
		
		p = new JPanel();
		bNew = new JButton("Nhập Hàng Hóa Mới");
		bNew.addActionListener(this);
		
		bEdit = new JButton("Chỉnh Sửa Thông Tin");
		bEdit.addActionListener(this);
		
		bDelete = new JButton("Xuất Hàng Hóa");
		bDelete.addActionListener(this);
		
		bThongKe = new JButton("Thống Kê Hàng Hóa");
		bThongKe.addActionListener(this);
		bThongKeTime = new JButton("Thống Kê Theo Thời Gian");
		bThongKeTime.addActionListener(this);
		
		lableTK = new JLabel("Tìm Kiếm");
		lableTK.setHorizontalAlignment(SwingConstants.CENTER);
		lableTimKiem = new JLabel("Nhập Id hoac Ten");
		lableTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		tfTK = new JTextField("");
		bTimKiem = new JButton("Tìm Kiếm");
		bTimKiem.addActionListener(this);
		
		lableSX = new JLabel("Sắp Xếp");
		lableSX.setHorizontalAlignment(SwingConstants.CENTER);
		
		lableSapXep = new JLabel("Chọn Thông Tin Muốn Sắp Xếp");
		lableSapXep.setHorizontalAlignment(SwingConstants.CENTER);
		comSX = new JComboBox();
		
		comSX.addItem("Ten");
		comSX.addItem("Gia");
		comSX.addItem("So Luong");
		comSX.addItem("Ngay Nhap Kho");
		comSX.addItem("Ngay Xuat Kho");
		
		bSapXep = new JButton("Sắp Xếp");
		bSapXep.addActionListener(this);
		bLamMoi = new JButton("Xóa Hàng Hóa");
		bLamMoi.addActionListener(this);
		//Lam mau
		bNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		bNew.setBackground(new Color(153, 255, 102));
		bNew.setForeground(Color.BLACK);
		
		bDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		bDelete.setBackground(new Color(153, 255, 102));
		bDelete.setForeground(Color.BLACK);
		
		bEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		bEdit.setBackground(new Color(153, 255, 102));
		bEdit.setForeground(Color.BLACK);
		
		bLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		bLamMoi.setBackground(new Color(153, 255, 102));
		bLamMoi.setForeground(Color.BLACK);
		
		bThongKe.setFont(new Font("Tahoma", Font.BOLD, 12));
		bThongKe.setBackground(new Color(51, 255, 255));
		bThongKe.setForeground(Color.BLACK);
		
		bThongKeTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		bThongKeTime.setBackground(new Color(51, 255, 255));
		bThongKeTime.setForeground(Color.BLACK);
		
		bTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		bTimKiem.setBackground(new Color(51, 255, 255));
		bTimKiem.setForeground(Color.BLACK);
		
		bSapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		bSapXep.setBackground(new Color(51, 255, 255));
		bSapXep.setForeground(Color.BLACK);
		
		lableTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableTK.setForeground(Color.BLACK);
		lableSX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableSX.setForeground(Color.BLACK);
		
		lableTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lableTimKiem.setForeground(Color.BLACK);
		lableSapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lableSapXep.setForeground(Color.BLACK);
		
		//Add
		p.setLayout(new GridLayout(6,3));
		p.setBackground(new Color(204, 255, 204));
		p.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "CÁC CHỨC NĂNG  ", 
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.MAGENTA));
		p.add(bNew);
		p.add(lableTK);
		p.add(lableSX);
		
		p.add(bDelete);
		p.add(lableTimKiem);
		p.add(lableSapXep);
		
		p.add(bEdit);
		p.add(tfTK);
		p.add(comSX);
		
		p.add(bLamMoi);
		p.add(bTimKiem);
		p.add(bSapXep);
		
		p.add(bThongKe);
		JLabel sv = new JLabel("SINH VIÊN : ");
		sv.setFont(new Font("Tahoma", Font.BOLD, 13));
		sv.setBackground(new Color(51, 255, 255));
		sv.setForeground(new Color(255, 0, 0));
		sv.setHorizontalAlignment(SwingConstants.RIGHT);
		p.add(sv);
		
		JLabel svk = new JLabel("Pham Gia Bảo - Hồ Thị Mái - PNV25A");
		svk.setFont(new Font("Tahoma", Font.BOLD, 13));
		svk.setBackground(new Color(51, 255, 255));
		svk.setForeground(new Color(255, 0, 0));
		svk.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(svk);
		
		p.add(bThongKeTime);
	
		this.add(p,BorderLayout.SOUTH);
		setLocation(300,100);
		setSize(800,500);
		setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		getRow = Integer.valueOf(tb.getSelectedRow());
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Nhập Hàng Hóa Mới")) {
			new NhapKho("Nhập Hàng Hóa Mới", list, model);
		}
		else if(e.getActionCommand().equals("Xuất Hàng Hóa")) {
			new XuatKho("Xuất Hàng Hóa", list, model);
		}
		else if(e.getActionCommand().equals("Chỉnh Sửa Thông Tin")) {
			new ChinhSua("Chỉnh Sửa Thông Tin", list, model, getRow);
		}
		else if(e.getActionCommand().equals("Thống Kê Hàng Hóa")) {
			new ThongKe("Thống Kê Hàng Hóa", list);
		}
		else if(e.getActionCommand().equals("Thống Kê Theo Thời Gian")) {
			new ThongKeTime("Thống Kê Hàng Hóa Theo Thời Gian",list);
		}
		else if(e.getActionCommand().equals("Tìm Kiếm")) {
			boolean b=false;
			for (HangHoa o : list) {
				if((o.getId().equals(tfTK.getText()))||(o.getTen().equals(tfTK.getText()))){
					b=true;
				}
			}
			if(tfTK.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu");
			else if(b) new TimKiem("Tìm Kiếm", list, tfTK.getText());
			else JOptionPane.showMessageDialog(rootPane, "Không có trong kho");
		}
		else if(e.getActionCommand().equals("Sắp Xếp")) {
			String clone = comSX.getSelectedItem().toString();
			new SapXep("Sắp Xếp", list, clone);

		}
		else if(e.getActionCommand().equals("Xóa Hàng Hóa")) {
			new XoaHangHoa(list, model, getRow);		
		}
		 
	}
	
	public static void main(String[] args) {
		new QLHangHoa("ĐỒ ÁN JAVA CUỐI KÌ I");
	}
}