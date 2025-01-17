package Test_Project;

import java.util.Scanner;
//این کد رشته را برعکس میکند
public class Test_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        String t = "";

        for (int i = message.length()- 1; i >= 0; i--) {
            t += message.charAt(i);
        }
        System.out.println(t);
    }
}
