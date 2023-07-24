package com.apostas.gerenciador.controller;

import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.service.ApostaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aposta")
public class ApostaController {

    @Autowired
    private ApostaService apostaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemAposta> realizarAposta(@RequestBody DadosCadastroAposta dadosCadastroAposta){
        var aposta = apostaService.realizarAposta(dadosCadastroAposta);
        return ResponseEntity.ok().body(aposta);
    }

}
