package io.github.luansz.javafundamentals.methods;

import java.util.Scanner;

public class Exercise05ServiceDeskDailyReport {
    public static String calculatePriority(boolean isSystemunavailable, int waitingTime) {
        if (isSystemunavailable && waitingTime >= 20) {
            return "CRITICAL";
        } else if (isSystemunavailable || waitingTime >= 30) {
            return "HIGH";
        } else if (waitingTime >= 10) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static int calculateSLA(String priority) {
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

    public static int resolutionSLA(int resolutionTime, int sla) {
        if (resolutionTime <= sla) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double averageResolutionTime(int sumCase, int totalCases) {
        return (double) sumCase / totalCases;
    }

    public static void showStatus(int totalCases, int totalCritical, int totalHigh, int totalMedium, int totalLow, int totalWithinSLA, int totalOutsideSLA, double averageResolutionTime) {
        System.out.println("===== DAILY REPORT =====");
        System.out.println("Total Tickets: " + totalCases);
        System.out.println("Critical Tickets: " + totalCritical);
        System.out.println("High Tickets: " + totalHigh);
        System.out.println("Medium Tickets: " + totalMedium);
        System.out.println("Low Tickets: " + totalLow);
        System.out.println("Tickets within SLA: " + totalWithinSLA);
        System.out.println("Tickets outside SLA: " + totalOutsideSLA);
        System.out.printf("SLA Compliance: %.2f%%%n", ((double) totalWithinSLA / totalCases) * 100);
        System.out.printf("Average resolution time: %.2f minutes%n", averageResolutionTime);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many tickets were handled today? - ");
        int totalCases = scanner.nextInt();
        scanner.nextLine();
        String[] ticketName = new String[totalCases];
        int[] waitingTime = new int[totalCases];
        int[] resolutionTime = new int[totalCases];
        boolean[] isSystemunavailable = new boolean[totalCases];
        String[] isSystemInput = new String[totalCases];
        String[] slaStatus = new String[totalCases];
        int totalCritical = 0;
        int totalHigh = 0;
        int totalMedium = 0;
        int totalLow = 0;
        int totalTicketWithin = 0;
        int totalTicketOutside = 0;
        String[] myPriority = new String[totalCases];
        int[] mySLA = new int[totalCases];
        int[] myResolutionSLA = new int[totalCases];
        int sumCase = 0;
        for (int i = 0; i < totalCases; i++) {
            System.out.print("Ticket title: ");
            ticketName[i] = scanner.nextLine();
            System.out.print("Waiting time in minutes: ");
            waitingTime[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Resolution time in minutes: ");
            resolutionTime[i] = scanner.nextInt();
            sumCase += resolutionTime[i];
            scanner.nextLine();
            do {
                System.out.print("Was the system unavailable? (Y/N): ");
                isSystemInput[i] = scanner.nextLine();
                if (isSystemInput[i].equalsIgnoreCase("Y")) {
                    isSystemunavailable[i] = true;
                } else if (isSystemInput[i].equalsIgnoreCase("N")) {
                    isSystemunavailable[i] = false;
                } else {
                    System.out.println("Invalid input.");
                }
            } while (!isSystemInput[i].equalsIgnoreCase("Y") && !isSystemInput[i].equalsIgnoreCase("N"));
        }

        double myAverageResolutionTime = averageResolutionTime(sumCase, totalCases);
        for (int i = 0; i < totalCases; i++) {
            myPriority[i] = calculatePriority(isSystemunavailable[i], waitingTime[i]);
            if (myPriority[i].equals("CRITICAL")) {
                totalCritical++;
            } else if (myPriority[i].equals("HIGH")) {
                totalHigh++;
            } else if (myPriority[i].equals("MEDIUM")) {
                totalMedium++;
            } else {
                totalLow++;
            }
            mySLA[i] = calculateSLA(myPriority[i]);
            myResolutionSLA[i] = resolutionSLA(resolutionTime[i], mySLA[i]);

            if (myResolutionSLA[i] == 1) {
                slaStatus[i] = "Within SLA";
                totalTicketWithin++;
            } else {
                slaStatus[i] = "Outside SLA";
                totalTicketOutside++;
            }

            System.out.println("Ticket: " + ticketName[i]);
            System.out.println("Priority: " + myPriority[i]);
            System.out.println("Resolution time: " + resolutionTime[i] + " minutes");
            System.out.println("SLA: " + mySLA[i] + " minutes");
            System.out.println("Status: " + slaStatus[i]);
            System.out.println();
        }
        showStatus(totalCases, totalCritical, totalHigh, totalMedium, totalLow, totalTicketWithin, totalTicketOutside, myAverageResolutionTime);
        scanner.close();
    }
}
