package com.synergisticit.capstoneproject.model;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {


	@Id
    private String id;

    private int empId;
    private String firstName;
    private String lastName;
    private float salary;
}
