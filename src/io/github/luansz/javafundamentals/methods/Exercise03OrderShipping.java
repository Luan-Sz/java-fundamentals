package io.github.luansz.javafundamentals.methods;

import java.util.Scanner;

public class Exercise03OrderShipping {
    public static double calculateSubtotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    public static double calculateDelivery(int deliveryType, double subtotal) {
        if (deliveryType == 1) {
            if (subtotal >= 100) {
                return 0.00;
            } else {
                return 12.00;
            }
        } else {
            if (subtotal >= 200) {
                return 15.00;
            } else {
                return 25.00;
            }
        }
    }

    public static double calculateTotal(double subtotal, double deliveryPrice) {
        return subtotal + deliveryPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product: ");
        String productName = scanner.nextLine();
        System.out.print("Unit price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        int deliveryType;
        do {
            System.out.print("Enter the delivery type (1 = STANDARD, 2 for EXPRESS): ");
            deliveryType = scanner.nextInt();
            if (deliveryType != 1 && deliveryType != 2) {
                System.out.println("Invalid delivery type");
            }
        } while (deliveryType != 1 && deliveryType != 2);

        double mySubtotal = calculateSubtotal(unitPrice, quantity);
        double myDelivery = calculateDelivery(deliveryType, mySubtotal);
        double myTotal = calculateTotal(mySubtotal, myDelivery);
        System.out.println("Product: " + productName);
        System.out.printf("Subtotal: $%.2f%n", mySubtotal);
        System.out.printf("Shipping: $%.2f%n", myDelivery);
        System.out.printf("Total: $%.2f%n", myTotal);
        scanner.close();
    }
}
