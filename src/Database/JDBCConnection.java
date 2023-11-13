package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyHangHoa.HangHoa;

public class JDBCConnection {
    private Connection conn;

    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/ProductManagement";
            String username = "root";
            String password = "";

            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Lỗi connect");
            e.printStackTrace();
        }

        return conn;
    }

    public boolean addHangHoa(HangHoa e) {
        String sql = "INSERT INTO qlhanghoa(Id, Ten, Gia, SoLuong, DaNhap, NgayNhap, DaXuat, NgayXuat) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getId());
            ps.setString(2, e.getTen());
            ps.setDouble(3, e.getGia());
            ps.setInt(4, e.getSoLuong());
            ps.setInt(5, e.getDaNhap());
            ps.setString(6, e.getNgayNhap());
            ps.setInt(7, e.getDaXuat());
            ps.setString(8, e.getNgayXuat());
            return ps.executeUpdate() > 0;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public ArrayList<HangHoa> getListHangHoa() {
        ArrayList<HangHoa> list = new ArrayList<>();
        String sql = "SELECT * FROM qlhanghoa";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HangHoa s = new HangHoa(rs.getString("Id"), rs.getString("Ten"), rs.getDouble("Gia"),
                        rs.getInt("SoLuong"), rs.getInt("DaNhap"), rs.getString("NgayNhap"), rs.getInt("DaXuat"),
                        rs.getString("NgayXuat"));

                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void closeConnect(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a new instance of HangHoa
        HangHoa newHangHoa = new HangHoa("123", "Tên hàng hóa", 10.5, 20, 0, "", 0, "");

        // Create a new instance of JDBCConnection
        JDBCConnection jdbcConnection = new JDBCConnection();

        // Get a connection
        Connection connection = jdbcConnection.getConnection();

        // Assign the obtained connection to the conn variable
        jdbcConnection.conn = connection;

        // Add the new HangHoa to the database
        boolean success = jdbcConnection.addHangHoa(newHangHoa);

        if (success) {
            System.out.println("Hàng hóa đã được thêm vào CSDL.");
        } else {
            System.out.println("Lỗi khi thêm hàng hóa vào CSDL.");
        }

        // Close the connection
        jdbcConnection.closeConnect(connection);
    }
}