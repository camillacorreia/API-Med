<h1 align="center">
  <img alt="" title="" src="github/banner.png">
</h1>

API Rest em JAVA da aplicação Voll.med com o intuito de cadastrar médicos e pacientes, além de agendar consultas.

- Sprint Boot 3.
- Banco de Dados MySQL.
- Maven como gerenciador de dependências.
- Flyway como ferramenta de Migrations.
- Lombok para produtividade e redução de código boilerplate.
- Bean Validation para validações.

<h1 align="center">
  <img alt="" title="" src="github/home.png">
</h1>

## Requisitos
**Cadastro de médicos**

O sistema deve possuir uma funcionalidade de cadastro de médicos, na qual as seguintes informações deverão ser preenchidas:

- [x] Nome
- [x] E-mail
- [x] Telefone
- [x] CRM
- [x] Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia)
- [x] Endereço completo (logradouro, número, complemento, bairro, cidade, UF e CEP)

```shell
Todas as informações são de preenchimento obrigatório, exceto o número e o complemento do endereço.
```

<h1 align="center">
  <img alt="" title="" src="github/novo-perfil.png">
</h1>

**Listagem de médicos**

O sistema deve possuir uma funcionalidade de listagem de médicos, na qual as seguintes informações, de cada um dos médicos cadastrados, deverão ser exibidas:

- [x] Nome
- [x] E-mail
- [x] CRM
- [x] Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia)

```shell
A listagem deve ser ordenada pelo nome do médico, de maneira crescente, bem como ser paginada, trazendo 10 registros por página.
```

``
/medicos?size=2&page=0&sort=nome
``

<h1 align="center">
  <img alt="" title="" src="github/listagem-medicos.png">
</h1>

**Atualização de médicos**

O sistema deve possuir uma funcionalidade de atualização de dados cadastrais de médicos, na qual as seguintes informações poderão ser atualizadas:

- [x] Nome
- [x] Telefone
- [x] Endereço completo (logradouro, número, complemento, bairro, cidade, UF e CEP)

As seguintes regras de negócio devem ser validadas pelo sistema:

- Não permitir a alteração do e-mail do médico;
- Não permitir a alteração do CRM do médico;
- Não permitir a alteração da Especialidade do médico.

<h1 align="center">
  <img alt="" title="" src="github/edicao-medico.png">
</h1>

**Inativação de médicos**

O sistema deve possuir uma funcionalidade que permita a exclusão de médicos cadastrados.

As seguintes regras de negócio devem ser validadas pelo sistema:

- A exclusão não deve apagar os dados do médico, mas torná-lo como "inativo" no sistema.

- Não poderá ser realizada a exclusão caso existam consultas agendadas.

<h1 align="center">
  <img alt="" title="" src="github/inativacao.png">
</h1>

