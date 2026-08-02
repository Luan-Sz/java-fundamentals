package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise05ServicePrice {
    static void main() {
        String serviceName;
        double ogprice;
        double newprice;
        double discountAmount;
        double discount;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the service name: ");
        serviceName=scanner.nextLine();
        System.out.print("Enter the service price: ");
        ogprice=scanner.nextDouble();
        System.out.print("Enter the discount: ");
        discount=scanner.nextDouble();

        discountAmount = (ogprice * discount)/100;
        newprice = (ogprice - discountAmount);
        System.out.println();
        System.out.println("Service: " + serviceName);
        System.out.printf("Original price: $%.2f%n", ogprice);
        System.out.printf("Discount: %.1f%%%n", discount);
        System.out.printf("Discount amount: $%.2f%n", discountAmount);
        System.out.printf("Final price: $%.2f%n", newprice);
        scanner.close();
    }
}
