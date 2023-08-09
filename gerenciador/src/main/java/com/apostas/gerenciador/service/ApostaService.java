package com.apostas.gerenciador.service;

import com.apostas.gerenciador.exception.ApostadorNaoEncontrado;
import com.apostas.gerenciador.model.Aposta;
import com.apostas.gerenciador.model.Apostador;
import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.model.record.DadosListagemNumeroAposta;
import com.apostas.gerenciador.repository.ApostaRepository;
import com.apostas.gerenciador.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApostaService {

    @Autowired
    private ApostadorRepository apostadorRepository;
    @Autowired
    private ApostaRepository apostaRepository;

    public DadosListagemAposta realizarAposta(DadosCadastroAposta dadosCadastroAposta){
        Optional<Apostador> apostadorEncontrado = apostadorRepository.findById(dadosCadastroAposta.idApostador());
        String numeroAposta = UUID.randomUUID().toString();

        if (apostadorEncontrado.isEmpty()) {
            throw new ApostadorNaoEncontrado();
        }

        Aposta aposta = new Aposta(dadosCadastroAposta, numeroAposta);
        apostaRepository.save(aposta);

        return new DadosListagemAposta(aposta, apostadorEncontrado.get());
    }

    public List<DadosListagemAposta> listarApostas() {
        List<Aposta> apostas = apostaRepository.findAll();
        return apostas.stream().map(aposta -> (new DadosListagemAposta(aposta, aposta.getApostador()))).toList();
    }

    public List<DadosListagemNumeroAposta> listarApostasDeUmApostador(Long idApostador){
        Optional<Apostador> apostadorEncontrado = apostadorRepository.findById(idApostador);
        if(apostadorEncontrado.isEmpty()){
            throw  new ApostadorNaoEncontrado();
        }

        List<Aposta> apostasApostador = apostaRepository.findAllByApostadorId(idApostador);
        return apostasApostador.stream().map(apostaApostador -> (new DadosListagemNumeroAposta(apostaApostador))).toList();
    }
}
