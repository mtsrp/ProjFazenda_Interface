
ALTER TABLE funcionario
ADD email_func	VARCHAR(60)	NOT NULL;

ALTER TABLE funcionario
ADD nasc_func	DATE		NOT NULL;

ALTER TABLE funcionario
ADD sexo_func	VARCHAR(1)	NOT NULL;


ALTER TABLE funcionario CHANGE senha_func senha_func VARCHAR(20)
