package io.github.luansz.javafundamentals.oop;

public class Requester {
    //var
    private String name;
    private String email;
    private int employeeId;

    //constructor
    public Requester(String name, String email, int employeeId) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must be placed");
        } else {
            this.name = name;
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must be placed");
        } else {
            this.email = email;
        }
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be greater than zero");
        } else {
            this.employeeId = employeeId;
        }
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
