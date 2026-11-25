# 🚚 LogiTrack

Sistema de gerenciamento logístico desenvolvido para organizar e controlar operações de estoque, produtos, pedidos, armazéns e entregas.

O LogiTrack tem como objetivo aplicar conhecimentos de desenvolvimento Full Stack, utilizando Java com Spring Boot no backend e Angular no frontend.

## 🛠️ Tecnologias utilizadas

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- Bean Validation

### Frontend
- Angular
- TypeScript
- HTML
- CSS

## 📦 Módulos do sistema

| Módulo | Responsabilidade |
|---|---|
| User | Gerenciamento de usuários e permissões. |
| Product | Cadastro e gerenciamento de produtos. |
| Stock | Controle de estoque, quantidades disponíveis e movimentações. |
| Warehouse | Gerenciamento de armazéns e suas localizações. |
| Order | Gerenciamento de pedidos e seus respectivos itens. |
| Delivery | Controle de entregas, rastreamento e gerenciamento de entregadores. |

## 🏗️ Arquitetura do backend

O backend está organizado em módulos independentes, seguindo uma estrutura baseada em responsabilidades.

Cada módulo possui pastas destinadas a:

- `controller`: exposição dos endpoints da API.
- `dto`: transferência de dados entre as camadas.
- `entity`: representação das entidades persistidas no banco de dados.
- `enumm`: definição de estados e tipos.
- `exception`: tratamento de exceções específicas.
- `repository`: acesso e persistência dos dados.
- `service`: implementação das regras de negócio por meio de UseCases.

Nem todos esses componentes estão implementados em todos os módulos.

## 📂 Estrutura do projeto

```text
logitrack/
├── back/
│   └── logitrack-api/
│       └── src/
│           └── main/
│               └── java/
│                   └── com/erickleo/logitrack/
│                       └── modules/
│                           ├── user/
│                           ├── product/
│                           ├── stock/
│                           ├── warehouse/
│                           ├── order/
│                           └── delivery/
├── front/
│   └── logitrack/
└── README.md
```

## 🚧 Status do desenvolvimento

**Em desenvolvimento.**

### Backend

- [x] Estrutura inicial do backend.
- [x] Criação dos seis módulos principais.
- [x] Desenvolvimento das entidades (Entities).
- [x] Criação dos enums.
- [x] Criação dos repositórios (Repositories).
- [x] Criação dos DTOs iniciais.
- [x] Criação das exceções específicas do módulo User.
- [x] Implementação inicial dos UseCases de User (CRUD).
- [ ] Finalização dos UseCases de User.
- [ ] Desenvolvimento dos demais UseCases.
- [ ] Desenvolvimento dos Controllers.
- [ ] Implementação do tratamento global de exceções.
- [ ] Configuração e integração com PostgreSQL.
- [ ] Implementação da segurança e autenticação com Spring Security e JWT.

### Frontend

- [ ] Configuração inicial do Angular.
- [ ] Desenvolvimento dos componentes.
- [ ] Desenvolvimento dos serviços.
- [ ] Implementação da navegação entre páginas.
- [ ] Integração entre Angular e Spring Boot.

### Testes e integração

- [ ] Testes dos endpoints com Apidog.
- [ ] Testes automatizados com JUnit.
- [ ] Validação das regras de negócio.
- [ ] Integração completa entre frontend e backend.

## 🎯 Objetivo do projeto

Desenvolver uma aplicação Full Stack que simule um sistema de gerenciamento logístico, trabalhando com relacionamentos entre entidades, regras de negócio, APIs REST, persistência de dados e integração entre frontend e backend.

O projeto também busca aprofundar conhecimentos em Java, Spring Boot, Angular, PostgreSQL, arquitetura de software e desenvolvimento de aplicações escaláveis.

---

**Desenvolvido por Erick Leonardo**

[GitHub](https://github.com/ErickLeo01)
