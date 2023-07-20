package com.apostas.gerenciador.service;

import com.apostas.gerenciador.model.Apostador;
import com.apostas.gerenciador.model.record.DadosCadastroApostador;
import com.apostas.gerenciador.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApostadorService {

    @Autowired
    private ApostadorRepository apostadorRepository;
    public Apostador salvarApostador(DadosCadastroApostador dadosCadastroApostador){
        Apostador apostador = new Apostador(dadosCadastroApostador);
        apostadorRepository.save(apostador);
        return apostador;
    }
}
