package com.apostas.gerenciador.controller;

import com.apostas.gerenciador.model.Aposta;
import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.service.ApostaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aposta")
public class ApostaController {

    @Autowired
    private ApostaService apostaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemAposta> realizarAposta(@RequestBody DadosCadastroAposta dadosCadastroAposta){
        DadosListagemAposta aposta = apostaService.realizarAposta(dadosCadastroAposta);
        return ResponseEntity.ok().body(aposta);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemAposta>> listarApostas(){
        List<DadosListagemAposta> apostas = apostaService.listarApostas();
        return ResponseEntity.ok().body(apostas);
    }

}
