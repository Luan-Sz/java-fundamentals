package io.github.luansz.javafundamentals.oop;

public class Exercise05EmployeeInheritance {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Vasily Ignatenko", 1986);
        Employee employee2 = new Technician("Valery Legasov", 1988, "nuclear physicist");

        employee1.showRole();
        employee2.showRole();
    }
}
