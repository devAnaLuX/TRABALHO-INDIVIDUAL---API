# 📚 Biblioteca Inclusiva API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Swagger-OpenAPI_3-85EA2D?style=for-the-badge&logo=swagger&logoColor=black"/>
</p>

---

## ✅ Funcionalidades

- 👤 **Usuários** — cadastro, consulta, atualização e remoção
- ♿ **Perfil de Acessibilidade** — configuração por tipo de deficiência e formato preferido
- 📖 **Livros** — gerenciamento do acervo com disponibilidade em múltiplos formatos
- 🏷️ **Categorias** — organização dos livros por categoria
- 🔄 **Empréstimos** — controle de empréstimos com status e datas
- 📄 **Documentação** — Swagger UI integrado

---

## 🛠 Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 17+ | Linguagem principal |
| Spring Boot | 3.x | Framework principal |
| Spring Data JPA | 3.x | Persistência de dados |
| PostgreSQL | 15+ | Banco de dados |
| Hibernate | 6.x | ORM |
| SpringDoc OpenAPI | 2.3.0 | Documentação Swagger |
| Maven | 3.x | Gerenciamento de dependências |
| Bean Validation | 3.x | Validação de dados |

---

## 📁 Estrutura do Projeto

```
src/main/java/BibliotecaInclusiva/AtivIndividual/
│
├── 📂 Controller/
│   ├── UsuarioController.java
│   ├── PerfilAcessibilidadeController.java
│   ├── LivroController.java
│   ├── CategoriaController.java
│   └── EmprestimoController.java
│
├── 📂 Service/
│   ├── UsuarioService.java
│   ├── PerfilAcessibilidadeService.java
│   ├── LivroService.java
│   ├── CategoriaService.java
│   └── EmprestimoService.java
│
├── 📂 Domain/
│   ├── Usuario.java
│   ├── PerfilAcessibilidade.java
│   ├── Livro.java
│   ├── Categoria.java
│   └── Emprestimo.java
│
├── 📂 DTO/
│   ├── Usuario/
│   ├── PerfilAcessibilidade/
│   ├── Livro/
│   ├── Categoria/
│   └── Emprestimo/
│
├── 📂 Repository/
├── 📂 Enumerated/
│   ├── Tipo.java
│   ├── Deficiencia.java
│   ├── Formato.java
│   └── Status.java
│
└── 📂 config/
    ├── SwaggerConfig.java
    ├── CorsConfig.java
    └── AppConfig.java
```

---

## ▶️ Como Executar

### Pré-requisitos

- Java 17+
- Maven 3.x
- PostgreSQL 15+

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/biblioteca-inclusiva.git
cd biblioteca-inclusiva
```

### 2. Configure o banco de dados

Crie um banco no PostgreSQL:

```sql
CREATE DATABASE biblioteca_inclusiva;
```

### 3. Configure o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_inclusiva
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Execute o projeto

```bash
mvn spring-boot:run
```

### 5. Acesse a documentação

```
http://localhost:8080/swagger-ui.html
```

---

## 🔀 Endpoints

### 👤 Usuários `/usuarios`

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/usuarios` | Lista todos os usuários | `200` |
| `GET` | `/usuarios/{id}` | Busca usuário por ID | `200` / `404` |
| `POST` | `/usuarios` | Cria novo usuário | `201` / `409` |
| `PUT` | `/usuarios/{id}` | Atualiza usuário | `200` / `404` |
| `DELETE` | `/usuarios/{id}` | Remove usuário | `204` / `404` |

### ♿ Perfis `/perfis`

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/perfis` | Lista todos os perfis | `200` |
| `GET` | `/perfis/{id}` | Busca perfil por ID | `200` / `404` |
| `POST` | `/perfis` | Cria novo perfil | `201` |
| `PUT` | `/perfis/{id}` | Atualiza perfil | `200` / `404` |
| `DELETE` | `/perfis/{id}` | Remove perfil | `204` / `404` |

### 📖 Livros `/livros`

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/livros` | Lista todos os livros | `200` |
| `GET` | `/livros/{id}` | Busca livro por ID | `200` / `404` |
| `POST` | `/livros` | Adiciona livro | `201` / `409` |
| `PUT` | `/livros/{id}` | Atualiza livro | `200` / `404` |
| `DELETE` | `/livros/{id}` | Remove livro | `204` / `404` |

### 🏷️ Categorias `/categorias`

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/categorias` | Lista todas as categorias | `200` |
| `GET` | `/categorias/{id}` | Busca categoria por ID | `200` / `404` |
| `POST` | `/categorias` | Cria categoria | `201` |
| `PUT` | `/categorias/{id}` | Atualiza categoria | `200` / `404` |
| `DELETE` | `/categorias/{id}` | Remove categoria | `204` / `404` |

### 🔄 Empréstimos `/emprestimos`

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/emprestimos` | Lista todos os empréstimos | `200` |
| `GET` | `/emprestimos/{id}` | Busca empréstimo por ID | `200` / `404` |
| `POST` | `/emprestimos` | Registra empréstimo | `201` |
| `PUT` | `/emprestimos/{id}` | Atualiza empréstimo | `200` / `404` |
| `DELETE` | `/emprestimos/{id}` | Remove empréstimo | `204` / `404` |

---

## 🗃 Modelo de Dados

```
Usuario (1) ──── (1) PerfilAcessibilidade
Usuario (1) ──── (N) Emprestimo
Livro   (1) ──── (N) Emprestimo
Livro   (N) ──── (N) Categoria
```

### Enumerações

| Enum | Valores |
|---|---|
| `Tipo` | Estudante, Professor, Visitante... |
| `Deficiencia` | Visual, Auditiva, Motora... |
| `Formato` | Braille, AudioLivro, Ebook, Libras... |
| `Status` | Ativo, Devolvido, Atrasado... |

---

## 👤 Autor

Desenvolvido por **Ana Luísa**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/devAnaLuX)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ana-luisa-cunha-reis-8baa563a3/)

---

<p align="center">

```
    　 ／＞　 フ
    　| 　_　_|
    ／` ミ＿xノ
   /　　　　 |        
  /　 ヽ　　 ﾉ        
  │　　|　|　|           
 ／￣|　　 |　|
(￣ヽ＿_ヽ_)__)
＼二)
```

</p>
