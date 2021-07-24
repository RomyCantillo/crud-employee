package co.com.rocas.crudemployee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String numberId;
    private LocalDate birthDate;

    public EmployeeDto(String name, String numberId, LocalDate birthDate) {
        this.name = name;
        this.numberId = numberId;
        this.birthDate = birthDate;
    }
}
