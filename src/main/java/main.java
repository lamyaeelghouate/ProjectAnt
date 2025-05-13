package com.app;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculator calculator = new calculator();

        System.out.println("Entrez deux nombres : ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("Addition : " + calculator.add(num1, num2));
        System.out.println("Soustraction : " + calculator.subtract(num1, num2));
        System.out.println("Multiplication : " + calculator.multiply(num1, num2));
        
        try {
            System.out.println("Division : " + calculator.divide(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        scanner.close();
    }
}