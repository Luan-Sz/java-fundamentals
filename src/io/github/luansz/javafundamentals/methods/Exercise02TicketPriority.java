package io.github.luansz.javafundamentals.methods;

import java.util.Scanner;
public class Exercise02TicketPriority {
    public static String calculatePriority(boolean systemUnavailable, int waitingTime){
        if(systemUnavailable && time >= 20){
            return "CRITICAL";
        } else if(systemUnavailable || time >= 30){
            return "HIGH";
        } else if(time >= 10){
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static int calculateSla(String priority){
        if (priority.equals("CRITICAL")) {
            return 15;
        } else if (priority.equals("HIGH")) {
            return 30;
        } else if (priority.equals("MEDIUM")) {
            return 120;
        } else {
            return 480;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Enter the waiting time (minutes only): ");
        int waitingTime = scanner.nextInt();
        scanner.nextLine();
        boolean systemUnavailable;
        String response;
        do {
            System.out.print("Is the system unavailable? (Y/N): ");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                systemUnavailable = true;
            } else {
                systemUnavailable = false;
            }
        } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"));

        String myPriority = calculatePriority(systemUnavailable, waitingTime);
        int myTime = calculateSla(myPriority);
        System.out.println("Ticket: " + serviceName);
        System.out.println("Priority: " + myPriority);
        System.out.println("SLA: " + myTime + " minutes");
        scanner.close();
    }
}