package com.apostas.gerenciador.model.record;

import com.apostas.gerenciador.model.Aposta;

public record DadosListagemNumeroAposta(String numeroAposta) {

    public DadosListagemNumeroAposta(Aposta aposta){
        this(aposta.getNumeroAposta());
    }
}
