package com.synergisticit.capstoneproject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.synergisticit.capstoneproject.model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);


}