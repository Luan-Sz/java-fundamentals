package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise01Introduction {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        System.out.println("Hi!");
        System.out.print("What is your name: ");
        name = scanner.nextLine();
        System.out.print("What is your age: ");
        age = scanner.nextInt();
        scanner.close();
        System.out.println("Your name is " + name);
        System.out.println("Your age is " + age);
    }
}
