package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AvaliacaoFisicaForm;
import com.thiago.springjpa.repository.AlunoRepository;
import com.thiago.springjpa.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.getReferenceById(form.getAlunoId());

        AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();
        novaAvaliacao.setAluno(aluno);
        novaAvaliacao.setAltura(form.getAltura());
        novaAvaliacao.setPeso(form.getPeso());
        return avaliacaoFisicaRepository.save(novaAvaliacao);
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica;

        try {
            avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
        }catch (NoSuchElementException e){
            System.out.println("Id nao encontrado || " + e.getMessage());
            return null;

        }

        avaliacaoFisica.setDataAvaliacao(form.getDataAvaliacao());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public boolean delete(Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();

        if(avaliacaoFisica == null) return false;

        avaliacaoFisicaRepository.delete(avaliacaoFisica);
        return true;
    }

    @Override
    public List<AvaliacaoFisica> getAllMinAltura(Double minAltura) {
        return avaliacaoFisicaRepository.findByAlturaGreaterThanEqual(minAltura);
    }

    @Override
    public List<AvaliacaoFisica> getAllByPeso(Double minPeso, Double maxPeso) {
        if(minPeso < 0) minPeso = 0.0;
        if(maxPeso <= 0) maxPeso = Double.POSITIVE_INFINITY;

        return avaliacaoFisicaRepository.findAllByPeso(minPeso, maxPeso);
    }
}
