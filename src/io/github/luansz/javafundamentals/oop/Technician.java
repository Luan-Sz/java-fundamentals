package io.github.luansz.javafundamentals.oop;

public class Technician extends Employee {
    private String specialty;

    public Technician(String name, int employeeId, String specialty) {
        super(name, employeeId);
        this.specialty = specialty;
    }

    @Override
    public void showRole() {
        System.out.println("Technician");
    }

    public String getSpecialty() {
        return specialty;
    }
}
