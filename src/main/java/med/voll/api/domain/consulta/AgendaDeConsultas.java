package med.voll.api.domain.consulta;


import jakarta.validation.ValidationException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

  @Autowired
  private ConsultaRepository consultaRepository;

  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private PacienteRepository pacienteRepository;

  public void agendar(DadosAgendamentoConsulta dados){
    if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
      throw new ValidationException("Id do médico não existe!");
    }

    if(!pacienteRepository.existsById(dados.idPaciente())){
      throw new ValidationException("Id do paciente não existe!");
    }

    var medico = escolherMedico(dados);
    var paciente = pacienteRepository.findById(dados.idPaciente()).get();
    var consulta = new Consulta(null, medico, paciente, dados.data());
    consultaRepository.save(consulta);
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
