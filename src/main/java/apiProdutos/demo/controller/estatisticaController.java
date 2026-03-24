package apiProdutos.demo.controller;

import apiProdutos.demo.controller.dto.estatisticaDto;
import apiProdutos.demo.service.estatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@Slf4j
public class estatisticaController {
    @Autowired
    private estatisticaService estatisticaService;

    @Operation(summary = "Lista estatistica", description = "Retorna uma estatistica das sessoes dos ultimos 60 segundos!")
    @GetMapping
    public estatisticaDto exibirEstatisticaController(){
        log.info("Exibindo estatisticas");
        return estatisticaService.exibirEstatisticaService();
    }
}
