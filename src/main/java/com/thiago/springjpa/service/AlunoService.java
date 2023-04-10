package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AlunoForm;
import com.thiago.springjpa.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> getAll(String dataNascimento) {
        if(dataNascimento == null){
            return alunoRepository.findAll();
        }
        return alunoRepository.findByDataNascimento(LocalDate.parse(dataNascimento));

    }

    @Override
    public Aluno get(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(form.getNome());
        novoAluno.setCpf(form.getCpf());
        novoAluno.setBairro(form.getBairro());
        // transformando nascimento para String e colocando isso abaixo funciona
        //novoAluno.setDataNascimento(LocalDate.parse(form.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        novoAluno.setDataNascimento(form.getDataNascimento());

        return alunoRepository.save(novoAluno);

    }

    @Override
    public Aluno update(Long id, AlunoForm form) {
        Aluno alunoAtualizado = alunoRepository.findById(id).get();

        if(alunoAtualizado == null){
            return null;
        }

        alunoAtualizado.setNome(form.getNome());
        alunoAtualizado.setBairro(form.getBairro());
        alunoAtualizado.setDataNascimento(form.getDataNascimento());

        System.out.println(alunoAtualizado);

        return alunoRepository.save(alunoAtualizado);


    }

    @Override
    public boolean delete(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        if(aluno == null){
            return false;
        }

        alunoRepository.delete(aluno);
        return true;

    }

    @Override
    public List<AvaliacaoFisica> getAvaliacoesFisicaByAlunoId(Long id) {

        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }


}
