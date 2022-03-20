package folha.de.pagamento;

public class EmpregadoNãoEncontradoExceção extends RuntimeException {

    EmpregadoNãoEncontradoExceção(Long id) {
        super("Não foi possível achar o funcionário " + id + "!");
    }
}
