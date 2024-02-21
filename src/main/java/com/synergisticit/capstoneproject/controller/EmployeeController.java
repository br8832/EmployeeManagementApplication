package com.synergisticit.capstoneproject.controller;


import java.util.List;

import com.synergisticit.capstoneproject.model.Employee;
import com.synergisticit.capstoneproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee-Management")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public Employee get(@RequestParam int id) {
    	return employeeService.getEmployeeById(id);
    }
    @GetMapping("/delete")
    public Employee delete(@RequestParam int id) {
    	Employee e = employeeService.getEmployeeById(id);
    	try {
			employeeService.deleteById(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return e;
    }
    @GetMapping("/save")
    public Employee save(@RequestParam int id, @RequestParam String firstname,@RequestParam String lastname, @RequestParam float salary) {
    	try {
			employeeService.save(Employee.builder().empId(id).firstName(firstname).lastName(lastname).salary(salary).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return employeeService.getEmployeeById(id);
    }
    @GetMapping("/update")
    public Employee update(@RequestParam int id, @RequestParam String firstname,@RequestParam String lastname, @RequestParam float salary) {
    	try {
			return employeeService.update(Employee.builder().empId(id).firstName(firstname).lastName(lastname).salary(salary).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    @GetMapping("/say")
    public String sayHello() {
        return "Hello Employee Management Application - Capstone Project";
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable int empId ) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> getEmployeeByName(@PathVariable String firstName ) {
        return employeeService.getEmployeeByFirstName(firstName);
    }

    // get employee by first name (equals())
    @GetMapping("/one-by-firstName/{firstName}")
    public Employee getOneEmployeeByFirstName(@PathVariable String firstName) {
        return employeeService.getOneEmployeeByFirstName(firstName);
    }

    // get employee by first name %LIKE%
    @GetMapping("/firstName-like/{firstName}")
    public List<Employee> getEmployeeByFirstNameLike(@PathVariable String firstName) {
        return employeeService.getEmployeeByFirstNameLike(firstName);
    }

    @GetMapping("/one-by-lastName/{lastName}")
    public Employee getEmployeeBylName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastName(lastName);
    }


    @GetMapping("/salary-greater-than/{salary}")
    public List<Employee> getEmployeeBySalaryGreaterThan(@PathVariable int salary) {
        return employeeService.getEmployeeBySalaryGreaterThan(salary);
    }

    @PostMapping("/get-by-condition")
    public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
        return employeeService.getEmployeeByCondition(employee);
    }
}




