package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise06BarbershopMenu {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== BARBERSHOP MENU ===");
            System.out.println("1 - Haircut");
            System.out.println("2 - Beard trim");
            System.out.println("3 - Haircut and beard");
            System.out.println("0 - Exit");
            System.out.print("Choice - ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Service: Haircut");
                    System.out.println("Price: $35.00");
                    break;
                case 2:
                    System.out.println("Service: Beard trim");
                    System.out.println("Price: $25.00");
                    break;
                case 3:
                    System.out.println("Service: Haircut and beard");
                    System.out.println("Price: $55.00");
                    break;
                case 0:
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    System.out.println("Try again with a valid choice.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
