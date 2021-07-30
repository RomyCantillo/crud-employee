package co.com.rocas.crudemployee.controller;

import co.com.rocas.crudemployee.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeController {

    ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto);

    ResponseEntity<List<EmployeeDto>> getAllEmployees();

    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id);

    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> getOldestEmployees();

    ResponseEntity<EmployeeDto> inactivateEmployee(@PathVariable Long id);
}
