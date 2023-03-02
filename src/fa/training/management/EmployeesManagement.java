package fa.training.management;

import fa.training.entities.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeesManagement  {
    public List<Employee> listOfEmployee;

    public EmployeesManagement(List<Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    //Add a new employee
    public void addEmployee(Employee employee) {
        listOfEmployee.add(employee);
    }

    //Show all employees
    public void showAllEmployees() {
        if (listOfEmployee.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : listOfEmployee) {
                System.out.println(employee);
            }
        }
    }

    //Search by employee name
    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name to search: ");
        String name = scanner.nextLine();
        if (listOfEmployee.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : listOfEmployee) {
                if (employee.getName().equals(name)) {
                    System.out.println(employee);
                }
            }
        }
    }

    //Sort employees by salary ascending
    public List<Employee> sortBySalaryAscending() {
        listOfEmployee.sort(Comparator.comparing(Employee::getSalary));
        return listOfEmployee;
    }
}
