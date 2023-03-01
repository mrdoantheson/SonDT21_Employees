package fa.training.entities;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author SonDT21
 * version 1.0
 */

public abstract class Employee implements Serializable {
    private String code;
    private String name;
    private int age;
    private double salary;
    private double Tax;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTax() {
        return Tax;
    }

    public void setTax(double tax) {
        this.Tax = tax;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    protected void inputData(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Enter employee code:");
        String code = scanner.nextLine();
        setCode(code);

        System.out.println("Enter employee name:");
        String name = scanner.nextLine();
        setName(name);

        System.out.println("Enter employee age:");
        int age = scanner.nextInt();
        setAge(age);

        System.out.println("Enter employee salary:");
        double salary = scanner.nextDouble();
        setSalary(salary);
    }

    abstract double calculateTax();
}
