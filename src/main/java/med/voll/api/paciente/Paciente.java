package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String telefone;

  @Embedded
  private Endereco endereco;

  public Paciente(DadosCadastroPaciente dados) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.telefone = dados.telefone();
    this.endereco = new Endereco(dados.endereco());
  }
}
