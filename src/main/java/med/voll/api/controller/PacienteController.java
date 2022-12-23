package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

  @Autowired
  private PacienteRepository pacienteRepository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
    pacienteRepository.save(new Paciente(dados));
  }

  @GetMapping
  public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
    return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
  }

  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
    var paciente = pacienteRepository.getReferenceById(dados.id());
    paciente.atualizarInformacoes(dados);
  }
}
