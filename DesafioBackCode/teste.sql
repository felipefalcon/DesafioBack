
/* 	Para testes( em localhost com MySQL ) foi criado o database "testeback"
	e criada a tabela tb_customer_account dentro do database mencionado com os seguintes comandos.
*/	
	
	DROP TABLE tb_customer_account;

	CREATE TABLE tb_customer_account(
		id_customer INTEGER PRIMARY KEY AUTO_INCREMENT,
		cpf_cnpj NUMERIC(30),
		nm_customer VARCHAR(100),
		is_active CHAR(1),
		vl_total NUMERIC(30)
	);

	ALTER TABLE tb_customer_account AUTO_INCREMENT=1500; 
	
/* 	Também foi criado um usuário:
	Usuário: 	testeback
	Senha:		testeback
*/

/* 	Para executar os teste é só executar o arquivo .jar

	O arquivo: inserts.sql é o arquivo com o inserts que serão feitos no Banco ao rodar o .jar
	Ele pode ser editado a vontade.
	
*/
	