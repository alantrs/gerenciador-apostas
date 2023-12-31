package com.apostas.gerenciador.repository;

import com.apostas.gerenciador.model.Apostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
}
