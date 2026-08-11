package io.github.luansz.javafundamentals.oop;

public class Exercise04TicketPriorityEnum {
    public static void main(String[] args) {
        Requester requester1 = new Requester("Ana Souza", "ana@company.com", 4582);
        Ticket ticket1 = new Ticket(requester1, "Login unavailable", 25, true);

        ticket1.showSummary();

        System.out.println();

        ticket1.resolve(10, "Marcos");
        ticket1.setWaitingTime(5);
        ticket1.setSystemUnavailable(false);
        ticket1.showSummary();

        System.out.println();

        Requester requester2 = new Requester("Carlos Lima", "carlos@company.com", 7310);
        Ticket ticket2 = new Ticket(requester2, "Slow application", 35, false);

        ticket2.showSummary();

        System.out.println();

        ticket2.resolve(40, "Julia");
        ticket2.showSummary();
    }
}
