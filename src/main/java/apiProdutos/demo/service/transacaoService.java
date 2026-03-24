package apiProdutos.demo.service;

import apiProdutos.demo.controller.dto.transacaoDto;
import apiProdutos.demo.exeptions.unprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class transacaoService {
    //iniciar array de transacao
    public List<transacaoDto> transacaoDto = new ArrayList<>();

    public void adicionarTransacaoService(transacaoDto dto){
        if(dto.valor()==null || dto.dataHora() == null){
            log.error("valor ou dataHora do body no Post transacao esta nullo");
            throw new unprocessableEntity();
        }
        if(dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("dataHora no body esta no futuro no Post transacao");
            throw new unprocessableEntity();
        }

        if(dto.valor()<0){
            log.error("valor no body esta negativo no Post Transacao");
            throw new unprocessableEntity();
        }
        transacaoDto.add(dto);
    }

    public void deletarTransacoesService(){
        transacaoDto.clear();
    }

    //apenas para eu conseguir fazer o estatistica
    //retornando apenas as transacoes dos ultimos 60 segundos :)s
    public List<transacaoDto> verTransacoes(){
        OffsetDateTime tempoIntervalo = OffsetDateTime.now().minusSeconds(60);
        List transacoes1Minuto = transacaoDto.stream().filter(p->p.dataHora().isAfter(tempoIntervalo)).toList();
        return transacoes1Minuto;
    }
}
