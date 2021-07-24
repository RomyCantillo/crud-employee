package co.com.rocas.crudemployee.controller;

import co.com.rocas.crudemployee.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeController {
    ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto);
    ResponseEntity<List<EmployeeDto>> getAllEmployees();
}
