package med.voll.api.domain.consulta;


import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

  @Autowired
  private ConsultaRepository consultaRepository;

  @Autowired
  private PacienteRepository pacienteRepository;

  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private List<ValidadorAgendamentoDeConsulta> validadoresAgendamento;

  @Autowired
  private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

  public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
    if(!pacienteRepository.existsById(dados.idPaciente())){
      throw new ValidationException("Id do paciente não existe!");
    }

    if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
      throw new ValidationException("Id do médico não existe!");
    }

    validadoresAgendamento.forEach(v -> v.validar(dados));

    var paciente = pacienteRepository.findById(dados.idPaciente()).get();
    var medico = escolherMedico(dados);
    if(medico == null){
      throw new ValidationException("Não existe médico disponível nessa data");
    }

    var consulta = new Consulta(null, medico, paciente, dados.data(), null);
    consultaRepository.save(consulta);

    return new DadosDetalhamentoConsulta(consulta);
  }

  public void cancelar(DadosCancelamentoConsulta dados) {
    if (!consultaRepository.existsById(dados.idConsulta())) {
      throw new ValidationException("Id da consulta informado não existe");
    }

    validadoresCancelamento.forEach(v -> v.validar(dados));

    var consulta = consultaRepository.getReferenceById(dados.idConsulta());
    consulta.cancelar(dados.motivo());
  }

  private Medico escolherMedico(DadosAgendamentoConsulta dados) {
    if (dados.idMedico() != null) {
      return medicoRepository.getReferenceById(dados.idMedico());
    }

    if(dados.especialidade() == null) {
      throw new ValidationException("Especialidade é obrigatória quando o médico não foi escolhido");
    }

    return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
  }
}
