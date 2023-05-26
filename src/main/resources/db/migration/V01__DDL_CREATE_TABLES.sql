-- DDL -> USUARIO
CREATE TABLE usuario
(
    cpf   VARCHAR(255) NOT NULL,
    nome  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    senha VARCHAR(255) NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (cpf)
);


-- DDL -> ENDERECO
CREATE TABLE endereco
(
    id          INT          NOT NULL,
    cep         VARCHAR(255) NULL,
    rua         VARCHAR(255) NULL,
    numero      BIGINT       NULL,
    cidade      VARCHAR(255) NULL,
    bairro      VARCHAR(255) NULL,
    uf          VARCHAR(255) NULL,
    cpf_usuario VARCHAR(255) NULL,
    CONSTRAINT pk_endereco PRIMARY KEY (id)
);

ALTER TABLE endereco
    ADD CONSTRAINT FK_ENDERECO_ON_CPF_USUARIO FOREIGN KEY (cpf_usuario) REFERENCES usuario (cpf);


-- DDL -> CATEGORIA
CREATE TABLE categorias
(
    id        INT          NOT NULL,
    categoria VARCHAR(255) NULL,
    CONSTRAINT pk_categorias PRIMARY KEY (id)
);


-- DDL -> MAQUINA
CREATE TABLE maquina
(
    id           INT          NOT NULL,
    titulo       VARCHAR(255) NULL,
    descricao    VARCHAR(255) NULL,
    valor_diaria DECIMAL      NULL,
    id_categoria INT          NULL,
    CONSTRAINT pk_maquina PRIMARY KEY (id)
);

ALTER TABLE maquina
    ADD CONSTRAINT FK_MAQUINA_ON_ID_CATEGORIA FOREIGN KEY (id_categoria) REFERENCES categorias (id);


-- DDL -> IMAGENS MAQUINA
CREATE TABLE imagens_maquina
(
    id         INT          NOT NULL,
    nome       VARCHAR(255) NULL,
    tipo       VARCHAR(255) NULL,
    tamanho    BIGINT       NULL,
    conteudo   VARCHAR(255) NULL,
    id_maquina INT          NULL,
    CONSTRAINT pk_imagens_maquina PRIMARY KEY (id)
);

ALTER TABLE imagens_maquina
    ADD CONSTRAINT FK_IMAGENS_MAQUINA_ON_ID_MAQUINA FOREIGN KEY (id_maquina) REFERENCES maquina (id);


-- DDL -> RESERVA
CREATE TABLE reserva
(
    id             INT          NOT NULL,
    cpf_usuario    VARCHAR(255) NULL,
    id_maquina     INT          NULL,
    data_reserva   date         NULL,
    data_retirada  date         NULL,
    prev_devolucao date         NULL,
    CONSTRAINT pk_reserva PRIMARY KEY (id)
);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_CPF_USUARIO FOREIGN KEY (cpf_usuario) REFERENCES usuario (cpf);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_ID_MAQUINA FOREIGN KEY (id_maquina) REFERENCES maquina (id);


-- DDL -> ALUGUEL
CREATE TABLE aluguel
(
    id             INT     NOT NULL,
    data_devolucao date    NULL,
    multa          DECIMAL NULL,
    valor_total    DECIMAL NULL,
    id_reserva     INT     NULL,
    CONSTRAINT pk_aluguel PRIMARY KEY (id)
);

ALTER TABLE aluguel
    ADD CONSTRAINT FK_ALUGUEL_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);


-- DDL -> AVALIACAO USUARIO
CREATE TABLE avaliacao_usuario
(
    id         INT          NOT NULL,
    descricao  VARCHAR(255) NULL,
    avaliacao  FLOAT        NULL,
    id_reserva INT          NULL,
    CONSTRAINT pk_avaliacao_usuario PRIMARY KEY (id)
);

ALTER TABLE avaliacao_usuario
    ADD CONSTRAINT FK_AVALIACAO_USUARIO_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);


-- DDL -> AVALIACAO MAQUINA
CREATE TABLE avaliacao_maquina
(
    id         INT          NOT NULL,
    descricao  VARCHAR(255) NULL,
    avaliacao  FLOAT        NULL,
    id_reserva INT          NULL,
    CONSTRAINT pk_avaliacao_maquina PRIMARY KEY (id)
);

ALTER TABLE avaliacao_maquina
    ADD CONSTRAINT FK_AVALIACAO_MAQUINA_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);
