package Employees;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data_Base db = new Data_Base();
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
            Connection connection = db.getConnection();
            // بررسی مطابقت داشتن کاربر با رمز عبور
            String sql = "SELECT password FROM employees WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            // مقایسه رمز عبور ورودی با رمز عبور ذخیره شده
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                if (storedPassword.equals(password)) {
                    System.out.println("رمز عبور صحیح است.");
                } else {
                    System.out.println("رمز عبور نادرست است.");
                }
            } else {
                System.out.println("کاربر یافت نشد.");
            }
            // بستن منابع
            resultSet.close();
            preparedStatement.close();
            db.closeConnection();

        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

    }

}
