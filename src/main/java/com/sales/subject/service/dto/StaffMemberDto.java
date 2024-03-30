package com.sales.subject.service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffMemberDto {

    private String name;
    private String surname;
    private String department;

}
