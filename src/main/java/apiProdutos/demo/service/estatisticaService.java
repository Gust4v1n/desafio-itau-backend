package apiProdutos.demo.service;

import apiProdutos.demo.controller.dto.estatisticaDto;
import apiProdutos.demo.controller.dto.transacaoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class estatisticaService {
    public List<estatisticaDto> estatisticaDto = new ArrayList<>();
    @Autowired
    private transacaoService transacaoService;
    private List<transacaoDto> transacaoDto;
    //Integer count, Double sum, Double avg, Double min, Double max
    private Integer countEstatistica(){
        OffsetDateTime intervaloTransacoes = OffsetDateTime.now().minusSeconds(60);
        transacaoService.verTransacoes().stream().filter(p->p.dataHora().isAfter(intervaloTransacoes)).toList();

        return transacaoService.verTransacoes().size();
    }

    private Double sumEstatistica(){
        double totalValor = 0;
        for(int i = 0; i<transacaoService.verTransacoes().size();i++){
            totalValor+=transacaoService.verTransacoes().get(i).valor();
        }
        return totalValor;
    }

    private Double avgEstatistica(){
        double totalValor = 0;
        for(int i = 0; i<transacaoService.verTransacoes().size();i++){
            totalValor+=transacaoService.verTransacoes().get(i).valor();
        }
        return totalValor/transacaoService.verTransacoes().size();
    }

    private Double minEstatistica(){
        double totalMinimo = 0;
        //meio confuso mas vou explicar um pouco, se for o primeiro loop, total vai ficar igual ao primeiro valor da
        //array, mas se nao for percorre outro if, e esse if verifica se o valor totalMinimo e maior que o valor[i] da
        //array, se for, totalMinimo se torna o valor da array :)
        for(int i = 0; i<transacaoService.verTransacoes().size();i++){
            if(i==0){
                totalMinimo=transacaoService.verTransacoes().get(i).valor();
            }
            else if(totalMinimo>transacaoService.verTransacoes().get(i).valor()){
                totalMinimo=transacaoService.verTransacoes().get(i).valor();
            }
        }
        return totalMinimo;
    }

    private Double maxEstatistica(){
        double totalMaximo = 0;
        //so inverti a logica d minEstatistica()

        for(int i = 0; i<transacaoService.verTransacoes().size();i++){
            if(i==0){
                totalMaximo=transacaoService.verTransacoes().get(i).valor();
            }
            else if(totalMaximo<transacaoService.verTransacoes().get(i).valor()){
                totalMaximo=transacaoService.verTransacoes().get(i).valor();
            }
        }
        return totalMaximo;
    }

    public estatisticaDto exibirEstatisticaService(){
        estatisticaDto naoSeiQueNomeColocar = new estatisticaDto(countEstatistica(), sumEstatistica(), avgEstatistica(), minEstatistica(), maxEstatistica());
        return naoSeiQueNomeColocar;
    }
}
