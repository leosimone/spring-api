package med.clinimed.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoData data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.cidade = data.cidade();
        this.uf = data.uf();
        this.complemento = data.complemento();
        this.numero = data.numero();

    }

    public void updateAddress(EnderecoData endereco) {
        if(endereco.logradouro() != null) this.logradouro = endereco.logradouro();
        if(endereco.bairro() != null) this.bairro = endereco.bairro();
        if(endereco.cep() != null) this.cep = endereco.cep();
        if(endereco.uf() != null) this.uf = endereco.uf();
        if(endereco.complemento() != null) this.complemento = endereco.complemento();
        if(endereco.numero() != null) this.numero = endereco.numero();
    }
}
