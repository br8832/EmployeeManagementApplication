package com.synergisticit.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.capstoneproject.model.Employee;
import com.synergisticit.capstoneproject.services.EmployeeService;

@RestController
public class EmployeeModelController {
	@Autowired 
	EmployeeService employeeService;
	
	@GetMapping("/test")
	public String test() {
		return "String";
	}
	@RequestMapping("/employeeForm")
	public ModelAndView employee() {
		return form("");
	}
	private ModelAndView form(String page) {
		return new ModelAndView("employeeForm"+page);
	}
	@RequestMapping("/getAll")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	@RequestMapping("/save")
	public ModelAndView saveEmp(@RequestParam String AddId, @RequestParam String AddSalary, @RequestParam String AddFirstName, @RequestParam String AddLastName) {
		if(AddId!="")
		employeeService.save(Employee.builder().empId(Integer.parseInt(AddId)).salary(Integer.parseInt(AddSalary))
				.firstName(AddFirstName).lastName(AddLastName).build());
		return form("");
	}
	
	
	@RequestMapping("/get")
	public ModelAndView getTheEmployee(@RequestParam String GetId) {
		Employee e = employeeService.getEmployeeById(Integer.parseInt(GetId));
		//System.out.println(e);
		ModelAndView  mav = form("").addObject("e", e);
		//System.out.println(mav);
		return mav;
		

	}
	
	@RequestMapping("/update")
	public ModelAndView updatesEmployee(@RequestParam String Id, @RequestParam String Salary, @RequestParam String FirstName, @RequestParam String LastName) {
		if(Id!="")
		System.out.println(employeeService.update(Employee.builder().empId(Integer.parseInt(Id)).
				salary(Float.parseFloat(Salary)).firstName(FirstName).lastName(LastName).build()));
		return form("");
	}
	
	
	@RequestMapping("delete")
	public ModelAndView deletesTheEmployee(@RequestParam String DelId) {
		employeeService.deleteById(Integer.parseInt(DelId));
		return form("");
	}
}
