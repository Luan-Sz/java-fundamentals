package io.github.luansz.javafundamentals.oop;

public class Technician extends Employee implements Supportable{
    private String specialty;

    public Technician(String name, int employeeId, String specialty) {
        super(name, employeeId);
        this.specialty = specialty;
    }

    @Override
    public void showRole() {
        System.out.println("Technician");
    }

    @Override
    public void support() {
        System.out.println("Providing technical support");
    }

    public String getSpecialty() {
        return specialty;
    }
}
