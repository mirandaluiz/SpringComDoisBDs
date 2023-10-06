package com.teste.service;

import com.teste.dto.PessoaDTO;
import com.teste.repository.defaultBD.PessoaRepositoryDefault;
import com.teste.repository.jalapaoBD.PessoaRepositoryJalapao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepositoryDefault pessoaRepositoryDefault;
    private PessoaRepositoryJalapao pessoaRepositoryJalapao;

    // Se chegar 1, lista as pessoas do banco default
    public List<PessoaDTO> listar(int id) {
        return id == 1 ? pessoaRepositoryDefault.findAllDefault() : pessoaRepositoryJalapao.findAllJalapao();
    }
}