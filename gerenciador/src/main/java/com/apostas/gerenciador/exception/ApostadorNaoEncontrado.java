package com.apostas.gerenciador.exception;

public class ApostadorNaoEncontrado extends RuntimeException{
    private String mensagem = "Apostador não existe";

    public String getMensagem(){
        return mensagem;
    }
}

