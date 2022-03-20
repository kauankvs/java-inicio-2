package folha.de.pagamento;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmpregadoController {

    private final EmpregadoRepositorio repositorio;

    EmpregadoController(EmpregadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/empregados")
    List<Empregado> todos() {
        return repositorio.findAll();
    }

    @PostMapping("/empregados")
    Empregado novoEmpregado(@RequestBody Empregado novoEmpregado) {
        return repositorio.save(novoEmpregado);
    }

    @GetMapping("/empregados/{id}")
    Empregado um(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new EmpregadoNãoEncontradoExceção(id));
    }

    @PutMapping("/empregados/{id}")
    Empregado substituirEmpregado(@RequestBody Empregado novoEmpregado, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(empregado -> {
                    empregado.setNome(novoEmpregado.getNome());
                    empregado.setFunção(novoEmpregado.getFunção());
                    return repositorio.save(empregado);
                })
                .orElseGet(() -> {
                    novoEmpregado.setId(id);
                    return repositorio.save(novoEmpregado);
                });
    }

    @DeleteMapping("/empregados/{id}")
    void deleteEmpregado(@PathVariable Long id) {
        repositorio.deleteById(id);
    }

}