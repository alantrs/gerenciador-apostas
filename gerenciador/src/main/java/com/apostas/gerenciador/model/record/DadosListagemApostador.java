package com.apostas.gerenciador.model.record;

import com.apostas.gerenciador.model.Apostador;

public record DadosListagemApostador(Long id, String nome, String email, Integer idade) {

    public DadosListagemApostador(Apostador apostador){
        this(apostador.getId(),
                apostador.getNome(),
                apostador.getEmail(),
                apostador.getIdade());
    }
}
