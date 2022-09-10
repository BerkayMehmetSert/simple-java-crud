package com.bms.main;

import com.bms.dao.EmployeeDao;
import com.bms.dao.IEmployeeDao;
import com.bms.model.Employee;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        IEmployeeDao employeeDao = new EmployeeDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Employee Management System");
        
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Get Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("===== Add Employee =====");
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    
                    System.out.println("Enter address: ");
                    String address = scanner.next();
                    
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    
                    System.out.println("Enter phone: ");
                    String phone = scanner.next();
                    
                    Employee employee = new Employee(name, address, email, phone);
                    boolean isAdded = employeeDao.addEmployee(employee);
                    if (isAdded) {
                        System.out.println("Employee added successfully");
                    } else {
                        System.out.println("Failed to add employee");
                    }
                    break;
                
                case 2:
                    System.out.println("===== Update Employee =====");
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    
                    System.out.println("Enter name: ");
                    name = scanner.next();
                    
                    System.out.println("Enter address: ");
                    address = scanner.next();
                    
                    System.out.println("Enter email: ");
                    email = scanner.next();
                    
                    System.out.println("Enter phone: ");
                    phone = scanner.next();
                    
                    Employee employee1 = new Employee(name, address, email, phone);
                    boolean isUpdated = employeeDao.updateEmployee(id, employee1);
                    if (isUpdated) {
                        System.out.println("Employee updated successfully");
                    } else {
                        System.out.println("Failed to update employee");
                    }
                    break;
                
                case 3:
                    System.out.println("===== Delete Employee =====");
                    System.out.println("Enter id: ");
                    id = scanner.nextInt();
                    
                    boolean isDeleted = employeeDao.deleteEmployee(id);
                    if (isDeleted) {
                        System.out.println("Employee deleted successfully");
                    } else {
                        System.out.println("Failed to delete employee");
                    }
                    break;
                
                case 4:
                    System.out.println("===== Get Employee =====");
                    
                    boolean isGet = employeeDao.getEmployee();
                    if (isGet) {
                        System.out.println("Employee get successfully");
                    } else {
                        System.out.println("Failed to get employee");
                    }
                    break;
                
                case 5:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        
    }
}
