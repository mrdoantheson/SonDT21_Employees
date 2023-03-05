package fa.training.main;

import fa.training.dao.DBUtils;
import fa.training.dao.ItEmployeeDAO;
import fa.training.dao.ItEmployeeDAOImpl;
import fa.training.entities.Employee;
import fa.training.entities.ITEmployee;
import fa.training.entities.ProductEmployee;
import fa.training.management.EmployeesManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static List<Employee> listOfEmployee = new ArrayList<>();

    public static void main(String[] args) {

        read();
        Scanner scanner = new Scanner(System.in);
        EmployeesManagement employeesManagement = new EmployeesManagement(listOfEmployee);
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add a new IT employee");
            System.out.println("2. Add a new Product employee");
            System.out.println("3. Show the staff");
            System.out.println("4. Search by employee name");
            System.out.println("5. Sort employees by salary ascending");
            System.out.println("6. End program");
            System.out.println("Enter your choice (1-6):");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    ITEmployee itEmployee = new ITEmployee();
                    itEmployee.inputData(scanner);
                    employeesManagement.addEmployee(itEmployee);

                    ItEmployeeDAO itEmployeeDAO = new ItEmployeeDAOImpl();
                    boolean result = itEmployeeDAO.insert(itEmployee);
                    System.out.println("Insert success " + result);

                }
                case 2 -> {
                    ProductEmployee productEmployee = new ProductEmployee();
                    productEmployee.inputData(scanner);
                    employeesManagement.addEmployee(productEmployee);
                }
                case 3 -> employeesManagement.showAllEmployees();
                case 4 -> employeesManagement.searchByName();
                case 5 -> employeesManagement.sortBySalaryAscending();
                case 6 -> running = false;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
        write();
        read();
    }

    private static void write() {
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream("EmployeesData.txt"))) {
            objectOutputStream.writeObject(listOfEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void read() {
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream("EmployeesData.txt"))) {
            Object data = objectInputStream.readObject();
            listOfEmployee = (List<Employee>) data;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
