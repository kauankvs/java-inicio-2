package folha.de.pagamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmpregadoNãoEncontradaRecomendação {

    @ResponseBody
    @ExceptionHandler (EmpregadoNãoEncontradoExceção.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    String empregadoNãoEncontradoHandler(EmpregadoNãoEncontradoExceção ex) {
        return ex.getMessage();
    }

}
