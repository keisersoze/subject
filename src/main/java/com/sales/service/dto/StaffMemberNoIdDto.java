package com.sales.service.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StaffMemberNoIdDto {

    private String name;
    private String surname;
    private String department;
    private LocalDate birthdate;

}
