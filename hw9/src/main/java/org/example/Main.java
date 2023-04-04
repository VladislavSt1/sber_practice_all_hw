package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        try {
            System.out.println("Enter the first number");
            a = in.nextInt();
            System.out.println("Enter the second number");
            b = in.nextInt();
            int result = Multiplier.multiplyEvenNumbers(a, b);
            System.out.println("The product of the numbers is: " + result);
        } catch (CustomException ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("The program has ended");
        }
    }
}