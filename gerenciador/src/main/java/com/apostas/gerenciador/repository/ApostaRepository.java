package com.apostas.gerenciador.repository;

import com.apostas.gerenciador.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, String> {
    List<Aposta> findAllByApostadorId(Long idApostador);
}
