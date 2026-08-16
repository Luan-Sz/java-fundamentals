package io.github.luansz.javafundamentals.oop;

public class Employee {
    private String name;
    private int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void showRole(){
        System.out.println("Employee");
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
