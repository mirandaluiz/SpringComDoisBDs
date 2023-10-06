package com.teste.repository.defaultBD;

import com.teste.model.defaultBD.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositoryBD1 extends JpaRepository<Pessoa, Long> {
}