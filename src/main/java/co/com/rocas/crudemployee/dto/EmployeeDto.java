package co.com.rocas.crudemployee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String numberId;
    private LocalDate birthDate;
    private Character status;
    private BigDecimal salary;
    private LocalDate startDate;

}
