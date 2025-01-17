package Employees;

import java.util.Random;
import java.util.Scanner;

public class Person {
    Scanner scanner = new Scanner(System.in);//آبجکت ورودی

    private String username;

    Random random = new Random();// آبجکت رندوم

    // اعداد تصادفی
    public int random_password = random.nextInt(10000);
    //تعداد تلاش password
    public int passwords;
    int correctPassword2;
    int number = 3;
    //متغیری برای برس صحت رمز عبور
    public boolean Boolean1 = false;


    public void setUsername(String username1) {
        this.username = username1;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(int password1) //اعتبار سنجی رمز ورود
    {
        if (password1 == random_password) {
            Boolean1 = true;
            System.out.println("nice");
        } else {
            System.out.println("not password");

            while (!Boolean1 && number > 0) {
                if (password1 != random_password) {
                    correctPassword2 = random.nextInt(10000);
                    System.out.print("[pass] :" + correctPassword2 + "\n");
                    System.out.print("new password :");
                    passwords = scanner.nextInt();
                    if (passwords == correctPassword2) {
                        System.out.println("nice jab");
                        break;
                    } else {
                        System.out.println("no pass");
                        number--;
                    }
                    if (number == 0) {
                        throw new IllegalArgumentException("(((limit)))");
                    }
                }
            }
        }
    }
}