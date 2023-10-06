package com.teste.repository.defaultBD;

import com.teste.dto.PessoaDTO;
import com.teste.model.defaultBD.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepositoryDefault extends JpaRepository<Pessoa, Long> {

    @Query(" SELECT NEW com.teste.dto.PessoaDTO(p.id, p.nome) FROM Pessoa p ")
    List<PessoaDTO> findAllDefault();
}