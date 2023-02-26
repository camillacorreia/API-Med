<h1 align="center">
  <img alt="" title="" src="github/banner.png">
</h1>

API Rest em JAVA da aplicação Voll.med com o intuito de cadastrar médicos e pacientes, além de agendar e cancelar consultas.

- Java 17
- Sprint Boot 3
- Banco de Dados MySQL
- Maven como gerenciador de dependências.
- Flyway como ferramenta de Migrations.
- Hibernate para mapeamento objeto/relacional (ORM).
- Lombok para produtividade e redução de código boilerplate.
- Bean Validation para validações.
- Spring Security para segurança, autenticação, autorização e proteção contra-ataques.
- SpringDoc para documentação da API.
- JUnit para testes unitários.

## Documentação das funcionalidades

A documentação das funcionalidades da aplicação pode ser acessada neste link: <a href="https://trello.com/b/SS9lH0Op/api-voll-med">Trello</a>

## Documentação da API

```shell
http://localhost:8080/swagger-ui.html
http://localhost:8080/v3/api-docs
```

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=Voll%20Med%20API&uri=https%3A%2F%2Fgithub.com%2Fcamillacorreia%2FAPI-Med%2Fblob%2Fmaster%2FInsomnia_2023-02-26.json)

## To run

```shell
mvn clean install

docker-compose build

docker-compose up
```

## Arquitetura


## 🎨 Layout

O layout da aplicação mobile está disponível neste link: <a href="https://www.figma.com/file/h2y2D0ImbXtpxqPqS4UFQ8/Voll.med?t=eEkj6ahn0Genw1Fz-0">Figma</a>

<h1 align="center">
  <img alt="" title="" src="github/home.png">
</h1>

Feito com 💜 por [Camilla Correia](https://www.linkedin.com/in/camilla-correia-3203a3139/)

