package com.apostas.gerenciador.model;

import com.apostas.gerenciador.model.record.DadosCadastroApostador;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Apostador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer idade;

    public Apostador(DadosCadastroApostador dadosCadastroApostador){
        this.nome = dadosCadastroApostador.nome();
        this.email = dadosCadastroApostador.email();
        this.idade = dadosCadastroApostador.idade();
    }
}
