package com.sales.subject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Entity
@Table(name = "customer")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Subject {

    @Column
    private LocalDateTime birthdate;

}
