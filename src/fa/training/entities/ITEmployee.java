package fa.training.entities;

import java.util.Scanner;

public class ITEmployee extends Employee {

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
    }

    @Override
    public double calculateTax() {
        if (getSalary() > 11000000) {
            double tax = getSalary() * 0.1;
            setTax(tax);
        } else if (getSalary() > 15000000) {
            double tax = 400000;
            setTax(tax);
        }
        return getTax();
    }

    /**
     * Display data to console.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", Tax=" + getTax() +
                '}';
    }
}
