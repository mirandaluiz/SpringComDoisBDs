package com.teste.model.jalapaoBD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Pessoa {

    @Id
    private Long id;

    private String nome;
}
