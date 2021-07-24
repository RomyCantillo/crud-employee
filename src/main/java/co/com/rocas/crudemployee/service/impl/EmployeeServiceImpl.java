package co.com.rocas.crudemployee.service.impl;

import co.com.rocas.crudemployee.dto.EmployeeDto;
import co.com.rocas.crudemployee.entity.Employee;
import co.com.rocas.crudemployee.mapper.EmployeeMapper;
import co.com.rocas.crudemployee.repository.EmployeeRepository;
import co.com.rocas.crudemployee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        log.info("Inside save method in EmployeeServiceImpl");
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        return EmployeeMapper.INSTANCE.employeeToDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return EmployeeMapper.INSTANCE.employeeToDtoList(employeeRepository.findAll());
    }
}
