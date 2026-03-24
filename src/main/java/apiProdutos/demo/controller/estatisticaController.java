package apiProdutos.demo.controller;

import apiProdutos.demo.controller.dto.estatisticaDto;
import apiProdutos.demo.service.estatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class estatisticaController {
    @Autowired
    private estatisticaService estatisticaService;

    @GetMapping
    public estatisticaDto exibirEstatisticaController(){
        return estatisticaService.exibirEstatisticaService();
    }
}
