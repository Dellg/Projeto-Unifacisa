# Projeto Unifacisa
Sistema de Gestão de Contas Bancárias é um projeto desenvolvido em [Java](https://www.java.com/) utilizando o <i>framework</i> [Spring Boot](https://spring.io/) e o banco de dados [MySQL](https://www.mysql.com/).

## Estrutura do Projeto
O projeto foi desenvolvido no [Eclipse](https://www.eclipse.org/) e usa o sistema de organização <b>Package by Layer</b>: 
* <i>model:</i>
  * Pacote que contém os modelos Pessoa, Conta, Transacao e MovimentoConta.
* <i>controller:</i>
  * Pacote que contém os controladores PessoaController, ContaController e TransacaoController.
* <i>service:</i>
  * Pacote que contém os serviços PessoaService, ContaService e TransacaoService, serve para comunicar os controladores com os respectivos repositórios.
* <i>repository:</i>
  * Pacote que contém os repositórios PessoaRepository, ContaRepository e TransacaoRepository, serve para realizar as operações no banco de dados.
* <i>security:</i>
  * Pacote que contém as configurações de segurança.

## Estrutura do Banco de Dados
O projeto está definido para utilizar o banco de dados MySQL através da porta 8081. O banco será criado automaticamente, se ainda não existir, contendo as seguintes tabelas:

TB_Pessoa:
<i>(pk)</i> id_pessoa | nome | cpf | data_nascimento
----------|------|-----|----------------
Long | String | String | Date

TB_Conta:
<i>(pk)</i> id_conta | id_pessoa | tipo_conta | data_criacao | saldo | limite_saque_diario | flag_ativo |
---------|-----------|------------|--------------|-------|---------------------|-------------
Long | Long | Integer | Date | Double | Double | Boolean

TB_Transacao:
<i>(pk)</i> id_transacao | id_conta | tipo_transacao | valor | data_transacao |
-------------|----------|----------------|-------|----------------
Long | Long | Integer | Double | Date

## Funcionalidades
* <i>Path</i> que cadastra um usuário:
  * método Post que recebe um .json contendo "nome", "cpf" e "dataNascimento" (formatado como yyyy-mm-dd).
* <i>Path</i> que cadastra uma conta bancária:
  * método Post que recebe um .json contendo o "idPessoa" e "tipoConta" (0 ou 1 para débito ou crédito, respectivamente). A conta inicia com saldo 0 e limite de saque diário com 500.
* <i>Path</i> que realiza a operação de depósito em uma conta:
  * método Post que recebe um .json contendo o "idConta" e "valor".
* <i>Path</i> que realiza a operação de saque de uma conta:
  * método Post que recebe um .json contendo o "idConta" e "valor".
* <i>Path</i> que permite bloquear uma conta:
  * método Post que recebe um .json contendo o "idConta".
* <i>Path</i> que permite desbloquear uma conta:
  * método Post que recebe um .json contendo o "idConta".
* <i>Path</i> que realiza a consulta de saldo das contas de um usuário:
  * método Get que recebe como parâmetro o "idPessoa".
* <i>Path</i> que realiza a consulta das transações feitas em uma conta durante por período:
  * método Get que recebe como parâmetros o "idConta", a "dataInicio" e a "dataFim".

## Rodando o Sistema
Ao rodar o [Wampserver](https://www.wampserver.com/) e executar o sistema pelo Eclipse, é possível utilizar o [Postman](https://www.postman.com/) para realizar a execução das rotas através da porta 8081. Seguem algumas imagens mostrando como executar cada <i>path</i>.

* Exemplo de cadastro de uma pessoa e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240153-61441280-bb24-11eb-97aa-b0ccfb0060f0.png)

* Exemplo de cadastro de uma conta e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240202-92244780-bb24-11eb-9b92-0a76c965df53.png)

* Exemplo de depósito e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240270-e4656880-bb24-11eb-941e-b87eb7ed7943.png)

* Exemplo de saque e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240282-f6dfa200-bb24-11eb-99a1-319ce4661657.png)

* Exemplo de bloqueio de conta e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240298-0a8b0880-bb25-11eb-90d8-d769b3baac02.png)

* Exemplo de desbloqueio de conta e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240305-17a7f780-bb25-11eb-8294-21e999656729.png)

* Exemplo de verificação do saldo das contas de um usuário e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240321-2f7f7b80-bb25-11eb-8db2-6c3ff82c8c15.png)

* Exemplo de verificação de transações durante um período de tempo e resposta esperada:
![image](https://user-images.githubusercontent.com/26439598/119240340-458d3c00-bb25-11eb-9eeb-3d7541b59d1b.png)
