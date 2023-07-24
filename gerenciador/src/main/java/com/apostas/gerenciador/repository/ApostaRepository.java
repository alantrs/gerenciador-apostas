package com.apostas.gerenciador.repository;

import com.apostas.gerenciador.model.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, String> {
}
