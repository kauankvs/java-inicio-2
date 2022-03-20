package folha.de.pagamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBancoDeDados {

    private static final Logger log = LoggerFactory.getLogger(LoadBancoDeDados.class);

    @Bean
    CommandLineRunner initBancoDeDados(EmpregadoRepositorio repositorio) {

        return args -> {
            log.info("Pré-carregando " + repositorio.save(new Empregado("Walter White", "químico")));
            log.info("Pré-carregando " + repositorio.save(new Empregado("Jesse Pinkman", "vendedor")));
        };
    }
}
