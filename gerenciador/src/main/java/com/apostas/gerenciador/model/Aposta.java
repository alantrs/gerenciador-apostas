package com.apostas.gerenciador.model;

import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Aposta {

    @Id
    private String numeroAposta;

    @ManyToOne
    @JoinColumn(name = "id")
    private Apostador apostador;

    public  Aposta(){

    }

    public Aposta(DadosCadastroAposta dadosCadastroAposta, String numeroAposta){
        this.numeroAposta = numeroAposta;
        this.apostador = new Apostador();
        this.apostador.setId(dadosCadastroAposta.idApostador());
    }
}
