package com.synergisticit.capstoneproject.repository;

import java.util.List;

import com.synergisticit.capstoneproject.model.Employee;

public interface EmployeeQueryDao {

    List<Employee> getAll();

    List<Employee> getEmployeeByFirstName(String firstName);

    Employee getSingleEmployeeByFirstName(String firstName);

    List<Employee> getEmployeeByFirstNameLike(String firstName);

    Employee getSingleEmployeeByLastName(String lastName);

    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

}
