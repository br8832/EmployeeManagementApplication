package com.synergisticit.capstoneproject.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import com.synergisticit.capstoneproject.model.Employee;

public class DBSupplierUtil {

    private DBSupplierUtil() {
    }


    public static Supplier<List<Employee>> employeeSupplier = () ->
            Arrays.asList(
                    Employee.builder().empId(6).firstName("Pedro").lastName("Sanchez").salary(2000.0f).build(),
                    Employee.builder().empId(7).firstName("Churumbe").lastName("Malagueño").salary(1500.0f).build(),
                    Employee.builder().empId(8).firstName("Alejandro").lastName("El Capitan").salary(5000.0f).build(),
                    Employee.builder().empId(9).firstName("Vago").lastName("Malgueño").salary(1000.0f).build(),
                    Employee.builder().empId(10).firstName("Andres").lastName("Alguacile").salary(2200.0f).build()
            );

}