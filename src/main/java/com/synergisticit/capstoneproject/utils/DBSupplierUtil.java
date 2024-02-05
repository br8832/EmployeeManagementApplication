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
                    Employee.builder().empId(1).firstName("Bryan").lastName("Harry").salary(3000.0f).build(),
                    Employee.builder().empId(2).firstName("Gauri").lastName("Kumari").salary(4000.0f).build(),
                    Employee.builder().empId(3).firstName("Adrik").lastName("Addy").salary(5000.0f).build(),
                    Employee.builder().empId(4).firstName("Arda").lastName("Aye").salary(6000.0f).build(),
                    Employee.builder().empId(5).firstName("Khan").lastName("Khan").salary(7000.0f).build()
            );

}