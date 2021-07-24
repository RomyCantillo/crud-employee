package co.com.rocas.crudemployee.mapper;

import co.com.rocas.crudemployee.dto.EmployeeDto;
import co.com.rocas.crudemployee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee dtoToEmployee (EmployeeDto employeeDto);
    EmployeeDto employeeToDto (Employee employee);
    List<EmployeeDto> employeeToDtoList(List<Employee> employees);

}
