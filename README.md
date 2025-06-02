# 🏢 Gerenciador de Condomínio em Java

Um sistema de gerenciamento de condomínio desenvolvido em Java, utilizando o padrão de arquitetura **MVC (Model-View-Controller)**, manipulação de banco de dados via **MySQL** e interface gráfica com **Swing**.

## 📜 Funcionalidades

- 🏠 **Gestão de Residências**
  - Cadastro, edição, remoção e listagem de residências.
  - Cada residência pode ter um ou mais moradores.
  - Pode definir um morador como dono da residência.

- 👨‍👩‍👧‍👦 **Gestão de Moradores**
  - Cadastro de moradores com informações como nome, CPF, RG e a residência em que vive.
  - edição, remoção e listagem de moradores.

- 💰 **Controle de Pagamentos**
  - Registro de pagamentos mensais por residência.
  - Utiliza **Padrão de projeto strategy** para fazer pagamentos em dia ou atrasados


## 🛠️ Tecnologias e Ferramentas

- ✅ Swing (Interface gráfica)
- ✅ JDBC (Conexão com banco de dados)
- ✅ MySQL (Banco de dados relacional)
- ✅ Padrões de projeto:
  - **MVC (Model - View - Controller)**
  - **Singleton** (Conexão com o banco)
  - **Strategy** (Para lógica de pagamento)

## 🗄️ Banco de Dados

- O projeto utiliza um banco de dados MySQL.
- O script de criação da base de dados se encontra na pasta `database`.

## 🎨 Diagrama UML

Os diagramas de classe e de entidade-relacionamento estão localizados na pasta `diagramas`


## 🚀 Como Executar

1. Baixar o arquivo:

2. Importe o projeto em uma IDE Java.

3. Configure seu banco de dados MySQL:
   - Crie o banco com o nome condominio
   - copie e cole o txt que se encontra na pasta `database` no seu MySql **seguindo a ordem em que estão**.

4. Altere as credenciais do banco no arquivo de conexão (Singleton)

5. Execute o programa pela TelaIncial na pasta view.

## 📁 Estrutura de Pastas

```
├── /src
│   ├── /controller
│   ├── /dao
│   ├── /model
│   ├── /view
        ├── TelaInicial.java <---- aqui
├── /diagramas
├── /database
├── README.md
```

## 🤝 Contribuição

Projeto feito em conjunto do meu amigo Gleisson para a aula de POO3 
Link do github dele:[GleissonValentim](https://github.com/GleissonValentim)
