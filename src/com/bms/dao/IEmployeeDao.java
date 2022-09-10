package com.bms.dao;

import com.bms.model.Employee;

public interface IEmployeeDao {
    public boolean addEmployee(Employee employee);
    
    public boolean updateEmployee(int id, Employee employee);
    
    public boolean deleteEmployee(int id);
    
    public boolean getEmployee();
}
