package com.apostas.gerenciador.service;

import com.apostas.gerenciador.model.Apostador;
import com.apostas.gerenciador.model.record.DadosCadastroApostador;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.model.record.DadosListagemApostador;
import com.apostas.gerenciador.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostadorService {

    @Autowired
    private ApostadorRepository apostadorRepository;
    public DadosListagemApostador salvarApostador(DadosCadastroApostador dadosCadastroApostador){
        Apostador apostador = new Apostador(dadosCadastroApostador);
        apostadorRepository.save(apostador);
        return new DadosListagemApostador(apostador);
    }

    public List<DadosListagemApostador> listarApostadores(){
        List<Apostador> apostadores = apostadorRepository.findAll();
        return apostadores.stream().map(apostador -> (new DadosListagemApostador(apostador))).toList();
    }


}
