package QuanLyHangHoa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ThongKe extends JFrame implements ActionListener{
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,lh;
	JButton ok;
	ArrayList<HangHoa> hh = new ArrayList<HangHoa>();
	public ThongKe(String s, ArrayList<HangHoa> h) {
		super(s);
		hh=h;
		int soLoaiHH=0,soLuongHH=0,soLuongNhap=0,soLuongXuat=0;
		String hhSapHet="  ";
		String hhConNhieu="  ";
		String hhHet="  ";
		for (HangHoa o : h) {
			soLoaiHH++;
			soLuongHH += o.getSoLuong();
			soLuongNhap+=o.getDaNhap();
			soLuongXuat+=o.getDaXuat();
			
			//hang hoa con it <5 va hang hoa con nhieu >20;
			if(o.getSoLuong()<5&&o.getSoLuong()>0) hhSapHet+=o.getTen()+", ";
			if(o.getSoLuong()>20) hhConNhieu+=o.getTen()+", ";
			if(o.getSoLuong()==0) hhHet+=o.getTen()+", ";
		}
		hhSapHet=hhSapHet.substring(0, hhSapHet.length()-2);
		hhConNhieu=hhConNhieu.substring(0, hhConNhieu.length()-2);
		hhHet=hhHet.substring(0, hhHet.length()-2);
		
		l1 = new JLabel("Số loại hàng hóa : "+String.valueOf(soLoaiHH));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2 = new JLabel("Tổng số lượng hàng hóa : "+String.valueOf(soLuongHH));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3 = new JLabel("Số lượng hàng hoá đã nhập : "+String.valueOf(soLuongNhap));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l4 = new JLabel("Số lượng hàng hoá đã xuất : "+String.valueOf(soLuongXuat));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lh = new JLabel("Các loại hàng hoá đã hết : "+hhHet);
		lh.setHorizontalAlignment(SwingConstants.CENTER);
		lh.setForeground(new Color(255, 0, 0));
		
		l5 = new JLabel("Các loại hàng hoá sắp hết : "+hhSapHet);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setForeground(new Color(255, 99, 71));
		l6 = new JLabel("Các loại hàng hoá còn nhiều : "+hhConNhieu);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setForeground(new Color(0, 0, 255));
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(7,1));
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(lh);
		p1.add(l5);
		p1.add(l6);
		ok = new JButton("Cancel");
		ok.addActionListener(this);
		this.add(p1,BorderLayout.CENTER);
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(ok);
		this.add(p2,BorderLayout.SOUTH);
		setLocation(450,200);
		setSize(500, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}
	}
}