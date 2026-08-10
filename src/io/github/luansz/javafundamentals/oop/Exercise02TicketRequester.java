package io.github.luansz.javafundamentals.oop;

public class Exercise02TicketRequester {
    public static void main(String[] args) {

        Requester requester1 = new Requester("Ana Souza", "ana@company.com", 456);
        Ticket ticket1 = new Ticket(requester1, "Login unavailable", 25, 10, true);

        ticket1.showSummary();


        Requester requester2 = new Requester("Carlos Lima", "carlos@company.com", 7310);
        Ticket ticket2 = new Ticket(requester2, "Slow application", 35, 40, false);
        ticket2.showSummary();


        Ticket ticket3 = new Ticket(requester1, "Application bug", 40, 25, true);
        ticket3.showSummary();
    }
}
