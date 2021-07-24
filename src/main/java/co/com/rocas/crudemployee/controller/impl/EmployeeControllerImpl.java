package co.com.rocas.crudemployee.controller.impl;

import co.com.rocas.crudemployee.controller.EmployeeController;
import co.com.rocas.crudemployee.dto.EmployeeDto;
import co.com.rocas.crudemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    @Override
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        log.info("Inside save method in EmployeeControllerImpl");
        EmployeeDto newEmployee=employeeService.save(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        log.info("Inside getAllEmployees method in EmployeeControllerImpl");
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
