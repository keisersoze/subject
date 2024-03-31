package com.sales.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.util.UUID;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public abstract class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
