Feature: logar
	Eu como usuario do site submarino
	Quero realizar login
	Para ter acesso as minhas informa��es

#Cenario positivo
Scenario: Realizar login
    Given Que eu esteja na pagina do Submarino
    When acessar a pagina de login 
    And inserir minhas informa��es
    And clicar em continuar
    Then aparece a informa��o 'Ol� Nome'
    
#Cenario Negativo
Scenario: Realizar login falho
    Given Que eu esteja na pagina do Submarino
    When acessar a pagina de login 
    And inserir minhas informa��es incorretas
    And clicar em continuar
    Then aparece a mensagem 'E-mail ou senha incorretos'
    
