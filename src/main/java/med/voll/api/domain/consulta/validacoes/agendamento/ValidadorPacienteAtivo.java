package med.voll.api.domain.consulta.validacoes.agendamento;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

  @Autowired
  private PacienteRepository pacienteRepository;

  public void validar(DadosAgendamentoConsulta dados){

    var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
    if(!pacienteEstaAtivo){
      throw  new ValidationException("A consulta não pode ser agendada com pacientes excluídos");
    }
  }
}
