# Projeto API de Mitigação de Eventos Extremos

---

## 1. Visão Geral do Projeto

Este projeto consiste em uma **API RESTful** desenvolvida com **Spring Boot** para centralizar dados e regras de negócio relacionadas à **mitigação de impactos de eventos extremos na população**. Ela serve como a espinha dorsal para futuras aplicações (front-ends, dashboards, aplicativos móveis) que visam coletar, processar e gerenciar informações cruciais para a prevenção e resposta a desastres.

A API foi projetada seguindo as boas práticas da arquitetura REST e incorpora diversos requisitos técnicos fundamentais para uma aplicação robusta e escalável.

---

## 2. Requisitos Técnicos e Implementação

A API foi construída com foco nos seguintes requisitos técnicos:

* **API Rest Atendendo Boas Práticas da Arquitetura:**
    * Endpoints claros e semânticos (ex: `/api/usuarios`, `/api/estacoes`).
    * Uso adequado dos verbos HTTP (GET, POST, PUT, DELETE).
    * Códigos de status HTTP semânticos (200 OK, 201 Created, 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found, 409 Conflict, 500 Internal Server Error).
* **Persistência em Banco de Dados Relacional utilizando Spring Data JPA:**
    * Utiliza o **Oracle** como sistema de gerenciamento de banco de dados.
    * Integração com o Spring Data JPA para abstração e simplificação das operações de persistência.
* **Mapeamento de Relacionamento entre Entidades:**
    * As entidades (ex: `Usuario`, `Estacao`, `Sensor`) são mapeadas com relacionamentos (`@OneToMany`, `@ManyToOne`) utilizando Hibernate para representar a complexidade do domínio.
* **Validação com Bean Validation:**
    * Uso de anotações como `@NotBlank`, `@Email`, `@Size` em DTOs e entidades para garantir a integridade dos dados de entrada.
    * As validações são aplicadas automaticamente com `@Valid` nos controllers.
* **Paginação, Ordenação e Filtros:**
    * Endpoints configurados para suportar paginação (`page`, `size`), ordenação (`sort`) e filtros específicos, otimizando o consumo de dados em grande escala.
    * _Nota: Para o endpoint de paginação de estações (`/api/estacoes/paginado`), os parâmetros de paginação e ordenação são enviados via Request Body para flexibilidade em futuros critérios de busca mais complexos._
* **Documentação da API com Swagger:**
    * A API é auto-documentada usando o Springdoc OpenAPI (Swagger UI), fornecendo uma interface interativa para explorar e testar todos os endpoints.
* **Autenticação com JWT (JSON Web Token):**
    * Implementação de um sistema de autenticação e autorização baseado em JWT, protegendo os endpoints sensíveis da API.
    * Os usuários obtêm um token JWT após o login, que deve ser enviado no cabeçalho `Authorization` para acessar recursos protegidos.
* **Deploy em Nuvem:**
    * A API está deployada e operando na plataforma **Render.com**, provando sua capacidade de funcionar em um ambiente de produção.

---

## 3. Tecnologias Utilizadas

* **Linguagem:** Java 21+
* **Framework:** Spring Boot 3.x
* **Persistência:** Spring Data JPA, Hibernate
* **Banco de Dados:** PostgreSQL
* **Autenticação:** Spring Security, JWT (Json Web Token)
* **Validação:** Bean Validation (Hibernate Validator)
* **Documentação API:** Springdoc OpenAPI (Swagger UI)
* **Gerenciador de Dependências:** Maven
* **Deploy:** Render.com

---

## 4. Estrutura do Projeto

O projeto segue uma arquitetura em camadas, comum em aplicações Spring Boot:

* `src/main/java/com/fonteviva/apirest`:
    * `controller`: Camada de entrada da API, responsável por receber as requisições HTTP.
    * `service`: Camada de lógica de negócio.
    * `repository`: Camada de acesso a dados (Spring Data JPA).
    * `entity`: Classes que representam as tabelas do banco de dados.
    * `dto`: Data Transfer Objects para comunicação entre camadas e com o cliente.
    * `config`: Classes de configuração (ex: Spring Security, JWT).
    * `exception`: Classes de tratamento de exceções customizadas.
    * `security`: Componentes relacionados à segurança (filtros, provedores de token).
* `src/main/resources`: Contém os arquivos de configuração (ex: `application.properties`).

---

## 5. Links e Acesso

### 5.1. Repositório de Código Fonte

* **GitHub:** https://github.com/2TDSPV-GS-01/JAVA-ADVANCED.git

### 5.2. Deploy em Nuvem

* **URL do Swagger UI:** `https://java-advanced.onrender.com/swagger-ui/index.html#`
    * _Esta é a interface interativa para explorar e testar a API diretamente no navegador._

---

## 6. Instruções para Acesso e Testes

A API está deployada na nuvem e pode ser testada utilizando ferramentas como **Swagger UI** (diretamente no navegador) ou **Postman/Insomnia**.

### 6.1. Acesso via Swagger UI (Recomendado para Testes Iniciais)

1.  Acesse a URL do Swagger UI no seu navegador: `https://java-advanced.onrender.com/swagger-ui/index.html#`
2.  **Passo 1: Autenticação (Login)**
    * Navegue até o endpoint de autenticação `api/auth/login`.
    * Utilize o método `POST /auth/login`.
    * No campo `Request Body`, forneça o usuário e senha abaixo (usuário Teste para ambiente de desenvolvimento).
        ```json
        {
          "email": "gmsssnathalia@gmail.com",
          "senha": "25055505"
        }
        ```
    * Clique em `Execute`. A resposta conterá o seu **token JWT**.
    * **Copie o token JWT** (apenas a string do token, sem "Bearer ").
3.  **Passo 2: Autorização no Swagger**
    * No canto superior direito da página do Swagger UI, clique no botão **`Authorize`**.
    * No pop-up, insira o token copiado no campo `Value`.
    * Clique em `Authorize` e depois em `Close`. Agora, suas requisições via Swagger serão autenticadas.
4.  **Passo 3: Testar Endpoints Protegidos**
    * Expanda qualquer endpoint de interesse (ex: `EstacaoTratamento Controller`).
    * Utilize os métodos `GET`, `POST`, `PUT`, `DELETE` para interagir com a API, fornecendo os parâmetros necessários nos `Request Body` ou `Query Parameters`.
    * Para `POST /api/estacoes/paginado`, o Request Body esperado é:
        ```json
        {
          "page": 0,
          "size": 10,
          "sort": [
            "dataInstalacao,asc"
          ]
        }
        ```

## **Integrantes**

- Nome: Francesco Di Benedetto
  RM: RM557313
- Nome: Nathalia Gomes da Silva
  RM: RM554945
- Nome: Gustavo Goulart Bretas
  RM: RM555708

## 7. CRUD

### 7.1. Autenticação do usuário

<img width="655" alt="1  autenticacao_usuario" src="https://github.com/user-attachments/assets/c3a0d960-a9dc-44b5-a030-4423e641fed6" />

<img width="613" alt="2  response_autenticacao_usuario" src="https://github.com/user-attachments/assets/ac55ca83-52bb-433b-a5fd-54d00623299b" />

### 7.2 Post

<img width="669" alt="5  post_request" src="https://github.com/user-attachments/assets/03ad1335-812e-423e-8992-fc1d8c5df8e2" />
<img width="642" alt="6  post_response" src="https://github.com/user-attachments/assets/43a8cf39-7f36-4570-a7ba-ae22c008f0cf" />


### 7.3 Get
<img width="658" alt="7  get_request" src="https://github.com/user-attachments/assets/2c636c29-8b4c-4299-ab7e-e3ada299f20a" />
<img width="630" alt="8  get_response" src="https://github.com/user-attachments/assets/31d08ad8-6427-4721-af4f-9bfc0b16b08d" />


### 7.4 Put (alterando de Ativo para Inativo)
<img width="657" alt="9  put_request" src="https://github.com/user-attachments/assets/ddfa27c1-c169-4534-b5d7-8e3f0108a758" />
<img width="622" alt="10  put_response" src="https://github.com/user-attachments/assets/087568b7-c11f-49ba-88ff-16ef29a38aae" />


### 7.5 Delete
<img width="656" alt="11  delete_request" src="https://github.com/user-attachments/assets/b5d5d7a4-35d0-47fd-a86c-b6d152f26b75" />
<img width="632" alt="12  delete_response" src="https://github.com/user-attachments/assets/36699d63-6393-42db-890a-1086fc6e48b7" />



## 8. Vídeos de Demonstração

* **Vídeo Demonstração da Solução Completa:** [[Vídeo de demonstração](https://youtu.be/fUW_IH_rGJ0?si=TnDiQrOGWY6MvJIt)]
* **Vídeo Pitch:** [[Vídeo pitch]](https://www.youtube.com/watch?v=pGPg7w3ZHkE)

---
