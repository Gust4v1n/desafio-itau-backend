package apiProdutos.demo.controller.dto;

public record estatisticaDto(Integer count, Double sum, Double avg, Double min, Double max) {
    public estatisticaDto{
        if(avg.isNaN()){
            avg=0.0;
        }
    }
}
