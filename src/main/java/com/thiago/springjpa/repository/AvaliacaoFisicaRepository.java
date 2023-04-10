package com.thiago.springjpa.repository;

import com.thiago.springjpa.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findByAlturaGreaterThanEqual(Double altura);

    @Query(value = "SELECT * " +
            " FROM tb_avaliacoes av " +
            " WHERE av.peso_atual >= :minPeso AND av.peso_atual <= :maxPeso", nativeQuery = true)
    List<AvaliacaoFisica> findAllByPeso(Double minPeso, Double maxPeso);

}
