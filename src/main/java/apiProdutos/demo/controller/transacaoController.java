package apiProdutos.demo.controller;

import apiProdutos.demo.controller.dto.transacaoDto;
import apiProdutos.demo.service.transacaoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Slf4j
public class transacaoController {
    private transacaoDto dto;
    @Autowired
    private transacaoService transacaoService;

    @PostMapping
    @Operation(summary = "Adiciona uma sessao", description = "Retorna Created ao adicionar uma sessao")
    public ResponseEntity<Void> adicionarTransacaoController(@RequestBody transacaoDto dto){
        transacaoService.adicionarTransacaoService(dto);
        log.info("Adicionando uma nova sessao e Exibindo Status Created");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Deleta todas sessoes", description = "Retorna OK ao deletar todas sessoes")
    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoesController(){
        transacaoService.deletarTransacoesService();
        log.info("Apagando todas sessoes e exibindo Status OK");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
