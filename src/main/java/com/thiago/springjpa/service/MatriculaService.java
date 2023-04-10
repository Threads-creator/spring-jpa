package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.Matricula;
import com.thiago.springjpa.entity.form.MatriculaForm;
import com.thiago.springjpa.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;

    @Override
    public Matricula save(MatriculaForm matriculaForm) {
        Aluno aluno = alunoService.get(matriculaForm.getAlunoId());

        Matricula novaMatricula = new Matricula();
        novaMatricula.setAluno(aluno);

        return matriculaRepository.save(novaMatricula);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if(bairro == null){
            return matriculaRepository.findAll();
        }

        return matriculaRepository.findByAlunoBairro(bairro);
    }
}
