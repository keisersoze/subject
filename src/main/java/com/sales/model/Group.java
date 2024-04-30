package com.sales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "group_subject")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class Group extends Subject {

    @Column
    private String code;

}
