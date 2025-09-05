# WayAds Backend - Kotlin + Spring Boot

Este projeto é o **backend** do aplicativo **WayAds**, desenvolvido em **Kotlin** utilizando o framework **Spring Boot**.

## Tecnologias Utilizadas

* **Linguagem:** Kotlin  
* **Framework:** Spring Boot  
* **Banco de Dados (dev):** H2 Database (memória, para testes)  
* **ORM:** Spring Data JPA  
* **Gerenciamento de Dependências:** Gradle Kotlin DSL  

---

## Arquitetura

O projeto segue uma **Clean Architecture (Arquitetura Limpa simplificada)**, organizada em camadas bem definidas:

- **Presentation (Controller):** responsável por expor endpoints REST e receber as requisições do frontend.  
- **Application (Service/DTO):** contém a lógica de aplicação e orquestra as regras de negócio.  
- **Domain (Model/Repository):** núcleo do sistema, representando as entidades e regras essenciais (ex: `Anuncio`).  
- **Infrastructure:** suporte técnico (tratamento de exceções, utilitários, persistência com Spring Data JPA).  

Esse formato garante baixo acoplamento e alta coesão, permitindo que as regras de negócio evoluam sem impacto direto na interface ou na infraestrutura.

## Benefícios da Estrutura

- **Organização clara:** responsabilidades bem definidas entre camadas.  
- **Escalabilidade:** fácil adicionar novas features sem quebrar o código existente.  
- **Testabilidade:** cada camada pode ser testada de forma isolada.  
- **Padronização:** segue boas práticas de desenvolvimento com Spring Boot + Kotlin.  

---

## Estrutura de Pacotes  

### 📂 `application`
Contém a lógica de **aplicação** (casos de uso).  

- **`dto`** – Define os objetos de transferência de dados (Data Transfer Objects), usados para trafegar informações entre camadas e expor dados de forma segura.  
- **`service`** – Implementa os serviços de aplicação, coordenando chamadas para repositórios, validações e regras de negócio.  

---

### 📂 `domain`
Define o **núcleo do domínio**.  

- **`model`** – Entidades e objetos de domínio persistidos no banco de dados. Exemplo: `Anuncio`.  
- **`repository`** – Interfaces para acesso a dados, geralmente estendendo `JpaRepository` ou `CrudRepository`.  

---

### 📂 `infrastructure`
Contém aspectos técnicos e transversais.  

- **`exception`** – Classes para tratamento e padronização de exceções da aplicação.  
- **`utils`** – Utilitários genéricos reutilizáveis em várias partes do projeto.  

---

### 📂 `presentation`
Camada de **exposição** da aplicação.  

- **`controller`** – Controllers REST, responsáveis por receber requisições HTTP, chamar os serviços e retornar respostas adequadas em JSON.  

---

### 📂 `resources`
Contém arquivos de configuração e recursos do projeto.  

- **`application.properties`** – Configurações principais do Spring Boot (datasource, logging, profiles, etc).  
- **`static` / `templates`** – Estrutura padrão para servir arquivos estáticos ou templates (se aplicável).  

---
