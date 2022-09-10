package com.bms.dao;


import com.bms.connection.DBConnection;
import com.bms.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao implements IEmployeeDao {
    
    @Override
    public boolean addEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO employee (name, address, email, phone) VALUES (?, ?, ?, ?)";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean updateEmployee(int id, Employee employee) {
        try {
            String sql = "UPDATE employee SET name = ?, address = ?, email = ?, phone = ? WHERE id = ?";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean deleteEmployee(int id) {
        try {
            String sql = "DELETE FROM employee WHERE id = ?";
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean getEmployee() {
        try {
            String sql = "SELECT * FROM employee";
            
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("==================================");
            }
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
