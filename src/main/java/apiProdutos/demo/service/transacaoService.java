package apiProdutos.demo.service;

import apiProdutos.demo.controller.dto.transacaoDto;
import apiProdutos.demo.exeptions.unprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class transacaoService {
    //iniciar array de transacao
    public List<transacaoDto> transacaoDto = new ArrayList<>();

    public void adicionarTransacaoService(transacaoDto dto){
        if(dto.valor()==null || dto.dataHora() == null){
            throw new unprocessableEntity();
        }
        if(dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new unprocessableEntity();
        }

        if(dto.valor()<0){
            throw new unprocessableEntity();
        }
        transacaoDto.add(dto);
    }
}
