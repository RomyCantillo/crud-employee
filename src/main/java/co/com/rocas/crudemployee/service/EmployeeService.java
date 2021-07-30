package co.com.rocas.crudemployee.service;

import co.com.rocas.crudemployee.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    @Transactional
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    Employee inactivateEmployee(Long id);

    Employee getOldestEmployees();
}
