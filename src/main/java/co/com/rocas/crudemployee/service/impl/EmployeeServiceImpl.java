package co.com.rocas.crudemployee.service.impl;

import co.com.rocas.crudemployee.entity.Employee;
import co.com.rocas.crudemployee.repository.EmployeeRepository;
import co.com.rocas.crudemployee.service.EmployeeService;
import co.com.rocas.crudemployee.util.exceptions.ConflictException;
import co.com.rocas.crudemployee.util.exceptions.ResourceNotFoundException;
import co.com.rocas.crudemployee.util.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final String CLASSNAME = "The employee ";

    @Override
    public Employee save(Employee employee) {
        log.info("Inside save method in EmployeeServiceImpl");
        Employee employeeSaved = employeeRepository.save(employee);
        log.info(CLASSNAME + employee.getNumberId() + " was create");
        return employeeSaved;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Inside getAllEmployees method in EmployeeServiceImpl");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Inside getEmployeeById method in EmployeeServiceImpl, id employee " + id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("The Employee whit id " + id + " was not found");
                    return new ResourceNotFoundException("The Employee was not found");
                });
    }

    @Override
    public Employee updateEmployee(Employee employeeForSave) {
        log.info("Inside updateEmployee method in EmployeeServiceImpl, id employee " + employeeForSave.getId());
        Employee employeeFound = getEmployeeById(employeeForSave.getId());
        employeeForSave.setSalary(employeeForSave.getSalary().setScale(2, RoundingMode.HALF_EVEN));
        if (!employeeForSave.equals(employeeFound)) {
            log.info(CLASSNAME + employeeForSave.getNumberId() + " is updating");
            return employeeRepository.save(employeeForSave);
        }
        log.info(CLASSNAME + employeeForSave.getNumberId() + " did not be update, because it have de same information");
        return employeeForSave;
    }

    @Override
    public Employee inactivateEmployee(Long id) {

        log.info("Inside inactivateEmployee method in EmployeeServiceImpl, id employee " + id);
        Employee employeeFound = getEmployeeById(id);
        if (!Status.ACTIVE.getValue().equals(employeeFound.getStatus())) {
            throw new ConflictException(CLASSNAME + employeeFound.getNumberId() + " is inactive");
        }
        log.info(CLASSNAME + employeeFound.getNumberId() + " is inactive");
        employeeFound.setStatus(Status.RETIRED.getValue());
        return employeeRepository.save(employeeFound);
    }

    @Override
    public Employee getOldestEmployees() {
        List<Employee> employeeList = getAllEmployees();
        Map<Long, Integer> yearList = employeeList
                .stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        employee -> Period.between(employee.getStartDate(), LocalDate.now()).getYears()));
        Long oldestEmployeeId = 0l;
        if(!yearList.isEmpty()) {
            oldestEmployeeId = yearList
                    .entrySet()
                    .stream()
                    .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            return getEmployeeById(oldestEmployeeId);
        }
        return null;
    }
}
