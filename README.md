# Lab: Padrões de Projeto com Spring Boot

Este projeto é um exemplo prático de implementação de **Padrões de Projeto (Design Patterns)** utilizando o ecossistema Spring Boot. A aplicação expõe uma API REST para o gerenciamento de clientes, integrando persistência em banco de dados e consumo de serviços externos.

---

## 🚀 Sobre o Projeto

O objetivo principal é demonstrar a aplicação dos seguintes padrões de projeto:

- **Singleton**: Utilizado pelo Spring por meio da injeção de dependências.
- **Strategy**: Implementação de diferentes lógicas a partir de uma mesma interface de serviço.
- **Facade**: Simplificação da complexidade de integrações (Banco de Dados e API ViaCEP) por meio de um Controller que atua como fachada.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21 (configurado via Maven)
- **Framework:** Spring Boot 4.0.1
- **Gerenciador de Dependências:** Maven
- **Banco de Dados:** H2 (em memória, para desenvolvimento)
- **Integração Externa:** OpenFeign (API ViaCEP)
- **Documentação da API:** SpringDoc OpenAPI (Swagger UI)

---

## 📋 Requisitos

- **Java:** 17 ou superior (recomendado Java 21)
- **Maven:** 3.6 ou superior
- **Sistema Operacional:** Windows, Linux ou macOS

---

## ⚙️ Como Compilar e Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/lab-padroes-projeto-spring.git
cd lab-padroes-projeto-spring
```
---

### 2. Compilar o projeto

```bash
mvn clean package

```
### 3. Executar a aplicação
Usando o Maven:
```bash
mvn spring-boot:run
```

Ou executando o JAR gerado:
```bash
java -jar target/lab-padroes-projeto-spring-0.0.1-SNAPSHOT.jar

```

## 🔗 Endpoints Principais (API REST)
Base da API:
```bash
http://localhost:8080/clientes

```

| Método | Endpoint         | Descrição                           |
| ------ | ---------------- | ----------------------------------- |
| GET    | `/clientes`      | Lista todos os clientes cadastrados |
| GET    | `/clientes/{id}` | Busca um cliente pelo ID            |
| POST   | `/clientes`      | Cadastra um novo cliente            |
| PUT    | `/clientes/{id}` | Atualiza um cliente existente       |
| DELETE | `/clientes/{id}` | Remove um cliente pelo ID           |


## 📌 Exemplo de Requisição (POST)
```bash
curl -X POST http://localhost:8080/clientes \
-H "Content-Type: application/json" \
-d '{
  "nome": "Raiane Batista",
  "endereco": {
    "cep": "01001000"
  }
}'


```

## 📂 Estrutura do Projeto
```bash
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   ├── controller   # Facade da API REST (ClienteRestController)
    │   │   ├── model        # Entidades e repositórios (Cliente, Endereco)
    │   │   └── service      # Strategy e integração com ViaCEP (OpenFeign)
    │   └── resources
    │       └── application.properties
```

## 🗄️ Banco de Dados e Documentação
* Swagger UI:
Acesse e teste a API em:
http://localhost:8080/swagger-ui/index.html

* H2 Console:
Acesse o banco em memória em:
http://localhost:8080/h2-console

Nota: Verifique as credenciais no arquivo application.properties.

###  🧪 Testes

Para executar os testes automatizados:
```bash
mvn test


```

## 👩‍💻 Desenvolvido por

[Raiane Batista](https://github.com/RaianeBatista)



