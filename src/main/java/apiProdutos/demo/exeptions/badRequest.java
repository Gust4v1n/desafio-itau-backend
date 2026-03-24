package apiProdutos.demo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class badRequest extends RuntimeException {
    public badRequest() {

    }
}
