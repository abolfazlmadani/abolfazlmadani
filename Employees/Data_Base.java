package Employees;





import java.sql.*;
//اطلاعات پایگاه داده
public class Data_Base {
    private static final String URL = "jdbc:mysql://localhost:3306/data_employees";
    private static final String USER = "root";
    private static final String PASSWORD = "abolfazl05";
    //اتصال به پایگاه داده
    private Connection connection;

    //سازنده هنگام ایجاد شی فراخوان میشود که اتصال به پایگاه داده را برقرار میکند
    public Data_Base() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    //این متد برای بستن اتصال به پایگاه داده استفاده میشود
    public void closeConnection() {
        try {
            if (connection != null) {//بررسی میکند اگر اتصال موجود است آن را ببندد
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}



