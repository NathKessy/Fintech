DROP TABLE t_comprov_socios cascade constraints;
DROP TABLE t_endereco_empresa cascade constraints;

-- Drop todas as tabelas do banco
DROP TABLE t_conta_empresa cascade constraints;
DROP TABLE t_cidade cascade constraints;
DROP TABLE t_pais cascade constraints;
DROP TABLE t_estado cascade constraints;
DROP TABLE t_endereco cascade constraints;
DROP TABLE t_comprov cascade constraints;
DROP TABLE t_doc_socios cascade constraints;
DROP TABLE t_empresa cascade constraints;
DROP TABLE t_fornecedores cascade constraints;
DROP TABLE t_investimentos cascade constraints;
DROP TABLE t_receita cascade constraints;
DROP TABLE t_saldo cascade constraints;
DROP TABLE t_despesas cascade constraints;
DROP TABLE t_usuario cascade constraints;

-- Drop sequencias
DROP SEQUENCE SQ_FINTECH;
DROP SEQUENCE SQ_ENDERECO;
DROP SEQUENCE SQ_EMPRESA;
DROP SEQUENCE SQ_USUARIO;
DROP SEQUENCE SQ_DOC_SOCIOS;
DROP SEQUENCE SQ_CONTA_EMPRESA;
DROP SEQUENCE SQ_SALDO;
DROP SEQUENCE SQ_RECEITA;
DROP SEQUENCE SQ_FORNECEDORES;
DROP SEQUENCE SQ_INVESTIMENTO;
DROP SEQUENCE SQ_DESPESA;

-- Criação de sequencias 
CREATE SEQUENCE SQ_FINTECH INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_ENDERECO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_EMPRESA INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_USUARIO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_DOC_SOCIOS INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_CONTA_EMPRESA INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_SALDO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_RECEITA INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_FORNECEDORES INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_INVESTIMENTO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_DESPESA INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;

-- Criação entidades 

CREATE TABLE t_cidade (
    id_cidade   INTEGER NOT NULL,
    nome_cidade VARCHAR2(50) NOT NULL
);

ALTER TABLE t_cidade ADD CONSTRAINT pk_t_cidade PRIMARY KEY ( id_cidade );

CREATE TABLE t_comprov (
    id_comprov   INTEGER NOT NULL,
    fk_t_comprov INTEGER NULL,
    endereco     VARCHAR2(50) NOT NULL,
    data_emissao DATE NOT NULL,
    tipo_comprov VARCHAR2(20) NOT NULL
);

ALTER TABLE t_comprov ADD CONSTRAINT pk_t_comprov PRIMARY KEY ( id_comprov );

CREATE TABLE t_conta_empresa (
    id_conta             INTEGER NOT NULL,
    t_usuario_id_usuario INTEGER NULL,
    numero_conta         VARCHAR2(7) NOT NULL,
    tipo_conta           VARCHAR2(20) NOT NULL,
    status_conta         INTEGER NOT NULL,
    data_abertura        DATE NOT NULL
);


ALTER TABLE t_conta_empresa ADD CONSTRAINT pk_t_conta_empresa PRIMARY KEY ( id_conta );

CREATE TABLE t_doc_socios (
    id_socios            INTEGER NOT NULL,
    t_empresa_id_empresa INTEGER NOT NULL,
    nome                 VARCHAR2(50) NOT NULL,
    rg                   VARCHAR2(7) NOT NULL,
    cpf                  VARCHAR2(11) NOT NULL,
    data_nasc            DATE NOT NULL,
    estado_civil         VARCHAR2(20) NOT NULL,
    nacionalidade        VARCHAR2(20) NOT NULL,
    endereco             VARCHAR2(50) NOT NULL
);

ALTER TABLE t_doc_socios ADD CONSTRAINT pk_t_doc_socios PRIMARY KEY ( id_socios );

CREATE TABLE t_empresa (
    id_empresa             INTEGER NOT NULL,
    razao_social           VARCHAR2(30) NOT NULL,
    nome_fantasia          VARCHAR2(50) NOT NULL,
    cnpj                   VARCHAR2(14) NOT NULL,
    capital_emp            NUMBER(38, 2) NOT NULL,
    cep                    VARCHAR2(8) NOT NULL,
    telefone               VARCHAR2(9) NOT NULL,
    email                  VARCHAR2(50) NOT NULL,
    endereco               INTEGER NULL,
    faturamento            NUMBER(38, 2) NOT NULL
);

ALTER TABLE t_empresa ADD CONSTRAINT pk_t_empresa PRIMARY KEY ( id_empresa );

CREATE TABLE t_endereco (
    id_endereco        INTEGER NOT NULL,
    t_estado_id_estado INTEGER NOT NULL,
    t_cidade_id_cidade INTEGER NOT NULL,
    t_pais_id_pais     INTEGER NOT NULL,
    logradouro         VARCHAR2(50) NOT NULL,
    bairro             VARCHAR2(30) NOT NULL,
    numero             VARCHAR2(10) NOT NULL,
    cep                VARCHAR2(10) NOT NULL
);

ALTER TABLE t_endereco
    ADD CONSTRAINT pk_t_endereco PRIMARY KEY ( id_endereco);


CREATE TABLE t_estado (
    id_estado   INTEGER NOT NULL,
    uf          VARCHAR2(2) NOT NULL,
    nome_estado VARCHAR2(30) NOT NULL
);

ALTER TABLE t_estado ADD CONSTRAINT pk_t_estado PRIMARY KEY ( id_estado );

CREATE TABLE t_fornecedores (
    id_fornecedores          INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    nome                     VARCHAR2(30) NOT NULL,
    cnpj                     VARCHAR2(20) NOT NULL,
    t_endereco_id_endereco   INTEGER NULL,
    telefone                 NUMBER(11) NOT NULL,
    email                    VARCHAR2(50) NOT NULL,
    categoria                VARCHAR2(30) NOT NULL,
    status                   INTEGER NOT NULL,
    prog_pagamento           DATE NOT NULL,
    descricao_fornecedor     VARCHAR2(50) NOT NULL
);

ALTER TABLE t_fornecedores ADD CONSTRAINT pk_t_fornecedores PRIMARY KEY ( id_fornecedores );

CREATE TABLE t_investimentos (
    id_investimentos         INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    tipo_invest              VARCHAR2(20) NOT NULL,
    valor_investido          NUMBER(38, 2) NOT NULL,
    data_inicio              DATE NOT NULL,
    data_resgate             DATE NOT NULL,
    descricao_invest         VARCHAR2(50) NOT NULL,
    status                   VARCHAR2(20) NOT NULL,
    data_registro            DATE NOT NULL
);

ALTER TABLE t_investimentos ADD CONSTRAINT pk_t_investimentos PRIMARY KEY ( id_investimentos );

CREATE TABLE t_pais (
    id_pais   INTEGER NOT NULL,
    nome_pais VARCHAR2(30) NOT NULL,
    sigla     VARCHAR2(8) NULL
);

ALTER TABLE t_pais ADD CONSTRAINT pk_t_pais PRIMARY KEY ( id_pais );

CREATE TABLE t_receita (
    id_receita               INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    nome_transacao           VARCHAR2(20) NOT NULL,
    tipo_transacao           VARCHAR2(20) NOT NULL,
    descricao_transacao      VARCHAR2(50) NOT NULL,
    data_transacao           DATE NOT NULL,
    data_registro            DATE NOT NULL
);

ALTER TABLE t_receita ADD CONSTRAINT pk_t_hist_transacao PRIMARY KEY ( id_receita );

CREATE TABLE t_saldo (
    id_saldo                 INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    saldo_atual              NUMBER(38, 2) NOT NULL,
    data_atualizacao         DATE NOT NULL,
    tipo_moeda               VARCHAR2(5) NOT NULL
);

ALTER TABLE t_saldo ADD CONSTRAINT pk_t_saldo PRIMARY KEY ( id_saldo );

CREATE TABLE t_despesas (
    id_despesa               INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    data_registro            DATE NOT NULL,
    desc_despesas            VARCHAR2(100) NOT NULL,
    quantidade               INTEGER NOT NULL,
    destino                  VARCHAR2(80) NOT NULL,
    custo                    NUMBER(14, 2)
);

ALTER TABLE t_despesas ADD CONSTRAINT t_despesas_pk PRIMARY KEY ( id_despesa );

CREATE TABLE t_usuario (
    id_usuario               INTEGER NOT NULL,
    t_empresa_id_empresa     INTEGER NULL, 
    login_empresa            VARCHAR2(50) NOT NULL,
    email                    VARCHAR2(50) NOT NULL,
    senha                    VARCHAR2(20) NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT pk_t_usuario PRIMARY KEY ( id_usuario );

-- Relacionamentos entre tabelas 

ALTER TABLE t_despesas
    ADD CONSTRAINT fk_id_contav8 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_cidade FOREIGN KEY ( t_cidade_id_cidade )
        REFERENCES t_cidade ( id_cidade );

ALTER TABLE t_investimentos
    ADD CONSTRAINT fk_id_contav1 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_fornecedores
    ADD CONSTRAINT fk_id_contav2 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_fornecedores
    ADD CONSTRAINT fk_id_endereco FOREIGN KEY ( t_endereco_id_endereco )
        REFERENCES t_endereco ( id_endereco );

ALTER TABLE t_receita
    ADD CONSTRAINT fk_id_contav4 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_saldo
    ADD CONSTRAINT fk_id_contav5 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_doc_socios
    ADD CONSTRAINT fk_id_empresa FOREIGN KEY ( t_empresa_id_empresa )
        REFERENCES t_empresa ( id_empresa );

ALTER TABLE t_comprov
    ADD CONSTRAINT fk_t_comprov FOREIGN KEY ( fk_t_comprov )
        REFERENCES t_doc_socios (id_socios);

ALTER TABLE t_usuario
    ADD CONSTRAINT fk_id_empresav2 FOREIGN KEY ( t_empresa_id_empresa )
        REFERENCES t_empresa ( id_empresa );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_estado FOREIGN KEY ( t_estado_id_estado )
        REFERENCES t_estado ( id_estado );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_pais FOREIGN KEY ( t_pais_id_pais )
        REFERENCES t_pais ( id_pais );

ALTER TABLE t_conta_empresa
    ADD CONSTRAINT fk_id_usuario FOREIGN KEY ( t_usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );


-- Insert registros para relacionamentos 
INSERT INTO T_PAIS (id_pais, nome_pais, sigla)VALUES (1, 'Brasil', 'BR');
INSERT INTO T_PAIS (id_pais, nome_pais, sigla)VALUES (2, 'Argentina', 'AR');
INSERT INTO T_PAIS (id_pais, nome_pais, sigla)VALUES (3, 'Uruguai', 'UY');

INSERT INTO T_CIDADE (id_cidade, nome_cidade) VALUES (1, 'São Paulo');
INSERT INTO T_CIDADE (id_cidade, nome_cidade) VALUES (2, 'Salvador');
INSERT INTO T_CIDADE (id_cidade, nome_cidade) VALUES (3, 'São bernardo do Campo');

INSERT INTO T_ESTADO (id_estado, nome_estado, UF) VALUES (1, 'São Paulo', 'SP');
INSERT INTO T_ESTADO (id_estado, nome_estado, UF) VALUES (2, 'Rio de Janeiro', 'RJ');


COMMIT;