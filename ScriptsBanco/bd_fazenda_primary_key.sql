ALTER TABLE FUNCIONARIO
ADD CONSTRAINT PK_FUNCIONARIO
PRIMARY KEY (cod_func);

ALTER TABLE PERMISSAO
ADD CONSTRAINT PK_PERMISSAO
PRIMARY KEY (cod_permis);

ALTER TABLE SETOR
ADD CONSTRAINT PK_SETOR
PRIMARY KEY (cod_setor);

ALTER TABLE OCORRENCIA
ADD CONSTRAINT PK_OCORRENCIA
PRIMARY KEY (cod_ocor, cod_setor);

ALTER TABLE TAREFA
ADD CONSTRAINT PK_TAREFA
PRIMARY KEY (cod_tarefa, cod_setor);

ALTER TABLE TB_STATUS
ADD CONSTRAINT PK_STATUS
PRIMARY KEY (cod_status);
