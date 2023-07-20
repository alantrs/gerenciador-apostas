package com.apostas.gerenciador.controller;

import com.apostas.gerenciador.model.Apostador;
import com.apostas.gerenciador.model.record.DadosCadastroApostador;
import com.apostas.gerenciador.service.ApostadorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apostador")
public class ApostadorController {

    @Autowired
    private ApostadorService apostadorService;

    @PostMapping
    @Transactional
    public ResponseEntity<Apostador> salvarApostador(@RequestBody DadosCadastroApostador dadosCadastroApostador){
        Apostador apostador = apostadorService.salvarApostador(dadosCadastroApostador);
        return ResponseEntity.status(HttpStatus.CREATED).body(apostador);
    }
}
