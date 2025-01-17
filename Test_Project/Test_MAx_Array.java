package Test_Project;

import java.util.Random;
import java.util.Scanner;

public class Test_MAx_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("number :");
        int number;
        Random rand = new Random();
        while (true) {
            number = sc.nextInt();
            int random = rand.nextInt(10);

            if (number == random) {
                System.out.println("درست حدس زدی"+":"+ random);
            } else {
                System.out.println("اشتباه حدس زدی" +":"+ random);
            }
        }
    }

}
