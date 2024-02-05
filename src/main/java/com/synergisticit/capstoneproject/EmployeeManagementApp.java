package com.synergisticit.capstoneproject;

import com.synergisticit.capstoneproject.model.Employee;
import com.synergisticit.capstoneproject.repository.EmployeeRepository;
import com.synergisticit.capstoneproject.utils.DBSupplierUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
public class EmployeeManagementApp implements CommandLineRunner{

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApp.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Employee> employees = employeeRepository.findAll();
			if (employees.isEmpty()) {
				LOGGER.info("******* Inserting Employees to DB *******");
				employeeRepository.saveAll(DBSupplierUtil.employeeSupplier.get());
			} else {
				LOGGER.info("******* Employees stored in DB Size :: {}", employees.size());
				LOGGER.info("******* Employees stored in DB :: {}", employees);
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

