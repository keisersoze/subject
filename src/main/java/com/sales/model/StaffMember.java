package com.sales.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "staff")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class StaffMember extends HumanSubject {

    @Column
    private String department;

}
