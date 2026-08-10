package io.github.luansz.javafundamentals.oop;

public class Ticket {
    private String ticketTitle;
    private Requester requester;
    private int waitingTime;
    private int resolutionTime;
    private boolean isSystemUnavailable;
    private String priority;
    private int sla;
    private String slaStatus;

    //constructor
    public Ticket(Requester requester, String ticketTitle, int waitingTime, int resolutionTime, boolean isSystemUnavailable) {
        if (requester == null) {
            throw new IllegalArgumentException("Requester must be placed");
        } else {
            this.requester = requester;
        }
        this.setTicketTitle(ticketTitle);
        this.setWaitingTime(waitingTime);
        this.setResolutionTime(resolutionTime);
        this.setSystemUnavailable(isSystemUnavailable);
    }

    //methods
    public void showSummary() {
        System.out.println("Requester");
        System.out.println("Name: " + requester.getName());
        System.out.println("Email: " + requester.getEmail());
        System.out.println("EmployeeID: " + requester.getEmployeeId());

        System.out.println();

        System.out.println("Ticket Title: " + ticketTitle);
        System.out.println("Waiting time: " + waitingTime);
        System.out.println("Resolution time: " + resolutionTime);
        System.out.println("System Unavailable: " + isSystemUnavailable);
        System.out.println("Priority:" + priority);
        System.out.println("SLA: " + sla);
        System.out.println("SLA Status: " + slaStatus);
    }

    private void calculatePriority() {
        if (isSystemUnavailable && waitingTime >= 20) {
            priority = "CRITICAL";
        } else if (isSystemUnavailable || waitingTime >= 30) {
            priority = "HIGH";
        } else if (waitingTime >= 10) {
            priority = "MEDIUM";
        } else {
            priority = "LOW";
        }
    }

    private void calculateSla() {
        if (priority.equals("CRITICAL")) {
            sla = 15;
        } else if (priority.equals("HIGH")) {
            sla = 30;
        } else if (priority.equals("MEDIUM")) {
            sla = 120;
        } else {
            sla = 480;
        }
    }

    private void calculateSlaStatus() {
        if (resolutionTime <= sla) {
            slaStatus = "WITHIN SLA";
        } else {
            slaStatus = "SLA BREACHED";
        }
    }

    //specials
    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        if (ticketTitle == null || ticketTitle.isBlank()) {
            throw new IllegalArgumentException("Ticket title must be placed");
        } else {
            this.ticketTitle = ticketTitle;
        }
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        if (waitingTime <=0){
            throw new IllegalArgumentException("Waiting time must be greater than zero");
        } else{
            this.waitingTime = waitingTime;
            this.calculatePriority();
            this.calculateSla();
            this.calculateSlaStatus();
        }
    }

    public int getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(int resolutionTime) {
        if (resolutionTime <=0){
            throw new IllegalArgumentException("Resolution time must be greater than zero");
        } else{
            this.resolutionTime = resolutionTime;
            this.calculateSlaStatus();
        }
    }

    public boolean isSystemUnavailable() {
        return isSystemUnavailable;
    }

    public void setSystemUnavailable(boolean systemUnavailable) {
        isSystemUnavailable = systemUnavailable;
        this.calculatePriority();
        this.calculateSla();
        this.calculateSlaStatus();
    }

    public String getPriority() {
        return priority;
    }


    public int getSla() {
        return sla;
    }

    public String getSlaStatus() {
        return slaStatus;
    }

}
