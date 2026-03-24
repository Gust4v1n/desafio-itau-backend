package apiProdutos.demo.controller;

import apiProdutos.demo.controller.dto.transacaoDto;
import apiProdutos.demo.service.transacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class transacaoController {
    private transacaoDto dto;
    @Autowired
    private transacaoService transacaoService;

    @PostMapping
    @Operation(summary = "Adiciona uma sessao", description = "Retorna Created ao adicionar uma sessao")
    public ResponseEntity<Void> adicionarTransacaoController(@RequestBody transacaoDto dto){
        transacaoService.adicionarTransacaoService(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Deleta todas sessoes", description = "Retorna OK ao deletar todas sessoes")
    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoesController(){
        transacaoService.deletarTransacoesService();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
