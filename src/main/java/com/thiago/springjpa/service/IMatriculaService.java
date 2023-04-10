package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.Matricula;
import com.thiago.springjpa.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService  {

    Matricula save(MatriculaForm matriculaForm);

    List<Matricula> getAll(String bairro);
}
