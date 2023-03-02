package fa.training.entities;

import java.util.Scanner;

public class ProductEmployee extends Employee {


    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
    }

    @Override
    public double calculateTax() {
        return 0;
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
                ", calculateTax=" + getTax() +
                '}';
    }
}
