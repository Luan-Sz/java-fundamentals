package io.github.luansz.javafundamentals.oop;

public class Exercise06EmployeeInterface {
    public static void main(String[] args) {
        Supportable support = new Technician(
                "Valery Legasov",
                1988,
                "Nuclear physicist"
        );

        support.support();
    }
}
