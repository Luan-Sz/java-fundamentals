package io.github.luansz.javafundamentals.basics;

import java.util.Scanner;

public class Exercise03StudentAverage {
    static void main() {
        float[] grades = new float[3];
        float sum = 0.0f;
        int count = 0;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? - ");
        name = scanner.nextLine();
        System.out.println("Let's get your grades " + name + "!");
        do {
            System.out.print((count + 1) + " grade - ");
            grades[count] = scanner.nextFloat();
            sum += grades[count];
            count++;
        } while (count < grades.length);
        float average = sum / count;
        System.out.println(name + " here's your result of the semester:");
        for (int i = 0; i < grades.length; i++) {
            System.out.println((i + 1) + ". " + grades[i]);
        }
        System.out.printf("Average: %.1f%n", average);
        if (average < 5.0f) {
            System.out.println("Average is below 5.0!");
            System.out.println("Failed semester!");
            System.out.println("Start fresh next semester!");
        } else if ( average < 7.0f) {
            System.out.println("Average is below 7.0!");
            System.out.println("Recovery semester!");
            System.out.println("Study and try harder, better and stronger!");
        } else  {
            System.out.println("Average is 7.0 or higher!");
            System.out.println("Successful semester!");
            System.out.println("Smile, it's a good day!");
        }
        scanner.close();
    }
}
