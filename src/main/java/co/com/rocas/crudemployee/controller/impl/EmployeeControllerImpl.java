package co.com.rocas.crudemployee.controller.impl;

import co.com.rocas.crudemployee.controller.EmployeeController;
import co.com.rocas.crudemployee.dto.EmployeeDto;
import co.com.rocas.crudemployee.mapper.EmployeeMapper;
import co.com.rocas.crudemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        EmployeeDto newEmployee =
                EmployeeMapper.INSTANCE.employeeToDto(employeeService.save(
                        EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto)));
        log.info("Finish of save method in EmployeeControllerImpl");
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        log.info("Inside getAllEmployees method in EmployeeControllerImpl");
        return new ResponseEntity<>(
                EmployeeMapper.INSTANCE.employeeToDtoList(employeeService.getAllEmployees()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        log.info("Inside getEmployeeById method in EmployeeControllerImpl");
        return new ResponseEntity<>(
                EmployeeMapper.INSTANCE.employeeToDto(employeeService.getEmployeeById(id)), HttpStatus.OK);
    }

    @PutMapping("/")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(EmployeeDto employeeDto) {
        log.info("Inside updateEmployee method in EmployeeControllerImpl");
        return new ResponseEntity<>(
                EmployeeMapper.INSTANCE.employeeToDto(employeeService.updateEmployee(
                        EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto))), HttpStatus.OK);
    }

    @GetMapping("/oldest-employee")
    @Override
    public ResponseEntity<EmployeeDto> getOldestEmployees() {
        log.info("Inside getOldestEmployees method in EmployeeControllerImpl");
        return new ResponseEntity<>(
                EmployeeMapper.INSTANCE.employeeToDto(employeeService.getOldestEmployees()), HttpStatus.OK);
    }

    @PutMapping("/inactivate/{id}")
    @Override
    public ResponseEntity<EmployeeDto> inactivateEmployee(@PathVariable Long id) {
        log.info("Inside inactivateEmployee method in EmployeeControllerImpl");
        return new ResponseEntity<>(
                EmployeeMapper.INSTANCE.employeeToDto(employeeService.inactivateEmployee(id)), HttpStatus.OK);
    }


}
