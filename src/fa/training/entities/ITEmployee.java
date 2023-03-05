package fa.training.entities;

import java.util.Scanner;

public class ITEmployee extends Employee {
    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
    }

    @Override
    public double calculateTax() {
        double tax = 0;
        if (getSalary() > 11000000) {
            tax = getSalary() * 0.1;
        } else if (getSalary() > 15000000) {
            tax = 400000;
        }
        setTax(tax);
        return getTax();
    }

    /**
     * Display data to console.
     */
    @Override
    public String toString() {
        String salary = String.format("%.2f", getSalary());
        String calculateTax = String.format("%.2f", calculateTax());
        return "Employee{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + salary +
                ", Tax=" + calculateTax +
                '}';
    }
}
