package com.apostas.gerenciador.controller;

import com.apostas.gerenciador.model.record.DadosCadastroApostador;
import com.apostas.gerenciador.model.record.DadosListagemApostador;
import com.apostas.gerenciador.service.ApostadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostador")
@Tag(name = "Apostador")
public class ApostadorController {

    @Autowired
    private ApostadorService apostadorService;

    @Operation(summary = "Salva apostador")
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemApostador> salvarApostador(@RequestBody DadosCadastroApostador dadosCadastroApostador){
        DadosListagemApostador apostador = apostadorService.salvarApostador(dadosCadastroApostador);
        return ResponseEntity.status(HttpStatus.CREATED).body(apostador);
    }

    @Operation(summary = "Lista apostadores")
    @GetMapping
    public ResponseEntity<List<DadosListagemApostador>> listarApostadores(){
        List<DadosListagemApostador> apostadores = apostadorService.listarApostadores();
        return ResponseEntity.ok().body(apostadores);
    }
}
