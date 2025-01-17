package Employees;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        Scanner scanner = new Scanner(System.in);

        // نام کاربری و رکز عبور کارمند
        System.out.print("user name :");
        person.setUsername(scanner.nextLine().toUpperCase());
        System.out.print("password :");
        String password = scanner.next();

        //رمز رندوم ریخته میشه تو متغیر برای نمایش
        int correctPassword = person.random_password;
        System.out.print("[password] :" + correctPassword + "\n");//نمایش رمز رندوم
        System.out.print("new Password :");
        person.setPassword(scanner.nextInt());

        try {
            // اتصال به پایگاه داده
            forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/?user=root", "root", "abolfazl05");
            String sql = "SELECT* FROM employees WHERE name =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute("use data_employees");
            statement.setString(1, person.getUsername());
            try (ResultSet resultSet = statement.executeQuery()) {
                // مقایسه رمز عبور ورودی با رمز عبور ذخیره شده
                if (resultSet.next()) {
                    String checkPassword = resultSet.getString("password");

                    if (checkPassword.equals(password)) {
                        System.out.println("رمز عبور صحیح است.");
                    } else {
                        System.out.println("رمز عبور نادرست است.");
                    }
                } else {
                    System.out.println("کاربر یافت نشد.");
                }
            }
            // بستن منابع


        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

    }

}
