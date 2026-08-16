package io.github.luansz.javafundamentals.oop;

public class Ticket {
    private String ticketTitle;
    private Requester requester;
    private int waitingTime;
    private Resolution resolution;
    private boolean isSystemUnavailable;
    private Priority priority;
    private SlaStatus slaStatus;

    //constructor
    public Ticket(Requester requester, String ticketTitle, int waitingTime, boolean isSystemUnavailable) {
        if (requester == null) {
            throw new IllegalArgumentException("Requester must be placed");
        } else {
            this.requester = requester;
        }
        this.setTicketTitle(ticketTitle);
        this.setWaitingTime(waitingTime);
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
        System.out.println("System Unavailable: " + isSystemUnavailable);
        System.out.println("Priority: " + priority);
        System.out.println("SLA: " + priority.getSlaMinutes());
        if (resolution == null) {
            System.out.println("Resolution Status: NOT RESOLVED");
        } else {
            System.out.println("Resolution time: " + resolution.getResolutionTime());
            System.out.println("Resolved by: " + resolution.getResolvedBy());
            System.out.println("SLA Status: " + slaStatus);
        }
    }

    private void calculatePriority() {
        if (isSystemUnavailable && waitingTime >= 20) {
            this.priority = Priority.CRITICAL;
        } else if (isSystemUnavailable || waitingTime >= 30) {
            this.priority = Priority.HIGH;
        } else if (waitingTime >= 10) {
            this.priority = Priority.MEDIUM;
        } else {
            this.priority = Priority.LOW;
        }
    }


    private void calculateSlaStatus() {
        if (resolution.getResolutionTime() <= this.priority.getSlaMinutes()) {
            this.slaStatus = SlaStatus.WITHIN_SLA;
        } else {
            this.slaStatus = SlaStatus.SLA_BREACHED;
        }
    }

    public void resolve(int resolutionTime, String resolvedBy) {
        resolution = new Resolution(resolutionTime, resolvedBy);
        this.calculateSlaStatus();
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
        if (waitingTime <= 0) {
            throw new IllegalArgumentException("Waiting time must be greater than zero");
        } else {
            this.waitingTime = waitingTime;
            this.calculatePriority();
            if (resolution != null){
                this.calculateSlaStatus();
            }
        }
    }

    public boolean isSystemUnavailable() {
        return isSystemUnavailable;
    }

    public void setSystemUnavailable(boolean systemUnavailable) {
        isSystemUnavailable = systemUnavailable;
        this.calculatePriority();
        if (resolution != null){
            this.calculateSlaStatus();
        }
    }

    public Priority getPriority() {
        return priority;
    }

    public SlaStatus getSlaStatus() {
        return slaStatus;
    }

}
