# 🌐 Projeto SARA - Sistema de Alerta e Resposta Automatizada

## 🧠 Resumo

O Projeto **SARA (Sistema de Alerta e Resposta Automatizada)** é uma solução tecnológica desenvolvida para mitigar os impactos de eventos extremos — como enchentes, deslizamentos, secas e outros desastres naturais — sobre a população. Através de sensores conectados, alertas inteligentes e notificações automatizadas, o sistema integra tecnologia e inovação para monitorar e responder rapidamente a situações críticas, promovendo segurança pública e bem-estar social.

Esta API REST, construída com **Spring Boot**, gerencia os dados e regras de negócio da aplicação, oferecendo suporte a autenticação segura com JWT, cadastro de usuários, gerenciamento de sensores, leitura de dados, emissão de alertas e envio de notificações.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- Spring Security com JWT  
- Bean Validation (Jakarta)  
- Oracle Database  
- Swagger / OpenAPI 3  
- Lombok  
- MapStruct  

---

## 📦 Requisitos

- Java 17 ou superior  
- Maven 3.8 ou superior  
- Banco Oracle Database (local ou remoto)  
- IDE de sua preferência (IntelliJ, VS Code, Eclipse, etc)  

---

## ⚙️ Configuração e Execução

### 1. Clone o repositório


git clone https://github.com/seu-usuario/projeto-sara.git
cd projeto-sara

---

### 2. Configure o banco de dados

No arquivo `src/main/resources/application.properties`, configure os dados para conexão com o Oracle Database. Exemplo:

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=RM557481
spring.datasource.password=250406
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

---

### 3. Acesso à API e documentação

A API estará disponível em:  
`http://localhost:8080/api`

Documentação Swagger UI disponível em:  
`http://localhost:8080/swagger-ui.html`  
ou  
`http://localhost:8080/swagger-ui/index.html`

---

## 🔐 Autenticação

A API utiliza autenticação via JWT. Para obter um token válido, envie um POST para:


POST /api/auth/login

{
  "username": "joao@gmail.com",
  "password": "senha123"
}

Authorization: Bearer <token>

---

## 🧩 Funcionalidades principais

- Gestão de usuários e tipos de usuários  
- Cadastro e consulta de sensores e leituras  
- Emissão e gerenciamento de alertas  
- Envio e status de notificações  
- Filtragem, paginação e ordenação nas consultas  
- Segurança com JWT para proteção dos endpoints  
