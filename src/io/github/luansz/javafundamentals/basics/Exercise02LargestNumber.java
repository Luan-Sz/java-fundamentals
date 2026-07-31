package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise02LargestNumber {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        int largest = 0;
        int count = 0;
        do {
            System.out.print("number " + (count + 1) + ": ");
            numbers[count] = scanner.nextInt();

            if (count == 0 || numbers[count] > largest) {
                largest = numbers[count];
            }

            count++;
        } while (count < numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i + 1) + ". " + numbers[i]);
        }
        System.out.println("The largest number is " + largest);
    }
}
