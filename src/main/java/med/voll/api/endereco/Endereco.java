package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
  private String logradouro;
  private String bairro;
  private String cep;
  private String cidade;
  private String complemento;
  private String numero;
  private String uf;

  public Endereco(DadosEndereco dados) {
    this.logradouro = dados.logradouro();
    this.bairro = dados.bairro();
    this.cep = dados.cep();
    this.uf = dados.uf();
    this.cidade = dados.cidade();
    this.numero = dados.numero();
    this.complemento = dados.complemento();
  }
}
