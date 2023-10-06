package com.teste.repository.jalapaoBD;

import com.teste.model.jalapaoBD.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositoryBD2 extends JpaRepository<Pessoa, Long> {
}