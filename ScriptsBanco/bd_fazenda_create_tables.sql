CREATE TABLE FUNCIONARIO(
	cod_func		SMALLINT	NOT NULL
	,nome_func		VARCHAR(45)	NOT NULL
	,dta_adm		DATE		NOT NULL
	,usuario_func	VARCHAR(10)	NOT NULL
	,senha_func		varchar(10)	NOT NULL
	,dta_dem		DATE		NULL
	,cod_permis		TINYINT		NOT NULL
	,cod_setor		TINYINT		NOT NULL
	);

CREATE TABLE PERMISSAO(
	cod_permis	 TINYINT	NOT NULL
	,tipo_permis VARCHAR(20)NOT NULL
	);

CREATE TABLE SETOR(
	cod_setor	TINYINT		NOT NULL
	,nome_setor VARCHAR(30) NOT NULL
	,ativo_sn	CHAR(1)		NOT NULL
	);

CREATE TABLE OCORRENCIA(
	cod_ocor		TINYINT		NOT NULL
	,cod_setor		TINYINT		NOT NULL
	,titulo_ocor	VARCHAR(45) NOT NULL
	,desc_ocor		VARCHAR(200)NOT NULL
	,data_ocor		DATE		NOT NULL
	,cod_status		TINYINT		NOT NULL
	);

CREATE TABLE TAREFA(
	cod_tarefa		TINYINT		NOT NULL
	,cod_setor		TINYINT		NOT NULL
	,titulo_tarefa	VARCHAR(45) NOT NULL
	,desc_tarefa	VARCHAR(200)NOT NULL
	,data_tarefa	DATE		NOT NULL
	,cod_status		TINYINT		NOT NULL
	);

CREATE TABLE TB_STATUS(
	cod_status		TINYINT		NOT NULL
	,tipo_status	VARCHAR(45) NOT NULL
	);