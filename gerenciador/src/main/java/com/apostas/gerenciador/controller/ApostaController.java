package com.apostas.gerenciador.controller;

import com.apostas.gerenciador.model.Aposta;
import com.apostas.gerenciador.model.record.DadosCadastroAposta;
import com.apostas.gerenciador.model.record.DadosListagemAposta;
import com.apostas.gerenciador.model.record.DadosListagemNumeroAposta;
import com.apostas.gerenciador.service.ApostaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aposta")
@Tag(name = "Aposta")
public class ApostaController {

    @Autowired
    private ApostaService apostaService;

    @Operation(summary = "Realiza aposta")
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemAposta> realizarAposta(@RequestBody DadosCadastroAposta dadosCadastroAposta){
        DadosListagemAposta aposta = apostaService.realizarAposta(dadosCadastroAposta);
        return ResponseEntity.ok().body(aposta);
    }

    @Operation(summary = "Lista apostas")
    @GetMapping
    public ResponseEntity<List<DadosListagemAposta>> listarApostas(){
        List<DadosListagemAposta> apostas = apostaService.listarApostas();
        return ResponseEntity.ok().body(apostas);
    }

    @Operation(summary = "Lista apostas de um apostador")
    @GetMapping("/{idApostador}")
    public ResponseEntity<List<DadosListagemNumeroAposta>> listarApostasApostador(@PathVariable("idApostador") Long idApostador){
        List<DadosListagemNumeroAposta> apostasApostador = apostaService.listarApostasDeUmApostador(idApostador);
        return ResponseEntity.ok().body(apostasApostador);
    }

}
