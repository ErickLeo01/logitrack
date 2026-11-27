# 🚚 LogiTrack

Sistema de gerenciamento logístico desenvolvido para organizar e controlar operações de estoque, produtos, pedidos, armazéns e entregas.

O LogiTrack tem como objetivo aplicar conhecimentos de desenvolvimento Full Stack, utilizando Java com Spring Boot no backend e Angular no frontend.

## 🛠️ Tecnologias utilizadas

### Backend
- Java 21
- Spring Boot 3.2
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway (versionamento do banco de dados)
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
- `service`: implementação das regras de negócio por meio de UseCases (uma classe por operação).

Nem todos esses componentes estão implementados em todos os módulos.

### Banco de dados

O schema é criado e versionado com Flyway, por meio de migrations em `src/main/resources/db/migration`. Existem 9 migrations, uma para cada tabela: armazéns, usuários, produtos, entregadores, estoque, pedidos, itens do pedido, entregas e movimentações de estoque.

### Paginação

As listagens (armazéns, produtos e entregadores) usam `Pageable` e retornam `Page` de DTOs de resposta, sem expor as entidades.

## 📂 Estrutura do projeto

```text
logitrack/
├── back/
│   └── logitrack-api/
│       └── src/
│           └── main/
│               ├── java/
│               │   └── com/erickleo/logitrack/
│               │       └── modules/
│               │           ├── user/
│               │           ├── product/
│               │           ├── stock/
│               │           ├── warehouse/
│               │           ├── order/
│               │           └── delivery/
│               └── resources/
│                   └── db/migration/
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
- [x] Migrations do banco de dados com Flyway.
- [x] Configuração e integração com PostgreSQL.
- [x] Criação dos DTOs de User, Warehouse, Product e DeliveryPerson.
- [x] Exceções específicas dos módulos User, Warehouse, Product e DeliveryPerson.
- [x] UseCases de User (criar, buscar, atualizar e deletar).
- [x] UseCases de Warehouse (CRUD e listagem paginada).
- [x] UseCases de Product (CRUD e listagem paginada).
- [ ] Validação de código duplicado nos UseCases de Product.
- [ ] UseCases de DeliveryPerson (criar e atualizar iniciados; faltam deletar, buscar e listar).
- [ ] Listagem de User.
- [ ] UseCases de Stock, Order e Delivery.
- [ ] Desenvolvimento dos Controllers.
- [ ] Implementação do tratamento global de exceções.
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
