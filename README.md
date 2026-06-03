# 📦 Order Management API

API REST completa para gerenciamento de pedidos de e-commerce, construída com Java 17 e Spring Boot 3.

## 📋 Sobre o Projeto

Este sistema permite gerenciar pedidos de uma loja virtual. Cada pedido pode conter múltiplos itens, possui status de acompanhamento e é protegido por autenticação JWT. O projeto demonstra uma arquitetura em camadas bem estruturada com Controller → Service → Repository.

## ✨ Funcionalidades

- ✅ Criar pedido com múltiplos itens
- ✅ Listar todos os pedidos com paginação
- ✅ Buscar pedido por ID
- ✅ Atualizar status do pedido (PENDING → CONFIRMED → SHIPPED → DELIVERED → CANCELLED)
- ✅ Cancelar pedido
- ✅ Autenticação e autorização com JWT
- ✅ Cálculo automático do valor total
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento global de exceções
- ✅ Documentação Swagger/OpenAPI

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/api/auth/login` | Login e geração de token JWT |
| GET | `/api/orders` | Listar todos os pedidos |
| GET | `/api/orders/{id}` | Buscar pedido por ID |
| POST | `/api/orders` | Criar novo pedido |
| PUT | `/api/orders/{id}/status` | Atualizar status do pedido |
| DELETE | `/api/orders/{id}` | Cancelar pedido |

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3.2
- Spring Security + JWT
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker & Docker Compose
- Swagger / OpenAPI 3
- Lombok
- Bean Validation

## ▶️ Como Executar

```bash
# Subir o banco de dados
docker-compose up -d

# Executar a aplicação
./mvnw spring-boot:run
```

Acesse a documentação Swagger em: `http://localhost:8080/swagger-ui.html`

## 📂 Estrutura do Projeto

```
src/main/java/com/patryck/orders/
├── controller/     # Endpoints REST
├── service/        # Regras de negócio
├── repository/     # Acesso ao banco de dados
├── entity/         # Entidades JPA (Order, OrderItem)
├── dto/            # Objetos de transferência de dados
├── security/       # Configuração JWT e Spring Security
└── exception/      # Tratamento global de erros
```
