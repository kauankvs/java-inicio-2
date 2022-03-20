package folha.de.pagamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Empregado {

    private @Id @GeneratedValue Long id;
    private String nome;
    private String função;

    Empregado() {}

    Empregado(String nome, String função) {
        this.nome = nome;
        this.função = função;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setFunção(String função) {
        this.função = função;
    }
    public String getFunção() {
        return função;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Empregado)) {
            return false;
        }

        Empregado empregado = (Empregado) o;
        return Objects.equals(this.id, empregado.id)
                && Objects.equals(this.nome, empregado.nome)
                && Objects.equals(this.função, empregado.função);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nome, this.função);
    }

    @Override
    public String toString() {
        return "Empregado{" + "id: " + this.id + ", nome: " + this.nome
                +  ", função: " + this.função + "}";
    }
}
