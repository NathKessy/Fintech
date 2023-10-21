CREATE TABLE t_cidade (
    id_cidade   INTEGER NOT NULL,
    nome_cidade VARCHAR2(50) NOT NULL
);

ALTER TABLE t_cidade ADD CONSTRAINT pk_t_cidade PRIMARY KEY ( id_cidade );

CREATE TABLE t_comprov (
    id_comprov   INTEGER NOT NULL,
    endereco     VARCHAR2(50) NOT NULL,
    data_emissao DATE NOT NULL,
    tipo_comprov VARCHAR2(20) NOT NULL
);

ALTER TABLE t_comprov ADD CONSTRAINT pk_t_comprov PRIMARY KEY ( id_comprov );

CREATE TABLE t_comprov_socios (
    t_doc_socios_id_socios INTEGER NOT NULL,
    t_comprov_id_comprov   INTEGER NOT NULL
);

ALTER TABLE t_comprov_socios ADD CONSTRAINT pk_t_comprov_socios PRIMARY KEY ( t_doc_socios_id_socios,
                                                                              t_comprov_id_comprov );

CREATE TABLE t_conta_empresa (
    id_conta             INTEGER NOT NULL,
    t_usuario_id_usuario INTEGER NOT NULL,
    t_saldo_id_saldo     INTEGER NOT NULL,
    numero_conta         VARCHAR2(7) NOT NULL,
    tipo_conta           VARCHAR2(20) NOT NULL,
    status_conta         VARCHAR2(20) NOT NULL,
    data_abertura        DATE NOT NULL
);


ALTER TABLE t_conta_empresa ADD CONSTRAINT pk_t_conta_empresa PRIMARY KEY ( id_conta );

CREATE TABLE t_despersas (
    id_despesa               INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    data_registro            DATE NOT NULL,
    desc_despesas            VARCHAR2(100) NOT NULL,
    quantidade               INTEGER NOT NULL,
    destino                  VARCHAR2(80) NOT NULL,
    custo                    NUMBER(4, 2)
);

ALTER TABLE t_despersas ADD CONSTRAINT t_despersas_pk PRIMARY KEY ( id_despesa );

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
    t_doc_socios_id_socios INTEGER NOT NULL,
    t_usuario_id_usuario   INTEGER NOT NULL,
    razao_social           VARCHAR2(30) NOT NULL,
    nome_fantasia          VARCHAR2(50) NOT NULL,
    cnpj                   VARCHAR2(14) NOT NULL,
    capital_emp            NUMBER(38, 2) NOT NULL,
    cep                    VARCHAR2(8) NOT NULL,
    telefone               VARCHAR2(9) NOT NULL,
    email                  VARCHAR2(50) NOT NULL,
    endereco               VARCHAR2(50) NOT NULL,
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
    cep                VARCHAR2(8) NOT NULL
);

ALTER TABLE t_endereco
    ADD CONSTRAINT pk_t_endereco PRIMARY KEY ( id_endereco,
                                               t_estado_id_estado,
                                               t_cidade_id_cidade,
                                               t_pais_id_pais );

CREATE TABLE t_endereco_empresa (
    t_endereco_id_endereco        INTEGER NOT NULL,
    t_endereco_t_estado_id_estado INTEGER NOT NULL,
    t_endereco_t_cidade_id_cidade INTEGER NOT NULL,
    t_endereco_t_pais_id_pais     INTEGER NOT NULL,
    t_empresa_id_empresa          INTEGER NOT NULL
);

ALTER TABLE t_endereco_empresa
    ADD CONSTRAINT pk_t_endereco_empresa PRIMARY KEY ( t_endereco_id_endereco,
                                                       t_endereco_t_estado_id_estado,
                                                       t_endereco_t_cidade_id_cidade,
                                                       t_endereco_t_pais_id_pais,
                                                       t_empresa_id_empresa );

CREATE TABLE t_estado (
    id_estado   INTEGER NOT NULL,
    uf          VARCHAR2(2) NOT NULL,
    nome_estado VARCHAR2(30) NOT NULL
);

ALTER TABLE t_estado ADD CONSTRAINT pk_t_estado PRIMARY KEY ( id_estado );

CREATE TABLE t_forncedores (
    id_fornecedores          INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    nome                     VARCHAR2(30) NOT NULL,
    cnpj                     VARCHAR2(14) NOT NULL,
    endereco                 VARCHAR2(50) NOT NULL,
    telefone                 NUMBER(11) NOT NULL,
    email                    VARCHAR2(50) NOT NULL,
    nome_contato             VARCHAR2(50) NOT NULL,
    categoria                VARCHAR2(30) NOT NULL,
    status                   VARCHAR2(30) NOT NULL,
    prog_pagamento           DATE NOT NULL,
    hist_pagamentos          VARCHAR2(50) NOT NULL
);

ALTER TABLE t_forncedores ADD CONSTRAINT pk_t_forncedores PRIMARY KEY ( id_fornecedores,
                                                                        t_conta_empresa_id_conta );

CREATE TABLE t_investimentos (
    id_investimentos         INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    tipo_invest              VARCHAR2(20) NOT NULL,
    valor_investido          NUMBER(38, 2) NOT NULL,
    data_inicio              DATE NOT NULL,
    data_resgate             DATE NOT NULL,
    descricao_invest         VARCHAR2(50) NOT NULL,
    status                   VARCHAR2(20) NOT NULL,
    hist_invest              VARCHAR2(20) NOT NULL,
    data_registro            DATE NOT NULL
);

ALTER TABLE t_investimentos ADD CONSTRAINT pk_t_investimentos PRIMARY KEY ( id_investimentos,
                                                                            t_conta_empresa_id_conta );

CREATE TABLE t_pais (
    id_pais   INTEGER NOT NULL,
    nome_pais VARCHAR2(30) NOT NULL
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

ALTER TABLE t_receita ADD CONSTRAINT pk_t_hist_transacao PRIMARY KEY ( id_receita,
                                                                       t_conta_empresa_id_conta );

CREATE TABLE t_saldo (
    id_saldo                 INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    saldo_atual              NUMBER(38, 2) NOT NULL,
    data_atualizacao         DATE NOT NULL,
    tipo_moeda               VARCHAR2(5) NOT NULL
);

ALTER TABLE t_saldo ADD CONSTRAINT pk_t_saldo PRIMARY KEY ( id_saldo );

CREATE TABLE t_usuario (
    id_usuario               INTEGER NOT NULL,
    t_empresa_id_empresa     INTEGER NOT NULL,
    t_conta_empresa_id_conta INTEGER NOT NULL,
    login_empresa            VARCHAR2(50) NOT NULL,
    email                    VARCHAR2(50) NOT NULL,
    senha                    VARCHAR2(20) NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT pk_t_usuario PRIMARY KEY ( id_usuario );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_cidade FOREIGN KEY ( t_cidade_id_cidade )
        REFERENCES t_cidade ( id_cidade );

ALTER TABLE t_comprov_socios
    ADD CONSTRAINT fk_id_comprov FOREIGN KEY ( t_comprov_id_comprov )
        REFERENCES t_comprov ( id_comprov );

ALTER TABLE t_usuario
    ADD CONSTRAINT fk_id_conta FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_investimentos
    ADD CONSTRAINT fk_id_contav1 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_forncedores
    ADD CONSTRAINT fk_id_contav2 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_receita
    ADD CONSTRAINT fk_id_contav4 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_saldo
    ADD CONSTRAINT fk_id_contav5 FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );

ALTER TABLE t_doc_socios
    ADD CONSTRAINT fk_id_empresa FOREIGN KEY ( t_empresa_id_empresa )
        REFERENCES t_empresa ( id_empresa );

ALTER TABLE t_usuario
    ADD CONSTRAINT fk_id_empresav2 FOREIGN KEY ( t_empresa_id_empresa )
        REFERENCES t_empresa ( id_empresa );

ALTER TABLE t_endereco_empresa
    ADD CONSTRAINT fk_id_empresav3 FOREIGN KEY ( t_empresa_id_empresa )
        REFERENCES t_empresa ( id_empresa );

ALTER TABLE t_endereco_empresa
    ADD CONSTRAINT fk_id_endereco FOREIGN KEY ( t_endereco_id_endereco,
                                                t_endereco_t_estado_id_estado,
                                                t_endereco_t_cidade_id_cidade,
                                                t_endereco_t_pais_id_pais )
        REFERENCES t_endereco ( id_endereco,
                                t_estado_id_estado,
                                t_cidade_id_cidade,
                                t_pais_id_pais );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_estado FOREIGN KEY ( t_estado_id_estado )
        REFERENCES t_estado ( id_estado );

ALTER TABLE t_endereco
    ADD CONSTRAINT fk_id_pais FOREIGN KEY ( t_pais_id_pais )
        REFERENCES t_pais ( id_pais );

ALTER TABLE t_conta_empresa
    ADD CONSTRAINT fk_id_saldo FOREIGN KEY ( t_saldo_id_saldo )
        REFERENCES t_saldo ( id_saldo );

ALTER TABLE t_empresa
    ADD CONSTRAINT fk_id_socios FOREIGN KEY ( t_doc_socios_id_socios )
        REFERENCES t_doc_socios ( id_socios );

ALTER TABLE t_comprov_socios
    ADD CONSTRAINT fk_id_sociosv2 FOREIGN KEY ( t_doc_socios_id_socios )
        REFERENCES t_doc_socios ( id_socios );

ALTER TABLE t_conta_empresa
    ADD CONSTRAINT fk_id_usuario FOREIGN KEY ( t_usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_empresa
    ADD CONSTRAINT fk_id_usuarios FOREIGN KEY ( t_usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_despersas
    ADD CONSTRAINT t_despersas_t_conta_empresa_fk FOREIGN KEY ( t_conta_empresa_id_conta )
        REFERENCES t_conta_empresa ( id_conta );