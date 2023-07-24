package com.apostas.gerenciador.service;

import com.apostas.gerenciador.model.Aposta;
import com.apostas.gerenciador.model.Apostador;
import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApostaService {

    @Autowired
    private ApostadorRepository apostadorRepository;

    public DadosListagemAposta realizarAposta(DadosCadastroAposta dadosCadastroAposta){
        Optional<Apostador> apostadorEncontrado = apostadorRepository.findById(dadosCadastroAposta.idApostador());
        String numeroAposta = UUID.randomUUID().toString();

        Aposta aposta = new Aposta(dadosCadastroAposta, numeroAposta);

        return new DadosListagemAposta(aposta, apostadorEncontrado.get());
    }
}
