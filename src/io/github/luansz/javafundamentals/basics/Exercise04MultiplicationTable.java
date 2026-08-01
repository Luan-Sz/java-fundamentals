package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise04MultiplicationTable {
    static void main() {
        int num;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        num = scanner.nextInt();
        do {
            System.out.println(num + " x " + (count + 1) + " = " + (num * (count + 1)));
            count++;
        } while (count < 10);
        scanner.close();
    }
}
