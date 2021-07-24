package co.com.rocas.crudemployee.service;

import co.com.rocas.crudemployee.dto.EmployeeDto;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    @Transactional
    EmployeeDto save(EmployeeDto employee);

    List<EmployeeDto> getAllEmployees();
}
