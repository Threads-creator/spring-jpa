package com.thiago.springjpa.service;

import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AvaliacaoFisicaForm;

import java.util.List;

public interface IAvaliacaoFisicaService extends IDefaultService<AvaliacaoFisica, AvaliacaoFisicaForm, Long> {
    List<AvaliacaoFisica> getAllMinAltura(Double minAltura);

    List<AvaliacaoFisica> getAllByPeso(Double minPeso, Double maxPeso);
}
