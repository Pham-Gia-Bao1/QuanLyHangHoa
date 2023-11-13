package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Database.JDBCConnection;
import QuanLyHangHoa.HangHoa;

public class test {
    public static void main(String[] args) {
        JDBCConnection jdbcConnection = new JDBCConnection();
        Connection connection = jdbcConnection.getConnection();

    	
    	HangHoa newHangHoa = new HangHoa("456", "Tên hàng hóa 2", 15.75, 30, 0, "", 0, "");
    	boolean success = jdbcConnection.addHangHoa(newHangHoa);
    	if (success) {
    	    System.out.println("Hàng hóa đã được thêm vào CSDL.");
    	} else {
    	    System.out.println("Lỗi khi thêm hàng hóa vào CSDL.");
    	}

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM qlhanghoa WHERE id = 1");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int col = rsmd.getColumnCount();

            for (int i = 1; i <= col; i++) {
                System.out.print(rsmd.getColumnLabel(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcConnection.closeConnect(connection);
    }
}