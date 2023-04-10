package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AlunoForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm form);

    List<Aluno> getAll(String dataNascimento);

    Aluno get(Long id);

    Aluno update(Long id, AlunoForm form);

    boolean delete(Long id);

    List<AvaliacaoFisica> getAvaliacoesFisicaByAlunoId(Long id);

}
