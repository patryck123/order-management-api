# Order Management API

API REST completa para gerenciamento de pedidos de e-commerce, desenvolvida com **Java 17** e **Spring Boot 3**.

## Tecnologias

- Java 17
- Spring Boot 3.2
- Spring Security + JWT
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker / Docker Compose
- Swagger / OpenAPI 3

## Funcionalidades

- Criar, listar, buscar e cancelar pedidos
- Autenticação e autorização via JWT
- Validação de dados com Bean Validation
- Tratamento centralizado de exceções
- Documentação automática com Swagger UI
- Containerização com Docker

## Como Executar

### Com Docker (recomendado)

```bash
docker-compose up --build
```

Acesse: http://localhost:8080/swagger-ui.html

### Localmente

1. Certifique-se de ter o PostgreSQL rodando na porta 5432
2. Crie o banco `order_db`
3. Configure `application.properties` com suas credenciais

```bash
mvn spring-boot:run
```

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/api/orders` | Criar novo pedido |
| GET | `/api/orders` | Listar todos os pedidos |
| GET | `/api/orders/{id}` | Buscar pedido por ID |
| GET | `/api/orders/customer?email=` | Pedidos por e-mail |
| PATCH | `/api/orders/{id}/status` | Atualizar status |
| DELETE | `/api/orders/{id}` | Cancelar pedido |

## Estrutura do Projeto

```
src/main/java/com/patryck/orders/
├── controller/   # Endpoints REST
├── service/      # Regras de negócio
├── repository/   # Acesso ao banco
├── entity/       # Entidades JPA
├── dto/          # Data Transfer Objects
├── security/     # JWT e configuração Spring Security
└── exception/    # Tratamento de erros
```

## Autor

**Patryck Martins Langsdorff** — Desenvolvedor Java Back End Junior

[![LinkedIn](https://img.shields.io/badge/LinkedIn-patryck--martins--langsdorff-blue)](https://www.linkedin.com/in/patryck-martins-langsdorff)
