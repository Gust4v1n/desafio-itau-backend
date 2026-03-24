package apiProdutos.demo.controller;

import apiProdutos.demo.controller.dto.transacaoDto;
import apiProdutos.demo.service.transacaoService;
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
    public ResponseEntity<Void> adicionarTransacaoController(@RequestBody transacaoDto dto){
        transacaoService.adicionarTransacaoService(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoesController(){
        transacaoService.deletarTransacoesService();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
