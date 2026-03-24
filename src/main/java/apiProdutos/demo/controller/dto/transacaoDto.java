package apiProdutos.demo.controller.dto;

import java.time.OffsetDateTime;

public record transacaoDto(Double valor, OffsetDateTime dataHora) {
}
