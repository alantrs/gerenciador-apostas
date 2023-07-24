package com.apostas.gerenciador.model.record;

import com.apostas.gerenciador.model.Aposta;
import com.apostas.gerenciador.model.Apostador;

public record DadosListagemAposta(String numeroAposta, String nomeApostador, String emailApostador) {

    public DadosListagemAposta(Aposta aposta, Apostador apostador){
        this(aposta.getNumeroAposta(),
                apostador.getNome(),
                apostador.getEmail());
    }
}
