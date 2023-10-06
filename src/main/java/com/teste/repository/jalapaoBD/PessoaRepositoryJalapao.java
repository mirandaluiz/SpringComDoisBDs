package com.teste.repository.jalapaoBD;

import com.teste.dto.PessoaDTO;
import com.teste.model.jalapaoBD.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepositoryJalapao extends JpaRepository<Pessoa, Long> {

    @Query(" SELECT NEW com.teste.dto.PessoaDTO(p.id, p.nome) FROM Pessoa p")
    List<PessoaDTO> findAllJalapao();
}