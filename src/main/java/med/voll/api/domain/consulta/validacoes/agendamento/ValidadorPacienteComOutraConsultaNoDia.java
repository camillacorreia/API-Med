package med.voll.api.domain.consulta.validacoes.agendamento;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteComOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

  @Autowired
  private ConsultaRepository consultaRepository;

  public void validar(DadosAgendamentoConsulta dados){
    var primeiroHorario = dados.data().withHour(7);
    var ultimoHorario = dados.data().withHour(18);
    var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween((dados.idPaciente()), primeiroHorario, ultimoHorario);
    if(pacientePossuiOutraConsultaNoDia){
      throw new ValidationException("O paciente já possui uma consulta agendada nesse dia");
    }
  }
}
