-- DDL -> USUARIO
CREATE TABLE usuario
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    cpf            VARCHAR(11)           NOT NULL,
    nome           VARCHAR(80)           NOT NULL,
    email          VARCHAR(200)          NOT NULL,
    telefone       VARCHAR(11)           NOT NULL,
    senha          VARCHAR(100)          NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);


-- DDL -> ENDERECO
CREATE TABLE endereco
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    cep            VARCHAR(8)            NOT NULL,
    rua            VARCHAR(150)          NOT NULL,
    numero         BIGINT                NOT NULL,
    cidade         VARCHAR(50)           NOT NULL,
    bairro         VARCHAR(50)           NOT NULL,
    uf             VARCHAR(2)            NOT NULL,
    id_usuario     BIGINT                NOT NULL,
    CONSTRAINT pk_endereco PRIMARY KEY (id)
);

ALTER TABLE endereco
    ADD CONSTRAINT FK_ENDERECO_ON_ID_USUARIO FOREIGN KEY (id_usuario) REFERENCES usuario (id);


-- DDL -> CATEGORIA
CREATE TABLE categoria
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    nome           VARCHAR(40)           NOT NULL,
    CONSTRAINT pk_categoria PRIMARY KEY (id)
);


-- DDL -> MAQUINA
CREATE TABLE maquina
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    titulo         VARCHAR(80)           NOT NULL,
    descricao      LONGTEXT              NOT NULL,
    valor_diaria   DECIMAL               NOT NULL,
    id_categoria   BIGINT                NOT NULL,
    CONSTRAINT pk_maquina PRIMARY KEY (id)
);

ALTER TABLE maquina
    ADD CONSTRAINT FK_MAQUINA_ON_ID_CATEGORIA FOREIGN KEY (id_categoria) REFERENCES categoria (id);


-- DDL -> IMAGENS MAQUINA
CREATE TABLE imagem_maquina
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    nome           VARCHAR(100)          NOT NULL,
    tipo           VARCHAR(5)            NOT NULL,
    tamanho        BIGINT                NOT NULL,
    conteudo       LONGTEXT              NOT NULL,
    id_maquina     BIGINT                NOT NULL,
    CONSTRAINT pk_imagemmaquina PRIMARY KEY (id)
);

ALTER TABLE imagem_maquina
    ADD CONSTRAINT FK_IMAGEMMAQUINA_ON_ID_MAQUINA FOREIGN KEY (id_maquina) REFERENCES maquina (id);


-- DDL -> RESERVA
CREATE TABLE reserva
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao      datetime              NULL,
    data_inclusao       datetime              NOT NULL,
    data_reserva        date                  NOT NULL,
    data_retirada       date                  NOT NULL,
    data_prev_devolucao date                  NOT NULL,
    id_usuario          BIGINT                NOT NULL,
    id_maquina          BIGINT                NOT NULL,
    CONSTRAINT pk_reserva PRIMARY KEY (id)
);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_ID_MAQUINA FOREIGN KEY (id_maquina) REFERENCES maquina (id);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_ID_USUARIO FOREIGN KEY (id_usuario) REFERENCES usuario (id);


-- DDL -> ALUGUEL
CREATE TABLE aluguel
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    data_devolucao date                  NOT NULL,
    multa          DECIMAL               NULL,
    valor_total    DECIMAL               NOT NULL,
    id_reserva     BIGINT                NOT NULL,
    CONSTRAINT pk_aluguel PRIMARY KEY (id)
);

ALTER TABLE aluguel
    ADD CONSTRAINT FK_ALUGUEL_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);


-- DDL -> AVALIACAO USUARIO
CREATE TABLE avaliacao_usuario
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    descricao      LONGTEXT              NOT NULL,
    avaliacao      FLOAT                 NOT NULL,
    id_reserva     BIGINT                NOT NULL,
    CONSTRAINT pk_avaliacaousuario PRIMARY KEY (id)
);

ALTER TABLE avaliacao_usuario
    ADD CONSTRAINT FK_AVALIACAOUSUARIO_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);


-- DDL -> AVALIACAO MAQUINA
CREATE TABLE avaliacao_maquina
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data_alteracao datetime              NULL,
    data_inclusao  datetime              NOT NULL,
    descricao      LONGTEXT              NOT NULL,
    avaliacao      FLOAT                 NOT NULL,
    id_reserva     BIGINT                NOT NULL,
    CONSTRAINT pk_avaliacaomaquina PRIMARY KEY (id)
);

ALTER TABLE avaliacao_maquina
    ADD CONSTRAINT FK_AVALIACAOMAQUINA_ON_ID_RESERVA FOREIGN KEY (id_reserva) REFERENCES reserva (id);
