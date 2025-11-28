Sistema de exemplo (Maven) - Demonstração de Abstração, Encapsulamento, Herança e Polimorfismo.

Como usar:
1. Crie um banco MySQL e execute o script `database/schema.sql`.
   - Exemplo:
     CREATE DATABASE sistema_cadastro;
     USE sistema_cadastro;
     -- then run the contents of database/schema.sql

2. Atualize `src/main/resources/db.properties` com seu usuário/senha/URL de conexão.

3. No terminal, na pasta do projeto, execute:
   mvn clean package
   java -jar target/sistema-cadastro-1.0-SNAPSHOT.jar
   (Ou execute a classe Main via IDE)

O sistema permite:
- Cadastrar (inserir) pessoas (Student ou Teacher) no banco.
- Consultar (listar) todas as pessoas no banco.

Observações:
- O projeto usa JDBC direto (mysql-connector-j).
- Arquivos importantes:
  - src/main/java/com/example/sistema/Main.java
  - src/main/java/com/example/sistema/model/Person.java
  - src/main/java/com/example/sistema/model/Student.java
  - src/main/java/com/example/sistema/model/Teacher.java
  - src/main/java/com/example/sistema/dao/PersonDAO.java
  - src/main/java/com/example/sistema/util/DBConnection.java
  - src/main/resources/db.properties
